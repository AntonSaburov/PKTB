package edu.javacourse.sales.exception;

/**
 * Created by antonsaburov on 09.06.16.
 */
public class SalesSystemException extends Exception
{
    private String codeSustem;

    public String getCodeSustem() {
        return codeSustem;
    }

    public void setCodeSustem(String codeSustem) {
        this.codeSustem = codeSustem;
    }

    public SalesSystemException() {
    }

    public SalesSystemException(String message) {
        super(message);
    }

    public SalesSystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public SalesSystemException(Throwable cause) {
        super(cause);
    }

    public SalesSystemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
