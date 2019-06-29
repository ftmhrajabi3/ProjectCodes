package Try.Network;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashSet;
import java.util.Iterator;

import Try.logic.User;

public class ServerGetRequests {

	String email;
	HashSet<User> requests = new HashSet<>();

	public ServerGetRequests(String email) {
		super();
		this.email = email;
		File file = new File("D:\\Jpotify\\SampelCode\\Server\\" + email + "requsts.txt");
		if(file.exists()) {

			System.out.println("Server: " + email + " exits");
			try(FileReader fr = new FileReader(file);
					BufferedReader br = new BufferedReader(fr)) {
				
				String temp;
				while((temp = br.readLine()) != null) {
					System.out.println("Server: request from: " + temp);
					requests.add(getUser(temp));
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public HashSet<User> getRequests() {
		return requests;
	}
	
	
	private User getUser(String email) {
		User user = null;
		try {
			if(new File("D:\\Jpotify\\SampelCode\\Server\\" + email + ".txt").exists()) {
				System.out.println("Server:" + email + "file found");
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\Jpotify\\SampelCode\\Server\\" + email + ".txt")); 
				user = (User) ois.readObject();
				ois.close();				
			}
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(user != null)
			System.out.println("Server:" + email + "found");
		return user;
	}

	
}
