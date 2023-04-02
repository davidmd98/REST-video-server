package isdcm.restapp.utils;

import isdcm.restapp.models.Video;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author david
 */
public class Json {
    public static String convertToJson(List<Video> input) throws JsonProcessingException{
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(input);
            return json;
        } catch (Exception e){
            throw e;
        }
    }
    public static String convertToJson(Video input) throws JsonProcessingException{
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(input);
            return json;
        } catch (Exception e){
            throw e;
        }
    }
}
