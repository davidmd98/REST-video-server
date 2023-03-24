/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isdcm.restapp.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import isdcm.restapp.services.VideoService;
import java.sql.Date;
import java.sql.SQLException;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author david
 */
@WebService(serviceName = "ServerREST")
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
    @POST   
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVideosByTitle (@FormParam("title") String title) 
            throws SQLException, JsonProcessingException{
        try{
            String json = videoService.searchByTitle(title);
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
    @POST   
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVideosByAuthor (@FormParam("author") String author) 
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
     * @param start
     * @param end
     * @return 
     */
    @Path("getByCreationDate")
    @POST   
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVideosByCreationDate (@FormParam("start") Date start, Date end) 
            throws SQLException, JsonProcessingException{
        try{
            String json = videoService.searchByCreationDate(start, end);
            return Response.ok(json).build();
        } catch(Exception e){
            throw e;
        }
    }
}
