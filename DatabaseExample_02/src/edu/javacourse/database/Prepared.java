package edu.javacourse.database;

import java.sql.*;

/**
 * Created by antonsaburov on 30.06.16.
 */
public class Prepared
{
    public static void main(String[] args) throws Exception {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://127.0.0.1:5432/javacourse";
        String login = "postgres";
        String password = "postgres";

        String firstName = "A'B'S";
        String lastName = "F''GT";
        try {
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                String sql = "INSERT INTO jc_example (first_name, last_name) VALUES (?, ?)";
                PreparedStatement pst = con.prepareStatement(sql, new String[] {"person_id"});
                for(int i=0; i<5; i++) {
                    pst.setString(1, firstName);
                    pst.setString(2, lastName);

                    pst.executeUpdate();

                    ResultSet gen = pst.getGeneratedKeys();
                    while(gen.next()) {
                        Integer personId = gen.getInt(1);
                        System.out.println(personId);
                    }
                    gen.close();
                }
                pst.close();
            } finally {
                con.close();
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }


    }
}
