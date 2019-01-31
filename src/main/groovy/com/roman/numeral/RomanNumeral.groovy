package com.roman.numeral

import com.roman.symbol.RomanDecimal
import com.roman.symbol.RomanSustractiveSymbol
import com.roman.symbol.RomanSymbol

/**
 * Roman Numeral Subtractive Notation
 * See <a href="https://en.wikipedia.org/wiki/Roman_numerals#Basic_decimal_pattern">Roman Numerals. Basic decimal pattern</a>
 */
class RomanNumeral {
    final static List<RomanDecimal> ROMAN_SUBTRACTIVE_NOTATION = (RomanSymbol.values() + RomanSustractiveSymbol.values()).sort { a, b ->
        b.decimal.compareTo(a.decimal)
    }

    final int decimal
    final boolean valid
    final String roman

    RomanNumeral(int decimal) {
        this.decimal = decimal
        valid = decimal > 0

        roman = valid ? getSubtractiveNotation(decimal) : ''
    }

    @Override
    final String toString() {
        roman
    }

    private String getSubtractiveNotation(int value) {
        ROMAN_SUBTRACTIVE_NOTATION.collect { RomanDecimal romanNumeral ->
            int times = value.intdiv(romanNumeral.decimal)
            if (times) {
                value -= times * romanNumeral.decimal
                return (1..times).collect { romanNumeral }.join()
            }

            ''
        }.join()
    }
}