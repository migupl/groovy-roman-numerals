package com.roman.numeral

final class RomanNumeralRange {

    private static final int FROM = 1
    private static final int TO = 3999

    static final int INVALID_VALUE = FROM.previous()

    static String getRange() {
        "$FROM .. $TO"
    }

    static boolean isValid(int number) {
        !(number < FROM ||
                number > TO)
    }
}