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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javax.swing.*;
import javax.xml.soap.Text;

//inheritance
public class ClientGUI extends Application implements EventHandler<ActionEvent>{ //from javaFX

    Button sendButton;
    TextArea textSquare;
    TextField textEntry;


    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Client");
        sendButton = new Button("Send");
        sendButton.setOnAction(this);
        sendButton.setLayoutX(500);
        sendButton.setLayoutY(500);

        textSquare = new TextArea("Welcome to the Chat!");


        textEntry = new TextField();
        textEntry.setLayoutX(0);
        textEntry.setLayoutY(355);

        StackPane layout = new StackPane();

        Scene scene = new Scene(layout,550,550);
        primaryStage.setScene(scene);
        primaryStage.show();


        layout.getChildren().add(textSquare);
        layout.getChildren().add(textEntry);
        layout.getChildren().add(sendButton);


    }

    /**
     * Invoked when a specific event of the type for which this handler is
     * registered happens.
     *
     * @param event the event which occurred
     */

    @Override
    public void handle(ActionEvent event) {
        if( event.getSource() == sendButton){
            //add code to send the message to the other clients

        }
    }
}
