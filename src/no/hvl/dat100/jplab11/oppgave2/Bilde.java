package no.hvl.dat100.jplab11.oppgave2;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.Innlegg;

public class Bilde extends Tekst {

	private String url;

	public Bilde(int id, String bruker, String dato, String tekst, String url) {

		super(id, bruker, dato, tekst);
		this.url = url;

	}

	public Bilde(int id, String bruker, String dato, int likes, String tekst, String url) {

		super(id, bruker, dato, likes, tekst);
		this.url = url;

	}

	public String getUrl() {

		return url;

	}

	public void setUrl(String url) {

		this.url = url;

	}

	@Override
	public String toString() { //BILDE\n1\nOle Olsen\n23-10\n0\net bilde\nhttp://www.picture.com/oo.jpg\n

		return "BILDE" + "\n" + getId() + "\n" + getBruker() + "\n" + getDato() + "\n" + getLikes() + "\n"
				+ getTekst() + "\n" + url + "\n";

	}

	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {

		throw new UnsupportedOperationException(TODO.method());

	}
}
