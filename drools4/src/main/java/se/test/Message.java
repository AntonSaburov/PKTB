package se.test;

public class Message
{
    public static final int GOOD_MORNING = 1;
    public static final int GOOD_DAY = 2;
    public static final int GOOD_NIGHT = 3;


    private String message;
    private int status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void printMessage() {
        System.out.println("Message:" + message + ", Status:" + status);
    }
}
