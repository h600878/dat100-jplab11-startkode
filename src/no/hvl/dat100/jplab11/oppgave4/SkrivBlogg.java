package no.hvl.dat100.jplab11.oppgave4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import no.hvl.dat100.jplab11.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {

		File file = new File(mappe, filnavn);
		PrintWriter skriver = null;
		Boolean utført = false;

		try {

			skriver = new PrintWriter(file);

			if (samling.getAntall() > 0){

				skriver.print(samling);
				utført = true;
			}

		}

		catch (FileNotFoundException e){

			System.out.println("Fant ikke filen :(");

		}
		finally {
			if (skriver != null) {
				skriver.close();
			}
		}

		return utført;
	}
}
