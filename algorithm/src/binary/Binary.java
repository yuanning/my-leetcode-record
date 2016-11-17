package binary;

/**
 * Created by yn on 2016/8/25.
 */
public class Binary {


    /**
     * 计算目标数与2的对数
     * @param targetNum 目标数
     * @return
     */
    public int log2(int targetNum) {
        double result = Math.log(targetNum)/Math.log(2);
        return (int)result;
    }

    /**
     *
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

    public static void main(String[] args) {
        Binary binary = new Binary();
        System.out.println(Integer.toBinaryString(16));
        System.out.println(binary.toDecimalStr(16, 8));
        System.out.println(binary.log2(8));
    }


}
