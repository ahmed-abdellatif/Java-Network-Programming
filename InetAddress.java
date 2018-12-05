/**
* InetAddress Class - Java Network Programming
**/
import java.net.*;

class InetAddressTest {
  public static void main (String args[] throws UnknownHostException) {
   InetAddress Address = InetAddress.getLocalHost();
   System.out.println("Address");


   Address = InetAddress.getByName("www.nameofaddress.com");
   System.out.println("Address");

   InetAddress SW[] = InetAddress.getAllByName("www.nameofaddress.com");
   for(int i=0; i<SW.length; i++)
   	System.out.println(SW[i]);

  }
}