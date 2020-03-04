package ClientServerSocket;

import java.io.*;
import java.text.*;
import java.util.*;
import java.net.*;
//Code for this class based on https://www.geeksforgeeks.org/introducing-threads-socket-programming-java/
//from the author Rishabh Mahrsee. (not exact same implementation and use of attributes and methods).

public class ClientHandler extends Thread { //inheritance
    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;

    //constructor
    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos){
        this.dis = dis;
        this.dos = dos;
        this.s   = s;

    }
    public void run() {
        String received;
        String toreturn;

        received = dis.readUTF();
        while(!(received.equals("Over") || received.equals("Out"))){
            try{
                //handle what to do with every received text that is not the exit command for the server.


            }catch(Exception e){
                e.printStackTrace();
            }

        }try{
            s.close();
            dis.close();
            dos.close();
        }catch(IOException Ioexcpt){
            System.out.println(Ioexcpt);
        }

    }
}
