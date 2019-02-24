package by.gritsuk.dima.service.impl;

import by.gritsuk.dima.domain.User;

public class UserValidation {
    private static final String LOGIN_PATTERN="^[\\w]+$";
    private static final String PASSWORD_PATTERN="^[\\w]+$";
    private static final String FIRST_NAME_PATTERN="^[a-zA-Z]+$";
    private static final String LAST_NAME_PATTERN="^[a-zA-Z]+$";
    private static final String EMAIL_PATTERN="^\\w+@[_a-zA-Z]+\\.[a-z]{2,3}$";

    public UserValidation(){}

    public static boolean validate(User user){
        String firstName=user.getFirstName();
        String lastName=user.getLastName();
        String login=user.getLogin();
        String email=user.getEmail();
        String password=user.getPassword();

        //if cases needed to be changed to the messages for user

        if(firstName.length()<1||!firstName.matches(FIRST_NAME_PATTERN)){
            return false;
        }
        if(lastName.length()<1||!lastName.matches(LAST_NAME_PATTERN)){
            return false;
        }
        if(login.length()<1||!login.matches(LOGIN_PATTERN)){
            return false;
        }
        if(password.length()<4||!password.matches(PASSWORD_PATTERN)){
            return false;
        }
        if(email.length()<5||!email.matches(EMAIL_PATTERN)){
            return false;
        }
        return true;
    }
}
