# Class Projects

This repository holds various projects I have worked on in the classroom.

#### Date project
The Date project is a java class with various methods to create and manipulate objects that contain calendar data. This was originally a project for a computer science class I took through Bellevue College.

To test the class, I created a  sample test case that lists all of the class methods and their output.

To do:
* add javadocs to the class
* create some type of interface (tui or gui)

#### imgManipulator project
This started out as a homework assignment for a python class I had at North Seattle College. The program uses image files in .ppm format and alters them in a couple of different ways. The .ppm format basically stores image data in ASCII characters, which can be easily manipulated. The image format is not efficient at all, and file sizes are much bigger than other image formats, like .png or .jpg. The format is also not used a lot, making viewing and converting other image files (.png, .jpg, or .gif) difficult. GIMP (Gnu Image Manipulation Program) is capable of doing this, which is what I used to convert and view images for this project.

In .ppm images, each pixel is represented by 3 numbers, one for red, blue, and green, with values between 0 and 255. The program manipulates these values to perform various transformations on images. Three transformations are performed, one converting the image to black and white, another removing all red values (sets red to 0), and the final transformation reverses the order of the pixels causing the image to flip. See the examples below.

Original Image
![image](https://raw.githubusercontent.com/joseph-sayler/class_projects/master/imgManipulator/examples/logo.png)

Black and White transformation
![image](https://raw.githubusercontent.com/joseph-sayler/class_projects/master/imgManipulator/examples/gr_logo.png)

Removal of Red transformation
![image](https://raw.githubusercontent.com/joseph-sayler/class_projects/master/imgManipulator/examples/nr_logo.png)

Image Flip transformation
![image](https://raw.githubusercontent.com/joseph-sayler/class_projects/master/imgManipulator/examples/fl_logo.png)

To do:
* create a gui with file explorer making it easier to pick images for transformation

