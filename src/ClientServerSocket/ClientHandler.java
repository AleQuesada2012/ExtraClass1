package ClientServerSocket;

import java.io.*;
import java.text.*;
import java.util.*;
import java.net.*;

public class ClientHandler extends Thread {
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


            }
        }
    }
}
