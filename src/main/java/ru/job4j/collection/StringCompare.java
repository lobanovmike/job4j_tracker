package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rst = 0;
        int leftLength = left.length();
        int rightLength = right.length();
        int minLength = Math.min(leftLength, rightLength);
        for (int i = 0; i < minLength; i++) {
            rst = Character.compare(left.charAt(i), right.charAt(i));
            if (rst != 0) {
                break;
            }
        }
        if (leftLength != rightLength && rst == 0) {
            rst = Integer.compare(leftLength, rightLength);
        }
        return rst;
    }
}
