package by.gritsuk.dima.dao.exception;

/**
 * Dao Exception
 */
public class DaoException extends Exception {

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoException(String message) {
        super(message);
    }
}
