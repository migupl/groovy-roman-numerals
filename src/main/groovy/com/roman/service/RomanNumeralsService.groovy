package com.roman.service

import com.roman.numeral.RomanNumeral

@Singleton
class RomanNumeralsService {

    String valueToSubtractiveNotation(int value) {
        RomanNumeral romanNumeral = new RomanNumeral(value)

        romanNumeral.roman
    }

    int subtractiveNotationToDecimal(String roman) {
        RomanNumeral romanNumeral = new RomanNumeral(roman)

        romanNumeral.number
    }
}
