package tecktalk201902.junit4;

import java.util.OptionalInt;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tecktalk201902.Sut_Chapter1;
import tecktalk201902.testcase.Test_Chapter1;

/**
 * Tecktalk 2019 02 後半.<br>
 * テストケース１のJunit4実装
 *
 * @author y.takada
 *
 */
public class Junit4_Test_Chapter1 implements Test_Chapter1 {

	private Sut_Chapter1 sut;

	@Before
	public void setup() {
		// テスト対象セットアップ
		sut = new Sut_Chapter1() {
			// nothing.
		};
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see tecktalk201902.junit4.Test_Chapter11#テスト1_1_基本のテスト_文字列()
	 */
	@Override
	@Test
	public void テスト1_1_基本のテスト_文字列() {

		String actual = sut.repeat("test", 10);
		// 文字列
		Assert.assertNotNull("結果はnullではないこと", actual);
		Assert.assertEquals("結果は40桁であること", 40, actual.length());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see tecktalk201902.junit4.Test_Chapter11#テスト1_2_基本のテスト_数値()
	 */
	@Override
	@Test
	public void テスト1_2_基本のテスト_数値() {
		// 数値
		int actual = sut.sum(1, 1);
		Assert.assertEquals("`1 + 1`は2であること", 2, actual);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see tecktalk201902.junit4.Test_Chapter11#テスト1_3_基本のテスト_配列()
	 */
	@Override
	@Test
	public void テスト1_3_基本のテスト_配列() {
		// 配列
		int[] fibo = sut.fibo(0, 10);
		Assert.assertEquals("配列の要素数は10", 10, fibo.length);
		Assert.assertArrayEquals("配列の要素比較", new int[] { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 }, fibo);

		OptionalInt max = sut.max(fibo);

		Assert.assertTrue("配列の最大値が取得できること", max.isPresent());
		Assert.assertEquals("初期値0, 要素数10のフィボナッチの最大値は34", 34, max.getAsInt());
	}
}
