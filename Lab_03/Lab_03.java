import java.util.*;

public class Lab_03 {
    public static void main(String[] args) {
        question_05();
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

    // Question 02.
    // This function is not to answer Question 02.
    // This function shows you how to calculate running time of codes.
    public static void question_02() {
        long startTime = System.currentTimeMillis();

        System.out.println("Start loop.");

        for (int i = 0; i < 1000000; ++i) {
            System.out.println(i);
        }

        System.out.println("End loop.");

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.print("Duration: " + duration);
    }

    // Question 03.
    public static void question_03() {
        QuadraticEquation qe = new QuadraticEquation(2, 4, 2);

        int result = qe.getDiscriminant();

        if (result > 0) {
            System.out.print("\nRoot 01: " + qe.getRoot1());
            System.out.print("\nRoot 02: " + qe.getRoot2());
        } else if (result == 0) {
            System.out.print("\nRoot 01: " + qe.getRoot1());
        } else {
            System.out.print("\nThe equation has no roots.");
        }
    }

    // Question 05.
    public static void question_05() {
        ContactList contactList = new ContactList();

        contactList.addContact("Mr. A", "0000000000");
        contactList.addContact("Mr. B", "1111111111");
        contactList.addContact("Mr. C", "2222222222");

        while (true) {
            int option = showMenuQuestion05();

            switch (option) {
                case 0:
                    return;

                case 1:
                    contactList.showAllByName();
                    break;

                case 2:
                    viewContactDetails(contactList);
                    break;

                case 3:
                    updateContactPhone(contactList);
                    break;

                case 4:
                    deleteContact(contactList);
                    break;

                default:
                    System.out.println("\nWrong option. Enter again !!!");
            }
        }
    }

    public static int showMenuQuestion05() {
        Scanner in = new Scanner(System.in);

        System.out.println("\n\n-------------------------");
        System.out.println("1. Show All Contacts.");
        System.out.println("2. Find Contact.");
        System.out.println("3. Update Phone.");
        System.out.println("4. Delete Contact.");
        System.out.println("0. Exit.");

        System.out.print("Please enter an option: ");
        int option = in.nextInt();

        in.close();

        return option;
    }

    public static void viewContactDetails(ContactList contactList) {
        Scanner in = new Scanner(System.in);

        System.out.print("\nPlease enter a name: ");
        String name = in.nextLine();

        contactList.viewDetails(name);

        in.close();
    }

    public static void updateContactPhone(ContactList contactList) {
        Scanner in = new Scanner(System.in);

        System.out.print("\nPlease enter a name: ");
        String name = in.nextLine();

        System.out.print("\nPlease enter a new phone: ");
        String phone = in.nextLine();

        contactList.updateContact(name, phone);

        in.close();
    }

    public static void deleteContact(ContactList contactList) {
        Scanner in = new Scanner(System.in);

        System.out.print("\nPlease enter a name: ");
        String name = in.nextLine();

        contactList.deleteContact(name);

        in.close();
    }
}