import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        E_8(args);
    }

    /* Demonstration for Exercise 03 */
    public static void E_3() {
        try {
            System.out.println("Statement 01.");
            System.out.println("Statement 02: " + 1 / 0);
            System.out.println("Statement 03.");
        } catch (ArithmeticException ex) {
            System.out.println(ex.getMessage());
        } catch (IndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("Statement 04.");
    }

    /* Demonstration for Exercise 04 */
    public static void E_4() {
        try {
            System.out.println("Statement 01.");
            System.out.println("Statement 02: " + 1 / 0);
            System.out.println("Statement 03.");
        } catch (ArithmeticException ex) {
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("Statement 04.");
        }

        System.out.println("Statement 05.");
    }

    /* Demonstration for Exercise 05 */
    public static void E_5() {
        try {
            String[] texts = null;
            System.out.println("Statement 01.");
            //System.out.println("Statement 02: " + texts[2]);
            System.out.println("Statement 02: " + 1 / 0);
            System.out.println("Statement 03.");
        } catch (ArithmeticException ex) {
            System.out.println(ex.getMessage());
        } catch (IndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("Statement 04.");
        }

        System.out.println("Statement 05.");
    }

    /* Exercise 06 */
    public static void E_6() {
        int[] numbers = new int[10];

        for (int i = 0; i < 10; ++i)
            numbers[i] = (int) (Math.random() * 10) + 1;

        try {
            Scanner input = new Scanner(System.in);

            System.out.print("Enter an index: ");
            int index = input.nextInt();

            System.out.println("Number at " + index + ": " + numbers[index]);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Array Index Out of Bounds.");
        }
    }

    /* Exercise 07 */
    public static void E_7A() {
        try {
            E_7B("1010");
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            E_7B("123456789");
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            E_7B("abc");
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            E_7B("-1010");
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void E_7B(String binaryString) throws NumberFormatException {
        int decimal = Integer.parseInt(binaryString, 2);
        System.out.println(decimal);
    }

    /* Exercise 08 */
    public static void E_8(String[] args) {
        try {
            File sourceFile = null;
            File destinationFile = null;

            if (args.length == 1) {
                sourceFile = new File(args[0]);
                destinationFile = new File(sourceFile + "_Converted");
            } else if (args.length == 2) {
                sourceFile = new File(args[0]);
                destinationFile = new File(args[1]);
            } else {
                System.out.println("Arguments are invalid.");
                System.exit(1);
            }

            if (!sourceFile.exists()) {
                System.out.println("File " + args[0] + " does not exist.");
                System.exit(2);
            }

            String sourceString = Files.readString(Path.of(sourceFile.getPath()));
            String destinationString = sourceString.replaceAll("\\s+\\{", " {");

            PrintWriter myWriter = new PrintWriter(destinationFile);
            myWriter.println(destinationString);
            myWriter.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}