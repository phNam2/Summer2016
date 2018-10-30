package experiment_video;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
*
*http://stackoverflow.com/questions/1267488/play-wav-file-backward
* @author Martijn
*/

public class Audio_reverse {

    private byte[][] frames;
    private int frameSize;

    public Audio_reverse(AudioInputStream stream) throws IOException {
        readFrames(stream);
    }

    public byte[] getFrame(int i) {
        return frames[i];
    }

    public int numberFrames()
    {
        return frames.length;
    }

    public int frameSize()
    {
        return frameSize;
    }

    private void readFrames(AudioInputStream stream) throws IOException {
        frameSize = stream.getFormat().getFrameSize();
        frames = new byte[stream.available() / frameSize][frameSize];
        int i = 0;
        for (; i < frames.length; i++)
        {
            byte[] frame = new byte[frameSize];
            int numBytes = stream.read(frame, 0, frameSize);
            if (numBytes == -1)
            {
                break;
            }
            frames[i] = frame;
        }
        System.out.println("FrameSize = " + frameSize);
        System.out.println("Number frames = " + frames.length);
        System.out.println("Number frames read = " + i);
    }
	
	
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException {
    	
    	File test = new File("C:/individual/subject/project/project2/experiment3(video)/sound2.wav");
    	
    	AudioInputStream stream = AudioSystem.getAudioInputStream(test);
    	
    	Audio_reverse frameStream = new Audio_reverse(stream);
    	
    	//frameStream.readFrames(stream);
    }

}
