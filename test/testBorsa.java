import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class testBorsa {
	
	private Borsa b=new Borsa(20);
	private Attrezzo A=new Attrezzo("Gioco",2);
	private Attrezzo B=new Attrezzo("Spada",3);
	private Attrezzo C=new Attrezzo("Dado",1);
	
	@Before
	public void setUp() {
		b.addAttrezzo(A);
		b.addAttrezzo(B);
		b.addAttrezzo(C);
	}
	
	@Test
	public void test_getPeso(){
		assertEquals(6,b.getPeso());
	}
	
	@Test
	public void test_removeAttrezzo() {
		b.removeAttrezzo("Dado");
		assertEquals(5,b.getPeso());
	}
	
	@Test
	public void test_getnumeroAttrezzi() {
		assertEquals(3,b.getnumeroAttrezzi());
	}
	
	@Test
	public void test_getAttrezzo() {
		assertEquals(A,b.getAttrezzo("Gioco"));
		assertNull(b.getAttrezzo("Bambola"));
	}
	
}
