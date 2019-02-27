package com.roman.validation.impl

import com.roman.exception.InvalidRomanNumeralException
import com.roman.numeral.RomanNumeral
import com.roman.validation.RomanNumeralRule

import static com.roman.numeral.RomanNumeralRange.isValid

class RomanFullParsedRule implements RomanNumeralRule<RomanNumeral> {

    @Override
    def validate(RomanNumeral romanNumeral) throws InvalidRomanNumeralException {
        if (!romanNumeral.roman || !isValid(romanNumeral.number.value)) {
            throw new InvalidRomanNumeralException("'${romanNumeral.roman}' is not a valid Roman")
        }
    }
}
