package no.hvl.dat100.jplab11.oppgave4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {

		File file = new File(filnavn);
		PrintWriter skriver = null;
		Boolean utført = false;

		try {

			skriver = new PrintWriter(file);

			if (samling.getAntall() > 0){

				for (int i = 0; i < samling.getAntall(); i++){

				skriver.print(samling.toString());

				}

				utført = true;

			}

		}

		catch (FileNotFoundException e){

		skriver.print("Fant ikke filen :(");

		}

		return utført;
	}
}
