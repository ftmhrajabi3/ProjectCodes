package Try.Network;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashSet;

import Try.logic.User;

public class GettingFriends {

	HashSet<User> newFriends = new HashSet<User>();
	
	public GettingFriends(String email) {
		super();
		
		File file = new File("D:\\Jpotify\\SampelCode\\Server\\" + email + "acceptedRequsts.txt");
		
		try(FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr)) {
			String temp;
			while((temp = br.readLine()) != null) {
				System.out.println("Server: request from: " + temp);
				newFriends.add(getUser(temp));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	
	
	public HashSet<User> getFriends() {
		return newFriends;
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
