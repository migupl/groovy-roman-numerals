package com.roman.numeral

final class RomanNumeralRange {

    private final static Range<Integer> ROMAN_NUMBER_RANGE = 1 .. 3999

    final static int INVALID_VALUE = ROMAN_NUMBER_RANGE.from.previous()

    static String getRange() {
        "${ROMAN_NUMBER_RANGE.from} .. ${ROMAN_NUMBER_RANGE.to}"
    }

    static boolean isValid(int number) {
        ROMAN_NUMBER_RANGE.contains number
    }
}