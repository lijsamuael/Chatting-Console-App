import java.io.*;
import java.net.*;
public class ChatClient {

	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {

		try {
			Socket connection = new Socket("localhost",23); // creating a connection with ip and port
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));// to read from the keyboard
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream())); // read form the connectin created
			PrintWriter out = new PrintWriter(connection.getOutputStream());// to send to the connection created
			String msg, resp;
			System.out.println("When you want to close chatting type stop");
			do {
				System.out.println("Client says" );
				msg = br.readLine(); //reading from the keyboard
				out.println(msg); //sending the message the connection created or server
				if(msg.equals("stop"))
					break;
				resp  = in.readLine();  // reading from the connection
				System.out.println("Server says" + resp);
				
			}while(true);
			br.close();
			in.close();
			out.close();
			connection.close();
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
	}

}
