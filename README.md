# Summer2016-Picture Altering project

<p>This is a fun project that I did for fun when I was still a second-year student. In the end it becomes too big for me to handle. This is before I know about version control so I cannot upload all of the files I used to do. But I will still upload the core codes and the examples.<p><br/>

<h2>Part 1: Making picture</h2>
<p>The concept is simple: I used an original picture and build a Java program to convert it to a painting or a sketch<p>
<p>The method is basically loop through all of the pixels, check the range of its color (RGB) and decided which color it gonna be.</p>
<p>For the colors I used, I have created them by using the class <a href="https://github.com/phNam2/Summer2016/blob/master/Converting_Image/src/experiment/CreateColor.java">CreateColor.java</a>. and stored them in the folders: <a href="https://github.com/phNam2/Summer2016/tree/master/Converting_Image/colors">colors</a> and <a href="https://github.com/phNam2/Summer2016/tree/master/Converting_Image/colors3">colors3</a></p><br/>

<p>So, the concept here is that in the normal picture, we can have many pixels that represent one color, such as blue. However, those "blue" have different RGB values. So, I get all of those blue pixels, compare to the color blue in my folder, and turn them into that one blue. Basically, to make a more animated version the real-world image, we have to make similar pixels become the same.</p><br/>

<p>After a while, I have created a bunch of classes to do different ways of alternating picture.</p>
<p>If you want to try all of the method at one, you can download the whole <a href="https://github.com/phNam2/Summer2016/tree/master/Converting_Image">Converting_Image</a> folder, and fo to the <a href="https://github.com/phNam2/Summer2016/blob/master/Converting_Image/src/experiment/index.java">index.java</a> file in the Converting_Image/src/experiment path. Before you run the code, you will  need to choose the path for your picture in the main method. And when you run it, it will ask you the number as a way to which method you want to use, and it will show up in a panel.<br/></p>

<p>Now, I have some examples here. We have an original picture:</p>
<p><img alt="Image" title="icon" src="https://github.com/phNam2/Summer2016/blob/master/image/pic/1.PNG" width="480px" height="270px"/></p>
<ul>
    <li><h4>Automatic Altering</h4>
        The first one is automatic convert, it is the <a href="https://github.com/phNam2/Summer2016/blob/master/Converting_Image/src/experiment/Automatic_Convert.java">Automatic_Convert.java</a> file and just like the name, it will make the original picture become more painting like and you don't need to change the code. Here is the result:
        <p><img alt="Image" title="icon" src="https://github.com/phNam2/Summer2016/blob/master/image/pic/2.PNG" width="480px" height="270px"/></p>
    </li>
    <li><h4>Convert by choice</h4>
        This option was done by the <a href="https://github.com/phNam2/Summer2016/blob/master/Converting_Image/src/experiment/Control_Convert.java">Control_Convert.java</a> file. You can actually change the number in the file if you want to get to the range of color number and get the version of picture if you want. I originally plan to create a panel to do this easier, but then forget about it on the way. The range is in the <strong>Drawing</strong> method and change the range of the RGB. Here is the result with the range of 50:
        <p><img alt="Image" title="icon" src="https://github.com/phNam2/Summer2016/blob/master/image/pic/3.PNG" width="480px" height="270px"/></p>
    </li>
    <li><h4>Double picture</h4>
        This method a create just becaue I want to compare the original with the altered one, as a way to test. The file is <a href="https://github.com/phNam2/Summer2016/blob/master/Converting_Image/src/experiment/Double_Picture.java">Double_Picture.java</a> and the result is:
        <p><img alt="Image" title="icon" src="https://github.com/phNam2/Summer2016/blob/master/image/pic/4.PNG" width="960px" height="270px"/></p>
    </li>    
    <li><h4>Pencil sketch</h4>
        This one is a little tricky because this means the color is even more reduce than before, and too much color can make the whole sketch become chaotic. This is why I made use 2 files for this. First, I used the <a href="https://github.com/phNam2/Summer2016/blob/master/Converting_Image/src/experiment/Image_Reduced.java">Image_Reduced.java</a> file to make the color becoming as less as possible, such as:
        <p><img alt="Image" title="icon" src="https://github.com/phNam2/Summer2016/blob/master/experiment1(picture)/product6/sample3.png" width="480px" height="270px"/></p>
        And then, after I got the raw picture, I will use the file <a href="https://github.com/phNam2/Summer2016/blob/master/Converting_Image/src/experiment/Pencil_Sketch.java">Pencil_Sketch.java</a> to loop through it. Bascally, the code will compare the current pixel to it previous one. If the 2 pixels have the same color, the current pixel will become white. However, if they are different, the pixel will become black. And here is the result:
        <p><img alt="Image" title="icon" src="https://github.com/phNam2/Summer2016/blob/master/image/pic/5.PNG" width="480px" height="270px"/></p>
        You can change the range of the color in the <strong>Image_Reduced</strong> file to get a new raw picture. The one I have in my file range is 50. But we also have another sample like:
        <p><img alt="Image" title="icon" src="https://github.com/phNam2/Summer2016/blob/master/experiment1(picture)/product3/sample1.png" width="480px" height="270px"/></p>
    </li>
</ul>
<br/>

<h2>Part 2: Making gif</h2>
<p>When I finish up with the picture section, I started to thought about how about I can change the whole video into more painting like. So I decide to find out how to do it. The first sample I want to try with is gif. Obviously, I do not know how to do it myelf, so I find the external library to help me extract the gif file into frames. And the code I found are the <a href="https://github.com/phNam2/Summer2016/blob/master/Converting_Image/src/experiment_giff/GifDecoder.java">GifDecoder.java</a> and <a href="https://github.com/phNam2/Summer2016/blob/master/Converting_Image/src/experiment_giff/Giffer.java">Giffer.java</a>. I have inserted the link where I found them in the begining of each file. And I did all of the decode in the <a href="https://github.com/phNam2/Summer2016/blob/master/Converting_Image/src/experiment_giff/Gif_View.java">Gif_View.java</a> file, at the <strong>printImages</strong> method. You can give the location of the gif file and the location you want to stores the pictures. And here we have the sample:
    <p><img alt="Image" title="icon" src="https://github.com/phNam2/Summer2016/blob/master/Converting_Image/sample2/dance.gif" width="150px" height="150px"/></p>
And here is the result:
    <p>
        <img alt="Image" title="icon" src="https://github.com/phNam2/Summer2016/blob/master/image/gif/1.png" width="150px" height="150px" float="left" postion="relative"/>
        <img alt="Image" title="icon" src="https://github.com/phNam2/Summer2016/blob/master/image/gif/2.png" width="150px" height="150px" float="left" postion="relative"/>
        <img alt="Image" title="icon" src="https://github.com/phNam2/Summer2016/blob/master/image/gif/3.png" width="150px" height="150px" float="left" postion="relative"/>
        <img alt="Image" title="icon" src="https://github.com/phNam2/Summer2016/blob/master/image/gif/4.png" width="150px" height="150px" float="left" postion="relative"/>
        <img alt="Image" title="icon" src="https://github.com/phNam2/Summer2016/blob/master/image/gif/5.png" width="150px" height="150px" float="left" postion="relative"/>
        <img alt="Image" title="icon" src="https://github.com/phNam2/Summer2016/blob/master/image/gif/6.png" width="150px" height="150px" float="left" postion="relative"/>
        <img alt="Image" title="icon" src="https://github.com/phNam2/Summer2016/blob/master/image/gif/7.png" width="150px" height="150px" float="left" postion="relative"/>
        <img alt="Image" title="icon" src="https://github.com/phNam2/Summer2016/blob/master/image/gif/8.png" width="150px" height="150px" float="left" postion="relative"/>
        <img alt="Image" title="icon" src="https://github.com/phNam2/Summer2016/blob/master/image/gif/9.png" width="150px" height="150px" float="left" postion="relative"/>
    </p>
And in the <a href="https://github.com/phNam2/Summer2016/blob/master/Converting_Image/src/experiment_giff/Create_Gif.java">Create_Gif</a> file, you can create a gif from a list of picture. However, for now, what I do is only decode the gif and then resemble them in the file. I have not created a method that access a specific flder yet.
</p>
<br/>

<h2>Part 3: Making video</h2>
<p>Video is the hardest of them all when I have to try many type of external libraries to decode the video. I finally found the jcodec, and I have imported it in my project. The first outcome was not that great because the frame color was not the same as the video. Therefore, I have to change the source code a little bit. <br/>
In the end, I have done all the file inside the <a href="https://github.com/phNam2/Summer2016/blob/master/Converting_Image/src/experiment_video/Video_decode_jcodec.java">Video_decode_jcodec.java</a> file at the <strong>decodeVideo</strong> method. You can also change the rate of the picture, which mean the time beetween the frames to get the most precise number of frames for later recreation. Because there are like 67 frames for the shortest video, here are some of the frame samples:
    <p>
        <img alt="Image" title="icon" src="https://github.com/phNam2/Summer2016/blob/master/image/video/frame_1.png" width="150px" height="150px" float="left" postion="relative"/>
        <img alt="Image" title="icon" src="https://github.com/phNam2/Summer2016/blob/master/image/video/frame_3.png" width="150px" height="150px" float="left" postion="relative"/>
        <img alt="Image" title="icon" src="https://github.com/phNam2/Summer2016/blob/master/image/video/frame_6.png" width="150px" height="150px" float="left" postion="relative"/>
        <img alt="Image" title="icon" src="https://github.com/phNam2/Summer2016/blob/master/image/video/frame_9.png" width="150px" height="150px" float="left" postion="relative"/>
        <img alt="Image" title="icon" src="https://github.com/phNam2/Summer2016/blob/master/image/video/frame_10.png" width="150px" height="150px" float="left" postion="relative"/>
        <img alt="Image" title="icon" src="https://github.com/phNam2/Summer2016/blob/master/image/video/frame_13.png" width="150px" height="150px" float="left" postion="relative"/>
        <img alt="Image" title="icon" src="https://github.com/phNam2/Summer2016/blob/master/image/video/frame_16.png" width="150px" height="150px" float="left" postion="relative"/>
        <img alt="Image" title="icon" src="https://github.com/phNam2/Summer2016/blob/master/image/video/frame_18.png" width="150px" height="150px" float="left" postion="relative"/>
        <img alt="Image" title="icon" src="https://github.com/phNam2/Summer2016/blob/master/image/video/frame_20.png" width="150px" height="150px" float="left" postion="relative"/>
        <img alt="Image" title="icon" src="https://github.com/phNam2/Summer2016/blob/master/image/video/frame_22.png" width="150px" height="150px" float="left" postion="relative"/>
    </p>
And also in that file, you can use the <strong>makeVideo</strong> method to make a video with no sound, because like the gif, I have not make a method to access folder yet. Here is a <a href="https://github.com/phNam2/Summer2016/blob/master/image/video/Pikachu.mp4">sample</a>.<br/>
And for the audio, I also made <a href="https://github.com/phNam2/Summer2016/blob/master/Converting_Image/src/experiment_video/Audio.java">Audio.java</a> file that can extract the audio out of the video. You can add the location of the mp4 file you want to extract and the mp3 you want to store. And here is the <a href="https://github.com/phNam2/Summer2016/blob/master/image/video/Pikachu.mp3">sample</a>.<br/>
I also plan to find a way to combine the video and audio file into one, in the <strong>Combine.java</strong> file, but in the end, I never finish it.
</p><br/>

<h2>In Conclusion</h2>
<p>My idea when making this project is to turn a real-life video into something more animated, and I was very closed until I stuck at the combining audio and video. Also, buiding the whole inteface to make the code more robust is too hard for me alone, and they already have program that can do this online, so in the end, I drop it for a while. But this was a fun experience, and I tend to look forward to the next project in the future.</p>


