package hujf.leetcode.util;

import java.util.Arrays;
import java.util.List;

public class Printer {

    public static void sout(String[] ss) {
        sout(Arrays.asList(ss));
    }

    public static void sout(List<String> ss) {
        if (ss == null) {
            System.out.println("null");
            return;
        }
        if (ss.isEmpty()) {
            System.out.println("empty");
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < ss.size(); ++i) {
            if (i != 0) {
                sb.append(',');
            }
            sb.append(ss.get(i));
        }
        sb.append(']');
        System.out.println(sb);
    }

}
