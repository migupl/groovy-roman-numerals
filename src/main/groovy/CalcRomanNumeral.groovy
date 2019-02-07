import com.roman.service.RomanNumeralsService

if (args) {
    try {
        def (int number, service) = [
                args[0].toInteger(),
                RomanNumeralsService.instance
        ]

        def romanNumeral = service.valueToSubtractiveNotation(number)

        println """
'$romanNumeral' is Roman Numeral for $number
"""

    } catch (NumberFormatException _) {
        helpMessage()

    }

} else {
    helpMessage()
}

def helpMessage() {
    println """
Use: ./gradlew --number=<number>  // Number in 1 .. 3999
"""
}