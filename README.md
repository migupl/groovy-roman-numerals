# Roman Numerals

Roman Numerals Subtractive Notation ([Basic decimal pattern][1])

Use
```bash
$ ./gradlew -q

Use: ./gradlew --number=<number>  // Number in 1 .. 3000

```
for getting help

Example,
```bash
$ ./gradlew -q -Pnumber=2019

'MMXIX' is Roman Numeral for 2019

```

Jar file is generated at _libs/_ folder using Gradle task **doJar**
```bash
$ ./gradlew -q doJar$

```

[1]: https://en.wikipedia.org/wiki/Roman_numerals#Basic_decimal_pattern