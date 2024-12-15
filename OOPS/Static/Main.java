package Static;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.fun();
        greeting();

    }

    static void greeting(){
        //fun(); // non static methods cannot be called inside a static method
        System.out.println("Inside static method greeting()");

        //create a object if you wanted to call the non static method
        Main main = new Main();
        main.fun();
    }

    void fun(){
        greeting();// static method can be valled inside a non-static method
        System.out.println("Inside non static method fun()");
    }
}
