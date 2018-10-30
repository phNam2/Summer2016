package experiment_video;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;
import it.sauronsoftware.jave.InputFormatException;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;


public class Audio {

	public Audio() {

		
	}

	
	public void madeClip(String file) {
		
		File source = new File(file);
		File target = new File("C:/individual/subject/project/project2/experiment3(video)/Pikachu.mp3");
		AudioAttributes audio	= new AudioAttributes();
		audio.setCodec("libmp3lame");
		audio.setBitRate(new Integer(128000));
		audio.setChannels(new Integer(2));
		audio.setSamplingRate(new Integer(44100));
		EncodingAttributes attrs = new EncodingAttributes();
		attrs.setFormat("mp3");
		attrs.setAudioAttributes(audio);
		Encoder encoder = new Encoder();
		try {
			encoder.encode(source, target, attrs);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InputFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncoderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public double getTime(String input) throws UnsupportedAudioFileException, IOException {
		
		
		File file = new File(input);
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
		AudioFormat format = audioInputStream.getFormat();
		long audioFileLength = file.length();
		int frameSize = format.getFrameSize();
		float frameRate = format.getFrameRate();
		float durationInSeconds = (audioFileLength / (frameSize * frameRate));
		
		return durationInSeconds;
		
		
	}
	
	public static void main(String[] args) throws UnsupportedAudioFileException, IOException {

		Audio ex = new Audio();

		ex.madeClip("sample3/Pikachu.mp4");
		//System.out.println("The time: " + ex.getTime("C:/individual/subject/project/project2/experiment3(video)/Pikachu.mp3"));
	}

}
