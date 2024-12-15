package Static;
class Test {
    String name;
    String id;

    public Test(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
//}
public class InnerClass {

    public static void main(String[] args) {
        Test test = new Test("Govind");
        System.out.println(test);

    }
}
