package it.uniroma3.diadia.giocatore;

public class Giocatore {
	
	static final private int CFU_INIZIALI = 20;
	private int cfu=CFU_INIZIALI;
	private Borsa borsa;
	
	public Giocatore() {
		this.borsa=new Borsa();
		this.cfu=CFU_INIZIALI;
	}
	
	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
	public Borsa getBorsa() {
		return this.borsa;
	}
	
	public String getDescrizione() {
		return this.borsa.toString()+"\n("+this.cfu+" cfu)\n";
	}
}
