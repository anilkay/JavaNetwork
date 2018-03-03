import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocket {
    public static void main(String args[]) {
        Socket link = null;
        try {
            link = new Socket(InetAddress.getLocalHost(), 1234);
            Scanner input = new Scanner(link.getInputStream());
            PrintWriter output = new PrintWriter(link.getOutputStream(), true);
            Scanner user = new Scanner(System.in);
            String message, response;
            do {
                System.out.println("Enter message:");
                message = user.nextLine();
                output.println(message); //Servera bu printwriter objesi ile mesaj gönderiliyor.

                response = input.nextLine();
                System.out.println("response:"+response);
            } while (!message.equals("***"));
        } catch (IOException e) {
            System.out.println("Houston there has a problem\n" + e.toString());
        }
    }
}
