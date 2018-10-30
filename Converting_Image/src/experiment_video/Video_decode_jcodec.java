package experiment_video;

import java.util.LinkedList;
import java.util.ListIterator;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
 
import javax.imageio.ImageIO;

//import org.jcodec.api.awt.AWTFrameGrab;
import org.jcodec.api.FrameGrab;
import org.jcodec.api.JCodecException;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.common.model.Picture;
import org.jcodec.api.SequenceEncoder;
import org.jcodec.scale.AWTUtil;

public class Video_decode_jcodec {
	
	
	public LinkedList<BufferedImage> images;
	

	public Video_decode_jcodec() {
		// TODO Auto-generated constructor stub
		images = new LinkedList<BufferedImage>();
	}

	
	public void decodeVideo (String fileName, double time) throws IOException, JCodecException {
		
		AWTUtil convert = new AWTUtil();
		
		int x =1;

		for (double i =0; i < time; i= i + 0.04) {
			
			Picture frame = FrameGrab.getFrameAtSec(new File(fileName), i);
			BufferedImage frame3 = convert.toBufferedImage(frame);
			ImageIO.write(frame3, "png", new File("C:/individual/subject/project/project2/experiment3(video)/kyonji2/frame_" + x + ".png"));
			
			x++;
		}
	}
	
	
	public void makeFrame_List(String fileName, double time) throws IOException, JCodecException {
		
		AWTUtil convert = new AWTUtil();

		for (double i =0; i < time; i= i + 0.04) {
			
			Picture frame = FrameGrab.getFrameAtSec(new File(fileName), i);
			BufferedImage frame3 = convert.toBufferedImage(frame);
	
			images.addLast(frame3);
		}
		
	}
	
	public LinkedList<BufferedImage> getList(){
		
		return images;
	}
	
	public void makeVideo(String fileName, double time) throws IOException, JCodecException{
		
		AWTUtil convert = new AWTUtil();
		makeFrame_List(fileName, time);
		
		//SequenceEncoder enc = new SequenceEncoder(new File("filename"));
		
		SeekableByteChannel ch = NIOUtils.writableChannel(new File("C:/individual/subject/project/project2/experiment3(video)/kyonji2/Eldia2.mp4"));
		SequenceEncoder enc = new SequenceEncoder(ch);
		
		ListIterator<BufferedImage> iterator = getList().listIterator();
		while (iterator.hasNext()){
			
			BufferedImage image = iterator.next();
			Picture pic = convert.fromBufferedImageRGB(image);
			
			enc.encodeNativeFrame(pic);
		}
		enc.finish();
		
	}
	
	public static void main(String[] args) throws IOException, JCodecException {
		// TODO Auto-generated method stub

		Video_decode_jcodec exp = new Video_decode_jcodec();
		
		//exp.decodeVideo("sample3/Eldia.mp4", 90);
		exp.makeVideo("sample3/Eldia.mp4", 90);
		
	}	

}
