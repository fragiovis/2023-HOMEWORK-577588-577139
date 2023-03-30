package it.uniroma3.diadia;
import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi" , "posa"};

	private Partita partita;

	private IOConsole IOConsole;


	public DiaDia() {
		this.partita = new Partita();
		this.IOConsole = new IOConsole();
	}

	public void gioca() {
		String istruzione; 

		this.IOConsole.mostraMessaggio(MESSAGGIO_BENVENUTO);
			
		do		
			istruzione = this.IOConsole.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		while(comandoDaEseguire.getNome()!=null) {		//AGGIUNTO DA ME
			if (comandoDaEseguire.getNome().equals("fine")) {
				this.fine(); 
				return true;
			}
			else if (comandoDaEseguire.getNome().equals("vai"))
				this.vai(comandoDaEseguire.getParametro());

			else if (comandoDaEseguire.getNome().equals("aiuto"))
				this.aiuto();
			else if (comandoDaEseguire.getNome().equals("prendi")) {
				this.prendi(comandoDaEseguire.getParametro());
			}
			else if (comandoDaEseguire.getNome().equals("posa"))
				this.posa(comandoDaEseguire.getParametro());

			else
				this.IOConsole.mostraMessaggio("Comando sconosciuto");
			if (this.partita.vinta()) {
				this.IOConsole.mostraMessaggio("Hai vinto!");
				return true;
			}
			else
				return false;

		}
		return false;
	}   


	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			this.IOConsole.mostraMessaggio(elencoComandi[i]+" ");
		this.IOConsole.mostraMessaggio(" ");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			System.out.println("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			this.IOConsole.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu--);
		}
		this.IOConsole.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		this.IOConsole.mostraMessaggio(partita.getGiocatore().getDescrizione());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		this.IOConsole.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();

	}

	private void prendi(String nomeAttrezzo) {
		Stanza s=this.partita.getStanzaCorrente();
		if(s.getnumeroAttrezzi()!=0) {
			if(s.hasAttrezzo(nomeAttrezzo)) {
				Attrezzo attrezzo = this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
				this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
				s.removeAttrezzo(attrezzo);
				this.IOConsole.mostraMessaggio("Attrezzo preso con successo!");
			}
			else
				this.IOConsole.mostraMessaggio("Attrezzo non presente nella stanza!\n");
		}
		else
			this.IOConsole.mostraMessaggio("Non ci sono attrezzi nella stanza\n");
		this.IOConsole.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		this.IOConsole.mostraMessaggio(partita.getGiocatore().getDescrizione());

	}

	private void posa(String nomeAttrezzo) {
		Borsa b=this.partita.getGiocatore().getBorsa();
		if(b.getnumeroAttrezzi()!=0) {
			if(b.hasAttrezzo(nomeAttrezzo)) {
				partita.getStanzaCorrente().addAttrezzo(b.getAttrezzo(nomeAttrezzo));
				b.removeAttrezzo(nomeAttrezzo);
				this.IOConsole.mostraMessaggio("Attrezzo posato con successo!");
			}
			else
				this.IOConsole.mostraMessaggio("Attrezzo non presente nella borsa!\n");
		}

		else
			this.IOConsole.mostraMessaggio("Non ci sono attrezzi in borsa!\n");
		this.IOConsole.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		this.IOConsole.mostraMessaggio(partita.getGiocatore().getDescrizione());
	}



}
