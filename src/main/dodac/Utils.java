package dodac;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Utils {

	private static final Integer[] tones = {0,1,2,3,4,5,6,7,8,9,10,11};

	public static Integer[] generateTones() {
		List<Integer> l = Arrays.asList(tones);
		Collections.shuffle(l);

		return (Integer[])l.toArray();
	}
	
	public static Integer[] transposeArray(Integer[] tones, int t) {
		Integer[] tr = new Integer[tones.length];

		for(int x = 0; x < tones.length; x++) {
			tr[x] = (tones[x] + t) % 12;
		}

		return tr;
	}
}
