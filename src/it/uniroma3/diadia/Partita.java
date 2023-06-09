package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private boolean finita;
	private int cfu;
	private Giocatore giocatore;
	private Labirinto labirinto;
	private Stanza stanzaCorrente;
	
	public Partita(){
		
		giocatore=new Giocatore();
		labirinto=new Labirinto();
		labirinto.creaStanze();
		this.stanzaCorrente=labirinto.getStanzaIniziale();
		this.finita = false;
	}
	
	public Labirinto getLabirinto(){
		return this.labirinto;
	}
	
	public Giocatore getGiocatore() {
		return this.giocatore;
	}
	
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.stanzaCorrente== labirinto.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		giocatore=new Giocatore();
		return finita || vinta() || (giocatore.getCfu()== 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
	
	public boolean getFinita() {
		return this.finita;
	}
}
