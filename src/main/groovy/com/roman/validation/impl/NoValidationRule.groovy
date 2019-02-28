package com.roman.validation.impl

import com.roman.exception.InvalidRomanNumeralException
import com.roman.validation.RomanNumeralRule

class NoValidationRule implements RomanNumeralRule {

    @Override
    def validate(value) throws InvalidRomanNumeralException {
    }
}
