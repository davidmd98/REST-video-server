package isdcm.restapp.models;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author david
 */
public class Video {

    private String title;
    private String author;
    private Date creationDate;
    private Time duration;
    private int reproductions;
    private String description;
    private boolean isLocal;
    private String url;

    public Video(String title, String author, Date creationDate, Time duration, String description, String url, boolean isLocal) {
        this.title = title;
        this.author = author;
        this.creationDate = creationDate;
        this.duration = duration;
        this.reproductions = 0;
        this.description = description;
        this.url = url;
        this.isLocal = isLocal;
    }
    
    public Video(String title, String author, Date creationDate, Time duration, int reproductions, String description, String url, boolean isLocal) {
        this.title = title;
        this.author = author;
        this.creationDate = creationDate;
        this.duration = duration;
        this.reproductions = reproductions;
        this.description = description;
        this.url = url;
        this.isLocal = isLocal;
    }
    
    public Video(String title, String author, Time duration, String description, String url, boolean isLocal) {
        this.title = title;
        this.author = author;
        this.creationDate = new Date(System.currentTimeMillis());
        this.duration = duration;
        this.reproductions = 0;
        this.description = description;
        this.url = url;
        this.isLocal = isLocal;
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
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
