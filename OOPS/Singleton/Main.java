package Singleton;

public class Main {
    public static void main(String[] args) {

        SingletonClass obj1 = SingletonClass.getSingletonInstance();

        SingletonClass obj2 = SingletonClass.getSingletonInstance();

        SingletonClass obj3 = SingletonClass.getSingletonInstance();

        // all 3 ref variables are pointed to same object. Only 1 instance would be created

    }
}
