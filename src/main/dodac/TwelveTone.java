package dodac;

import java.util.ArrayList;
import java.util.List;

public class TwelveTone {
	
	private static final String TAB = "\t";
	
	public static void main(String[] args) {
		//All info is output by default. Outputs can be optionally suppressed
		boolean suppressRow = false;
		boolean suppressTimepoints = false;
		boolean suppressMatrix = false;
		boolean suppressNotation = false;
		List<Integer> inputTones = new ArrayList<Integer>();
		for(String s : args) {
			switch(s) {
			case "-r" : suppressRow = true;
			break;
			case "-t" : suppressTimepoints = true;
			break;
			case "-m" : suppressMatrix = true;
			break;
			case "-n" : suppressNotation = true;
			break;
			default: inputTones.add(Integer.parseInt(s));//assume it's an integer - otherwise exception
			}
		}
		Row row = null;
		try {
			//check if tones have been input on the command line, else generate a random set
			if(inputTones.size() > 0) {
				row = new Row(inputTones.toArray(new Integer[inputTones.size()]));
			} else {
				row = new Row(Utils.generateTones());
			}
			if (!suppressRow) {
				//Row row = new Row(tones);
				System.out.println("ROW P: ");
				System.out.println(row.toString());
				System.out.println(row.printNoteNames());
				System.out.println("ROW I: ");
				System.out.println(row.invert().toString());
				System.out.println(row.invert().printNoteNames());
				System.out.println("Timepoints: P, I, R, RI:");
			}
			if (!suppressTimepoints) {
				System.out.println(row.getTimePoints());
				System.out.println(row.invert().getTimePoints());
				System.out.println(row.retrograde().getTimePoints());
				System.out.println(row.invert().retrograde().getTimePoints());
			}
			if (!suppressMatrix) {
				System.out.println("\n\nMatrix:");
				printMatrix(row);
			}
			if (!suppressNotation) {
				JMus jMus = new JMus();
				jMus.notateRow(row);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void printMatrix(Row row) {
		
		int first = row.getFirst();
		
		//print I labels
		System.out.print(TAB);
		for(Integer i: row) {
			System.out.print("I" + String.format("%4s", i + TAB));			
		}
		System.out.print("\n");

		for(int n: row.invert()) {

			System.out.print("P" + String.format("%4s", n + TAB));
			int t = 0;
			if(n >= first) {
				t = Math.abs(n - first);
			} else {
				t= row.length() + n - first;
			}

			System.out.println(row.transposeRow(t).printNoteNames());

		}

	}
}
