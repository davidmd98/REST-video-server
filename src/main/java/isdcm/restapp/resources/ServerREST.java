package isdcm.restapp.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import isdcm.restapp.models.Author;
import isdcm.restapp.models.Id;
import isdcm.restapp.models.Period;
import isdcm.restapp.models.Title;
import isdcm.restapp.services.VideoService;
import java.io.IOException;
import java.sql.SQLException;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author david
 */
@WebService(serviceName = "ServerREST")
@Path("ServerREST")
public class ServerREST {

    private VideoService videoService;
    
    public ServerREST(){
        this.videoService = new VideoService();
    }
    
     /**
     * POST method
     * @param title
     * @return
     */
    @Path("getByTitle")
    @PUT   
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVideosByTitle (Title title) 
            throws SQLException, JsonProcessingException{
        try{
            String json = videoService.searchByTitle(title);
            System.out.println(json);
            return Response.ok(json).build();
        } catch(Exception e){
            throw e;
        }
    }
    
     /**
     * POST method
     * @param author
     * @return 
     */
    @Path("getByAuthor")
    @PUT   
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVideosByAuthor (Author author) 
            throws SQLException, JsonProcessingException{
        try{
            String json = videoService.searchByAuthor(author);
            return Response.ok(json).build();
        } catch(Exception e){
            throw e;
        }
    }
    
     /**
     * POST method
     * @param request
     * @return 
     */
    @Path("getByCreationDate")
    @PUT   
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVideosByCreationDate (Period period) 
            throws SQLException, JsonProcessingException, IOException{
        try{
            String json = videoService.searchByCreationDate(period);
            System.out.println(json);
            return Response.ok(json).build();
        } catch(Exception e){
            throw e;
        }
    }
    
     /**
     * POST method
     * @param request
     * @return 
     */
    @Path("viewVideo")
    @PUT   
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateViews (Id id) 
            throws SQLException, JsonProcessingException, IOException{
        
        try{
            String json = videoService.updateViews(id);
            return Response.ok(json).build();
        } catch(Exception e){
            throw e;
        }
    }
}
