package Task14_Gerasimik_Pavel;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocket {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("127.0.0.1", 8000);
             PrintWriter out = new PrintWriter(socket.getOutputStream());
             Scanner in = new Scanner(socket.getInputStream())) {

            Scanner send = new Scanner(System.in);
            System.out.print("Введите ваше имя:");
            String name = send.nextLine().trim();
            System.out.println("Chat already start!");


            while (true) {
                System.out.print("me: ");
                String words = send.nextLine();
                out.println(name + ": " + words);
                out.flush();
                String s = in.nextLine();
                System.out.println(s);
            }
        }
    }
}
