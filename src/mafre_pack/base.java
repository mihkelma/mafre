package mafre_pack;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by mihkelm on 10/11/15.
 * http://www.promenaadimaja.ee/korterid/korrused/linnamaja-2nd-floor
 * Programm võimaldab internetist alla tõmmata kinnisvara uusarenduste andmeid,
 * salvestada need andmebaasi ning hiljem kuvada neid tabelis
 */
public class base extends Application {

    Stage lava;
    HBox nupuRida;
    VBox aken;
    TableView<Apartment> table;

    int aknaLaiusPikslites = 800;
    int aknaPikkusPikslites = 600;


    @Override
    public void start(Stage primaryStage) throws Exception {
        lava = primaryStage;
        seadistaAken();

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

        table = new TableView<>();
        table.setItems(getApartment());
        table.getColumns().addAll(numberColumn, tubaColumn, suurusColumn, hindColumn, olekColumn);

        aken.getChildren().addAll(table);
        //lisaTabel();
        //reageeriKlikile();
        //tombaAndmed();
        //salvestaAndmed();
        //kuvaAndmed();
        //lopp();
    }

    //Get all of the apartments
    public ObservableList<Apartment> getApartment() {
        ObservableList<Apartment> apartments = FXCollections.observableArrayList();
        apartments.add(new Apartment("3-1",2, 47.8, 120000.00, "Vaba"));
        apartments.add(new Apartment("3-2",3, 77.3, 130400.00, "Vaba"));
        apartments.add(new Apartment("3-3",1, 37.2, 117000.00, "Vaba"));
        apartments.add(new Apartment("3-4",2, 46.5, 131100.00, "Vaba"));
        apartments.add(new Apartment("3-5",2, 41.1, 138500.00, "Vaba"));
        apartments.add(new Apartment("3-6",3, 87.9, 156300.00, "Vaba"));
        return apartments;
    }

    private void seadistaAken() {
        aken = new VBox();
        aken.setSpacing(2);
        nupuRida = new HBox();
        nupuRida.setSpacing(5);

        //Lisa nupuritta 2 nuppu
        Button btn1 = new Button("Tõmba andmed");
        btn1.setId("tomba");
        Button btn2 = new Button("Kuva andmeid");
        btn2.setId("kuva");
        nupuRida.getChildren().addAll(btn1, btn2);

        //lisa nupurida põhiaknasse
        aken.getChildren().addAll(nupuRida);

        //määrame lava mõõtmed ja lisame sellesse menüü ning tabeli
        Scene kuvaStseen = new Scene(aken, aknaLaiusPikslites, aknaPikkusPikslites);
        lava.setScene(kuvaStseen);
        lava.show();
        lava.setOnCloseRequest(event -> System.exit(0));

    }
}
