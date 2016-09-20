import com.sun.org.apache.xpath.internal.SourceTree;

import static javafx.scene.input.KeyCode.V;

/**
 * Created by yn on 2016/8/8.
 */
public class RomanTransform {

    public int romanToInt(String s) {
        int length = s.length();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'I':
                    arr[i] = 1;
                    break;
                case 'V':
                    arr[i] = 5;
                    break;
                case 'X':
                    arr[i] = 10;
                    break;
                case 'L':
                    arr[i] = 50;
                    break;
                case 'C':
                    arr[i] = 100;
                    break;
                case 'D':
                    arr[i] = 500;
                    break;
                case 'M':
                    arr[i] = 1000;
                    break;
            }
        }
        return calculateResult(arr);
    }


    //new method
    public int calculateResult(int[] arr) {
        int value = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                value += arr[i] - 2 * arr[i - 1];
            } else {
                value += arr[i];
            }
        }
        return value;
    }

    //example
    public String intToRoman(int num) {
        String[][] roman = {
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "M", "MM", "MMM"}
        };

        String ret = "";
        int digit = 0;
        while (num != 0) {
            int remain = num % 10;
            ret = roman[digit][remain] + ret;
            digit++;
            num /= 10;
        }
        return ret;
    }

    //my method
    public String intToRoman_(int romanNum) {
        String[][] roman = {
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "M", "MM", "MMM"}
        };
        String ret = "";
        int digit = 0;
        while (romanNum>0) {
            int index = romanNum % 10;
            ret = roman[digit][index] + ret;
            digit++;
            romanNum /= 10;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(956%10);
        RomanTransform romanTransform = new RomanTransform();
        System.out.println(romanTransform.romanToInt("XIX"));
        System.out.println(romanTransform.romanToInt("DCXXI"));
        System.out.println(romanTransform.romanToInt("VI"));
        System.out.println(romanTransform.romanToInt("IV"));
        System.out.println(romanTransform.romanToInt("MMCDXXV"));
        System.out.println(romanTransform.romanToInt("MDCCCLXXX"));
        System.out.println(romanTransform.romanToInt("MMMCCCXXXIII"));
        System.out.println(romanTransform.romanToInt("MMCCCXCIX"));
        System.out.println(romanTransform.romanToInt("CMLII"));
        System.out.println(romanTransform.intToRoman_(952));
    }

}
