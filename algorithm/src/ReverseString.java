/**
 * Created by yn on 2016/8/25.
 */
public class ReverseString {

    public String reverse(String str) {
        String value = "";
        for (int i=0; i<str.length(); i++) {
            value = str.charAt(i) + value;
        }
        return value;
    }

    public String reverse_(String str) {
        StringBuffer sb = new StringBuffer();
        for (int i=str.length()-1; i>=0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        System.out.println(reverseString.reverse("hello"));
        System.out.println(reverseString.reverse_("hello"));
    }
}
