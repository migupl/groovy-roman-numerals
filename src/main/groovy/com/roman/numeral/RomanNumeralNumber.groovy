package com.roman.numeral

import com.roman.symbol.RomanDecimal
import com.roman.symbol.RomanSustractiveSymbol
import com.roman.symbol.RomanSymbol
import com.roman.validation.RomanNumeralRule
import com.roman.validation.impl.RomanNumeralNumberRangeRule

class RomanNumeralNumber extends RomanNumeralTemplate<Integer, RomanNumeralSymbol> {

    private final static TreeMap<Integer, String> ROMANS_BY_NUMBER = (RomanSymbol.values() + RomanSustractiveSymbol.values()).
            collectEntries { RomanDecimal romanDecimal ->
                [ (romanDecimal.number): romanDecimal as String ]
            }


    RomanNumeralNumber(int number, RomanNumeralRule<RomanNumeralNumber> rule = new RomanNumeralNumberRangeRule()) {
        super(number, rule)
    }

    @Override
    RomanNumeralSymbol transform() {
        def (total, res) = [ value, []]
        while (total > 0) {
            def number = ROMANS_BY_NUMBER.lowerKey(total + 1)

            int times = total.intdiv(number)

            total -= times * number
            res << (ROMANS_BY_NUMBER[number] as String) * times
        }

        new RomanNumeralSymbol(res.join())
    }
}
