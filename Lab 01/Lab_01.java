import java.util.Scanner;

public class Lab_01 {
    public static void main(String[] args) {
        question_01();
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
                } else {
                    System.out.println("This number is divisible by only 5.");
                }
            } else {
                if ((number % 6) == 0) {
                    System.out.println("This number is divisible by only 6.");
                } else {
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
}