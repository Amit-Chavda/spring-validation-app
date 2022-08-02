package com.validation.app;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<PasswordConstraint, String> {

    String username = "tony";


    //Must not contain username
    String regex = "^((?!" + username + ").)*$";

    /*
    Must be at least 8 characters in length
    Must contain at least 1 number
    Must contain at least 1 upper case letter
    Must contain at least 1 lower case letter
    */
    String regex1 = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[a-zA-Z\\d]{8,}$";

    @Override
    public void initialize(PasswordConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {

        if (password != null && !password.equals("")) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(password);
            if(matcher.matches()){
                return Pattern.compile(regex1).matcher(password).matches();
            }
        }
        return false;
    }
}

