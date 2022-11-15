package Sorting;

public class SingleElement {
    public static void main(String[] args) {
        int[] nums = {3,3,7,7,10,10,11,11,12,12,13,13,24,24,25,25,26,26,56,56,34,34,23,23,98,98,45,45,
                      65,65,342,342,44,44,55,55,88,88,98,98,121,121,122,123,123};
        int val = singleNonDuplicate(nums);
        System.out.println(val);
    }
    public static int singleNonDuplicate(int[] nums) {

        /*if(nums.length == 1){
            return nums[0];
        }
        for(int i=0;i<nums.length;i+=2){
            if(i<nums.length-2) {
                if (nums[i] != nums[i + 1])
                    return nums[i];
            } else {
                return nums[nums.length-1];
            }
        }

        return 0;*/

        int ans = binarySearch(nums);
        return ans;
    }
    static int binarySearch(int[] a){
        int s = 0;
        int e = a.length-1;

        while(s <= e) {
            int mid = s + (e - s) / 2;

            if(mid-1 >= 0 && mid+1 <= a.length-1){
                if(a[mid] != a[mid-1] && a[mid] != a[mid+1]){
                    return a[mid];
                }
                if(mid % 2 == 0){
                    if(a[mid] == a[mid-1]){ // new pair starts with even as index, hence pattern is disturbed in left
                        e = mid-1;
                    } else {
                        s = mid+1;
                    }
                } else { //for odd index
                    if(a[mid] == a[mid-1]){ //pattern is disturbed in right side
                        s = mid+1;
                    } else {
                        e = mid-1;
                    }
                }
            } else
                return a[mid];
        }

        return -1;
    }
}
