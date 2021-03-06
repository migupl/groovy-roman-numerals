package com.roman.symbol

enum RomanSustractiveSymbol implements RomanDecimal {
    CM(900),
    CD(400),
    XC(90),
    XL(40),
    IX(9),
    IV(4)

    final int number

    RomanSustractiveSymbol(int decimal) {
        this.number = decimal
    }
}
