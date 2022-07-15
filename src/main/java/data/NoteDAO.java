package data;

import Utils.Utils;
import static data.Conexion.*;
import entity.Note;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NoteDAO {
    
    private static final String SQL_CREATE = "INSERT INTO notes(title, body, description, tags) VALUES(?, ?, ?, ?)";
    private static final String SQL_READ = "SELECT * FROM notes WHERE baja = 0";
    private static final String SQL_READ_TAGS = "SELECT tags FROM notes WHERE idNote = ?";
    private static final String SQL_UPDATE = "UPDATE notes SET title = ?, body = ?, description = ?, tags = ? WHERE idNote = ?";
    private static final String SQL_UPDATE_TAGS = "UPDATE notes SET tags = ? WHERE idNote = ?";
    private static final String SQL_DELETE = "DELETE FROM notes WHERE idNote = ?";
    private static final String SQL_LOGIC_DELETE= "UPDATE notes set baja = ? WHERE idNote = ?";
    private static final String SQL_SELECT_BY_ID = "SELECT *  FROM notes WHERE idNote = ? AND baja = 0";
    
    public List<Note> findAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Note note = null;
        List<Note> notes = new ArrayList();
        System.out.println("|||||||||||noteDAO findAll()||||||||||||||");

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_READ);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idNote = rs.getInt(1);
                String title = rs.getString(2);
                String body = rs.getString(3);
                String description = rs.getString(4);
                String tagsString = rs.getString(5);
                List<String> tags = Utils.tagsStringToList(tagsString);
                
                System.out.println(tags);
                
                note = new Note(idNote, title, body, description, tags);
                notes.add(note);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return notes;
    }
    
    public Note findNoteById(int id){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Note note = null;
        System.out.println("|||||||||||noteDAO findNoteById()||||||||||||||");

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) { //con rs.absolute(0/1) indica que solo tendremos un registro
                int idNote = rs.getInt(1);
                String title = rs.getString(2);
                String body = rs.getString(3);
                String description = rs.getString(4);
                String tagsString = rs.getString(5);
                List<String> tags = Utils.tagsStringToList(tagsString);
                
                System.out.println(tags);
                
                note = new Note(idNote, title, body, description, tags);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return note;
    }
    
    public int create(Note note){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_CREATE);
            
            String tagsString = Utils.tagsListToString(note.getTags());
            
            stmt.setString(1, note.getTitle());
            stmt.setString(2, note.getBody());
            stmt.setString(3, note.getDescription());
            stmt.setString(4, tagsString);
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int update(Note note){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            String tagsString = Utils.tagsListToString(note.getTags());
            stmt.setString(1, note.getTitle());
            stmt.setString(2, note.getBody());
            stmt.setString(3, note.getDescription());
            stmt.setString(4, tagsString);
            stmt.setInt(5, note.getIdNote());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int updateTags(Note note){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE_TAGS);
            
            String tagsString = Utils.tagsListToString(note.getTags());
            
            stmt.setString(1, tagsString);
            stmt.setInt(2, note.getIdNote());
            registros = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }    
    
    
    public int delete(Note note){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, note.getIdNote());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int delete(int idNote){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, idNote);
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
     
    public Note selectById(String title) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Note note = null;

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setString(1, title);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                int idNote = rs.getInt("idNote");
                String titulo = rs.getString("title");
                String body = rs.getString("body");
                String description = rs.getString("description");
                String tagsString = rs.getString("tags");
                
                List<String> tags = Utils.tagsStringToList(tagsString);
                System.out.println(tags);

                note = new Note(idNote, titulo, body, description, tags);

                //notes.add(note);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return note;
    }
    
    
    
    public int bajaLogica (Note note){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try{
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_LOGIC_DELETE);
            stmt.setBoolean(1, true);
            stmt.setInt(2, note.getIdNote());
            registros = stmt.executeUpdate();
        } catch (SQLException ex){
            ex.printStackTrace(System.out);
        }
        finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex){
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    
            
    
}
