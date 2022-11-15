package Sorting;

public class ZIgZag {
    public static void main(String[] args) {
        String str = "PAYPALISHIRING";
        String res = convert(str,4);
        System.out.println(res);
    }
    public static String convert(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i=0;i<numRows;i++){
            sb[i] = new StringBuilder();
        }
        char[] arr = s.toCharArray();
        int len = s.length();
        int index = 0;

        while(index < len){
            //down
            for(int i=0 ;i<numRows && index<len; i++){
                sb[i].append(arr[index]);
                index++;
            }
            for(int i=numRows-2;i>0 && index<len; i--){
                sb[i].append(arr[index]);
                index++;
            }
        }
        StringBuilder res = sb[0];
        for(int k=1;k<numRows;k++){
            res.append(sb[k]);
        }
        return res.toString();
    }
}
