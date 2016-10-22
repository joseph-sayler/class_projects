/*Joseph Sayler
 * Assignment 3: Date
 * 12/04/2014
 * 
 * Programming Project #2, Chapter 8, p. 571
 */

public class Date {
	
	// Here are the private fields for this class.
	private int month = 0;
	private int day = 0;
	private int year = 0;

	// These are some common constants.
	private static final int daysInYear = 365;
	private static final int monthsInYear = 12;
	private static final int daysInWeek = 7;
	private static final int firstYear = 1753;
	
	// These two arrays contain strings naming months and days.
	// They are used in methods such as longDate().
	private static final String[] MONTHSOFYEAR = {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", 
		"JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
	private static final String[] DAYSOFWEEK = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", 
		"Friday", "Saturday"};
	// this array contains the ends of each month, used in getDOY 
	private static final int[] ENDOFMONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	// This is the main constructor for this class. It takes in integers for a year, a month and a day.
	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
		// ensures data entered is valid
		checkValidity();
	}
	
	// This is the 2nd constructor, utilizing a default date.
	public Date() {
		this(1970, 1, 1);
	}
	
	// This returns field "day".
	public int getDay() {
		return this.day;
	}
	
	// This returns field "month".
	public int getMonth() {
		return this.month;
	}
	
	// This returns field "year".
	public int getYear() {
		return this.year;
	}
	
	// This method counts and returns the number of days between two dates. It returns a
	// negative value if counting backwards.
	public int daysTo(Date other) {	
		int totalYears = 0;
		int leapCounter = 0;
		int totalDays = 0;
		// counts backwards (negative final value)
		if (this.year > other.getYear()) {
			// adds up # of leap years
			for (int i = other.getYear(); i < this.year; i++) {
				if (i % 4 == 0 && i % 100 != 0) {
					leapCounter++;
				} else if (i % 400 == 0) {
					leapCounter++;
				}
			}
			// gets total # of days over the years given (starts count on Jan 1)
			totalYears = (this.year - other.getYear()) * daysInYear;
			// adds everything up (including remaining days of year)
			totalDays = ((this.getDOY() - other.getDOY()) + leapCounter + totalYears) / -1;
		// counts forwards (positive final value)
		} else if (other.getYear() > this.year) {
			for (int i = this.year; i < other.getYear(); i++) {
				if (i % 4 == 0 && i % 100 != 0) {
					leapCounter++;
				} else if (i % 400 == 0) {
					leapCounter++;
				}
			}
			totalYears = (other.getYear() - this.year) * daysInYear;
			totalDays = (other.getDOY() - this.getDOY()) + leapCounter + totalYears;
		}
		return totalDays;
	}
	
	// This is a static method allowing two dates to be compared by passing parameters to the
	// daysTo() method.
	public static int daysTo(Date x, Date y) {
		return x.daysTo(y);
	}
	
	// This method increases the current date by x number of days via a loop and the
	// getDaysInMonth() method. After every 12-31, month is set to 1 and year is incremented by 1.
	public void addDays(int days) {
		for (int i = 1; i <= days; i++) {
			this.day++;
			if (this.day > this.getDaysInMonth()) {
				if (this.month == 12) {
					this.day -= this.getDaysInMonth();
					this.month = 1;
					this.year++;
				} else {
					this.day -=this. getDaysInMonth();
					this.month++;
				}
			}
		}
	}

	// This method adds one day per call by sending a value of 1 to addDays().
	public void nextDay() {
		this.addDays(1);
	}
	
	// This method converts weeks to days, then sends that value to the addDays() method.
	public void addWeeks(int weeks) {
		weeks *= daysInWeek;
		this.addDays(weeks);
	}
	
	// This method returns the end date of the current month. It checks February for a
	// leap year, and adjusts that month accordingly. It also differentiates between months
	// that end in 31 days versus 30 days.
	private int getDaysInMonth() {
		int endOfMonth = 0;
		// determines end date if leap year
		if (this.month == 2) {
			if (this.isLeapYear() == false) {
				endOfMonth = 28;
			} else if (this.isLeapYear() == true) {
				endOfMonth = 29;
			}
		// odd #'d months between Jan & Jul and even #'d months between Aug & Dec end in 31 days
		} else if ((this.month < 8 && this.month % 2 == 1) || 
				(this.month > 7 && this.month % 2 == 0)) {
			endOfMonth = 31;
		// all other months end in 30 days
		} else {
			endOfMonth = 30;
		}
		return endOfMonth;
	}
	
	// This method looks at day and month and returns the Day of that Year.
	public int getDOY() {
		int doy = 0;
		// loop add up ends of months until reaches target month
		for (int i = 0; i < this.month - 1; i++) {
			doy += ENDOFMONTH[i];
		}
		// checks if DOY ends on a month after Feb on a leap year
		if (isLeapYear() == true && doy >= 59) {
			doy += 1;
		}
		doy += this.day;
		return doy;
	}

	// This returns true if current year is a leap year.
	public boolean isLeapYear() {
		boolean leapYear;
		if(this.year % 4 == 0 && this.year % 100 != 0) {
			leapYear = true;
		} else if(this.year % 400 == 0) {
			leapYear = true;
		} else {
			leapYear = false;
		}
		return leapYear;
	}
	
	// This determines if 2 Date objects contain equal values by comparing fields in both objects.
	public boolean equals(Date x) {
		if (this.day == x.getDay() && this.month == x.getMonth() && this.year == x.getYear()) {
			return true;
		} else {
			return false;
		}
	}
	
	// This generates a string of the date in format mm/dd/yyyy by tacking on zeroes where necessary.
	public String toString() {
		String mo = "", da = "";
		if (this.month < 10) {
			mo = "0" + this.month;
		} else if (this.month > 10) {
			mo = "" + this.month;
		}
		if (this.day < 10) {
			da = "0" + this.day;
		} else if (this.day > 10) {
			da = "" + this.day;
		}
		return mo + "/" + da + "/" + this.year;
	}
	
	// This method returns a string representing the day and month in words.
	public String longDate() {
		return this.getDayOfWeek() + ", " + this.getMonthOfYear() + " " + this.day + ", " + this.year;
	}
	
	// This method returns a string equivalent of the current month (1 = January, etc.).
	private String getMonthOfYear() {
		return MONTHSOFYEAR[this.month - 1];
	}
	
	// This method returns the name of the day of the week. This method computes day
	// of the week is based on Dinh's Algorithm.
	// http://en.wikipedia.org/wiki/Determination_of_the_day_of_the_week#Dinh.27s_algorithm
	public String getDayOfWeek() {
		int y = (this.year - 1);
		int d = getDOY();
		int weekDay = (daysInYear * (y + (y / 4)) - (y / 100) + (y / 400) + d) % daysInWeek;
		return DAYSOFWEEK[weekDay];
	}
	
	// This method runs a series of logical statements to determine if the numbers entered
	// conform with the Gregorian calendar.
	private void checkValidity() {
		// checks for valid month and year entries
		if (this.month > monthsInYear || this.month < 0 || this.year < firstYear) {
			throw new IllegalArgumentException();
		//checks for valid day entries based on month
		} else if (this.day > getDaysInMonth() || this.day < 1) {
			throw new IllegalArgumentException();
		}
	}
}
