package logica;

import java.util.ArrayList;

	public class Magazzino {
		 
		 private ArrayList<Prodotto> prodotti;
		 private int size;
		 
		public Magazzino() {
			super();
			prodotti = new ArrayList<Prodotto>();
			size=0;
		}

		public ArrayList<Prodotto> getProdotti() {
			return prodotti;
		}

		public void setProdotti(ArrayList<Prodotto> prodotti) {
			this.prodotti = prodotti;
		}

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size; 
		}
		
		public boolean esisteProdotto(String codice) {
			 for(Prodotto i : prodotti) {
				 if(i.getCodice().equalsIgnoreCase(codice)) {
					 System.out.println("codice uguale");
					 return true;
				 }
			 }
			 
			 return false;
		}

		public boolean aggiungiProdotto(Prodotto p) {
			if (esisteProdotto(p.getCodice()))
				return false;
			
		  prodotti.add(p);
		  return true;
		}
		
		public boolean rimuoviProdotto(String codice) {
			if(esisteProdotto(codice)) {
				
			
			for(Prodotto i : prodotti) {
				if(i.getCodice().equalsIgnoreCase(codice)) {
					prodotti.remove(i);
					return true;
				}
			  }
			}
			return false;
		}
		
		
		public void stampaPerMarca(String MARCA) {
			System.out.println("Elenco prodotti della marca: " + MARCA);
			int n = 0;
			for(Prodotto i : prodotti)
				if(i.getMarca().equals(MARCA)) {
					i.stampa();
					n++;
				}
			if(n == 0)
				System.out.println("Non sono presenti prodotti della marca: " + MARCA);
		}
		
		public void stampaPerModello(String MODELLO) {
			System.out.println("Elenco prodotti del modello: " + MODELLO);
			int n = 0;
			for(Prodotto i : prodotti)
				if(i.getModello().equals(MODELLO)) {
					i.stampa();			
					n++;
				}
			if(n == 0)
				System.out.println("Non sono presenti prodotti del modello: " + MODELLO);
		}
		
		public void stampaPerAnnoDiProduzione(int ANNODIPRODUZIONE) {
			System.out.println("Elenco prodotti dell'anno " + ANNODIPRODUZIONE);
			int n = 0;
			for(Prodotto i : prodotti)
				if(i.getAnnoDiProduzione() == ANNODIPRODUZIONE) {
					i.stampa();
					n++;
				}
			if(n == 0)
				System.out.println("Non sono presenti prodotti dell'anno " + ANNODIPRODUZIONE);
		}
		
		public void ordinaEStampaPerPrezzo(boolean crescente) {
			System.out.println("Elenco prodotti stampati in ordine di prezzo");
			
			Prodotto[] tmp = new Prodotto[prodotti.size()];
			for(int i=0; i < prodotti.size(); i++) {
				tmp[i] = prodotti.get(i);
			}			
			
			Prodotto p = new Prodotto();
			for (int i = 0; i < tmp.length; i++) {
				boolean scambio = false;
				for (int j = 0; j < tmp.length - 1; j++) {
					if ((crescente && tmp[j].getPrezzo() > tmp[j + 1].getPrezzo())
							|| (!crescente && tmp[j].getPrezzo() < tmp[j + 1].getPrezzo())) {
						p = tmp[j];
						tmp[j] = tmp[j + 1];
						tmp[j + 1] = p;
						scambio = true;
					}
				}

				if (!scambio)
					break;
			}
			
			for (int i = 0; i < tmp.length; i++) {
				tmp[i].stampa();
			}
		}
		
		
		
		
		public void stampa() {
			
			if(prodotti.size() == 0)
				System.out.println("Elenco prodotti vuoto");
			else {
				
			System.out.println("Elenco prodotti");
			
			for(Prodotto i : prodotti)
				i.stampa();
	      }	
		}
	}
