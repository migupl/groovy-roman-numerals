package com.roman.symbol

enum RomanSymbol implements RomanDecimal {
    M(1000),
    D(500),
    C(100),
    L(50),
    X(10),
    V(5),
    I(1)

    final int decimal

    RomanSymbol(int decimal) {
        this.decimal = decimal
    }
}
