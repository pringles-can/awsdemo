package com.crud.awsdemo;


import com.crud.awsdemo.spring.model.Person;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;





public class PersonFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> paramClass) {
        return Person.class.equals(paramClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id.required");

        Person p = (Person) obj;
        if (p.getId() < 0) {
            errors.rejectValue("id", "negativeValue", new Object[]{"'id'"}, "id can't be negative");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");

    }


}
