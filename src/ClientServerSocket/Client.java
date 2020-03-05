/*
*********************************
Costa Rican Insitute of Technology
School of Computer Engineering
Algorithms and Data Structures I
Student: Alejandro Jose Quesada Calderon
Teacher: Diego Noguera Mena
Assignment: ExtraClass1
* Code based on geeks for geeks article tutorial for monoclient connection <https://www.geeksforgeeks.org/introducing-threads-socket-programming-java/>
* Code modified, now based on the article <https://www.geeksforgeeks.org/multi-threaded-chat-application-set-2/>.
*********************************
 */
package ClientServerSocket;

// Java implementation for multithreaded chat client
// Save file as Client.java

import java.io.*;
import java.net.*;
import java.util.Scanner;
//keyword class represents the concept Class from OOP
//public is a keyword related to encapsulation, as well as private and protected.
public class Client
{
    final static int ServerPort = 1234;

    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String args[]) throws IOException {
        Scanner scn = new Scanner(System.in);

        // getting localhost ip
        InetAddress ip = InetAddress.getByName("localhost");

        // establish the connection
        Socket s = new Socket(ip, ServerPort);

        // obtaining input and out streams
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        // sendMessage thread
        Thread sendMessage = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                    // read the message to deliver.
                    String msg = scn.nextLine();

                    try {
                        // write on the output stream
                        dos.writeUTF(msg);
                    } catch (IOException e) {
                        return;
                        //e.printStackTrace();
                    }
                }
            }
        });

        // readMessage thread
        Thread readMessage = new Thread(new Runnable()
        {
            @Override
            public void run() {

                while (true) {
                    try {
                        // read the message sent to this client
                        String msg = dis.readUTF();
                        System.out.println(msg);
                    } catch (IOException e) {
                        return;
                        //e.printStackTrace();
                    }
                }
            }
        });

        sendMessage.start();
        readMessage.start();

    }
}