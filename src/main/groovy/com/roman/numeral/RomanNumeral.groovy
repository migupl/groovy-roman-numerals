package com.roman.numeral

import com.roman.exception.InvalidRomanNumeralException

/**
 * Roman Numeral Subtractive Notation
 * See <a href="https://en.wikipedia.org/wiki/Roman_numerals#Basic_decimal_pattern">Roman Numerals. Basic number pattern</a>
 */
class RomanNumeral {

    final RomanNumeralNumber number
    final RomanNumeralSymbol roman

    RomanNumeral(RomanNumeralNumber number) throws InvalidRomanNumeralException {
        this.number = number
        this.roman = number.transform()
    }

    RomanNumeral(RomanNumeralSymbol roman) throws InvalidRomanNumeralException {
        this.roman = roman
        this.number = roman.transform()
    }

    String getSymbol() {
        roman.value
    }

    int getValue() {
        number.value
    }
}