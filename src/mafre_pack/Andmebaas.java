package mafre_pack;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

/**
 * Created by mihkelm on 23/01/16.
 */
public class Andmebaas {
    Connection conn = null;

    //Meetod, mis käivitatakse kohe objekti välja kutsumisel
    public Andmebaas() {
        looYhendus();
        looTabelKuiPuudub();
    }


    //Andmebaasiga ühenduse loomine
    private void looYhendus() {
        try {
            Class.forName("org.sqlite.JDBC");                   //Laeme draiveri sqlite jar failist
        } catch (ClassNotFoundException e) {                    //Püüame kinni võimalikud vead faili laadimisel
            System.out.println(e.getMessage());
        }
        try {
            // Loome ühendus andmebaasi failiga
            conn = DriverManager.getConnection("jdbc:sqlite:/Users/mihkelm/Documents/code/mafre/mafre.db");
            System.out.println("Ühendus loodud");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Kui andmebaasis tabelit pole, siis tuleb see luua
    public void looTabelKuiPuudub() {
        String sql = "CREATE TABLE IF NOT EXISTS OBJECTS (id INT AUTO_INCREMENT, Korter TEXT, " +
                "Tube INT, Suurus REAL, Hind REAL, Olek TEXT);";
        taidaParing(sql);
    }

    private void taidaParing(String sql) {
        try {
            Statement stat = conn.createStatement();
            stat.executeUpdate(sql);
            stat.close();                       //Sulgeme statementi (vajalik lisaks Connection-le
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void sulgeYhendus() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Ühendus suletud");
    }

    //Järgnevat aitas http://stackoverflow.com/questions/18941093/how-to-fill-up-a-tableview-with-database-data
    public ObservableList<Apartment> getApartment() {
        ObservableList<Apartment> apartments = FXCollections.observableArrayList();
        Statement stat = null;

        try {
            stat = conn.createStatement();
            String sql = "SELECT Korter, Tube, Suurus, Hind, Olek FROM Objects;";

            ResultSet rs = stat.executeQuery(sql);
            // Kui stat.executeQuery() toob tagasi tühja tulemuse, siis rs'i kasutada ei saa

            while (rs.next()) {
                apartments.add(new Apartment(rs.getString("Korter"), rs.getInt("Tube"),rs.getFloat("Suurus"),
                        rs.getFloat("Hind"), rs.getString("Olek")));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return apartments;
    }



}
