package Sorting;

public class ZigZagConv {
    public static void main(String[] args) {
        String str = "PAYPALISHIRING";
        String res = convert(str,4);
        System.out.println(res);
    }
    public static String convert(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++){
            sb[i] = new StringBuilder();
        }
        int n = s.length();
        char[] arr = s.toCharArray();
        int idx = 0;
        while(idx < n){
            // down
            for(int i = 0; i < numRows && idx < n; i++){
                sb[i].append(arr[idx]);
                idx++;
            }
            // up
            for(int i = numRows -2; i > 0 && idx < n; i--){
                sb[i].append(arr[idx]);
                idx++;
            }
        }
        // merge all stringBuilders
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < numRows; i++){
            res.append(sb[i]);
        }
        return res.toString();
    }
}
