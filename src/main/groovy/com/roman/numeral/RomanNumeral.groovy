package com.roman.numeral

import com.roman.symbol.RomanDecimal
import com.roman.symbol.RomanSustractiveSymbol
import com.roman.symbol.RomanSymbol

/**
 * Roman Numeral Subtractive Notation
 * See <a href="https://en.wikipedia.org/wiki/Roman_numerals#Basic_decimal_pattern">Roman Numerals. Basic number pattern</a>
 */
class RomanNumeral {
    final static List<RomanDecimal> ROMAN_SUBTRACTIVE_NOTATION = (RomanSymbol.values() + RomanSustractiveSymbol.values()).sort { a, b ->
        b.number.compareTo(a.number)
    }

    final int number
    final boolean valid
    final String roman

    RomanNumeral(int number) {
        this.number = number
        valid = number > 0

        roman = valid ? getSubtractiveNotation(number) : ''
    }

    @Override
    final String toString() {
        roman
    }

    private String getSubtractiveNotation(int value) {
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