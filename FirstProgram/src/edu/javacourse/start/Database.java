package edu.javacourse.start;

/**
 * Created by antonsaburov on 09.06.16.
 */
abstract public class Database
{
    protected Connect connectHandler;

    public abstract void connect(String ip, int port, String login, String password);

    public abstract void disconnect();

    public int insertSQLRequest(String sql) {
        // .........
        return 0;
    }

    public int updateSQLRequest(String sql) {
        // ...
        return 0;
    }

    public int deleteSQLRequest(String sql) {
        return 0;
    }

}
