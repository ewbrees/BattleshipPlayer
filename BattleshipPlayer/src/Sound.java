import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class Sound {
	
	void playSoundMiss(String soundLocation) {
		
		try {
			File soundPath = new File(soundLocation);
			if(soundPath.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(soundPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
				
				JOptionPane.showMessageDialog(null, "Miss...");
			} else {
				System.out.println("File not found");
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	void playSoundHit(String soundLocation) {
		
		try {
			File soundPath = new File(soundLocation);
			if(soundPath.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(soundPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
				
				JOptionPane.showMessageDialog(null, "Hit!");
			} else {
				System.out.println("File not found");
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	void playSoundAlarm(String soundlocation) {
		
		try {
			File soundPath = new File(soundlocation);
			if(soundPath.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(soundPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
				
				JOptionPane.showMessageDialog(null, "One of your Ships is Sunk!");
			} else {
				System.out.println("File not found");
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	void playSoundWin(String soundLocation) {
		
		try {
			File soundPath = new File(soundLocation);
			if(soundPath.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(soundPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
				
				JOptionPane.showMessageDialog(null, "You Win!");
			} else {
				System.out.println("File not found");
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	void playSoundLose(String soundLocation) {
		
		try {
			File soundPath = new File(soundLocation);
			if(soundPath.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(soundPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
				
				JOptionPane.showMessageDialog(null, "You Lose...");
			} else {
				System.out.println("File not found");
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
