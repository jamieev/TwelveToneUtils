package dodac;

import jm.music.data.*;

import jm.JMC;
import jm.util.*;

public class JMus implements JMC {
   
    private static final String RI = "RI";
	private static final String R = "R";
	private static final String I = "I";
	private static final String P = "P";

	public void notateRow(Row row) {
    	Score s = new Score("TwelveTone - Row");	    
    	
    	s.add(part(row ,P));
       	s.add(part(row.invert() ,I));
       	s.add(part(row.retrograde() ,R));
       	s.add(part(row.retrograde().invert() ,RI));
        View.notate(s);
        Write.midi(s, "row.mid");
    }
    
    private Part part(Row row, String name) {
		Part p = new Part(name, FLUTE, 0);
    	p.add(phrase(row, name));

    	return p;
    }
    
    private Phrase phrase(Row row, String name) {
		Phrase phr = new Phrase(name, 0.0);
		int[] durs = row.getTimePoints().getDurations();
		int counter = 0;
    	for(Integer i: row) {
    		phr.addNote(new Note(C4+i, SQ*durs[counter++]));
    	}

    	return phr;
    }
}
