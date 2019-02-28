package com.roman.numeral

import com.roman.exception.InvalidRomanNumeralException
import com.roman.validation.RomanNumeralRule
import com.roman.validation.impl.NoValidationRule

abstract class RomanNumeralTemplate<T, V> {

    protected final static NO_VALIDATION = new NoValidationRule()

    final T value

    RomanNumeralTemplate(T value, RomanNumeralRule rule) {
        this.value = value
        entryValidation(rule)
    }

    def entryValidation(RomanNumeralRule rule) {
        rule.validate(this)
    }

    abstract V transform() throws InvalidRomanNumeralException
}
