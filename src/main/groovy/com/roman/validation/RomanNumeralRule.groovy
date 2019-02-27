package com.roman.validation

import com.roman.exception.InvalidRomanNumeralException

interface RomanNumeralRule<T> {

    def validate(T value) throws InvalidRomanNumeralException
}