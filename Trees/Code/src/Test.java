import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


class Main {
//    static Integer dp[] = null;
    public static void main(String args[] ) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int counter = scanner.nextInt();
        int n = scanner.nextInt();
        int count=0;

        while(n!=1){
            if(n%2==0){
                count+=n/2;
                n = n/2;
            } else {
                count += n/2;
                n= n/2 +1;
            }
        }
        System.out.println(count);
    }
}