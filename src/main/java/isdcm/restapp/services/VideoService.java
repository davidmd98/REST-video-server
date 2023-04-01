package isdcm.restapp.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import isdcm.restapp.daos.VideoDao;
import isdcm.restapp.models.Author;
import isdcm.restapp.models.Period;
import isdcm.restapp.models.Title;
import isdcm.restapp.models.Video;
import isdcm.restapp.utils.Json;
import isdcm.restapp.validators.AuthorValidator;
import isdcm.restapp.validators.PeriodValidator;
import isdcm.restapp.validators.TitleValidator;
import isdcm.restapp.validators.VideoValidator;
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
    
    public String searchByTitle(Title title) throws SQLException, JsonProcessingException{
        try{
            TitleValidator.validateTitle(title);
            
            List<Video> videoList = videoDao.getVideosByTitle(title.getTitle());
            return Json.convertToJson(videoList);
        } catch(Exception e){
            throw e;
        }
    }
    
    public String searchByAuthor(Author author) throws SQLException, JsonProcessingException {
        try{
            AuthorValidator.validateAuthor(author);
            List<Video> videoList = videoDao.getVideosByAuthor(author.getAuthor());
            return Json.convertToJson(videoList);
        } catch(Exception e){
            throw e;
        }
    }
    
    public String searchByCreationDate(Period period) throws SQLException, JsonProcessingException{
        try{
            PeriodValidator.validatePeriod(period);
            List<Video> videoList = videoDao.getVideosByCreationDate(period.getStart(), period.getEnd());
            return Json.convertToJson(videoList);
        } catch(Exception e){
            throw e;
        }
    }
    
    public void updateViews(Video video)throws SQLException{
        try{
            VideoValidator.validateVideo(video);
            videoDao.updateViews(video.getId());
        } catch(Exception e){
            throw e;
        }
    }
}
