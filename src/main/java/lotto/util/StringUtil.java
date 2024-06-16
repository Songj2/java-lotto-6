package lotto.util;

import java.util.ArrayList;
import java.util.List;

public final class StringUtil {
    private StringUtil() {
    }

    public static List<Integer> makeList(String numbers) {
        List<Integer> list = new ArrayList<>();
        for (String number : splitStr(numbers)) {
            list.add(Integer.parseInt(number));
        }
        return list;
    }
    private static String[] splitStr(String str){
        return str.split(",");
    }
}
