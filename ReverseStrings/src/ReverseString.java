import java.util.ArrayList;
import java.util.List;

public class ReverseString {

    public static void main(String[] args) {
        String s = "Nani";
        ReverseString reverseString = new ReverseString();
        reverseString.reverseString(s);

        List<String> list = new ArrayList<String>();
        list.add("hei");
        System.out.println(list.get(0));
        list.add(0,"nani");
        System.out.println(list.get(0));

    }

    public void reverseString(String s){
        char[] chars = s.toCharArray();

        for(int i=0, j = chars.length-1; i<j; i++, j--){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        System.out.println(String.copyValueOf(chars));
    }
}
