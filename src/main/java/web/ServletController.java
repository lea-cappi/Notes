package web;

import Utils.Utils;
import data.NoteDAO;
import entity.Note;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/servletController")
public class ServletController extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action != null){
            switch (action){
                case "edit":
                    editNote(req, res);
                    break;
                case "delete":
                    deleteNote(req,res);
                    break;
                default:
                    defaultAction(req, res);
                    break;
            }
        } else {
            defaultAction(req, res);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String action = req.getParameter("action");
        if (action!=null){
            switch(action) {
                case "insert":
                    saveNote(req,res);
                    break;
                case "modify":
                    modifyNote(req,res);
                    break;
                default:
                    defaultAction(req,res);
                    break;
            }
        }
    }
    
    private void defaultAction (HttpServletRequest req, HttpServletResponse res) throws IOException {
        List<Note> notes = new NoteDAO().findAll();
        System.out.println("------------------------------servletController.defaultAction--------------------------------");
        System.out.println(notes);
        HttpSession session = req.getSession();
        System.out.println("--------------------------------------------------------------");
        session.setAttribute("notes", notes); //trabajamos con scope de sesion en vez de sesion de request        
//        session.setAttribute("tagsCount", tagsCount);
//        session.setAttribute("tagsString", Utils.tagsListToString(tagsList))
        //req.getRequestDispatcher("libros.jsp").forward(req, res); //redireccion mediante el request
        System.out.println("-----------------------------seteados atributos yendo a notes.jsp---------------------------------");
        res.sendRedirect("notes.jsp"); //redireccion mediante respuesta
    }
    
    private void saveNote (HttpServletRequest req, HttpServletResponse res) throws IOException {
        String title = req.getParameter("title");
        String body = req.getParameter("body");
        String description = req.getParameter("description");
        String tagsString = req.getParameter("tagsString");
        List<String> tags = Utils.tagsStringToList(tagsString);
        
        Note note  = new Note(title,body,description,tags);
        int regMod =  new NoteDAO().create(note);
        System.out.println("Insertados: " + regMod);
        defaultAction (req,res);
        
    }
    
    public void editNote (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int idNote = Integer.parseInt(req.getParameter("idNote"));
        Note note = new NoteDAO().findNoteById(idNote);
        req.setAttribute("modifyNote", note);
        req.getRequestDispatcher("/WEB-INF/pages/operations/editNote.jsp").forward(req,res);
        
        
    }
    
    private void modifyNote (HttpServletRequest req, HttpServletResponse res) {
        
    }
    
//    private void editNote (HttpServletRequest req, HttpServletResponse res) {
//        int idNote = Integer.parseInt(req.getParameter("idNote"));
//        Note lib = new NoteDAO().findNoteById(idNote);
//        req.setAttribute("libro", lib);
//        req.getRequestDispatcher("/WEB-INF/paginas/operaciones/editarLibro.jsp").forward(req, res);
//    }
    
    private void deleteNote (HttpServletRequest req, HttpServletResponse res) {
        
    }
    
    private void modifyTags(){}
    
    
    
//    protected List<String> tagsSeparation(String tags) {
//        List<String> tagsSeparated = new ArrayList();
//        
//        tagsSeparated = Arrays.asList(tags.split(","));
//        
//        return tagsSeparated;
//    }
    
}
