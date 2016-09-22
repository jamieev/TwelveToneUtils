package dodac;

public class TwelveTone {
	
	private static final String USAGE = "Usage: TwelveTone + a twelve tone array args ";
	private static final String TAB = "\t";
	
	public static void main(String[] args) {
		if(args.length<0 || args.length > 12) {
			System.out.println(USAGE);
			System.exit(0);
		}
		Row row = null;
		try {
			if(args.length > 0) {
				Integer[] inputTones = new Integer[args.length];
				for(int x = 0;x < args.length;x++) {
					inputTones[x] = Integer.parseInt(args[x]);
				}
				row = new Row(inputTones);
			} else {
				row = new Row(Utils.generateTones());
			}
			//Row row = new Row(tones);
			System.out.println("ROW P: ");
			System.out.println(row.toString());
			System.out.println(row.printNoteNames());
			System.out.println("ROW I: ");
			System.out.println(row.invert().toString());
			System.out.println(row.invert().printNoteNames());
			System.out.println("Timepoints: P, I, R, RI:");

			System.out.println(row.getTimePoints());
			System.out.println(row.invert().getTimePoints());
			System.out.println(row.retrograde().getTimePoints());
			System.out.println(row.invert().retrograde().getTimePoints());
			
			System.out.println("\n\nMatrix:");
			printMatrix(row);
			JMus jMus = new JMus();
			jMus.notateRow(row);

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
