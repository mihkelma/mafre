package mafre_pack;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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

    private TableView table = new TableView();
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
        border.setPrefSize(800,600);
        HBox hbox = createTopBox();
        VBox midbox = createMidBox();
        border.setTop(hbox);
        border.setCenter(midbox);


        Scene stseen = new Scene(border);
        primaryStage.setScene(stseen);
        primaryStage.show();

    }

    private VBox createMidBox() {
        VBox vbox = new VBox();
        final Label label = new Label("Objekt tänav 24");
        label.setFont(new Font("Arial", 20));

        TableColumn apartmentNo = new TableColumn("#");
        TableColumn floor = new TableColumn("Floor");
        TableColumn size = new TableColumn("Size");
        TableColumn balcony = new TableColumn("Balcony");
        TableColumn price = new TableColumn("Price");

        table.getColumns().addAll(apartmentNo, floor, size, balcony, price);

        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);

        return vbox;


        
    }


    public HBox createTopBox() {
        HBox hbox = new HBox();
        //hbox.setPadding(new Insets(10,10,10,10));
        hbox.setStyle("-fx-background-color: #494993;");

        Rectangle rectBtnOne = new Rectangle(100, 60);
        rectBtnOne.setFill(Color.web("#494993"));
        Text grabArea = new Text("GRAB");
        grabArea.setFont(Font.font("Arial", FontWeight.LIGHT, 18));
        grabArea.setFill(Color.web("#b0b0b0"));
        StackPane stack = new StackPane();
        stack.getChildren().addAll(rectBtnOne, grabArea);

        Rectangle rectBtnTwo = new Rectangle(100, 60);
        rectBtnTwo.setFill(Color.web("#494993"));
        Text showArea = new Text("SHOW");
        showArea.setFont(Font.font("Arial", FontWeight.LIGHT, 18));
        showArea.setFill(Color.web("#b0b0b0"));
        StackPane stack1 = new StackPane();
        stack1.getChildren().addAll(rectBtnTwo, showArea);

        //Ristkülik logo jaoks
        Rectangle rectangle = new Rectangle(20,20,220,50);
        rectangle.setFill(Color.web("#494993"));
        Text logo = new Text("mafre");
        logo.setFont(Font.font("Arial", FontWeight.LIGHT, 16));
        logo.setFill(Color.WHITE);

        StackPane stack2 = new StackPane();
        stack2.getChildren().addAll(rectangle, logo);

        hbox.getChildren().addAll(stack2,stack, stack1);

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
