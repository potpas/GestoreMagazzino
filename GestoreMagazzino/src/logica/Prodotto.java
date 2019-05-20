
package logica;

public class Prodotto {
       private double prezzo;
       private String marca;
       private String codice;
       private String modello;
       private int AnnoDiProduzione;
       private String tipo;
       
	public Prodotto(double prezzo, String marca, String codice, String modello, int annoDiProduzione, String tipo) {
		super();
		this.prezzo = prezzo;
		this.marca = marca;
		this.codice = codice;
		this.modello = modello;
		this.AnnoDiProduzione = annoDiProduzione;
		this.tipo = tipo;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public int getAnnoDiProduzione() {
		return AnnoDiProduzione;
	}

	public void setAnnoDiProduzione(int annoDiProduzione) {
		AnnoDiProduzione = annoDiProduzione;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	public void stampa() {
		System.out.println( "Prodotto: " + codice + "," + tipo + "," + marca + "," + modello + "," + AnnoDiProduzione + "," + prezzo );
	}       
}
