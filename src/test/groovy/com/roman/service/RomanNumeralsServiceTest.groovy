package com.roman.service

import com.roman.exception.InvalidRomanNumeralException
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class RomanNumeralsServiceTest extends Specification {

    @Shared
    def service = RomanNumeralsService.instance

    def "A InvalidRomanNumeralException is expected When valueToSubtractiveNotation(#number)"() {
        when: "valueToSubtractiveNotation(#number) is called"
        println "-- $number (${number.class.simpleName})"

        service.valueToSubtractiveNotation(number)

        then: "Expected  InvalidRomanNumeralException"
        def ex = thrown InvalidRomanNumeralException
        "$number is not at range 1 .. 3999" == ex.message

        where: "Number is #number"
        number << [ -1, 0, 4000 ]
    }

    def "Roman Numeral must be #expectedMessage When valueToSubtractiveNotation(#number)"() {
        expect: "Expected Roman Numeral is #expected"
        expected == service.valueToSubtractiveNotation(number)

        where: "Number is #number"
        number  || expected
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
        2019    || 'MMXIX'

        3999    || 'MMMCMXCIX'

        expectedMessage = expected ? "'$expected'" : 'empty String'
    }

    def "A InvalidRomanNumeralException is expected When subtractiveNotationToDecimal('#roman')"() {
        when: "subtractiveNotationToDecimal(#number) is called"
        service.subtractiveNotationToDecimal(roman)

        then: "Expected InvalidRomanNumeralException"
        def ex = thrown InvalidRomanNumeralException
        "'$roman' is not a valid Roman" == ex.message

        where: "Roman is '#roman'"
        roman << [ '', 'IXX' ]
    }

    def "Decimal must be #expected When subtractiveNotationToDecimal('#roman')"() {
        expect: "Expected number is #expected"
        expected == service.subtractiveNotationToDecimal(roman)

        where: "Roman numeral is '#roman'"
        roman        || expected
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
        'MMXIX'      || 2019

        'MMMCMXCIX'  || 3999
    }
}
