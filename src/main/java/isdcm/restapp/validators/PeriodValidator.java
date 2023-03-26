package isdcm.restapp.validators;

import isdcm.restapp.models.Period;
import java.util.regex.Pattern;

/**
 *
 * @author david
 */
public class PeriodValidator {
    
    private static final Pattern DATE_PATTERN = Pattern.compile("\\d{4}-(0[1-9]|1[0-2])-([0][1-9]|[1-2][0-9]|3[0-1])");
    
    public static void validatePeriod(Period period){
        if(period == null){
            throw new IllegalArgumentException("Period cannot be null");
        }
        validateDate(period.getStart());
        validateDate(period.getEnd());
    }
    
    private static void validateDate(String date){
        if(date == null || !DATE_PATTERN.matcher(date).matches()){
            throw new IllegalArgumentException("Date cannot be null.");
        } 
    }
}
