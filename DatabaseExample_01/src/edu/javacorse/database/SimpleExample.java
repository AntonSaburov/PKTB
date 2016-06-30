package edu.javacorse.database;

import java.sql.*;

/**
 * Created by antonsaburov on 30.06.16.
 */
public class SimpleExample
{
    public static void main(String[] args) throws Exception {

        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://127.0.0.1:5432/javacourse";
        String login = "postgres";
        String password = "postgres";

        try {
            Connection con = DriverManager.getConnection(url, login, password);
            Statement stmt = null;
            ResultSet rs = null;
            try {
                stmt = con.createStatement();
                rs = stmt.executeQuery("SELECT person_id, first_name, last_name FROM jc_example");
                while (rs.next()) {
                    int personId = rs.getInt(1);
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    System.out.println("PersonId:" + personId + ", FirstName:" + firstName + ", LastName:" + lastName);
                }
//                rs.close();
//                stmt.close();
            } finally {
                if(rs != null) {
                    rs.close();
                }
                if(stmt != null) {
                    stmt.close();
                }
                con.close();
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

    }
}
