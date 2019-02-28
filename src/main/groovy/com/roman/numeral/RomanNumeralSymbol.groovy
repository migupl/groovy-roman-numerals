package com.roman.numeral

import com.roman.exception.InvalidRomanNumeralException
import com.roman.symbol.RomanDecimal
import com.roman.symbol.RomanSustractiveSymbol
import com.roman.symbol.RomanSymbol
import com.roman.validation.RomanNumeralRule
import com.roman.validation.impl.RomanNumeralSymbolRule

class RomanNumeralSymbol extends RomanNumeralTemplate<String, RomanNumeralNumber> {

    private final static List<RomanDecimal> ROMAN_BY_SYMBOL = (RomanSymbol.values() + RomanSustractiveSymbol.values()).
            sort { a, b ->
                b.number.compareTo(a.number)
            }

    RomanNumeralSymbol(String roman, RomanNumeralRule<RomanNumeralSymbol> rule = new RomanNumeralSymbolRule()) {
        super(roman, rule)
    }

    @Override
    RomanNumeralNumber transform() throws InvalidRomanNumeralException {
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
