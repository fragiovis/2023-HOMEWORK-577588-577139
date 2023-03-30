import static org.junit.Assert.*;
/* test dei metodi getAttrezzo, hasAttrezzo, addAttrezzo e getDirezioni*/

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class testStanza {
	
	private Stanza stanza=new Stanza("n11");
	private Attrezzo a=new Attrezzo("Bambola",10);
	private Attrezzo b=new Attrezzo("Coltello",3);
	private Attrezzo c=new Attrezzo("Palla",4);
	private Attrezzo d=new Attrezzo("Dado",1);
	
	@Before
	public void setUp() {
	stanza.addAttrezzo(a);
	stanza.addAttrezzo(b);
	stanza.addAttrezzo(c);
	}
	
	@Test
	public void test_addAttrezzo() {
		assertTrue(stanza.addAttrezzo(d));
	}
	
	@Test
	public void test_getAttrezzo(){
		assertNull(stanza.getAttrezzo("coltello"));
	}
	
	@Test
	public void test_hasAttrezzo() {
		assertTrue(stanza.hasAttrezzo("Bambola"));
	}
	
	@Test
	public void test_removeAttrezzo() {
		stanza.removeAttrezzo(a);
		assertEquals(2,stanza.getnumeroAttrezzi());
	}
	
	@Test
	public void test_removeAttrezzo2() {
		assertTrue(stanza.removeAttrezzo(b));
	}
}
