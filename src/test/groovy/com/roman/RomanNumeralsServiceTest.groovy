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
        
        where: "Number is #decimal"
        decimal || expected
        -1      || ''
        0       || ''

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

        expectedMessage = expected ? "'$expected'" : 'empty String'
    }
}
