package mafre_pack;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

/**
 * Created by mihkelm on 10/11/15.
 * http://www.promenaadimaja.ee/korterid/korrused/linnamaja-2nd-floor
 * Programm võimaldab internetist alla tõmmata kinnisvara uusarenduste andmeid,
 * salvestada need andmebaasi ning hiljem kuvada neid tabelis
 */
public class base extends Application {

    Stage lava;
    VBox aken;
    TableView table;
    ArrayList<Apartment> apartmentList = new ArrayList<>();

    int aknaLaiusPikslites = 800;
    int aknaPikkusPikslites = 600;



    @Override
    public void start(Stage primaryStage) throws Exception {
        lava = primaryStage;
        table = new TableView();
        seadistaAken();

    }


    private void seadistaAken() {
        aken = new VBox();

        //Lisa aknasse 2 nuppu ja seejärel tabel
        Button btn1 = new Button("Tõmba");
        btn1.setId("tomba");

        Button btn2 = new Button("Näita");
        btn2.setId("naita");

        //Lisa nupud aknasse
        //hb.getChildren().addAll(btn1,btn2);
        aken.getChildren().addAll(btn1, btn2, looTabel());


        //Tõmba andmed andmebaasi, kui vajutati "Tõmba" nupule
        btn1.setOnMouseClicked(event1 -> {
            System.out.println("Vajutasid Tõmba nupule");
            Andmebaas a = new Andmebaas();
            //tombaAndmed();
            a.setApartment(tombaAndmed());
            //kuvaTeavitus();
            a.sulgeYhendus();
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


    private ArrayList tombaAndmed() {
        File input = new File("promenaadi.html");
        Apartment apartm = new Apartment();

        try {
            Document doc = Jsoup.parse(input, "UTF-8");

            Element table2 = doc.select("table").first();
            Elements rows = table2.select("tr");
            Integer ridu = rows.size();

            for (Element row : rows) {
                Elements tds = row.select("td");

                if (tds.size() > 0) {
                    //Used SO - http://stackoverflow.com/questions/4323599/best-way-to-parsedouble-with-comma-as-decimal-separator
                    DecimalFormat df = new DecimalFormat();
                    DecimalFormatSymbols symbols = new DecimalFormatSymbols();
                    symbols.setDecimalSeparator(',');
                    symbols.setGroupingSeparator(' ');
                    df.setDecimalFormatSymbols(symbols);


                    System.out.println("Sisu:" + tds.get(2).text());
                    apartm.setNumber(tds.get(0).text());
                    apartm.setTubadeArv(Integer.parseInt(tds.get(1).text()));
                    apartm.setSuurus(Float.parseFloat(tds.get(2).text().replace(",",".")));
                    apartm.setHind(Float.parseFloat(tds.get(3).text().replace(",",".")));
                    apartm.setOlek(tds.get(4).text());

                }

            }
            apartmentList.add(apartm);
            

        } catch (IOException e) {
            e.printStackTrace();
        }
        return  apartmentList;
    }


    public TableView looTabel() {

        //Korterinumbri tulp
        TableColumn<Apartment, String> numberColumn = new TableColumn<>("Korter");

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
