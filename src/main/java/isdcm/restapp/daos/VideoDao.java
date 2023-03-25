package isdcm.restapp.daos;

import isdcm.restapp.models.Video;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author david
 */
public class VideoDao {
    
    private Connection connection;
    
    public VideoDao(){
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            this.connection = DriverManager.getConnection(
                    "jdbc:derby://localhost:1527/pr2;user=pr2;password=pr2");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Video> getVideosByAuthor(String author) throws SQLException{
        String query = "SELECT * FROM VIDEOS WHERE author LIKE ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query);){
            preparedStatement.setString(1, String.format("%%%s%%",author));
            ResultSet resultSet = preparedStatement.executeQuery();
            return getVideoList(resultSet);
        } 
    }
    
    public List<Video> getVideos() throws SQLException{
        String query = "SELECT * FROM VIDEOS";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query);){
            ResultSet resultSet = preparedStatement.executeQuery();
            return getVideoList(resultSet);
        } 
    }
    
    public List<Video> getVideosByTitle(String titleInput)throws SQLException{
        String query = "SELECT * FROM VIDEOS WHERE title LIKE ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query);){
            preparedStatement.setString(1, String.format("%%%s%%", titleInput));
            ResultSet resultSet = preparedStatement.executeQuery();
            return getVideoList(resultSet);
        } 
    }
    
    public List<Video> getVideosByCreationDate(String start, String end)throws SQLException{
        String query = "SELECT * FROM VIDEOS WHERE creation_date BETWEEN ? AND ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query);){
            preparedStatement.setString(1, start);
            preparedStatement.setString(2, end);
            ResultSet resultSet = preparedStatement.executeQuery();
            return getVideoList(resultSet);
        } 
    }
    private List<Video> getVideoList(ResultSet resultSet)throws SQLException{
        List<Video> videos = new ArrayList<>();
        while (resultSet.next()) {
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            String creationDate = resultSet.getDate("creation_date").toString();
            Time duration = resultSet.getTime("duration");
            int reproductions = resultSet.getInt("reproductions");
            String description = resultSet.getString("description");
            String url = resultSet.getString("url");
            boolean isLocal = resultSet.getBoolean("is_local");
            Video video = new Video(title, author, creationDate, duration, reproductions, description, url, isLocal);
            videos.add(video);
        }
        return videos;
    }
}
