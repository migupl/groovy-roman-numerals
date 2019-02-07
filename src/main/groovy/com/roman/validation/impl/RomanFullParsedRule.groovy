package com.roman.validation.impl

import com.roman.exception.InvalidRomanNumeralException
import com.roman.numeral.RomanNumeral
import com.roman.numeral.RomanNumeralRange
import com.roman.validation.RomanNumeralRule

class RomanFullParsedRule implements RomanNumeralRule<RomanNumeral> {

    @Override
    def validate(RomanNumeral romanNumeral) throws InvalidRomanNumeralException {
        if (!romanNumeral.roman || !RomanNumeralRange.isValid(romanNumeral.number)) {
            throw new InvalidRomanNumeralException("'${romanNumeral.roman}' is not a valid Roman")
        }
    }
}
