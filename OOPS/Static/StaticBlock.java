package Static;

public class StaticBlock {
    static int a = 10;
    static int b;

    static { // runs only once, when the obj is created. i.e when the class is loaded for the first time
        System.out.println("I am inside static block");
        b = 2 * a;
    }

    public static void main(String[] args) {
        StaticBlock staticVariable = new StaticBlock();
        System.out.println(StaticBlock.a +" "+ StaticBlock.b);

        b = b + 3;
        System.out.println(a +" "+ b);

    }
}
