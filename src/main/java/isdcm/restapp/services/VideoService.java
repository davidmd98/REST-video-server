package isdcm.restapp.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import isdcm.restapp.daos.VideoDao;
import isdcm.restapp.models.Video;
import isdcm.restapp.utils.Json;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author david
 */
public class VideoService {
    
    private VideoDao videoDao;
    
    public VideoService(){
        this.videoDao = new VideoDao();
    }
    
    public String searchByTitle(String title) throws SQLException, JsonProcessingException{
        try{
            List<Video> videoList = videoDao.getVideosByTitle(title);
            return Json.convertToJson(videoList);
        } catch(Exception e){
            throw e;
        }
    }
    
    public String searchByAuthor(String author) throws SQLException, JsonProcessingException {
        try{
            List<Video> videoList = videoDao.getVideosByAuthor(author);
            return Json.convertToJson(videoList);
        } catch(Exception e){
            throw e;
        }
    }
    
    public String searchByCreationDate(String startDate, String endDate) throws SQLException, JsonProcessingException{
        try{
            List<Video> videoList = videoDao.getVideosByCreationDate(startDate, endDate);
            return Json.convertToJson(videoList);
        } catch(Exception e){
            throw e;
        }
    }
}
