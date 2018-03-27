package presentation;

import utility.ConnectionFactory;

import java.sql.Connection;

public class controller {
    public static void main(String[] args) {
        System.out.println("Hello! Victor's Project");

        Connection con = ConnectionFactory.getConnection();
    }
}
