import java.util.*;
import java.io.*;
import java.net.*;

public class Server {
	public static void main(String[] args){

	    System.out.println("CardServer is started.");

	    try{
	    	@SuppressWarnings("resource") 
			ServerSocket s = new ServerSocket(5145); //assign last four digits of studentid
	        Socket clientSocket = s.accept();
	        System.out.println("Connected to: " + clientSocket.getInetAddress()
	          + " at port: " + clientSocket.getLocalPort());
	        ObjectOutputStream outToClient = new ObjectOutputStream(clientSocket.getOutputStream());
	        ObjectInputStream inFromClient = new ObjectInputStream(clientSocket.getInputStream());
	        CreditCard num;
	        try{
	          while(true){ 
	        	  num = (CreditCard) inFromClient.readObject();
	            System.out.println("Recieved credit card number from the client.");
	            boolean chk = CardValidation.isValid(num.getCardNumber());
	            num.setFlag(chk);
	            outToClient.writeObject(num);
	            outToClient.flush();
	            System.out.println("Send back credit card object to the client.");
	          }
			}
	        catch (ClassNotFoundException cntf){
	        	 System.out.println(cntf);
	        }
	        catch (EOFException exp){
	          System.out.println("The client terminated the session.");
	        }
	        catch (IOException iexe){
	        	System.out.println(iexe);
	        }
	        outToClient.close();
	        inFromClient.close();
	        clientSocket.close();

	      }
	      catch (IOException iexe){
	    	  System.out.println(iexe);
	      }
	    }
	  }


