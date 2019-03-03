import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sm123tt@gmail.com on 2019-03-02
 * Project : data-structure
 * Github : http://github.com/Siwoo-Kim
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(isMAC48Address("01-23-45-67-89-AB"));
    }

    static boolean isMAC48Address(String mac) {
        boolean valid = mac.matches("[0-9A-F]{2}(\\-[0-9A-F]{2})+\\-[0-9A-F]{2}$");
        if (!valid)
            return false;
        String[] str = mac.split("-");
        for (int i = 0; i < str.length; i++) {
            try {
                Integer.parseInt(str[i], 16);
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }


}
