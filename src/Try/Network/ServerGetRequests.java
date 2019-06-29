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
		File file = new File("D:\\Jpotify\\SampelCode\\Server\\"+ email + "requests.txt");
		if(file.exists()) {

			try(FileReader fr = new FileReader(file);
					BufferedReader br = new BufferedReader(fr);) {
				
				String temp;
				while((temp = br.readLine()) != null)
					requests.add(getUser(temp));
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public HashSet<User> getRequests() {
//		User[] allRequests = new User[requests.size()];
//		int i = 0;
//		Iterator<User> it = requests.iterator(); 
//        while (it.hasNext()) {
//        	allRequests[i] = it.next();
//        	i++;
//        }
//        return allRequests;
		return requests;
	}
	
	
	private User getUser(String email) {
		User user = null;
		try {
			if(new File("D:\\Jpotify\\SampelCode\\Client\\" + email + ".txt").exists()) {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\Jpotify\\SampelCode\\Client\\" + email + ".txt")); 
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
		return user;
	}

	
}
