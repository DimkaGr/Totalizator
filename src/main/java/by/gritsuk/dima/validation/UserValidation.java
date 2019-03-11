package by.gritsuk.dima.validation;

import by.gritsuk.dima.dao.DaoFactoryType;
import by.gritsuk.dima.dao.FactoryProducer;
import by.gritsuk.dima.dao.UserDAO;
import by.gritsuk.dima.dao.exception.DaoException;
import by.gritsuk.dima.dao.exception.DaoFactoryException;
import by.gritsuk.dima.domain.User;
import by.gritsuk.dima.validation.exception.LoginPersistException;
import by.gritsuk.dima.validation.exception.ValidationException;

public class UserValidation {
    private static final String LOGIN_PATTERN="^[\\w]+$";
    private static final String PASSWORD_PATTERN="^[\\w]+$";
    private static final String FIRST_NAME_PATTERN="^[a-zA-Z]+$";
    private static final String LAST_NAME_PATTERN="^[a-zA-Z]+$";
    private static final String EMAIL_PATTERN="^[\\w\\.-]+@[_a-zA-Z]+\\.[a-z]{2,3}$";

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

    public static boolean isReservedLogin(String login) throws ValidationException, LoginPersistException {
        try {
            UserDAO userDao = (UserDAO) FactoryProducer.getDaoFactory(DaoFactoryType.JDBC).getDao(User.class);
            if(userDao.getByLogin(login)!=null)
                throw new LoginPersistException("Login is use");
        } catch (DaoException|DaoFactoryException e) {
            throw new ValidationException("Failed while getting connection to database",e);
        }
        return true;
    }
}
