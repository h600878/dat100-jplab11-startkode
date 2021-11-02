package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import no.hvl.dat100.jplab11.oppgave2.Bilde;
import no.hvl.dat100.jplab11.oppgave2.Tekst;
import no.hvl.dat100.jplab11.oppgave4.SkrivBlogg;
import no.hvl.dat100.jplab11.oppgave6.HtmlBlogg;

class TestHtmlBlogg {

	private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/tests/";
	private static String FILNAVN = "blogg.html";
	
	@Test
	public void testskriv() {
		
		Tekst innlegg1 = new Tekst(1,"Ole Olsen","23-10","DAT100 oppgave 6");
		Bilde innlegg2 = new Bilde(2,"Oline Olsen","24-10","HVL logo","https://www.west-norway.no/wp-content/uploads/2018/05/HVL-nettside.jpg");
		
		HtmlBlogg samling = new HtmlBlogg();
		
		samling.leggTil(innlegg1);
		samling.leggTil(innlegg2);
		
		assertTrue(SkrivBlogg.skriv(samling, MAPPE, FILNAVN));
	}	
}
