package lotto.util;

import java.util.List;

public final class ListUtil {

    private ListUtil() {
    }

    public static List<Integer> sort(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                int temp = list.get(i);
                list.set(i, list.get(i + 1));
                list.set(i + 1, temp);
                i = -1;
            }
        }
        return list;
    }
}
