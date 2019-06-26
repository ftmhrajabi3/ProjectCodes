package Try;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Playbtn {

	String path;
	File file;
	FileInputStream fis;
	BufferedInputStream bis;
	Player player;
	boolean isPaused = false;
	long pauseLocation;
	long songTotalLength;
	Thread song;
	
	public FileInputStream getFis() {
		return fis;
	}


	public Playbtn(String path) {
		super();
		this.path = path;
		file = new File(path);
	}

	
	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public boolean isPlaying() {
		return isPaused;
	}


	public void setPlaying(boolean isPaused) {
		this.isPaused = isPaused;
	}


	public void play() {
		try{
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			if(player == null)
				songTotalLength = bis.available();
			player = new Player(bis);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JavaLayerException e) {
			e.printStackTrace();
		}
		
		song = new Thread(){
			public void run() {
				try {
					player.play();
					isPaused = false;
//					if(player.isComplete()) {
//						//play the next song
//					}
				
				}catch(JavaLayerException e) {
					e.printStackTrace();
				}
				
			}
		};
		song.start();
		
	}
	
	
	public void pause() {
		song.interrupt();
		if(player != null) {
			try {
				pauseLocation = bis.available();
				player.close();
				bis.close();
				fis.close();
				System.out.println("pauseLocation " + pauseLocation);
				isPaused = true;
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void resume() {
		try {
			fis = new FileInputStream(path);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
			System.out.println("pauseLocation " + bis.available());
			fis.skip(songTotalLength - pauseLocation);
			isPaused = false;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		song = new Thread(){
            @Override
            public void run(){
                try {
                    player.play();
                } catch (JavaLayerException ex) {
                	ex.printStackTrace();
                }
            }
		};
		song.start();
	}

}
	

