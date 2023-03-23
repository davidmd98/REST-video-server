package isdcm.restapp.daos;

import isdcm.restapp.models.Video;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
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
    
    public void addVideo(Video video) throws SQLException{
        String query = "INSERT INTO videos (title, author, creation_date, duration, description, url) VALUES (?, ?, ?, ?, ?, ?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query);){
            preparedStatement.setString(1, video.getTitle());
            preparedStatement.setString(2, video.getAuthor());
            preparedStatement.setDate(3, new Date(System.currentTimeMillis()));
            preparedStatement.setTime(4, video.getDuration());
            preparedStatement.setString(5, video.getDescription());
            preparedStatement.setString(6, video.getUrl());
            preparedStatement.executeUpdate();
        }
    }
    
    public List<Video> getVideosByAuthor(String author) throws SQLException{
        String query = "SELECT * FROM VIDEOS WHERE author = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query);){
            List<Video> videos = new ArrayList<>();
            preparedStatement.setString(1, author);
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
        String query = "SELECT * FROM VIDEOS WHERE author = ?";
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
    
    public List<Video> getVideosByCreationDate(Date startDate, Date endDate)throws SQLException{
        String query = "SELECT * FROM VIDEOS WHERE author = ?";
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
}
