package Try.Network;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ServerRequesting {

	public ServerRequesting(String emailAddress) {
		super();
		String userRequestPath = "D:\\Jpotify\\SampelCode\\Server\\" + emailAddress + "requests.txt";
		File file = new File(userRequestPath);
		if(file.exists()) {
			FileWriter fw;
			try {
				fw = new FileWriter(file, true);
				fw.write(emailAddress + "\r\n");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
}
