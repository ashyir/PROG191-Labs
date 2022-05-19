import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        question_01_lab_02();
    }

    // Question 01.
    // Write a program that get three integers from the user
    // and then prints them out in ascending order.
    public static void question_01() {
        final int ARRAY_SIZE = 3;

        Scanner in = new Scanner(System.in);
        int[] numbers = new int[ARRAY_SIZE];

        for (int i = 0; i < numbers.length; ++i) {
            System.out.printf("Please enter number %d: ", i + 1);
            numbers[i] = in.nextInt();
        }

        System.out.print("\nReverse order: ");
        for (int i = numbers.length - 1; i >= 0; --i) {
            System.out.print(numbers[i] + " ");
        }
    }

    // Question 02.
    // Write a program that repeatedly prompts the user to enter a positive integer
    // and checks whether the number is divisible by both 5 and 6,
    // or neither of them, or just one of them.
    // The program ends when the user enters a negative integer or zero.
    public static void question_02() {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.print("Please enter a number: ");
            int number = in.nextInt();

            if (number <= 0) {
                break;
            }

            if ((number % 5) == 0) {
                if ((number % 6) == 0) {
                    System.out.println("This number is divisible by both 5 and 6.");
                }
                else {
                    System.out.println("This number is divisible by only 5.");
                }
            }
            else {
                if ((number % 6) == 0) {
                    System.out.println("This number is divisible by only 6.");
                }
                else {
                    System.out.println("This number is not divisible by both 5 and 6.");
                }
            }
        }
    }

    // Question 05.
    // Write a program that prompts the user to enter an integer from 1 to 15
    // and displays a pyramid, as shown in the following sample run.
    public static void question_05() {
        Scanner in = new Scanner(System.in);

        System.out.print("Please enter a number: ");
        int number = in.nextInt();

        for (int i = 1; i <= number; ++i) {
            for (int j = 0; j < number - i; ++j) {
                System.out.print("\t");
            }

            for (int j = i; j > 1; --j) {
                System.out.print(j + "\t");
            }

            for (int j = 1; j <= i; ++j) {
                System.out.print(j + "\t");
            }

            System.out.println();
        }
    }

    // Question 01 - Lab 02
    // Write a program that prompts the user to enter a year
    // and a string of three characters for a month name
    // (with the first letter in uppercase)
    // then displays the number of days in the month.
    // If the user enters an invalid value for year or month,
    // print out a helpful error message.
    public static void question_01_lab_02() {
        Scanner in = new Scanner(System.in);

        int day;

        System.out.print("Enter a year: ");
        int year = in.nextInt();
        in.nextLine();

        System.out.print("Enter a month: ");
        String month = in.nextLine();

        switch (month) {
            case "Jan": case "Mar": case "May": case "Jul": case "Aug": case "Oct": case "Dec":
                day = 31; break;
            case "Apr": case "Jun": case "Sep": case "Nov":
                day = 30; break;
            case "Feb":
                if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                    day = 29;
                }
                else {
                    day = 28;
                }
                break;

            default: day = 0;
        }

        if (day == 0) {
            System.out.println("Wrong month !!!");
        }
        else {
            System.out.printf("\n%s %d has %d days.", month, year, day);
        }
    }
}