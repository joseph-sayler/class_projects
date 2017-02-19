# Class Projects

This repository holds various projects I have worked on in the classroom.
___
### Date project
The Date project is a java class with various methods to create and manipulate objects that contain calendar data. This was originally a project for a computer science class I took through Bellevue College.

To test the class, I created a sample test case that lists all of the class methods and their output. What follows is a brief overview of some of the methods within this class:

##### Constructors
This class has two constructors: one that takes in user supplied date information, and another that uses default values to create a generic data object.

For the main constructor, the user supplies a year, month and day. The constructor then calls a private method to check if the information entered is valid. This input validation method runs through a few logic statements and calls some other private helper functions to determine if the user input represents a valid date, either in the past or the future. The second constuctor creates a date object using default values of 1970, 1, and 1 to represent year, month and day respectively.

##### Accessor Methods
There are various public methods in this class used for accessing information from a Date object. This includes methods for getting the year, month, and day.

Other public methods that get data include `getMonthOfYear`, `getDayOfWeek`, `getDaysInMonth`, and `getDOY`. All of these methods use logic statements to interpret information entered by the user. For example, `getMonthOfYear` looks at the month of the date object and returns a string for the name of that month. `getDOY` looks day and month to return a number representing what the day of the year is for that date object.

##### Mutator Methods
The Date class also has various methods for changing a Date object. Methods include `addDays`, which changes the date based upon the number of days given, `nextDay`, which increments the date by 1 day, and `addWeeks`, which increments the date in multiples of 7.

##### Miscellaneous Methods
There are a few odd methods in this clas that help provide additional information about a date object.

The `daysTo` method compares two Date objects (this date object and some other date object) and determines the amount of time between them. If this date is greater than the other date (date 1 is AFTER date 2), the number returned is negative since the method i counting down from a future date. If the opposite is true (date 2 is greater than date 1), then the returned value is positive, because the method is counting forward (*to* some future date). This method was pretty complicated to produce, and it relies on method calls to other functions in the class, such as `getYear` and `getDOY`.

The `isLeapYear` method returns a boolean value if a particular year is a leap year. It is used in a few other methods (such as `getDOY`), but is also made available as a public method to let a user know if their date object is a leap year or not.

To do:
- [ ] add javadocs to the class
- [ ] create some type of interface (tui or gui)

___
### imgManipulator project
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
- [ ] create a gui with file explorer making it easier to pick images for transformation

