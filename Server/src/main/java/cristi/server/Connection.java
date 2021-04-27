/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cristi.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author crist
 */
public class Connection {
    
    public static final int PORT = 8100;
    
    public Connection() throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            while(true) {
                System.out.println("Waiting for a client...");
                Socket socket = serverSocket.accept();
                new ClientThread(socket).start();
            }
        }
        catch (IOException e){
            System.err.println("Error: " + e);
        }
        finally{
            serverSocket.close();
        }
    }
    public static void main ( String [] args ) throws IOException {
        Connection server = new Connection();
    }
}
