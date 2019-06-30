package Try.Network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
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
			System.out.println(getClass() + " : " + "gonna wake up server");
			server = new ServerSocket(444);
			socket = server.accept();
			dis = new DataInputStream(socket.getInputStream());
			System.out.println(getClass() + " : " + "server is awake");
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
				new ServerRequesting(dis.readUTF(), dis.readUTF());
				dis.close();
				socket.close();
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
			
			
		case "get requests":
			
			System.out.println(getClass() + " : " + "looking for requests of ");
			try (ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())){
				HashSet<User> requests = new ServerGetRequests(dis.readUTF(), "requests.txt").getRequests();
				out.writeObject(requests);
				out.flush();
				socket.close();
				server.close();
				System.out.println(getClass() + " : " + "Done!!");
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		
			
		case "accepted request of":
			
			try {
				new AcceptanceOfRequests(dis.readUTF(), dis.readUTF());
				socket.close();
				server.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
			
		case "getting new friends":
			
			try (ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())){
				HashSet<User> friends = new ServerGetRequests(dis.readUTF(), "acceptedRequsts.txt").getRequests();
				out.writeObject(friends);
				out.flush();
				socket.close();
				server.close();
				System.out.println(getClass() + " : " + "Done!!");
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + input);
		}
	}	
}
