package tecktalk201902.junit5;

import java.util.OptionalInt;

/* ================================================================================
 * ((1)) アノテーションいらないをjunit5のものにかえる
 * import org.junit.Assert; => import static org.junit.jupiter.api.Assertions.*;
 * import org.junit.Before; => import org.junit.jupiter.api.BeforeEach;
 * import org.junit.Test;   => import org.junit.jupiter.api.Test;
 * ================================================================================*/
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tecktalk201902.Sut_Chapter1;
import tecktalk201902.testcase.Test_Chapter1;

/**
 * Tecktalk 2019 02 後半.<br>
 * テストケース１のJunit5実装
 *
 * @author y.takada
 *
 */
public class Junit5_Test_Chapter1 implements Test_Chapter1 {

	private Sut_Chapter1 sut;

	@BeforeEach
	public void setup() {
		sut = new Sut_Chapter1() {
			// nothing.
		};
	}

	@Override
	@Test
	public void テスト1_1_基本のテスト_文字列() {
		String actual = sut.repeat("test", 10);
/*================================================================================
 * ((2)) org.junit.jupiter.api.Assertionsではmessageは最後の引数になった
 ================================================================================*/
		assertNotNull(actual, "結果はnullではないこと");
		assertEquals(40, actual.length(), "結果は40桁であること");
	}

	@Override
	@Test
	public void テスト1_2_基本のテスト_数値() {
		int actual = sut.sum(1, 1);
		assertEquals(2, actual, "`1 + 1`は2であること");
	}

	@Override
	@Test
	public void テスト1_3_基本のテスト_配列() {
		// 配列
		int[] fibo = sut.fibo(0, 10);
		assertEquals(10, fibo.length, "配列の要素数は10");
		assertArrayEquals(new int[] { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 }, fibo, "配列の要素比較");

		OptionalInt max = sut.max(fibo);

		assertTrue( max.isPresent(), "配列の最大値が取得できること");
		assertEquals(34, max.getAsInt(), "初期値0, 要素数10のフィボナッチの最大値は34");
	}
}
