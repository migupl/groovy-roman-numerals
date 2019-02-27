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

    final RomanNumeralNumber number
    final RomanNumeralSymbol roman

    RomanNumeral(RomanNumeralNumber number) {
        def rule = new NumberInRomanNumeralRangeRule()
        rule.validate(number)

        this.number = number
        this.roman = getSubtractiveNotation(number.value)
    }

    private static RomanNumeralSymbol getSubtractiveNotation(int value) {
        def res = []
        while (value > 0) {
            def number = ROMANS_BY_NUMBER.lowerKey(value + 1)

            int times = value.intdiv(number)

            value -= times * number
            res << (ROMANS_BY_NUMBER[number] as String) * times
        }

        new RomanNumeralSymbol(res.join())
    }

    RomanNumeral(RomanNumeralSymbol roman) {
        this.roman = roman
        this.number = getNumberFromRoman(roman.value)

        def rule = new RomanFullParsedRule()
        rule.validate(this)
    }

    private static RomanNumeralNumber getNumberFromRoman(String roman) {
        def (pos, subTotals) = [ 0, 0 ]

        ROMAN_BY_SYMBOL.each { RomanDecimal romanNumeral ->
            def symbol = romanNumeral as String

            while (roman.drop(pos).startsWith(symbol)) {
                pos += symbol.length()
                subTotals += romanNumeral.number
            }
        }

        // TODO: change this
        new RomanNumeralNumber(roman.drop(pos) ? RomanNumeralRange.INVALID_VALUE : subTotals)
    }
}