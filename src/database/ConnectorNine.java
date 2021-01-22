package database;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.*;


public class ConnectorNine {

    static Connection connection = null;
    private String url = "";
    String ip4 = "192.168.139.29";
    String ip6 = "jdbc:mariadb://[2001:878:200:4102:207:e9ff:fe62:eed]:3306/logins";
    String user = "sinan";
    String password = user;
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";


    public ConnectorNine (){
        // System.out.println("Hej fra C9");

        String localhostname = null;
        try {
            localhostname = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        //int number = localhostname.charAt(localhostname.length()-1);
//pseudocode to differentiate if we want a different target for connection.
        if(localhostname.contains("su")){

            // System.out.println(InetAddress.getLocalHost().getHostName());
            url = ip4;
        }else{
            url = ip6;
            //
            System.out.println("Remote host detected:"+localhostname);
        }

        try{

            Class.forName(JDBC_DRIVER);
            String IP4Maskine9= "jdbc:mariadb://192.168.239.29:3306/logins";

            String prefix = "jdbc:mariadb://";

            String schemanavn = ":3306/logins";
            String samletIP4 = prefix+ip4+schemanavn;
            //we can compare strings to see if their values are the same, if we deem it necessary

            connection = DriverManager.getConnection(IP4Maskine9, user, user);
            if(connection!=null){
                System.out.println("Forbindelse til schema:"+schemanavn);
            }

        } catch (Exception ex) {
        }

    }

    public  Connection getConnection(){
        return connection;

    }

}
