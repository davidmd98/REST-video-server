package isdcm.restapp.validators;

import isdcm.restapp.models.Title;

/**
 *
 * @author david
 */
public class TitleValidator {
public static void validateTitle(Title title){
        if(title == null){
            throw new IllegalArgumentException("Author cannot be null");
        }
        validateTitleName(title.getTitle());
    }
    
    private static void validateTitleName(String title){
        if(title == null || title.length() > 256 || title.length() == 0){
            throw new IllegalArgumentException("Author's name cannot be null or needs to be shorter.");
        } 
    }
}
