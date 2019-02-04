package com.roman.numeral

import com.roman.exception.InvalidRomanNumeralException
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
        if (isInvalid(number)) {
            println "$number out"
            throw new InvalidRomanNumeralException("$number is not at range ${ROMAN_NUMBER_RANGE.from} .. ${ROMAN_NUMBER_RANGE.to}")
        }

        this.number = number
        roman = getSubtractiveNotation(number)
    }

    private static boolean isInvalid(number) {
        !ROMAN_NUMBER_RANGE.contains(number)
    }

    private static String getSubtractiveNotation(int value) {
        ROMAN_SUBTRACTIVE_NOTATION.collect { RomanDecimal romanNumeral ->
            int times = value.intdiv(romanNumeral.number)

            value -= times * romanNumeral.number
            (romanNumeral as String) * times
        }.join()
    }

    RomanNumeral(String s) {
        roman = s
        number = getNumberFromRoman(s)

        if (isInvalid(number)) {
            throw new InvalidRomanNumeralException(exceptionMessage)
        }
    }

    private String getExceptionMessage() {
        "'$roman' is not a valid Roman Numeral"
    }

    private static getNumberFromRoman(String s) {
        def (pos, subTotals) = [ 0, 0 ]
        ROMAN_SUBTRACTIVE_NOTATION.each { RomanDecimal romanNumeral ->
            def symbol = romanNumeral as String

            while (s.drop(pos).startsWith(symbol)) {
                pos += symbol.length()
                subTotals += romanNumeral.number
            }
        }

        pos == s.length() ? subTotals : 0
    }

    @Override
    final String toString() {
        roman
    }
}