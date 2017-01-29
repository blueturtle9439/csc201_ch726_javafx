package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Arrays;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX ch726");
        primaryStage.show();

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(15, 15, 15, 15));

        Scene scene = new Scene(grid, 700, 375);
        primaryStage.setScene(scene);


        Text scenetitle = new Text("Please enter lists");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label list1label = new Label("Enter the first list:");
        grid.add(list1label, 0, 1);
        TextField list1input = new TextField();
        grid.add(list1input, 1, 1);

        Label list2label = new Label("Enter the second list:");
        grid.add(list2label, 0, 2);
        TextField list2input = new TextField();
        grid.add(list2input, 1, 2);


        Button btn = new Button("comparing the lists");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().

                add(btn);
        grid.add(hbBtn, 1, 4);

        final Text result = new Text();
        grid.add(result, 1, 8);


        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {

                String[] list1temp = list1input.getText().split(" ");
                int list1len = Integer.parseInt(list1temp[0]);

                int[] list1 = new int[list1len];
                for (int i = 1; i <= (list1len - 1); i++) {
                    list1[i] = Integer.parseInt(list1temp[(i + 1)]);
                }

                String[] list2temp = list2input.getText().split(" ");
                int list2len = Integer.parseInt(list1temp[0]);

                int[] list2 = new int[list2len];
                for (int i = 1; i <= (list1len - 1); i++) {
                    list2[i] = Integer.parseInt(list2temp[(i + 1)]);
                }

                result.setFill(Color.FIREBRICK);

                if (list1len != list2len) {
                    result.setText("Two lists are not strictly identical");
                } else if (equals(list1, list2)) {
                    result.setText("Two lists are strictly identical");
                } else {
                    result.setText("Two lists are not strictly identical");
                }


            }


            public boolean equals(int[] list1, int[] list2) {

                for (int i = 0; i <= (list1.length - 1); i++) {
                    if (list1[i] != list2[i]) {
                        return false;
                    }
                }


                return true;
            }
        });


    }


}



