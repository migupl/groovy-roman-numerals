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

    private final static List<RomanDecimal> ROMAN_BY_SYMBOL = (RomanSymbol.values() + RomanSustractiveSymbol.values()).
            sort { a, b ->
                b.number.compareTo(a.number)
            }

    private final static TreeMap<Integer, String> ROMANS_BY_NUMBER = (RomanSymbol.values() + RomanSustractiveSymbol.values()).
            collectEntries { RomanDecimal romanDecimal ->
                [ (romanDecimal.number): romanDecimal as String ]
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
        def res = []
        while (value > 0) {
            def number = ROMANS_BY_NUMBER.lowerKey(value + 1)

            int times = value.intdiv(number)

            value -= times * number
            res << (ROMANS_BY_NUMBER[number] as String) * times
        }

        res.join()
    }

    RomanNumeral(String roman) {
        this.roman = roman
        this.number = getNumberFromRoman(roman)

        def rule = new RomanFullParsedRule()
        rule.validate(this)
    }

    private static int getNumberFromRoman(String roman) {
        def (pos, subTotals) = [ 0, 0 ]

        ROMAN_BY_SYMBOL.each { RomanDecimal romanNumeral ->
            def symbol = romanNumeral as String

            while (roman.drop(pos).startsWith(symbol)) {
                pos += symbol.length()
                subTotals += romanNumeral.number
            }
        }

        roman.drop(pos) ? RomanNumeralRange.INVALID_VALUE : subTotals
    }
}