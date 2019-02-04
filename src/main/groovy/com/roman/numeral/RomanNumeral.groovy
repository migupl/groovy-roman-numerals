package com.roman.numeral

import com.roman.symbol.RomanDecimal
import com.roman.symbol.RomanSustractiveSymbol
import com.roman.symbol.RomanSymbol

/**
 * Roman Numeral Subtractive Notation
 * See <a href="https://en.wikipedia.org/wiki/Roman_numerals#Basic_decimal_pattern">Roman Numerals. Basic number pattern</a>
 */
class RomanNumeral {

    final static ROMAN_NUMBER_RANGE = 1 .. 3000
    final static List<RomanDecimal> ROMAN_SUBTRACTIVE_NOTATION = (RomanSymbol.values() + RomanSustractiveSymbol.values()).sort { a, b ->
        b.number.compareTo(a.number)
    }

    final int number
    final String roman

    RomanNumeral(int number) {
        this.number = number

        roman = isValid(number) ? getSubtractiveNotation(number) : ''
    }

    RomanNumeral(String s) {
        roman = s

        if (s) {
            try {
                number = getNumberFromRoman(s)

            } catch (Exception _) {
                number = 0
            }

            number = valid ? number : 0

        } else {
            number = 0
        }
    }

    boolean isValid() {
        isValid(number)
    }

    static boolean isValid(number) {
        ROMAN_NUMBER_RANGE.contains(number)
    }

    @Override
    final String toString() {
        roman
    }

    private static getNumberFromRoman(String s) {
        def pos = 0
        def subTotals = ROMAN_SUBTRACTIVE_NOTATION.collect { RomanDecimal romanNumeral ->
            def (symbol, subTotal) = [
                    romanNumeral as String,
                    0
            ]

            while (s.drop(pos).startsWith(symbol)) {
                pos += symbol.length()
                subTotal += romanNumeral.number
            }

            subTotal
        }

        if (pos != s.length()) {
            throw new Exception('Malformed Roman Numeral')
        }

        subTotals.sum()
    }

    private static String getSubtractiveNotation(int value) {
        ROMAN_SUBTRACTIVE_NOTATION.collect { RomanDecimal romanNumeral ->
            int times = value.intdiv(romanNumeral.number)
            if (times) {
                value -= times * romanNumeral.number
                return (1..times).collect { romanNumeral }.join()
            }

            ''
        }.join()
    }
}