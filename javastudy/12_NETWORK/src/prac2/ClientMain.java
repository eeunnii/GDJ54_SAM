package prac2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {

	public static void main(String[] args) {
		
		Socket socket = null;
		Scanner sc = null;
		PrintWriter out = null;
		
		try {
			
			socket = new Socket("localhost", 9090);
			// socket.connect(new InetSocketAddress("localhost", 9090));
			
			sc = new Scanner(System.in);
			
			out = new PrintWriter(socket.getOutputStream());
			
			Client client = new Client(socket);
			client.start();
			
			while(true) {
				System.out.print(">>> ");
				String message = sc.nextLine();
				if(message.equalsIgnoreCase("exit")) {
					break;
				}
				out.print(message);
				out.flush();
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(out != null) {
					out.close();
				}
				if(socket.isClosed() == false) {
					socket.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}

	}

}
