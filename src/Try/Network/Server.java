package Try.Network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;

import Try.logic.User;

public class Server extends Thread {
	
	private ServerSocket server;
	private Socket socket;
	
	private DataInputStream dis;
	private DataOutputStream dos;
	
	@Override
	public void run() {
		try {
			server = new ServerSocket(444);
			socket = server.accept();
			dis = new DataInputStream(socket.getInputStream());
			System.out.println("server is awake");
			requests((String)dis.readUTF());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void requests(String input) {
		switch (input) {
		case "check User Info":
			try {
				dos = new DataOutputStream(socket.getOutputStream());
				dos.writeBoolean(new ServerLoginCheck(dis.readUTF(), dis.readUTF()).checkUser());
				dos.flush();
				dos.close();
				dis.close();
				socket.close();
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case "user sign up":
			try {
				dos = new DataOutputStream(socket.getOutputStream());
				dos.writeBoolean(new ServerSignUpCheck(dis.readUTF(), dis.readUTF(), dis.readUTF()).checkEmail());
				dos.flush();
				dos.close();
				dis.close();
				socket.close();
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case "requesting to":
			try {
				String requestTo = dis.readUTF();
				System.out.println("server: requesting to " + requestTo);
				String requestFrom = dis.readUTF();
				new ServerRequesting(requestTo, requestFrom);
				dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case "get requests":
			System.out.print("Server: looking for requests of ");
			try (ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())){
				String requestsOf = dis.readUTF();
				System.out.println(requestsOf);
				HashSet<User> requests = new ServerGetRequests(requestsOf).getRequests();
				out.writeObject(requests);
				System.out.println("Server: done");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + input);
		}
	}	
}
