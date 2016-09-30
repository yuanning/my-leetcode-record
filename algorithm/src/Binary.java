import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * Created by yn on 2016/8/25.
 */
public class Binary {

    public String toDecimalStr(int num) {
        String result = "";
        int digit = 0;
        while (num > 0) {
            digit = num % 2;
            result = digit + result;
            num /= 2;
        }
        return result;
    }

    public static void main(String[] args) {
        Binary binary = new Binary();
        //System.out.println(Integer.toBinaryString(8));
        System.out.println(binary.toDecimalStr(8));
    }


}
