import java.util.Scanner;

public class Lab_02 {
    public static void main(String[] args) {
        question_02();
    }

    // Question 01.
    // Write a program that prompts the user to enter a year
    // and a string of three characters for a month name
    // (with the first letter in uppercase)
    // then displays the number of days in the month.
    // If the user enters an invalid value for year or month,
    // print out a helpful error message.
    public static void question_01() {
        Scanner in = new Scanner(System.in);

        int day;

        System.out.print("Enter a year: ");
        int year = in.nextInt();
        in.nextLine();

        System.out.print("Enter a month: ");
        String month = in.nextLine();

        switch (month) {
            case "Jan":
            case "Mar":
            case "May":
            case "Jul":
            case "Aug":
            case "Oct":
            case "Dec":
                day = 31;
                break;
            case "Apr":
            case "Jun":
            case "Sep":
            case "Nov":
                day = 30;
                break;
            case "Feb":
                if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                    day = 29;
                } else {
                    day = 28;
                }
                break;

            default:
                day = 0;
        }

        if (day == 0) {
            System.out.println("Wrong month !!!");
        } else {
            System.out.printf("\n%s %d has %d days.", month, year, day);
        }
    }

    // Question 02.
    // Write a method that takes a string and returns its reverse.
    // E.g. If the given string is "Good day" then the method returns "yad dooG".
    public static void question_02() {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = in.nextLine();

        System.out.print("Reverse order: ");
        for (int i = str.length() - 1; i >= 0; --i) {
            System.out.print(str.charAt(i));
        }

        in.close();
    }
}