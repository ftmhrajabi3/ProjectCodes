package Try.Network;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AcceptanceOfRequests {

	public AcceptanceOfRequests(String email, String acceptedEmail) {
		super();
		
		File file = new File("D:\\Jpotify\\SampelCode\\Server\\" + email + "requsts.txt");
		File copyFile = new File("D:\\Jpotify\\SampelCode\\Server\\" + email + "requsts1.txt");
		
		System.out.println(getClass() + " : " + email + " accepted "+ acceptedEmail);
		
		try(FileWriter fw = new FileWriter(copyFile)) {
			
			if(file.exists()) {
				System.out.println(getClass() + " : " + email + " exists");
				try(FileReader fr = new FileReader(file);
						BufferedReader br = new BufferedReader(fr)) {
					
					String temp;
					while((temp = br.readLine()) != null) {
						if(!temp.equals(acceptedEmail)) {
							System.out.println("Server: request from: " + temp);
							fw.write(temp + "\r\n");
							fw.flush();
						}
						else {
							File acceptedGuy = new File("D:\\Jpotify\\SampelCode\\Server\\" + acceptedEmail + "acceptedRequsts.txt");
							FileWriter fileWriter = new FileWriter(acceptedGuy);
							fileWriter.write(temp + "\r\n");
							fileWriter.flush();
							fileWriter.close();
						}
					}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		file.delete();
		copyFile.renameTo(new File("D:\\Jpotify\\SampelCode\\Server\\" + email + "requsts.txt"));

	}
	
}
