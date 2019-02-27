package com.roman.validation.impl

import com.roman.exception.InvalidRomanNumeralException
import com.roman.numeral.RomanNumeralNumber
import com.roman.numeral.RomanNumeralRange
import com.roman.validation.RomanNumeralRule

class RomanNumeralNumberRangeRule implements RomanNumeralRule<RomanNumeralNumber> {

    @Override
    def validate(RomanNumeralNumber number) throws InvalidRomanNumeralException {
        if (!RomanNumeralRange.isValid(number.value)) {
            throw new InvalidRomanNumeralException("${number.value} is not at range ${RomanNumeralRange.range}")
        }
    }
}
