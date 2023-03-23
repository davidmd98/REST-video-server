package isdcm.restapp.services;

import isdcm.restapp.daos.VideoDao;
import isdcm.restapp.models.Video;
import java.sql.SQLException;
import java.util.List;
import java.sql.Date;

/**
 *
 * @author david
 */
public class VideoService {
    
    private VideoDao videoDao;
    
    public VideoService(){
        this.videoDao = new VideoDao();
    }
    
    public List<Video> searchByTitle(String title) throws SQLException{
        try{
            return videoDao.getVideosByTitle(title);
        } catch(Exception e){
            throw e;
        }
    }
    
    public List<Video> searchByAuthor(String author) throws SQLException{
        try{
            return videoDao.getVideosByAuthor(author);
        } catch(Exception e){
            throw e;
        }
    }
    
    public List<Video> searchByCreationDate(Date startDate, Date endDate) throws SQLException{
        try{
            return videoDao.getVideosByCreationDate(startDate, endDate);
        } catch(Exception e){
            throw e;
        }
    }
}
