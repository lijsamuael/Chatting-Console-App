import java.io.*;
import java.net.*;
public class ChatServer {

	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(23); // creating a server with a port number 800
			System.out.println("Listening...");
			Socket connection = server.accept(); // to receive a connection from 
			System.out.println("Connection is created!");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //to read from the keyboard
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));//to read from the connection
			PrintWriter out = new PrintWriter(connection.getOutputStream(),true);// to send message to the connection
			String receive, send;
			do {
			receive = in.readLine(); //read from the connection and put into reaceive
			System.out.println("Client says " + receive);
			if(receive.equals("stop"))
				break;
			System.out.println("Server says ");
			send =br.readLine(); //read from the keyboard to later send to connection
			out.println(send); // sending to the connection that is read from the keyboard
			
			}while(true);
			br.close();
			in.close();
			out.close();
			connection.close();
			
		}catch( Exception e) {
			e.printStackTrace();
			
		}
		
	}

}
