package helloworld.lambdafunction;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import helloworld.ResponseDetails;
import helloworld.entities.Therapist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PostTherapist implements RequestHandler<Therapist, ResponseDetails> {
    Connection connection= getConnection();

    public PostTherapist() throws SQLException {
    }

    @Override
    public ResponseDetails handleRequest(Therapist therapist, Context context) {
        ResponseDetails responseDetails = new ResponseDetails();
        try {
            insertTherapist(therapist,responseDetails);

        }
        catch(SQLException e)
        {
            responseDetails.setResponse_id("100");
            responseDetails.setReason("unable to submit" + e);
        }
        return responseDetails;
    }

    public void insertTherapist(Therapist therapist,ResponseDetails responseDetails) throws SQLException {
        Statement statement = connection.createStatement();
        String query = getQuery(therapist);
        int responseCode = statement.executeUpdate(query);
        if(responseCode == 1)
        {
            responseDetails.setResponse_id(String.valueOf(responseCode));
            responseDetails.setReason("Client Added Successfully");
        }
    }
    private String getQuery(Therapist therapist)
    {
        String query = " insert into assignment.therapist(name,email,password,is_available) values (";
        if(therapist!=null)
        {
            query = query.concat("'"+therapist.getName()+ "','"
                   +therapist.getEmail()+"','"
                    +therapist.getPassword()+"',"
                    +true +")");
        }
        System.out.println("query is"+query);
        return query;
    }
    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://aws-demo.ccpogc7o4emk.ap-south-1.rds.amazonaws.com:3306";
        String user = "admin";
        String password = "awsdemoo";
        Connection conn = DriverManager.getConnection(url,user,password);
        return conn;
    }
}
