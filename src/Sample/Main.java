package Sample;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;  
import javax.swing.JFrame;  
import javazoom.jl.decoder.JavaLayerException;

public class Main extends JFrame implements ActionListener{

	FileInputStream  fileInputStream;

	JButton play=new JButton("Play");

	JButton pause=new JButton("pause");

	JButton resume=new JButton("resume");

	JButton stop=new JButton("stop");
    
	Main(){  
    
		JFrame frame=new JFrame();  
        
		play.setBounds(0,50,70, 50);  
        
		pause.setBounds(70,50,70, 50);      
        resume.setBounds(140,50,70, 50); 
        stop.setBounds(210,50,70, 50); 
        frame.add(play);  
        frame.add(pause); 
        frame.add(resume); 
        frame.add(stop); 
        frame.setSize(300,200);  
        frame.setLayout(null);  
        frame.setVisible(true);           
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        play.addActionListener(this);
        pause.addActionListener(this);
        resume.addActionListener(this);
        stop.addActionListener(this);
    }

    
    public void actionPerformed(ActionEvent e) {
   
        try {
             fileInputStream = new FileInputStream("C:\\Users\\Nakos\\Desktop\\They3.mp3");
             PausablePlayer player = new PausablePlayer(fileInputStream);
            
             Object source = e.getSource();
             if(source==play)
             {System.out.println("play button");
             player.play();}
             if(source==pause)
             {System.out.println("pause button");
             player.pause();    }
             if(source==resume)
             {System.out.println("resume button");
             player.resume();}
              if(source==stop)
             {System.out.println("stop button");
             player.stop();}
        } catch (FileNotFoundException | JavaLayerException ex) {
            Logger.getLogger(JButton.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(JButton.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}