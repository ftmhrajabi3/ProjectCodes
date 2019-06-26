package Try.Network;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import Try.logic.User;

public class ServerLoginCheck {
	
	private String username;
	private String password;
	
	
	
	public ServerLoginCheck(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}


	public boolean checkUser() {
		File file = new File("D:\\Jpotify\\SampelCode\\Server\\" + username + ".txt");
		if(!file.exists())
			return false;
		return checkPassword(file);
	}
	
	
	private boolean checkPassword(File file) {
		
		try(ObjectInputStream oin=new ObjectInputStream(new FileInputStream(file))) {
			User user = (User) oin.readObject();
			if(user.getPassword().equals(password))
				return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return false;
	}
}
