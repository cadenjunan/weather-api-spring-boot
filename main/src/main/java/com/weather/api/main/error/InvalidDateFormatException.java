package com.weather.api.main.error;

public class InvalidDateFormatException extends RuntimeException {
    public InvalidDateFormatException() {
        super("Wrong date format given. Date format must match either yyyy-mm-dd or yyyy-mm-ddTHH:mm:ss");
    }
}
