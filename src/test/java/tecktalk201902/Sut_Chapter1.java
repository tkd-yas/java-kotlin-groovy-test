package tecktalk201902;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.StreamSupport;

public interface Sut_Chapter1 {

	default String repeat(String value, int times) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; times > i; i++) {
			sb.append(value);
		}
		return sb.toString();
	}

	default int sum(int... args) {
		return StreamSupport.intStream(Arrays.spliterator(args), true).sum();
	}

	default int[] fibo(int start, int size) {
		int[] result = new int[size];
		if (size == 0) {
			return result;
		}
		result[0] = start;
		if (size == 1) {
			return result;
		}

		result[1] = start + 1;
		if (size == 2) {
			return result;
		}

		for (int i = 2; size > i; i++) {
			result[i] = result[i - 2] + result[i - 1];
		}
		return result;
	}

	default OptionalInt max(int[] args) {
		return StreamSupport.intStream(Arrays.spliterator(args), true).max();
	}
}
