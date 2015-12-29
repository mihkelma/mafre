package mafre_pack;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by mihkelm on 10/11/15.
 * http://www.promenaadimaja.ee/korterid/korrused/linnamaja-2nd-floor
 */
public class base extends Application {


    public static void main(String[] args)  throws IOException {

        launch(args);
        kuvaVorm();
        //laadiAndmed();
        //salvestaAndmed();
        //kysiObjekt();
        //kuvaObjektiAndmed();
        //teeArvutused();
        //lopetaProgramm();
        }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Window title");


        BorderPane border = new BorderPane();
        HBox hbox = createTopBox();
        border.setTop(hbox);
        addStackPane(hbox);         // Add stack to HBox in top region


        Scene stseen = new Scene(border);
        primaryStage.setScene(stseen);
        primaryStage.show();

    }

    public void addStackPane(HBox inbox) {
        StackPane stack = new StackPane();
        Rectangle logoBack = new Rectangle(30.0, 50.0);
        logoBack.setStroke(Color.web("#D0E6FA"));
        logoBack.setArcHeight(3.5);
        logoBack.setArcWidth(3.5);

        Text logo = new Text("mafre");
        logo.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        logo.setFill(Color.DARKMAGENTA);
        logo.setStroke(Color.web("#7080A0"));

        stack.getChildren().addAll(logoBack, logo);
        stack.setAlignment(Pos.CENTER_RIGHT);

        inbox.getChildren().add(stack);
        HBox.setHgrow(stack, Priority.ALWAYS);
    }

    public HBox createTopBox() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10,10,10,10));
        hbox.setSpacing(6);
        hbox.setStyle("-fx-background-color: #ffffff;");


        Button grabBtn = new Button("Grab");
        Button showBtn = new Button("Show");
        hbox.getChildren().addAll(grabBtn, showBtn);

        return hbox;
    }

    private static void laadiAndmed() {
        /*File input = new File ("promenaadi.html");
        Document doc = Jsoup.parse(input, "UTF-8");
        Elements table = doc.select("table");
        Elements rows = table.select("tr");
        Dictionary testDict = null;
        ArrayList al = new ArrayList();



        for (int i = 1; i < rows.size(); i++) {
            Element row = rows.get(i);
            Elements tds = row.select("td");
            Integer elemente= tds.size();

            for (int j = 0; j < elemente; j++) {

            }

            String var1 = tds.get(0).text();
            String var2 = var1.substring(var1.length() - 1);
            String rooms = tds.get(1).text();
            String size = tds.get(2).text();
            String balcony = tds.get(3).text();
            String price = tds.get(4).text();
            String status = tds.get(5).text();


            System.out.println(elemente);*/
    }

    private static void kuvaVorm() {
    System.out.println("Pluti");
    }
}
