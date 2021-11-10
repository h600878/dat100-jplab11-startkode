package no.hvl.dat100.jplab11.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
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

		try (Scanner leser = new Scanner(filnavn) ) {
			int antallInnlegg = leser.nextInt(); //Henter antall innlegg på første linje
			blogg = new Blogg(antallInnlegg);

			for (int i = 0; i < antallInnlegg; i++) {
				if (leser.nextLine().equals(TEKST) ) {
					int id = leser.nextInt();
					String bruker = leser.nextLine();
					String dato = leser.nextLine();
					int liker = leser.nextInt();
					String tekst = "";

					while (leser.hasNextLine() ) {
						tekst += leser.nextLine();
						if (leser.nextLine().equals(BILDE) ) {
							break;
						}
					}
					blogg.leggTil(new Tekst(id, bruker, dato, liker, tekst) );
				}
				else if (leser.nextLine().equals(BILDE)) {
					int id = leser.nextInt();
					String bruker = leser.nextLine();
					String dato = leser.nextLine();
					int liker = leser.nextInt();
					String tekst = "";

					while (leser.hasNextLine() ) {
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
		catch (Exception ignored) {}

		return blogg;
	}
}
