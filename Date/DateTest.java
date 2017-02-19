
public class DateTest {
	public static void main(String[] args) {
		Date date1 = new Date(1980, 12, 25);
		Date date2 = new Date();
		System.out.println("");
		System.out.println("This is a test of Date.class; 2 objects will be");
		System.out.println("created, and all the methods in the Date class");
		System.out.println("will be tested.");
		System.out.println("");
		System.out.println("Object \'date1\' created using main constructor");
		System.out.println("with date data 12/25/1980");
		System.out.println("Object \'date2\' created using default constructor");
		System.out.println("which uses date data 1/1/1970");
		System.out.println("");
		System.out.println("Method test using date1");
		System.out.println("date1.getMonth(): " + date1.getMonth());
		System.out.println("date1.getDay(): " + date1.getDay());
		System.out.println("date1.getYear(): " + date1.getYear());
		System.out.println("");
		System.out.println("date1.toString(): " + date1.toString());
		System.out.println("date1.longDate(): " + date1.longDate());
		System.out.println("date1.getDayOfWeek(): " + date1.getDayOfWeek());
		System.out.println("");
		System.out.println("date2.daysTo(date1): " + date2.daysTo(date1));
		System.out.println("date1.daysTo(date2): " + date1.daysTo(date2));
		System.out.println("date1.getDOY(): " + date1.getDOY());
		//System.out.print("Static method: daysTo(date1, date2): " + daysTo(date1, date2));
		System.out.println("");
		System.out.println("date1.equals(date2): " + date1.equals(date2));
		System.out.println("date1.isLeapYear(): " + date1.isLeapYear());
		System.out.println("");
		date1.addDays(3);
		System.out.println("date1.addDays(3): " + date1.toString());
		date1.nextDay();
		System.out.println("date1.nextDay(): " + date1.toString());
		date1.addWeeks(2);
		System.out.println("date1.addWeeks(2): " + date1.toString());
		System.out.println("");
	}
}
