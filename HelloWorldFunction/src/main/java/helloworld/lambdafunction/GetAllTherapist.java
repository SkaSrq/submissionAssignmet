package helloworld.lambdafunction;

import com.amazonaws.services.lambda.runtime.Client;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.google.gson.Gson;
import helloworld.ResponseDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GetAllTherapist implements RequestHandler<APIGatewayProxyRequestEvent,String> {
    Connection connection= getConnection();

    public GetAllTherapist() throws SQLException {
    }
    @Override
    public String handleRequest(APIGatewayProxyRequestEvent event, Context context) {
        List<String> list = new ArrayList<String>();
        String query = "SELECT name From assignment.therapist";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                list.add(resultSet.getString("name"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String result = new Gson().toJson(list);
        return result;
    }

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://aws-demo.ccpogc7o4emk.ap-south-1.rds.amazonaws.com:3306";
        String user = "admin";
        String password = "awsdemoo";
        Connection conn = DriverManager.getConnection(url,user,password);
        return conn;
    }


}
