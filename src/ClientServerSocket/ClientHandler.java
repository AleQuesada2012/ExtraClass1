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

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ClientHandler implements Runnable {
    //these parameters are the abstraction used to represent a client sorter through the class attributes.
    Scanner scn = new Scanner(System.in);
    private String name;
    final DataInputStream dis;
    final DataOutputStream dos;
    Socket s;
    boolean isloggedin;


    /**
     * Invoked when the thread is called to accept the client request
     *
     * @param s works as the communicating socket or the Client
     * @param name is the assigned ID for each client connected to the server
     * @param dis the data input stream for each client connecting
     * @param dos the data output stream for each client connecting
     */
    //this constructor is a method
    public ClientHandler(Socket s, String name,
                         DataInputStream dis, DataOutputStream dos) {
        this.dis = dis;
        this.dos = dos;
        this.name = name;
        this.s = s;
        this.isloggedin=true;
    }

    @Override
    public void run() {

        String received;
        while (true)
        {
            try
            {
                // receive the string
                received = dis.readUTF();

                System.out.println(received);

                if(received.equals("logout")){
                    this.isloggedin=false;
                    this.dis.close();
                    this.dos.close();
                    this.s.close();
                    //closing resources

                    return;
                }

                // break the string into message and recipient part
                StringTokenizer st = new StringTokenizer(received, "#");
                String MsgToSend = st.nextToken();
                String recipient = st.nextToken();

                // search for the recipient in the connected devices list.
                // ar is the vector storing client of active users
                for (ClientHandler mc : Server.ar)
                {
                    // if the recipient is found, write on its
                    // output stream
                    if (mc.name.equals(recipient) && mc.isloggedin==true)
                    {
                        mc.dos.writeUTF(this.name+" : "+MsgToSend);
                        break;
                    }
                }
            } catch (IOException e) {

                e.printStackTrace();
            }

        }
    }
}