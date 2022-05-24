import java.util.Scanner;

public class Lab_02 {
    public static void main(String[] args) {
        question_03_02();
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

    // Question 03.
    // A palindrome is a string that reads the same backward as forward
    // when ignoring punctuations, blanks and case difference.
    // E.g. "madam", "Hannah", "Step on no pets", "Was it a car or a cat I saw?",
    // "A450943534 man, a plan, a canal, Panama!" are all palindromes.
    // Write a method that checks if a given string is a palindrome or not.
    // Hint: use the method in the last exercise.
    public static void question_03_01() {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = in.nextLine();
        boolean isPalindrome = true;
        int length = str.length() - 1;

        str = str.replaceAll("[^a-zA-Z]", "").toLowerCase();

        for (int i = 0; i < (str.length() / 2); ++i) {
            if (str.charAt(i) != str.charAt(length - i)) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("This is a palindrome.");
        } else {
            System.out.println("This is not a palindrome.");
        }

        in.close();
    }

    public static void question_03_02() {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = in.nextLine();
        boolean isPalindrome = true;

        // A-Z: 65 - 90; a-z: 97 - 122
        for (int i = 0, j = str.length() - 1; i < j; ++i, --j) {
            int code_i = str.charAt(i);
            while ((i < j) && (code_i < 65 || code_i > 122 || (code_i > 90 && code_i < 97))) {
                ++i;
            }

            int code_j = str.charAt(j);
            while ((i < j) && (code_j < 65 || code_j > 122 || (code_j > 90 && code_j < 97))) {
                --j;
            }

            if ((code_i != code_j) && (code_i != code_j - 32) && (code_i != code_j + 32)) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("This is a palindrome.");
        } else {
            System.out.println("This is not a palindrome.");
        }

        in.close();
    }
}