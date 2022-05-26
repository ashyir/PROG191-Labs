import java.util.*;

public class Lab_03 {
    public static void main(String[] args) {
        question_01();
    }

    // Question 01.
    public static void question_01() {
        GregorianCalendar calendar = new GregorianCalendar();

        System.out.print("\nCurrent year: ");
        System.out.print(calendar.get(GregorianCalendar.YEAR));

        System.out.print("\nCurrent month: ");
        System.out.print(calendar.get(GregorianCalendar.MONTH) + 1);

        System.out.print("\nCurrent day: ");
        System.out.print(calendar.get(GregorianCalendar.DAY_OF_MONTH));

        System.out.print("\nCurrent day of week: ");
        System.out.print(calendar.get(GregorianCalendar.DAY_OF_WEEK));

        System.out.print("\nCurrent hour: ");
        System.out.print(calendar.get(GregorianCalendar.HOUR));

        System.out.print("\nCurrent minute: ");
        System.out.print(calendar.get(GregorianCalendar.MINUTE));

        System.out.print("\nCurrent second: ");
        System.out.print(calendar.get(GregorianCalendar.SECOND));

        System.out.print("\nCurrent millisecond: ");
        System.out.print(calendar.get(GregorianCalendar.MILLISECOND));

        // By default, the begging date is 01/01/0001. Now I change it to 01/01/1970.
        System.out.print("\n\nChange beginning date to 01/01/1970.");
        calendar.setTimeInMillis(1234567898765L);

        System.out.print("\nCurrent year after change: ");
        System.out.print(calendar.get(GregorianCalendar.YEAR));

        System.out.print("\nCurrent month after change: ");
        System.out.print(calendar.get(GregorianCalendar.MONTH) + 1);

        System.out.print("\nCurrent day after change: ");
        System.out.print(calendar.get(GregorianCalendar.DAY_OF_MONTH));
    }
}