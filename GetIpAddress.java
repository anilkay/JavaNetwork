import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetIpAddress {
    public static void main(String args[]) {
        try {
            InetAddress inAddress = InetAddress.getByName("notlar.herokuapp.com");
            byte[] adressByte = inAddress.getAddress();
            System.out.println(inAddress.getCanonicalHostName()); //it is thingis pingis
            System.out.println(inAddress.getHostName()); //ce.istanbul.edu.tr
            StringBuilder builder = new StringBuilder();
            int counter = 0;
           String son= inetAddressByteToString(adressByte);
           System.out.println(son);
           // builder.deleteCharAt(builder.length() - 1);
          //  System.out.println("\n" + builder.toString());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static String inetAddressByteToString(byte[] adressByte) {
        int counter = 0;
        StringBuilder builder = new StringBuilder();
        for (byte i : adressByte) {
            counter++;
            String last = "z";
            int f = 0;
            if (i < 0) {
                f = i + 256;
                builder.append(f + ".");
             //   System.out.print(f + ".");
                last = ".";
            } else {
                if (counter == 3) {
                    builder.append(i);
                 //   System.out.print(i);
                    continue;
                }
                if (last.equals("")) {
                    builder.append("." + i);
                   // System.out.print("." + i);
                } else {
                    builder.append(i + ".");
                   // System.out.print(i + ".");
                }
            }

        }
        System.out.println("counter "+counter);
        builder.deleteCharAt(builder.length()-1);
        return builder.toString();
    }
}
