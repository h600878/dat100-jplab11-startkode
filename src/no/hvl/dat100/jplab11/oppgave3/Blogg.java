package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

	private Innlegg[] innleggTabell;
	private int nesteLedig;

	public Blogg() {
		innleggTabell = new Innlegg[20];
		nesteLedig = 0;
	}

	public Blogg(int lengde) {
		innleggTabell = new Innlegg[lengde];
		nesteLedig = 0;
	}

	public int getAntall() {
		return nesteLedig;
	}
	
	public Innlegg[] getSamling() {
		return innleggTabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {

		if (finnes(innlegg) ) {
			for (int i = 0; i < nesteLedig; i++) {
				if (innleggTabell[i].erLik(innlegg) ) {
					return i;
				}
			}
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {

		if (nesteLedig > 0) {
			for (int i = 0; i < nesteLedig; i++) {
				if (innleggTabell[i].erLik(innlegg)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean ledigPlass() {
		return nesteLedig < innleggTabell.length;
	}
	
	public boolean leggTil(Innlegg innlegg) {

		if (ledigPlass() ) {
			innleggTabell[nesteLedig] = innlegg;
			nesteLedig++;
			return true;
		}
		return false;
	}

	//2\nTEKST\n1\nOle Olsen\n23-10\n0\nen tekst\nBILDE\n2\nOline Olsen\n24-10\n0\net bilde\nhttp://www.picture.com/oo.jpg\n
	public String toString() {

		String s = "";

		if (nesteLedig > 0) {
			for (int i = 0; i < nesteLedig; i++) {
				s += innleggTabell[i];
			}
		}
		return 	nesteLedig + "\n" + s;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {

		Blogg nyInnleggTabell = new Blogg(innleggTabell.length * 2);

		if (nesteLedig > 0) {
			for (int i = 0; i < innleggTabell.length; i++) {
				nyInnleggTabell.getSamling()[i] = innleggTabell[i];
			}
			innleggTabell = nyInnleggTabell.getSamling();
		}
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		if (ledigPlass() ) {
			if (!finnes(innlegg) ) {
				leggTil(innlegg);
				return true;
			}
		}
		else {
			utvid();
			leggTil(innlegg);
			return true;
		}
		return false;
	}
	
	public boolean slett(Innlegg innlegg) {

		int i = finnInnlegg(innlegg);

		if (nesteLedig > 0) {

			nesteLedig--;

			for (; i < nesteLedig; i++) {
				innleggTabell[nesteLedig] = innleggTabell[nesteLedig + 1];
			}

			innleggTabell[nesteLedig] = null;
			return true;
		}
		return false;
	}
	
	public int[] search(String keyword) {
		int antall = 0;
		for (int i = 0; i < nesteLedig; i++){
			if (innleggTabell[i].toString().contains(keyword)){
				antall ++;
			}
		}
		int[]tab = new int[antall];
		for (int i = 0; i < antall; i++){
			if (innleggTabell[i].toString().contains(keyword)){
				tab[i] = innleggTabell[i].getId();
			}
		}
		return tab;
	}
}