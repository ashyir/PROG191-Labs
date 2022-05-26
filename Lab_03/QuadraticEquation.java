public class QuadraticEquation {
    private int a;
    private int b;
    private int c;

    public QuadraticEquation(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getDiscriminant() {
        // return b2 – 4ac.
        return this.b * this.b - 4 * this.a * this.c;
    }

    public double getRoot1() {
        // return (-b + squareroot(b2 - 4ac)) / 2a.
        return (Math.sqrt(this.getDiscriminant()) - this.b) / (2 * this.a);
    }

    public double getRoot2() {
        // return (-b - squareroot(b2 - 4ac)) / 2a.
        return (-Math.sqrt(this.getDiscriminant()) - this.b) / (2 * this.a);
    }

    public void set_a(int a) {
        this.a = a;
    }

    public void set_b(int b) {
        this.b = b;
    }

    public void set_c(int c) {
        this.c = c;
    }

    public int get_a() {
        return this.a;
    }

    public int get_b() {
        return this.b;
    }

    public int get_c() {
        return this.c;
    }
}