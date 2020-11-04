package java1;

import java1.interfac.Quiz;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/chatbot";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    public static Connection connection;
    public static Statement myStmt;


    public static void main(String[] args) {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            myStmt = connection.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        new Quiz();
    }

}
