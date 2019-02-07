package com.roman.validation.impl

import com.roman.exception.InvalidRomanNumeralException
import com.roman.numeral.RomanNumeralRange
import com.roman.validation.RomanNumeralRule

class NumberInRomanNumeralRangeRule implements RomanNumeralRule<Integer> {

    @Override
    def validate(Integer number) throws InvalidRomanNumeralException {
        if (!RomanNumeralRange.isValid(number)) {
            throw new InvalidRomanNumeralException("${number} is not at range ${RomanNumeralRange.range}")
        }
    }
}
