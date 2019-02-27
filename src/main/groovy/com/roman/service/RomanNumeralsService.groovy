package com.roman.service

import com.roman.numeral.RomanNumeral
import com.roman.numeral.RomanNumeralNumber
import com.roman.numeral.RomanNumeralSymbol

@Singleton
class RomanNumeralsService {

    String valueToSubtractiveNotation(int value) {
        RomanNumeralNumber romanNumber = new RomanNumeralNumber(value)

        RomanNumeral romanNumeral = new RomanNumeral(romanNumber)

        romanNumeral.symbol
    }

    int subtractiveNotationToDecimal(String roman) {
        RomanNumeralSymbol romanSymbol = new RomanNumeralSymbol(roman)
        RomanNumeral romanNumeral = new RomanNumeral(romanSymbol)

        romanNumeral.value
    }
}
