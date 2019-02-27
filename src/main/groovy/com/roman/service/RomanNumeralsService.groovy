package com.roman.service

import com.roman.numeral.RomanNumeral
import com.roman.numeral.RomanNumeralNumber

@Singleton
class RomanNumeralsService {

    String valueToSubtractiveNotation(int value) {
        RomanNumeralNumber romanNumber = new RomanNumeralNumber(value)

        RomanNumeral romanNumeral = new RomanNumeral(romanNumber)

        romanNumeral.roman
    }

    int subtractiveNotationToDecimal(String roman) {
        RomanNumeral romanNumeral = new RomanNumeral(roman)

        romanNumeral.number.value
    }
}
