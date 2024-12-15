package Singleton;

public class SingletonClass {
    private SingletonClass(){

    }
    private static SingletonClass instance;

    public static SingletonClass getSingletonInstance(){
        if(instance == null){
            instance = new SingletonClass();
        }
        return instance;
    }
}
