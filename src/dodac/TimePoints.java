package dodac;

import java.util.stream.IntStream;

public class TimePoints  {
	private final int[] points;
	private final int[] durations;
	
	public TimePoints(Integer[] tones) {
		//zero the row
		Integer[] zeroed = Utils.transposeArray(tones, 12-tones[0]);


		points = new int[zeroed.length];
		durations = new int[zeroed.length];
		
		points[0] = zeroed[0];
		durations[0] = zeroed[1];
		int base = 0;
		for (int i = 1; i < zeroed.length;i++) {
			if(zeroed[i] < zeroed[i-1]) {
				base += zeroed.length;
			}

			points[i] = zeroed[i] + base;
			durations[i-1] = points[i] - points[i-1];
		}
		durations[zeroed.length-1] = 
				points[0] + base + (points[0]< zeroed[zeroed.length-1]?zeroed.length:0) - points[zeroed.length-1];
	}

	public int[] getPoints() {
		//defensive copy
		return points.clone();
	}

	public int[] getDurations() {
		//defensive copy
		return durations.clone();
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for(int x = 0;x < points.length;x++) {
			sb.append(points[x]);
			sb.append("("+ durations[x] + ")\t");
		}
		sb.append("(tot: " + IntStream.of(durations).sum() + ")");

		return sb.toString();
	}
}
