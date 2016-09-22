package dodac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Row implements Iterable<Integer> {

	private static final String TAB = "\t";
	private static final String[] NOTE_NAMES = {"C","C#","D","D#","E","F","F#","G","G#","A","Bb","B"};

	private TimePoints timePoints;
	
	private Integer[] tones;

	public Row(Integer[] tones) {
		super();
		this.tones = tones;
		this.timePoints = new TimePoints(tones.clone());
	}
	
	public String printNoteNames() {
		StringBuffer sb = new StringBuffer();
		for(int i : tones) {
			sb.append(String.format("%4s",NOTE_NAMES[i])).append(TAB);
		}

		return sb.toString();
	}
	
	public Row invert() {
		Integer[] i = new Integer[tones.length];
		for(int x = 0; x < tones.length; x++) {

			if(tones[x] == 0) {
				i[x] = 0;
			} else {
				i[x] = tones.length-tones[x];
			}
		}		
		return new Row(i);
	}
	
	public Row retrograde() {
		List<Integer> copyRow = new ArrayList<Integer>(Arrays.asList(tones));
		Collections.reverse(copyRow);
	
		return new Row(copyRow.toArray(new Integer[copyRow.size()]));
	}
	
	public Row transposeRow(int t) {
		if(t == 0 ) return new Row(tones);
		if(t > 11 || t < 0) {
			throw new IllegalArgumentException("Enter a transposition number between 1 and 11");
		}

		return new Row(Utils.transposeArray(tones, t));
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for(int i : tones) {
			sb.append(String.format("%4s",i)).append(TAB);
		}

		return sb.toString();
	}

	@Override
	public Iterator<Integer> iterator() {
		return Arrays.asList(tones).iterator();
	}
	
	public int length() {
		return tones.length;
	}
	
	public int getFirst() {
		int f = tones[0];
		return f;
	}

	public TimePoints getTimePoints() {
		return timePoints;
	}
}
