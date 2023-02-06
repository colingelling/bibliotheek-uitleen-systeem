package sample.resources.connect.db;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    public Connection getConnection() {

        try {
            String dburl = "jdbc:mysql://localhost:3306/";
            String dbtimeZoneFix = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String dbname = "bus";
            String dbusername = "root";
            String dbpassword = "";

            Connection connection = DriverManager.getConnection(dburl + dbname + dbtimeZoneFix, dbusername, dbpassword);
            return connection;

        } catch (SQLException e) {
            System.out.println("De database is op het moment niet verbonden: " + e.getMessage());
            System.out.println("SQL Status: " + e.getSQLState());
            System.out.println("Vendor error: " + e.getErrorCode());
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        }

        return null;
    }
}
