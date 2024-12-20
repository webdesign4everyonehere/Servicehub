package application;

import java.sql.Connection;
import java.sql.DriverManager;

public class database {
    
    public static Connection connectDb(){
        
        try{
            // Charger le driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Établir la connexion à la base de données servicehubdata
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/servicehubdata", "root", "");
            System.out.println("Connexion établie avec succès à la base de données servicehubdata.");
            return connect;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
}
