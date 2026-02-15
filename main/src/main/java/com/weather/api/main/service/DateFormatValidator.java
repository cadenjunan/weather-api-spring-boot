package com.weather.api.main.service;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class DateFormatValidator {
    private DateTimeFormatter datetimeFormatter;
    public DateFormatValidator(DateTimeFormatter formatter){
        this.datetimeFormatter = formatter;
    }

    public boolean validate(String dateString){
       try{
        this.datetimeFormatter.parse(dateString);
       }catch(DateTimeParseException e){
            return false;
       }
       return true;
    }
}
