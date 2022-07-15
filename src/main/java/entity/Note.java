package entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Note {
    private int idNote;
    private String title;
    private String body;
    private String description;
    private List<String> tags;
    private Boolean baja;

    public Note(int idNote, String title, String body, String description, List<String> tags) {
        this.idNote = idNote;
        this.title = title;
        this.body = body;
        this.description = description;
        this.tags = tags;
        baja = false;
    }    
    
    public Note(String title, String body, String description, List<String> tags) {
        this.title = title;
        this.body = body;
        this.description = description;
        this.tags = tags;
        baja = false;
    }

    public int getIdNote() {
        return idNote;
    }

    public void setIdNote(int idNote) {
        this.idNote = idNote;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        if(tags != null) {
            
            this.tags = tags;
            
        }
        
    }

    @Override
    public String toString() {
        return "Note{" + "title=" + title + ", body=" + body + ", description=" + description + ", tags=" + tags + ", baja=" + baja + '}';
    }
    
    
}
