/**
*********************************
*Costa Rican Insitute of Technology
*School of Computer Engineering
*Algorithms and Data Structures I
*Student: Alejandro Jose Quesada Calderon
*Teacher: Diego Noguera Mena
*Assignment: ExtraClass1
* Code based on geeks for geeks article tutorial for monoclient connection
* <https://www.geeksforgeeks.org/introducing-threads-socket-programming-java/>
* code modified, now based on the article https://www.geeksforgeeks.org/multi-threaded-chat-application-set-1/.
*********************************
 */
package ClientServerSocket;

import java.io.*;
import java.util.*;
import java.net.*;


public class Server {


    static Vector<ClientHandler> ar = new Vector<>();


    static int i = 0;

    /**
     *
     * @param args
     * @throws IOException can fail if client does not close the data streams properly
     */
    public static void main(String[] args) throws IOException
    {
        // server is listening on port 1234
        ServerSocket ss = new ServerSocket(1234);

        Socket s;

        // running infinite loop for getting
        // client request
        while (true)
        {
            // Accept the incoming request
            s = ss.accept();

            System.out.println("New client request received : " + s);

            // obtain input and output streams
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            System.out.println("Creating a new handler for this client...");

            // Create a new handler object for handling this request.
            ClientHandler mtch = new ClientHandler(s,"client " + i, dis, dos);

            // Create a new Thread with this object.
            Thread t = new Thread(mtch);

            System.out.println("Adding this client to active client list");

            // add this client to active clients list
            ar.add(mtch);

            // start the thread.
            t.start();

            // increment i for new client.
            // i is used for naming only, and can be replaced
            // by any naming scheme
            i++;

        }
    }
}
