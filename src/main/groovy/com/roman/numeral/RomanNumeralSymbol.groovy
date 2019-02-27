package com.roman.numeral

import com.roman.exception.InvalidRomanNumeralException
import com.roman.symbol.RomanDecimal
import com.roman.symbol.RomanSustractiveSymbol
import com.roman.symbol.RomanSymbol
import com.roman.validation.RomanNumeralRule
import com.roman.validation.impl.RomanNumeralSymbolRule

class RomanNumeralSymbol implements RomanNumeralElement<RomanNumeralNumber> {

    private final static List<RomanDecimal> ROMAN_BY_SYMBOL = (RomanSymbol.values() + RomanSustractiveSymbol.values()).
            sort { a, b ->
                b.number.compareTo(a.number)
            }

    final String value

    RomanNumeralSymbol(String roman, RomanNumeralRule<RomanNumeralSymbol> rule = new RomanNumeralSymbolRule()) {
        value = roman
        rule.validate(this)
    }

    @Override
    RomanNumeralNumber transform() {
        def (pos, subTotals) = [ 0, 0 ]

        ROMAN_BY_SYMBOL.each { RomanDecimal romanNumeral ->
            def symbol = romanNumeral as String

            while (value.drop(pos).startsWith(symbol)) {
                pos += symbol.length()
                subTotals += romanNumeral.number
            }
        }

        if (value.drop(pos)) {
            throw new InvalidRomanNumeralException("'$value' is a malformed Roman symbol")
        }

        new RomanNumeralNumber(subTotals)
    }
}
