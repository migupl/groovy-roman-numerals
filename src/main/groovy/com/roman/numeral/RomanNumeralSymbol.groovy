package com.roman.numeral

import com.roman.symbol.RomanDecimal
import com.roman.symbol.RomanSustractiveSymbol
import com.roman.symbol.RomanSymbol

class RomanNumeralSymbol implements RomanNumeralElement<RomanNumeralNumber> {

    private final static List<RomanDecimal> ROMAN_BY_SYMBOL = (RomanSymbol.values() + RomanSustractiveSymbol.values()).
            sort { a, b ->
                b.number.compareTo(a.number)
            }

    final String value

    RomanNumeralSymbol(String roman) {
        value = roman
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

        // TODO: change this
        new RomanNumeralNumber(value.drop(pos) ? RomanNumeralRange.INVALID_VALUE : subTotals)
    }
}
