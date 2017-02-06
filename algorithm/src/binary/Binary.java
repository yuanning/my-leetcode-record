package binary;

/**
 * Created by yn on 2016/8/25.
 */
public class Binary {


    /**
     * 计算目标数与2的对数
     *
     * @param targetNum 目标数
     * @return
     */
    public int log2(int targetNum) {
        double result = Math.log(targetNum) / Math.log(2);
        return (int) result;
    }

    /**
     * @param num 10进制数
     * @param hex 转换为几进制
     * @return
     */
    public String toDecimalStr(int num, int hex) {
        String result = "";
        int digit = 0;
        while (num > 0) {
            digit = num % hex;
            result = digit + result;
            num /= hex;
        }
        return result;
    }

    /**
     * 二分查找 非递归方式
     *
     * @param arr
     * @param dest 目标值
     * @return
     */
    public int binarySearch(int[] arr, int dest, int low, int high) {
        int len = arr.length;
        if (len > 0) {
            while (low <= high) {
                System.out.println("low="+low+"&high="+high);
                int middle = middleVal(low, high);
                if (dest == arr[middle]) {
                    return middle;
                } else if (dest > arr[middle]) {
                    low = middle + 1;
                } else {
                    high = middle - 1;
                }
            }
        }
        return -1;
    }

    //二分查找 递归方式
    public int binarySearch_(int[] arr, int dest, int low, int high) {
        if (low<=high) {
            System.out.println("low="+low+"&high="+high);
            int middle = middleVal(low, high);
            if (dest == arr[middle]) return middle;
            else if (dest > arr[middle]) return binarySearch_(arr, dest, ++middle, high);
            else return binarySearch_(arr, dest, low, --middle);
        }
        return -1;
    }

    // low + ((high - low) >> 1)
    public int middleVal(int low, int high) {
        return low + high >> 1;
    }

    //将十进制整数形式转换成127.0.0.1形式的ip地址
    public static String longToIP(long longIp){
        StringBuffer sb = new StringBuffer("");
        //直接右移24位
        sb.append(String.valueOf((longIp >>> 24)));
        sb.append(".");
        //将高8位置0，然后右移16位
        sb.append(String.valueOf((longIp & 0x00FFFFFF) >>> 16));
        sb.append(".");
        //将高16位置0，然后右移8位
        sb.append(String.valueOf((longIp & 0x0000FFFF) >>> 8));
        sb.append(".");
        //将高24位置0
        sb.append(String.valueOf((longIp & 0x000000FF)));
        return sb.toString();
    }

    public static void main(String[] args) {
        Binary binary = new Binary();
        //System.out.println(Integer.toBinaryString(16));
        //System.out.println(binary.toDecimalStr(16, 8));
        //System.out.println(binary.log2(8));
        int[] arr = new int[]{1,2,3,5,8,9,12};
        System.out.println(binary.binarySearch_(arr, 8, 0, arr.length-1));

        //ip地址转换
        long longIp = 3520061480l;
        System.out.println(longToIP(longIp));
        System.out.println(longIp >>> 24);
    }


}
