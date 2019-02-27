package com.roman.numeral


import com.roman.validation.impl.NumberInRomanNumeralRangeRule
import com.roman.validation.impl.RomanFullParsedRule

/**
 * Roman Numeral Subtractive Notation
 * See <a href="https://en.wikipedia.org/wiki/Roman_numerals#Basic_decimal_pattern">Roman Numerals. Basic number pattern</a>
 */
class RomanNumeral {



    final RomanNumeralNumber number
    final RomanNumeralSymbol roman

    RomanNumeral(RomanNumeralNumber number) {
        def rule = new NumberInRomanNumeralRangeRule()
        rule.validate(number)

        this.number = number
        this.roman = number.transform()
    }

    RomanNumeral(RomanNumeralSymbol roman) {
        this.roman = roman
        this.number = roman.transform()

        def rule = new RomanFullParsedRule()
        rule.validate(this)
    }
}