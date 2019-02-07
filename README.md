# java-kotlin-groovy-test

## 目的

javaでunitテストを実装する場合、まだまだjunit4が使われていることが多いかと思います。
junit4は2006年リリースされ、12年以上が経ちました。
現代的なframeworkを知り、
テストしやすさ、テストの楽しさを見つけてください。

## テスト対象アプリケーション

1. spring-boot ver 2.1
1. spring-mvc
1. controller - service -repository


## テストケース

1. 基本のテスト（数値、文字列、配列）
1. コラボレーターのテスト(mocking)
1. e2eテスト(@SpringBootTest)

## STEP

### step/01

junit4の実装をgroovy, kotlin用にconvertしました。
convertはeclipseをつかいました。
そのせいか、全く動きません。

### step/02

"1. 基本のテスト"を実装しました。

* src/test/java/tecktalk201902/junit4/Junit4_Test_Chapter1
* src/test/java/tecktalk201902/junit5/Junit5_Test_Chapter1
* src/test/groovy/tecktalk201902/groovy/Groovy_Test_Chapter1
* src/test/kotlin/tecktalk201902/kotlin/Kotlin_Test_Chapter1

### step/03

"2.コラボレーターのテスト"を実装しました
* src/test/java/tecktalk201902/junit4/Junit4_Test_Chapter2
* src/test/java/tecktalk201902/junit5/Junit5_Test_Chapter2
* src/test/groovy/tecktalk201902/groovy/Groovy_Test_Chapter2
* src/test/kotlin/tecktalk201902/kotlin/Kotlin_Test_Chapter2

### step/04

"3.e2eテスト"を実装しました
* src/test/java/tecktalk201902/junit4/Junit4_Test_Chapter2
* src/test/java/tecktalk201902/junit5/Junit5_Test_Chapter2
* src/test/groovy/tecktalk201902/groovy/Groovy_Test_Chapter2
* src/test/kotlin/tecktalk201902/kotlin/Kotlin_Test_Chapter2
