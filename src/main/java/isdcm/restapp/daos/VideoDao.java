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
            List<Video> videos = new ArrayList<>();
            preparedStatement.setString(1, String.format("%%%s%%",author));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                Date creationDate = resultSet.getDate("creation_date");
                Time duration = resultSet.getTime("duration");
                int reproductions = resultSet.getInt("reproductions");
                String description = resultSet.getString("description");
                String url = resultSet.getString("url");
                Video video = new Video(title, author, creationDate, duration, reproductions, description, url, false);
                videos.add(video);
            }
            return videos;
        } 
    }
    
    public List<Video> getVideos() throws SQLException{
        String query = "SELECT * FROM VIDEOS";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query);){
            List<Video> videos = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                Date creationDate = resultSet.getDate("creation_date");
                Time duration = resultSet.getTime("duration");
                int reproductions = resultSet.getInt("reproductions");
                String description = resultSet.getString("description");
                String url = resultSet.getString("url");
                Video video = new Video(title, author, creationDate, duration, reproductions, description, url, false);
                videos.add(video);
            }
            return videos;
        } 
    }
    
    public List<Video> getVideosByTitle(String titleInput)throws SQLException{
        String query = "SELECT * FROM VIDEOS WHERE title LIKE ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query);){
            List<Video> videos = new ArrayList<>();
            preparedStatement.setString(1, String.format("%%%s%%", titleInput));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                Date creationDate = resultSet.getDate("creation_date");
                Time duration = resultSet.getTime("duration");
                int reproductions = resultSet.getInt("reproductions");
                String description = resultSet.getString("description");
                String url = resultSet.getString("url");
                Video video = new Video(title, author, creationDate, duration, reproductions, description, url, false);
                videos.add(video);
            }
            return videos;
        } 
    }
    
    public List<Video> getVideosByCreationDate(Date startDate, Date endDate)throws SQLException{
        String query = "SELECT * FROM VIDEOS WHERE creation_date BETWEEN ? AND ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query);){
            List<Video> videos = new ArrayList<>();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            preparedStatement.setString(1, formatter.format(startDate));
            preparedStatement.setString(1, formatter.format(endDate));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                Date creationDate = resultSet.getDate("creation_date");
                Time duration = resultSet.getTime("duration");
                int reproductions = resultSet.getInt("reproductions");
                String description = resultSet.getString("description");
                String url = resultSet.getString("url");
                Video video = new Video(title, author, creationDate, duration, reproductions, description, url, false);
                videos.add(video);
            }
            return videos;
        } 
    }
}
