package mafre_pack;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by mihkelm on 10/11/15.
 * http://www.promenaadimaja.ee/korterid/korrused/linnamaja-2nd-floor
 * Programm võimaldab internetist alla tõmmata kinnisvara uusarenduste andmeid,
 * salvestada need andmebaasi ning hiljem kuvada neid tabelis
 */
public class base extends Application {

    Stage lava;
    GridPane aken;
    TableView table;

    int aknaLaiusPikslites = 800;
    int aknaPikkusPikslites = 600;



    @Override
    public void start(Stage primaryStage) throws Exception {
        lava = primaryStage;
        table = new TableView();
        seadistaAken();

        //Korterinumbri tulp
        TableColumn<Apartment, String> numberColumn = new TableColumn<>("Korter");
        numberColumn.setMinWidth(50);
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("korteriNumber"));

        //Tubade tulp
        TableColumn<Apartment, Integer> tubaColumn = new TableColumn<>("Tubade arv");
        tubaColumn.setMinWidth(50);
        tubaColumn.setCellValueFactory(new PropertyValueFactory<>("tubadeArv"));

        //Korteri suuruse tulp
        TableColumn<Apartment, Double> suurusColumn = new TableColumn<>("Suurus");
        suurusColumn.setMinWidth(50);
        suurusColumn.setCellValueFactory(new PropertyValueFactory<>("suurus"));

        //Korteri hinna tulp
        TableColumn<Apartment, Double> hindColumn = new TableColumn<>("Hind");
        hindColumn.setMinWidth(50);
        hindColumn.setCellValueFactory(new PropertyValueFactory<>("hind"));

        //Korteri oleku tulp
        TableColumn<Apartment, String> olekColumn = new TableColumn<>("Olek");
        olekColumn.setMinWidth(50);
        olekColumn.setCellValueFactory(new PropertyValueFactory<>("olek"));

        table.getColumns().addAll(numberColumn, tubaColumn, suurusColumn, hindColumn, olekColumn);

        aken.getChildren().addAll(table);


    }


    private void seadistaAken() {
        aken = new GridPane();


        //Lisa aknasse 2 nuppu ja seejärel tabel
        Button btn1 = new Button("Tõmba");
        btn1.setId("tomba");

        Button btn2 = new Button("Näita");
        btn2.setId("naita");

        //Lisa nupud aknasse
        aken.add(btn1, 0, 1);
        aken.add(btn2,1,1);
        //aken.add(looTabel(),0,1,2,1);

        //Tõmba andmed andmebaasi, kui vajutati "Tõmba" nupule
        btn1.setOnMouseClicked(event1 -> {
            System.out.println("Vajutasid Tõmba nupule");
            //Andmebaas a = new Andmebaas();
            //tombaAndmed();
            //salvestaAndmed();
            //kuvaTeavitus();
            //a.sulgeYhendus();
        });

        //kuva andmed tabelisse, kui vajutati "Näita" nupule
        btn2.setOnMouseClicked(event1 -> {
            System.out.println("Vajutasid Näita nupule");
            Andmebaas a = new Andmebaas();
            table.setItems(a.getApartment());
            a.sulgeYhendus();
        });

        //Määrame lava mõõtmed ja kuvame sisu
        Scene stseen = new Scene(aken, aknaLaiusPikslites, aknaPikkusPikslites);
        lava.setScene(stseen);
        lava.show();
        lava.setOnCloseRequest(event -> System.exit(0));

    }


    public TableView looTabel() {

        //Korterinumbri tulp
        TableColumn<Apartment, String> numberColumn = new TableColumn<>("Korter");
        numberColumn.setMinWidth(50);
        numberColumn.setCellValueFactory(new PropertyValueFactory<Apartment, String>("korteriNumber"));

        //Tubade tulp
        TableColumn<Apartment, Integer> tubaColumn = new TableColumn<>("Tubade arv");
        tubaColumn.setMinWidth(50);
        tubaColumn.setCellValueFactory(new PropertyValueFactory<Apartment, Integer>("tubadeArv"));

        //Korteri suuruse tulp
        TableColumn<Apartment, Double> suurusColumn = new TableColumn<>("Suurus");
        suurusColumn.setMinWidth(50);
        suurusColumn.setCellValueFactory(new PropertyValueFactory<Apartment, Double>("suurus"));

        //Korteri hinna tulp
        TableColumn<Apartment, Double> hindColumn = new TableColumn<>("Hind");
        hindColumn.setMinWidth(50);
        hindColumn.setCellValueFactory(new PropertyValueFactory<Apartment, Double>("hind"));

        //Korteri oleku tulp
        TableColumn<Apartment, String> olekColumn = new TableColumn<>("Olek");
        olekColumn.setMinWidth(50);
        olekColumn.setCellValueFactory(new PropertyValueFactory<Apartment, String>("olek"));

        table.getColumns().addAll(numberColumn, tubaColumn, suurusColumn, hindColumn, olekColumn);

        //aken.getChildren().addAll(table);
        return table;
    }


}
