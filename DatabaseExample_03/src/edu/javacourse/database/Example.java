package edu.javacourse.database;

import java.sql.*;

/**
 * Created by antonsaburov on 30.06.16.
 */
public class Example
{
    public static void main(String[] args) throws Exception {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://127.0.0.1:5432/javacourse";
        String login = "postgres";
        String password = "postgres";

        try {
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                commitStatement(con);
                rollbackStatement(con);
                batchUpdate(con);
            } finally {
                con.close();
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

    }

    private static void commitStatement(Connection con) throws SQLException {
        // Выставляем ручное управление операцией commit/rollback
        con.setAutoCommit(false);

        Statement stmt = con.createStatement();
        stmt.executeUpdate("INSERT INTO jc_example (first_name, last_name) VALUES ('11', '11')");
        stmt.executeUpdate("INSERT INTO jc_example (first_name, last_name) VALUES ('22', '22')");

        // Этот вызов подтверждает все изменения
        // Если закомментировать строку, то данные не будут сохранены
        con.commit();

        con.setAutoCommit(true);
    }

    private static void rollbackStatement(Connection con) throws SQLException {
        // Выставляем ручное управление операцией commit/rollback
        con.setAutoCommit(false);

        Statement stmt = con.createStatement();
        stmt.executeUpdate("INSERT INTO jc_example (first_name, last_name) VALUES ('33', '33')");
        stmt.executeUpdate("INSERT INTO jc_example (first_name, last_name) VALUES ('44', '44')");

        // Этот вызов отменяет все изменения
        con.rollback();

        con.setAutoCommit(true);
    }


    private static void batchUpdate(Connection con) throws SQLException {
        con.setAutoCommit(false);

        PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO jc_example (first_name, last_name) VALUES (?, ?)");

        pstmt.setString(1, "FirstName 1");
        pstmt.setString(2, "LastName 1");
        pstmt.addBatch();

        pstmt.setString(1, "FirstName 2");
        pstmt.setString(2, "LastName 2");
        pstmt.addBatch();

        int[] updateCounts = pstmt.executeBatch();
        con.commit();
        con.setAutoCommit(true);
    }


    public static void example(Connection con) throws SQLException {
        con.setAutoCommit(false);
        try {
            Statement st = con.createStatement();
            st.executeUpdate("sdfsdf");

            con.commit();
        } catch(Exception e) {
            con.rollback();
        }

    }
}
