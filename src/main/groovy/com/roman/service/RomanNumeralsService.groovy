package com.roman.service

import com.roman.exception.InvalidRomanNumeralException
import com.roman.numeral.RomanNumeral
import com.roman.numeral.RomanNumeralNumber
import com.roman.numeral.RomanNumeralSymbol

@Singleton
class RomanNumeralsService {

    String valueToSubtractiveNotation(int value) throws InvalidRomanNumeralException {
        RomanNumeralNumber romanNumber = new RomanNumeralNumber(value)

        RomanNumeral romanNumeral = new RomanNumeral(romanNumber)

        romanNumeral.symbol
    }

    int subtractiveNotationToDecimal(String roman) throws InvalidRomanNumeralException {
        RomanNumeralSymbol romanSymbol = new RomanNumeralSymbol(roman)
        RomanNumeral romanNumeral = new RomanNumeral(romanSymbol)

        romanNumeral.value
    }
}
