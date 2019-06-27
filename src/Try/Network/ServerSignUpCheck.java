package Try.Network;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import Try.logic.User;

public class ServerSignUpCheck {

	private String name;
	private String email;
	private String password;
	private File file;
	private User user;
	
	public ServerSignUpCheck(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		file = new File("D:\\Jpotify\\SampelCode\\Server\\" + email + ".txt");
	}

	public boolean checkEmail() {
		if(file.exists())
			return false;
		creatAccount();
		return true;
	}
	
	private void creatAccount() {
		user = new User(name, email, password);
		try {
			file.createNewFile();
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream out =  new ObjectOutputStream(fos);
			out.writeObject(user);
			out.flush();
			out.close();
			file = new File("D:\\Jpotify\\SampelCode\\Server\\" + email + "requsts.txt");
			file.createNewFile();
			file = new File("D:\\Jpotify\\SampelCode\\Server\\shared" + email);
			file.mkdir();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
