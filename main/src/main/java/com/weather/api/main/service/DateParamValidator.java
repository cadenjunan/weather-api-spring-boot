package com.weather.api.main.service;

import java.util.ArrayList;
import java.util.List;

public class DateParamValidator {

    public static class DateParamValidatorBuilder {
        private List<DateFormatValidator> validators;

        private DateParamValidatorBuilder() {
            this.validators = new ArrayList<>();
        }

        public DateParamValidatorBuilder addValidator(DateFormatValidator validator) {
            this.validators.add(validator);
            return this;
        }

        public DateParamValidator build() {
            return new DateParamValidator(validators);
        }

    }

    private List<DateFormatValidator> validators;

    private DateParamValidator(List<DateFormatValidator> validators) {
        this.validators = validators;
    }

    public static DateParamValidatorBuilder builder() {
        return new DateParamValidatorBuilder();
    }

    public boolean validate(String dateString) {
        for(DateFormatValidator validator: this.validators){
            if(validator.validate(dateString)){
                return true;
            }
        }
        return false;
    }

}
