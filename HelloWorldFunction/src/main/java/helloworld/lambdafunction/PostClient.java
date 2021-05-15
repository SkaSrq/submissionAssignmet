package helloworld.lambdafunction;

import com.amazonaws.services.lambda.runtime.Context;
import helloworld.entities.Client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostClient {
    Connection connection = getConnection();

    public PostClient() throws SQLException {
    }

    public static void handleRequest(Client client, Context context)
    {
    }

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://aws-demo.ccpogc7o4emk.ap-south-1.rds.amazonaws.com:3306";
        String user = "admin";
        String password = "awsdemoo";
        Connection conn = DriverManager.getConnection(url,user,password);
        return conn;
    }
}
