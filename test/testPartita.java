import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.Partita;

public class testPartita {
	
	private Partita p=new Partita();
	
	@Test
	public void test_setFinita() {
		p.setFinita();
		assertTrue(p.getFinita());
	}
	
	@Test
	public void test_isFinita() {
		assertFalse(p.isFinita());
	}
	
}
