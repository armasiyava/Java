import java.util.*;
import java.io.*;
import java.net.*;
public class Client {
	public static void main(String[] args){
		Socket clientSocket;
		    try{
		    	 clientSocket = new Socket(InetAddress.getByName("localhost"),5145);
		         System.out.println("Connected to " + clientSocket.getInetAddress().getHostName());
		         ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
		         ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream());
		         System.out.println("I/O connected");
		         CreditCard num = new CreditCard();
		         num=new CreditCard(33333333L, false);
		         System.out.println("This is first creditcard object before server invocation: ");
		         System.out.println(num.toString());
				try{
		             outToServer.writeObject(num);
		             outToServer.flush();
		             System.out.println("Sent object for process");
		             num = (CreditCard) inFromServer.readObject();
		             System.out.println("Recieved object");
		         } 
		         catch (ClassNotFoundException cntf){
		              	 System.out.println(cntf);
		         }
		         catch (EOFException excf){
		        	 System.out.println(excf);
		         }
		         catch (IOException ioex){
		        	 System.out.println(ioex);
		         }
		         outToServer.close();
		         inFromServer.close();
		         clientSocket.close();
		         System.out.println("This is first creditcard object before server invocation:");
		         System.out.println(num.toString());
		         }
		       catch (IOException ioex){
		    	   System.out.println(ioex);
		       } 
		       System.out.println("End of the client");
		    }
	}


