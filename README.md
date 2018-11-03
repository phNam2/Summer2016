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
        And then, after I got the raw picture, I will use the file <a href="https://github.com/phNam2/Summer2016/blob/master/Converting_Image/src/experiment/Pencil_Sketch.java">Pencil_Sketch.java</a> to loop through it. Bascally, the code will compare the current pixel to it previous one. If the 2 pixels have the same color, the current pixel will become white. However, if they are different, the pixe will become black. And here is the result:
        <p><img alt="Image" title="icon" src="https://github.com/phNam2/Summer2016/blob/master/image/pic/5.PNG" width="480px" height="270px"/></p>
        You can change the range of the color in the <strong>Image_Reduced</strong> file to get a new raw picture. The one I have in my file range is 50. But we also have another sample like:
        <p><img alt="Image" title="icon" src="https://github.com/phNam2/Summer2016/blob/master/experiment1(picture)/product3/sample1.png" width="480px" height="270px"/></p>
    </li>

</ul>
