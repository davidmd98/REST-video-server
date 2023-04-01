package isdcm.restapp.validators;

import isdcm.restapp.models.Video;
import java.util.regex.Pattern;

/**
 *
 * @author david
 */
public class VideoValidator {

    private static final Pattern DATE_PATTERN = Pattern.compile("\\d{4}-(0[1-9]|1[0-2])-([0][1-9]|[1-2][0-9]|3[0-1])");
    
    public static void validateVideo(Video video) {
        if (video == null) {
            throw new IllegalArgumentException("Video cannot be null.");
        }

        validateTitle(video.getTitle());
        validateAuthor(video.getAuthor());
        validateCreationDate(video.getCreationDate());
        validateReproductions(video.getReproductions());
        validateUrl(video.getUrl());
    }

    private static void validateTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        } else if(title.length() > 100){
            throw new IllegalArgumentException("Title lengths exceeds its limit.");
        }
    }

    private static void validateAuthor(String author) {
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Author cannot be null or empty.");
        } else if(author.length() > 100){
            throw new IllegalArgumentException("Author lengths exceeds its limit.");
        }
    }

    private static void validateCreationDate(String creationDate) {
        if(creationDate == null || !DATE_PATTERN.matcher(creationDate).matches()){
            throw new IllegalArgumentException("Date cannot be null.");
        } 
    }

    private static void validateReproductions(int reproductions) {
        if (reproductions < 0) {
            throw new IllegalArgumentException("Number of reproductions cannot be negative.");
        }
    }

    private static void validateUrl(String format) {
        if (format == null || format.isEmpty()) {
            throw new IllegalArgumentException("Format cannot be null or empty.");
        } else if(format.length() > 100){
            throw new IllegalArgumentException("Format lengths exceeds its limit.");
        }
    }
}
