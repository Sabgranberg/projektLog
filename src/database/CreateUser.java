
import database.ConnectorNine;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.*;
import java.util.ArrayList;

public class CreateUser{
    static Connection dbConnection = null;
    static PreparedStatement preparedStatement = null;
    static Statement statement = null;
    static ResultSet resultSet = null;
    static ConnectorNine connectorNine = new ConnectorNine(); 
}

    public static void main(String[] args) {
//grunden til at vi koerer med at bruge en Connector klasse, fremfor at have en lang Main metode, er at vi skal have masser af SOC
        // Separation Of Concerns


        dbConnection=connectorNine.getConnection();
        findLogin("234567-2345");


        //used for Group 9 in Semester project

        //needs to contain methods for the Database, but use a Connector Object instead.

    }


    public CreateUser() {

    }

    public String findpatient() {

        return "";
    }

    public void createBruger( String Mail, String Password, String CPR) {


    }
    public static ArrayList<String[]> findLogin(String ID) {
        if (dbConnection != null) {


            String SQL = "select * from Login where CPR = '" + ID + "';";
            //undgaa mellemrum osv ved jeres gaaseoejne
            //det jeg gjorde for at indsaette en variabel i strengen, var at jeg
            String legestring = "select * from Login where CPR = '234567-2345';";
            //satte et + efter den foerste ' og foer den sidste ', saa der kunne indsaettes variabel.

            try {
                statement = dbConnection.createStatement();

                resultSet = statement.executeQuery(SQL);

                ResultSetMetaData rsmd = resultSet.getMetaData();
                int column_count = rsmd.getColumnCount();


                while (resultSet.next()) {

                    System.out.println(resultSet.getInt(1));
                    System.out.println(resultSet.getObject(2));
                    System.out.println(resultSet.getObject(3));

                }


            } catch (Exception throwables) {
                //use to write out for HTML.
                StringWriter errors = new StringWriter();
                throwables.printStackTrace(new PrintWriter(errors));
                String errstring = errors.toString();
                System.out.println(errstring);

            }

        } else {
            System.out.println("tom connnection?");
        }


        return new ArrayList<>();
    }

;


