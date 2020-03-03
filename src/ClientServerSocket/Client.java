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
import java.net.*; //imported the package of java Networking API
 import java.io.*;  //imported package for input/output

public class Client {
    //attributes for this class that consist of the communication channels (socket, data streams) are initialized
    private Socket socket1 = null;
    private DataInputStream input = null;
    private DataOutputStream output = null;

    //the last three attributes have not been assigned with any value so far

    //constructor with the arguments containing IP address and port for communication establishment
    public Client(String IPadd, int PortNumber) {

        //try-catch used to attempt a connection without stopping the code in runtime if connection is not established.
        try {
            socket1 = new Socket(IPadd, PortNumber);
            System.out.println("Client connected");

            //user input
            input = new DataInputStream(System.in);

            //sending the output to the socket
            //method used is different from input due to the direction information is headed
            output = new DataOutputStream(socket1.getOutputStream());

        } catch (UnknownHostException Unknown) {
            //this code segment runs in case if the connection does not succeed, but it stops the code from stopping
            System.out.println(Unknown);
            //different types of Exception subclasses used to specify the detection of a problem and excecute another section of code instead of a general Exception.
        } catch (IOException Ioexcpt) {
            System.out.println(Ioexcpt);
        }
        //String used to store the messages read from the user
        String Message = "";

        //while condition to mantain connection until predetermined keyword is received by the server
        while ((!Message.equals("Over") || (!Message.equals("Out")))) {
            try {
                Message = input.readLine();
                output.writeUTF(Message); //this method is used as the codification used by both parties follows the UTF standard.
            } catch (IOException Ioexcpt) {
                System.out.println(Ioexcpt);
            }

        }
        try {
            input.close();
            output.close();
            socket1.close();

        } catch (IOException Ioexcpt) {
            System.out.println(Ioexcpt);
        }
    }
    public static void main(String[] args){
        Client Client1 = new Client("127.0.0.1", 128); //IPadd set to a value predetermined by the teacher in task specifications.

    }
}
//finished programming for one client, preparing Server code for further console test before implementing Threads and JavaFX GUI.