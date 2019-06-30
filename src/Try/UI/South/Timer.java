package Try.UI.South;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.sound.sampled.Clip;
import javax.swing.JLabel;
import javax.swing.JSlider;

import jaco.mp3.player.MP3Player;

/**
 * This class counts playing time in the form of HH:mm:ss
 * It also updates the time slider
 * @author www.codejava.net
 *
 */
public class Timer extends Thread {
	private DateFormat dateFormater = new SimpleDateFormat("HH:mm:ss");	
	private boolean isRunning = false;
	private boolean isPause = false;
	private boolean isReset = false;
	private long startTime;
	private long pauseTime;
	
	private JLabel labelRecordTime;
	private JSlider slider;
	int currentSecond = 0;
	private JLabel timeRemaining;
	private long totalTime;

	Timer(JLabel labelRecordTime, JSlider slider, JLabel timeRemaining) {
		this.labelRecordTime = labelRecordTime;
		this.slider = slider;
		this.timeRemaining = timeRemaining;
	}
	
	
	
	public void setTotalTime(long totalTime) {
		this.totalTime = totalTime;
		//slider.setMaximum((int)totalTime);
		timeRemaining.setText(getClipLengthString());
	}




	public void run() {
		isRunning = true;
		
		startTime = System.currentTimeMillis();
		while (isRunning) {
			try {
				Thread.sleep(100);
//				System.out.println(isReset);
				if(isReset) {
					startTime = System.currentTimeMillis();
					currentSecond = 0;
					pauseTime = 0;
					slider.setValue(0);
					labelRecordTime.setText("00:00:00");
					isReset = false;
				}
				if (!isPause) {
						labelRecordTime.setText(toTimeString());
						currentSecond += 100;
						slider.setValue(currentSecond/1000);
				} else {
					pauseTime += 100;
				}
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	
	/**
	 * Reset counting to "00:00:00"
	 */
	void reset() {
		System.out.println("timer must reset");
		isReset = true;
	}
	
	void pauseTimer() {
		isPause = true;
	}
	
	void resumeTimer() {
		isPause = false;
	}
	
	/**
	 * Generate a String for time counter in the format of "HH:mm:ss"
	 * @return the time counter
	 */
	private String toTimeString() {
		long now = System.currentTimeMillis();
		Date current = new Date(now - startTime - pauseTime);
		dateFormater.setTimeZone(TimeZone.getTimeZone("GMT"));
		String timeCounter = dateFormater.format(current);
		return timeCounter;
	}
	
	
	private static final int SECONDS_IN_HOUR = 60 * 60;
	private static final int SECONDS_IN_MINUTE = 60;
	
	
	public String getClipLengthString() {
		String length = "";
		long hour = 0;
		long minute = 0;
		long seconds = totalTime/1000;
		
//		System.out.println(seconds);
		
		if (seconds >= SECONDS_IN_HOUR) {
			hour = seconds / SECONDS_IN_HOUR;
			length = String.format("%02d:", hour);
		} else {
			length += "00:";
		}
		
		minute = seconds - hour * SECONDS_IN_HOUR;
		if (minute >= SECONDS_IN_MINUTE) {
			minute = minute / SECONDS_IN_MINUTE;
			length += String.format("%02d:", minute);
			
		} else {
			minute = 0;
			length += "00:";
		}
		
		long second = seconds - hour * SECONDS_IN_HOUR - minute * SECONDS_IN_MINUTE;
		
		length += String.format("%02d", second);
		
		return length;
	}

}