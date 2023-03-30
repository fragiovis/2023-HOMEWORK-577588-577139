import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.giocatore.Giocatore;

public class testGiocatore {
	
	private Giocatore g=new Giocatore();
			
	@Test
	public void test() {
		assertEquals(20,g.getCfu());
	}

}
