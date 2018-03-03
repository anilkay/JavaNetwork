import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ServerComm {
    Socket server=null;
   static ServerSocket socket=null;
    //Port is a logical connection beetween this peers. 1 65535
    public static void main(String []args) throws IOException {
        InetAddress inetAddress=InetAddress.getLocalHost();
        System.out.println(inetAddress); //192.168.2.5
         socket=new ServerSocket(1234);
       do {
           handleClient();
       }while (true);

      // System.out.println(line);
    }
    public static void handleClient(){
        Socket link;
        try {

            link=socket.accept();
            Scanner input=new Scanner(link.getInputStream());
            PrintWriter printWriter=new PrintWriter(link.getOutputStream(),true);
            String message=input.nextLine();
            while(!message.equals("***")){
                System.out.println("Message received "+message);
                Scanner user2=new Scanner(System.in);
                String falan=user2.nextLine();
                printWriter.println(falan); //Yollanan mesaw yine printwriterın mesajı
                if(input.hasNextLine()) {
                    message = input.nextLine();
                }
                else {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Yok pek bişi");
        }

    }
}
