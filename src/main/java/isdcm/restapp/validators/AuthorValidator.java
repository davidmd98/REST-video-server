package isdcm.restapp.validators;

import isdcm.restapp.models.Author;

/**
 *
 * @author david
 */
public class AuthorValidator {
    public static void validateAuthor(Author author){
        if(author == null){
            throw new IllegalArgumentException("Author cannot be null");
        }
        validateAuthorName(author.getAuthor());
    }
    
    private static void validateAuthorName(String name){
        if(name == null || name.length() > 256 || name.length() == 0){
            throw new IllegalArgumentException("Author's name cannot be null or needs to be shorter.");
        } 
    }
}
