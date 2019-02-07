package tecktalk201902.kotlin

import io.kotlintest.matchers.boolean.shouldBeTrue
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import tecktalk201902.Sut_Chapter1

/**
 * Tecktalk 2019 02 後半.<br>
 * テストケース１のJunit4実装
 *
 * @author y.takada
 *
 */
class Kotlin_Test_Chapter1 : StringSpec({

    val sut: Sut_Chapter1 = object : Sut_Chapter1 {}

    "テスト1_1_基本のテスト_文字列" {
        sut.repeat("test", 10).length.shouldBe(40)
    }

    "テスト1_2_基本のテスト_数値" {
        // 数値
        sut.sum(1, 1).shouldBe(2)
    }

    "テスト1_3_基本のテスト_配列" {
        // 配列
        val fibo = sut.fibo(0, 10)
        fibo.size.shouldBe(10)
        fibo.shouldBe(intArrayOf(0, 1, 1, 2, 3, 5, 8, 13, 21, 34))
        val max = sut.max(fibo)
        max.isPresent.shouldBeTrue()
        max.asInt.shouldBe(34)
    }
})
