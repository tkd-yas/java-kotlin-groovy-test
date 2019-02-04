package tecktalk201902;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.StreamSupport;

import org.junit.Assert;
import org.junit.Test;

public class Junit4TestChapter1 {

	private final String val1 = "文字列のテスト";

	private final int[] numbers = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 };

	@Test
	public void テスト1_基本のテスト() {

		// 文字列
		Assert.assertNotNull("val1はnullではないこと", val1);
		Assert.assertTrue("val1は`文字列`から開始すること	", val1.startsWith("文字列"));

		// ���l
		int two = 1 + 1;
		Assert.assertEquals("`1 + 1`は2であること", 2, two);

		// �z��
		OptionalInt max = StreamSupport.intStream(Arrays.spliterator(numbers), true).max();
		int expectedMax = 55;
		Assert.assertTrue("最大値は55", max.isPresent());
		Assert.assertEquals("最大値は55", expectedMax, max.getAsInt());
	}
}
