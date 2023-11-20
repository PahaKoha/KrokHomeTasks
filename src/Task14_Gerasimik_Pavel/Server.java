package Task14_Gerasimik_Pavel;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8000);
             Socket input = serverSocket.accept();
             Scanner in = new Scanner(input.getInputStream());
             PrintWriter out = new PrintWriter(input.getOutputStream())) {

            Scanner send = new Scanner(System.in);
            System.out.println("Chat already start!");

            while (in.hasNext()) {
                System.out.println(in.nextLine());
                String s = send.nextLine();
                out.println("server: " + s);
                out.flush();
            }
        }
    }
}
