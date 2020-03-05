/**
 *********************************
 *Costa Rican Insitute of Technology
 *School of Computer Engineering
 *Algorithms and Data Structures I
 *Student: Alejandro Jose Quesada Calderon
 *Teacher: Diego Noguera Mena
 *Assignment: ExtraClass1
 *********************************
 * //the next imports are suggested by youtube user "thenewboston" from tutorial:
 * //https://www.youtube.com/watch?v=FLkOX4Eez6o
 */
package ClientServerSocket;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javax.swing.*;

//inheritance
public class ClientGUI extends Application implements EventHandler<ActionEvent>{ //from javaFX

    Button sendButton;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Client");
        sendButton = new Button("Send");
        StackPane layout = new StackPane();
        layout.getChildren().add(sendButton);

        Scene scene = new Scene(layout,500,500);
        primaryStage.getScene(scene);
        primaryStage.show();

    }

    /**
     * Invoked when a specific event of the type for which this handler is
     * registered happens.
     *
     * @param event the event which occurred
     */
    @Override
    public void handle(ActionEvent event) {

    }
}
