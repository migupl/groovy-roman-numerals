package com.roman.numeral

import com.roman.symbol.RomanDecimal
import com.roman.symbol.RomanSustractiveSymbol
import com.roman.symbol.RomanSymbol
import com.roman.validation.impl.NumberInRomanNumeralRangeRule
import com.roman.validation.impl.RomanFullParsedRule
/**
 * Roman Numeral Subtractive Notation
 * See <a href="https://en.wikipedia.org/wiki/Roman_numerals#Basic_decimal_pattern">Roman Numerals. Basic number pattern</a>
 */
class RomanNumeral {

    private final static List<RomanDecimal> ROMAN_SUBTRACTIVE_NOTATION = (RomanSymbol.values() + RomanSustractiveSymbol.values()).sort { a, b ->
        b.number.compareTo(a.number)
    }

    final int number
    final String roman

    RomanNumeral(int number) {
        def rule = new NumberInRomanNumeralRangeRule()
        rule.validate(number)

        this.number = number
        this.roman = getSubtractiveNotation(number)
    }

    private static String getSubtractiveNotation(int value) {
        ROMAN_SUBTRACTIVE_NOTATION.collect { RomanDecimal romanNumeral ->
            int times = value.intdiv(romanNumeral.number)

            value -= times * romanNumeral.number
            (romanNumeral as String) * times
        }.join()
    }

    RomanNumeral(String roman) {
        this.roman = roman
        this.number = getNumberFromRoman(roman)

        def rule = new RomanFullParsedRule()
        rule.validate(this)
    }

    private static getNumberFromRoman(String roman) {
        def (pos, subTotals) = [ 0, 0 ]
        ROMAN_SUBTRACTIVE_NOTATION.each { RomanDecimal romanNumeral ->
            def symbol = romanNumeral as String

            while (roman.drop(pos).startsWith(symbol)) {
                pos += symbol.length()
                subTotals += romanNumeral.number
            }
        }

        println "-- $roman > ${roman.drop(pos)}"

        roman.drop(pos) ? RomanNumeralRange.INVALID_VALUE : subTotals
    }

    @Override
    final String toString() {
        roman
    }
}