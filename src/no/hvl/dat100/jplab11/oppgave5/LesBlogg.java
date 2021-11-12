package no.hvl.dat100.jplab11.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static final String TEKST = "TEKST";
	private static final String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {

		Blogg blogg = null;
		File fil = new File( mappe + filnavn);

		try (Scanner leser = new Scanner(fil) ) { //TODO leser hopper over flere linjer av og til🤔
			int antallInnlegg = Integer.parseInt(leser.nextLine() ); //Henter antall innlegg på første linje
			blogg = new Blogg(antallInnlegg);

			for (int i = 0; i < antallInnlegg; i++) {
				if (leser.nextLine().equals(TEKST) ) {
					int id = Integer.parseInt(leser.nextLine() );
					String bruker = leser.nextLine();
					String dato = leser.nextLine();
					int liker = Integer.parseInt(leser.nextLine() );
					String tekst = "";

					while (leser.hasNextLine() ) {
						tekst += leser.nextLine();
						if (leser.nextLine().equals(BILDE)) {
							break;
						}
					}
					blogg.leggTil(new Tekst(id, bruker, dato, liker, tekst) );
				}
				else if (leser.nextLine().equals(BILDE)) {
					int id = Integer.parseInt(leser.nextLine() );
					String bruker = leser.nextLine();
					String dato = leser.nextLine();
					int liker = Integer.parseInt(leser.nextLine() );
					String tekst = "";

					while (leser.hasNextLine()) {
						tekst += leser.nextLine();
						if (leser.nextLine().contains("http") ) {
							break;
						}
					}
					String url = leser.nextLine();
					blogg.leggTil(new Bilde(id, bruker, dato, liker, tekst, url) );
				}
			}
		}
		catch (NullPointerException e) {
			System.out.println("Error!");
		}
		catch (InputMismatchException e) {
			System.out.println("Feil input!");
		}
		catch (NumberFormatException e) {
			System.out.println("Feil format!!!!");
		}
		catch (FileNotFoundException e) {
			System.out.println("Fil ikke funnet!");
		}

		return blogg;
	}
}
