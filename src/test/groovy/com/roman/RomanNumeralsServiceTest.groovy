package com.roman

import com.roman.service.RomanNumeralsService
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class RomanNumeralsServiceTest extends Specification {

    @Shared
    def service = RomanNumeralsService.instance

    def "Roman Numeral must be #expectedMessage When valueToSubtractiveNotation(#decimal)"() {
        expect: "Expected Roman Numeral is #expected"
        expected == service.valueToSubtractiveNotation(decimal)
        
        where: "Number is #number"
        decimal || expected
        -1      || ''
        0       || ''
        3001    || ''

        1       || 'I'
        5       || 'V'
        10      || 'X'
        50      || 'L'
        100     || 'C'
        500     || 'D'
        1000    || 'M'

        39      || 'XXXIX'
        160     || 'CLX'
        207     || 'CCVII'
        246     || 'CCXLVI'
        421     || 'CDXXI'
        1066    || 'MLXVI'
        1776    || 'MDCCLXXVI'
        1954    || 'MCMLIV'
        1990    || 'MCMXC'
        2014    || 'MMXIV'
        2019    || 'MMXIX'
        3000    || 'MMM'

        expectedMessage = expected ? "'$expected'" : 'empty String'
    }

    def "Decimal must be #expected When subtractiveNotationToDecimal('#romanNumeral')"() {
        expect: "Expected decimal is #decimal"
        expected == service.subtractiveNotationToDecimal(romanNumeral)

        where: "Roman numeral is '#romanNumeral'"
        romanNumeral || expected
        ''           || 0
        'IXX'        || 0

        'I'          || 1
        'V'          || 5
        'X'          || 10
        'L'          || 50
        'C'          || 100
        'D'          || 500
        'M'          || 1000

        'XXXIX'      || 39
        'CLX'        || 160
        'CCVII'      || 207
        'CCXLVI'     || 246
        'CDXXI'      || 421
        'MLXVI'      || 1066
        'MDCCLXXVI'  || 1776
        'MCMLIV'     || 1954
        'MCMXC'      || 1990
        'MMXIV'      || 2014
        'MMXIX'      || 2019
        'MMM'        || 3000
    }
}
