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
			blogg = new Blogg(leser.nextInt() ); //Henter antall innlegg på første linje

			if (leser.nextLine().equals(TEKST) ) {
				int id = leser.nextInt();
				String bruker = leser.nextLine();
				String dato = leser.nextLine();

				while (leser.hasNextLine() ) {


					if (leser.nextLine().equals(BILDE) ) {
						break;
					}
				}
				Tekst tekst = new Tekst(id, bruker, dato, tekst);
			}
			else if (leser.nextLine().equals(BILDE)) {
				Bilde bilde;
				while (!leser.nextLine().equals(TEKST)) {

				}
			}
		}
		catch (Exception ignored) {}

		//blogg.leggTil();
		System.out.println(blogg);


		return blogg;
	}
}
