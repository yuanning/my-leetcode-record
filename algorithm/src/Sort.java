/**
 * Created by yn on 2016/11/8.
 */
public class Sort {

    public static int[] bubbleSort(int[] arr) {
        //临时变量
        int temp = 0;
        for (int i=0; i<arr.length-1; i++) {
            for (int j=0; j<arr.length-1-i; j++) {
                if (arr[j]>arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l<r) {
            int i=l,j=r;
            int temp = arr[i];
            while (l<r) {
                while (l<r && arr[j] >= temp)
                    j--;
                if (l<r) {
                    arr[i] = arr[j];
                    i++;
                }
                while (l<r && arr[i] < temp)
                    i++;
                //隐含条件
                if (l<r) {
                    arr[j] = arr[i];
                    j--;
                }
            }
            arr[i] = temp;
            quickSort(arr, l, i-1);
            quickSort(arr, i+1, r);
        }
    }

    public static void main(String[] args) {
        int[] arr = {49,38,65,97,76,13,27};
        bubbleSort(arr);
        System.out.println(arr);
    }

}
