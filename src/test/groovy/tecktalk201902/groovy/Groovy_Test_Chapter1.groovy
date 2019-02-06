package tecktalk201902.groovy

import org.junit.Test

import spock.lang.Specification
import tecktalk201902.Sut_Chapter1

/* ================================================================================
 * ((1)) spock.lang.Specification を 継承
 * ================================================================================*/
class Groovy_Test_Chapter1 extends Specification { // implements Test_Chapter1


	private Sut_Chapter1 sut


/* ================================================================================
 * ((2)). Junitいらない, ただし、＠Before相当はsetupという名前であること
 ================================================================================*/
//	@Before
	public void setup() {
		sut = new Sut_Chapter1() {}
	}

//	@Override
//	@Test /* ((1)) */
	public void テスト1_1_基本のテスト_文字列() {
/* ================================================================================
 * ((3)) expect:, then:ブロックに booleanを返す式を書くとassert
 ================================================================================*/
		// TODO: アンケート、expectedは左辺？
		expect:
		sut.repeat("test", 10).size() == 40
	}

//	@Override
//	@Test /* ((1)) */
	public void テスト1_2_基本のテスト_数値() {
		expect:
		sut.sum(1, 1) == 2 //`1 + 1`は2であること",
	}

//	@Override
//	@Test /* ((1)) */
	public void テスト1_3_基本のテスト_配列() {
		when:
		int[] fibo = sut.fibo(0, 10)
		OptionalInt max = sut.max(fibo)

		then:
		10 == fibo.length // "配列の要素数は10",
		[0, 1, 1, 2, 3, 5, 8, 13, 21, 34] == fibo // "配列の要素比較"
		max.present // "配列の最大値が取得できること"
		34 ==  max.asInt // "初期値0, 要素数10のフィボナッチの最大値は34",
	}

}
