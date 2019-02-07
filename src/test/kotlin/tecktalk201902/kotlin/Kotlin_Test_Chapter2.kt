package tecktalk201902.kotlin

import io.kotlintest.data.forall
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.kotlintest.tables.row
import jp.co.gxp.tecktalk201902.jo.JoService
import org.springframework.test.util.ReflectionTestUtils
import tecktalk201902.jo.MockPersonRepository

/**
 * Tecktalk 2019 02 後半.<br>
 * テストケース２のJunit4実装 パラメタライズドテスト.
 *
 * @author y.takada
 *
 */
//@RunWith(Parameterized::class)
class Kotlin_Test_Chapter2 : StringSpec() {

    val sut: JoService = JoService()

    init {

        ReflectionTestUtils.setField(sut, "personRepository", MockPersonRepository())

        forall(
                row(1, "ジョナサン・ジョースター"),
                row(2, "ジョセフ・ジョースター"),
                row(3, "空条承太郎"),
                row(4, "東方仗助"),
                row(5, "ジョルノ・ジョバーナ")
        ) { storyNumber: Int, name: String ->
            "テスト２＿parameterizedテスト:第${storyNumber}部のjojoは${name}である" {
                val actual = sut.story(storyNumber)
                actual.characters.iterator().next().name shouldBe name
            }
        }
    }

}