package Try.Network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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
		case "requesting":
/////////////////////
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + input);
		}
	}	
}
