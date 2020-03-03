/*
*********************************
Costa Rican Insitute of Technology
School of Computer Engineering
Algorithms and Data Structures I
Student: Alejandro Jose Quesada Calderon
Teacher: Diego Noguera Mena
Assignment: ExtraClass1
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
    public Client(String IPadd, int PortNumber){

        //try-catch used to attempt a connection without stopping the code in runtime if connection is not established.
        try{
            socket1 = new Socket(IPadd, PortNumber);
            System.out.println("Client connected");

            //user input
            input = new DataInputStream(System.in);

            //sending the output to the socket
            //method used is different from input due to the direction information is headed
            output = new DataOutputStream(socket1.getOutputStream());

        }catch(UnknownHostException Unknown){
            //this code segment runs in case if the connection does not succeed, but it stops the code from stopping
            System.out.println(Unknown);

        }catch(IOException Ioexcpt){
            System.out.println(Ioexcpt);
        }

    }

}
