package com.roman.numeral

import com.roman.exception.InvalidRomanNumeralException
import com.roman.validation.RomanNumeralRule

abstract class RomanNumeralTemplate<T, V> {

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
