package com.roman.validation.impl

import com.roman.exception.InvalidRomanNumeralException
import com.roman.numeral.RomanNumeralSymbol
import com.roman.symbol.RomanSymbol
import com.roman.validation.RomanNumeralRule

class RomanNumeralSymbolRule implements RomanNumeralRule<RomanNumeralSymbol> {

    private final static List<String> ROMAN_SYMBOLS = RomanSymbol.values().collect { it as String }

    @Override
    def validate(RomanNumeralSymbol symbol) throws InvalidRomanNumeralException {
        if (!symbol.value || (symbol.value.chars.toList() - ROMAN_SYMBOLS)) {
            throw new InvalidRomanNumeralException("'${symbol.value}' is not a valid Roman symbol")
        }
    }
}
