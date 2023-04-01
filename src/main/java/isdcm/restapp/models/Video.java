package isdcm.restapp.models;

/**
 *
 * @author david
 */
public class Video {

    private int id;
    private String title;
    private String author;
    private String creationDate;
    private int reproductions;
    private String description;
    private boolean isLocal;
    private String url;
    
    public Video(int id, String title, String author, String creationDate, int reproductions, String description, String url, boolean isLocal) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.creationDate = creationDate;
        this.reproductions = reproductions;
        this.description = description;
        this.url = url;
        this.isLocal = isLocal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public int getReproductions() {
        return reproductions;
    }

    public void setReproductions(int reproductions) {
        this.reproductions = reproductions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;

    }

    public boolean getIsLocal() {
        return isLocal;
    }

    public void setIsLocal(boolean isLocal) {
        this.isLocal = isLocal;
    }
}
