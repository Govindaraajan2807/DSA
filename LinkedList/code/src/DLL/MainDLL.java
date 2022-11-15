package DLL;

public class MainDLL {
    public static void main(String[] args) {
        DLL dll = new DLL();
        dll.insertFirst(10);
        dll.insertFirst(20);
        dll.insertFirst(30);
        dll.insertFirst(40);

        dll.insert(30,69);

        dll.display();
    }
}
