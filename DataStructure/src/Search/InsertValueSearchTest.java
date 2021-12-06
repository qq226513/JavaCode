package Search;

public class InsertValueSearchTest {
    //插值查找：使用了自适应的mid值
    //优势：对于线性的数组，查找速度很快，但是对跳跃性很大的就不一定优于二分查找
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 6, 7, 8, 9};
        System.out.println(InsertValueSearch(arr, 0, arr.length - 1, 6));
    }

    public static int InsertValueSearch(int[] arr, int left, int right, int key) {
        if (left > right || key < arr[0] || key > arr[arr.length - 1]) {
            return -1;
        }
        int mid = left + (right - left) * (key - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (key > midVal) {
            return InsertValueSearch(arr, mid + 1, right, key);
        } else if (key < midVal) {
            return InsertValueSearch(arr, left, mid - 1, key);
        } else {

            return mid;
        }
    }
}
