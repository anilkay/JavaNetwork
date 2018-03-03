import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user2
 */
public class ClientSocket{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Socket socket=null;
        try {
            socket=new Socket(InetAddress.getByName("192.168.2.5"),1234);
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            Scanner user = new Scanner(System.in);
            String message, response;
            Scanner input=new Scanner(socket.getInputStream());
            do {
                System.out.println("Enter message:");
                message = user.nextLine();
                output.println(message); //Servera bu printwriter objesi ile mesaj gönderiliyor.

                response = input.nextLine();
                System.out.println("response:"+response);
            } while (!message.equals("***"));
        } catch (UnknownHostException ex) {
            Logger.getLogger(Hapsu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Hapsu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
