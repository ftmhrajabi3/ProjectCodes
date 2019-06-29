package Try.Network;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ServerRequesting {

	public ServerRequesting(String requestTo, String requestFrom) {
		super();
		String userRequestPath = "D:\\Jpotify\\SampelCode\\Server\\" + requestTo + "requsts.txt";
		File file = new File(userRequestPath);
		if(file.exists()) {
			System.out.println("Server: "+ requestTo + " exists");
			FileWriter fw;
			try {
				fw = new FileWriter(file, true);
				fw.write(requestFrom + "\r\n");
				fw.flush();
				System.out.println("Server: Request is from " + requestFrom);
				System.out.println("Server: writing in the file ...");
				fw.close();
				System.out.println("Server: done");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
}
