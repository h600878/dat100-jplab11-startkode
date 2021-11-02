package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

public class TestBlogg {

	@Test
	public void testStandardConstructor() {
		Blogg samling = new Blogg();
		
		assertEquals(samling.getAntall(),0);
		assertEquals(samling.getSamling().length,20);
		
	}

	@Test
	public void testConstructor() {
		Blogg samling = new Blogg(40);
		
		assertEquals(samling.getAntall(),0);
		assertEquals(samling.getSamling().length,40);
	}
	
	
	@Test 
	public void testleggTil() {
		Blogg samling = new Blogg(40);
	
		TInnlegg innlegg1 = new TInnlegg(1,"Ole Olsen","23-10");
		TInnlegg innlegg2 = new TInnlegg(2,"Oline Olsen","24-10");
		TInnlegg innlegg3 = new TInnlegg(3,"Oda Olsen","24-10");
		
		assertTrue(samling.leggTil(innlegg1));
		assertTrue(samling.leggTil(innlegg2));
		
		assertEquals(samling.getAntall(),2);
		
		assertTrue(samling.finnInnlegg(innlegg1) >= 0);
		assertTrue(samling.finnInnlegg(innlegg3) < 0);
		
		assertTrue(samling.finnes(innlegg1));
		assertTrue(samling.finnes(innlegg2));
		assertFalse(samling.finnes(innlegg3));
		
	}
	
	@Test
	public void testledigPlass() {
		Blogg samling1 = new Blogg(40);
		Blogg samling2 = new Blogg(2);
		
		TInnlegg innlegg1 = new TInnlegg(1,"Ole Olsen","23-10");
		TInnlegg innlegg2 = new TInnlegg(2,"Oline Olsen","24-10");
		
		samling1.leggTil(innlegg1);
		samling1.leggTil(innlegg2);
		
		samling2.leggTil(innlegg1);
		samling2.leggTil(innlegg2);
		
		assertTrue(samling1.ledigPlass());
		assertFalse(samling2.ledigPlass());
	}
	
	@Test
	public void testutvid() {
		Blogg samling = new Blogg(2);
		
		TInnlegg innlegg1 = new TInnlegg(1,"Ole Olsen","23-10");
		TInnlegg innlegg2 = new TInnlegg(2,"Oline Olsen","24-10");

		samling.leggTil(innlegg1);
		samling.leggTil(innlegg2);
		
		assertEquals(samling.getAntall(),2);
		assertFalse(samling.ledigPlass());
		
		samling.utvid();
		
		assertTrue(samling.finnes(innlegg1));
		assertTrue(samling.finnes(innlegg2));
		assertEquals(samling.getAntall(),2);
		assertTrue(samling.ledigPlass());	
	}
	
	@Test
	public void testslett() {
	
		Blogg samling = new Blogg(2);
		
		TInnlegg innlegg1 = new TInnlegg(1,"Ole Olsen","23-10");
		TInnlegg innlegg2 = new TInnlegg(2,"Oline Olsen","24-10");

		samling.leggTil(innlegg1);
		samling.leggTil(innlegg2);
		
		assertEquals(2,samling.getAntall());
		assertTrue(samling.finnes(innlegg1));
		assertTrue(samling.finnes(innlegg2));
		
		samling.slett(innlegg2);
		
		assertEquals(1,samling.getAntall());
		assertTrue(samling.finnes(innlegg1));
		assertFalse(samling.finnes(innlegg2));
	}
	
	@Test
	public void testtoString() {
		Blogg samling = new Blogg(2);
		
		Tekst innlegg1 = new Tekst(1,"Ole Olsen","23-10","en tekst");
		Bilde innlegg2 = new Bilde(2,"Oline Olsen","24-10","et bilde","http://www.picture.com/oo.jpg");

		samling.leggTil(innlegg1);
		samling.leggTil(innlegg2);
		
		String str = "2\n" + 
				"TEKST\n1\nOle Olsen\n23-10\n0\nen tekst\n" + 
				"BILDE\n2\nOline Olsen\n24-10\n0\net bilde\nhttp://www.picture.com/oo.jpg\n";
		
		assertEquals(str,samling.toString());
		
	}
}
