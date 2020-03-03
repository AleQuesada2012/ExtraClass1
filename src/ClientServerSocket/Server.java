/*
*********************************
Costa Rican Insitute of Technology
School of Computer Engineering
Algorithms and Data Structures I
Student: Alejandro Jose Quesada Calderon
Teacher: Diego Noguera Mena
Assignment: ExtraClass1
* Code based on geeks for geeks article tutorial for monoclient connection *add link*
*********************************
 */
package ClientServerSocket;
import java.net.*;
import java.io.*;

public class Server {
    //declare attributes for the Server
    private Socket socket = null;
    private DataInputStream input = null;
    private ServerSocket server = null;

    //declaration of constructor with PortNumber as the argument
    public Server(int PortNumber) {
        try { //to stablish a connection
            server = new ServerSocket(PortNumber);
            System.out.println("Server initialized");
            System.out.println("Waiting for client...");
            socket = server.accept();
            System.out.println("Client Accepted");

            //store input in a string from the client socket
            input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String Message = "";
            //read message until "Over" or "Out" are sent.

            //this logical conditions were corrected with help from a StackOverflow entry on "while not or similars"
            while (!(Message.equals("Over") || Message.equals("Out"))) {
                try {
                    Message = input.readUTF();
                    System.out.println(Message);

                } catch (IOException Ioexcpt) {
                    System.out.println(Ioexcpt);

                }
            }//here the keywords should have been received so the program stops the connection with the client socket.
            System.out.println("Connection terminated");
            socket.close();
            input.close();
        } catch (IOException Ioexcpt) {
            System.out.println(Ioexcpt);
        }
    }
    public static void main(String[] args){
        Server server = new Server(128);
    }
}