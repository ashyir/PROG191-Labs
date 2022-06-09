import java.util.Scanner;

class Example_01 {
    private static double _BALANCE = 5;

    public static void main(String[] args) {
        try {
            System.out.println(deposit(-5));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static double deposit(double amount) {
        double oldBalance = _BALANCE;

        _BALANCE += amount;

        if (_BALANCE < oldBalance) {
            throw new IllegalArgumentException("New balance cannot be smaller than old balance.");
        }

        return balance;
    }
}

class Example_02 {
    public static void main(String[] args) {
        try {
            int value = 30;

            if (value < 40) {
                throw new Exception("Value is too small.");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("Continue after the catch block.");
    }
}