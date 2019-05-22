package logica;

import java.util.Scanner;

public class Main {
	private static Magazzino m = new Magazzino();

	public static void stampaMenu() {
		System.out.println("");
		System.out.println("");
		System.out.println("*******************************");
		System.out.println("1. Aggiungi prodotti");
		System.out.println("2. Aggiungi un prodotto");
		System.out.println("3. Rimuovi prodotto");
		System.out.println("4. Cerca prodotto per marca");
		System.out.println("5. Cerca prodotto per anno");
		System.out.println("6. Cerca prodotto per modello");
		System.out.println("7. Stampa prodotti per prezzo crescente");
		System.out.println("8. Stampa prodotti per prezzo decrescente");
		System.out.println("9. Stampa tutti i prodotti");
		System.out.println("0. Esci");
		System.out.println("*******************************");
		System.out.println("");
		System.out.println("");
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i;
		do {
			stampaMenu();			
			i = scanner.nextInt();			
			switch (i) {
			case 1:
				aggiungiProdotti(scanner);
				break;

			case 2:
				aggiungiProdotto(scanner);
				break;

			case 3:
				rimuoviProdotto(scanner);
				break;

			case 4:
				cerca(scanner, "marca");
				break;

			case 5:
				cerca(scanner, "anno");
				break;

			case 6:
				cerca(scanner, "modello");
				break;

			case 7:
				ordinaEStampa(true);
				break;

			case 8:
				ordinaEStampa(false);
				break;

			case 9:
				stampa();
				break;
				
			case 0:
				System.out.println("Arrivederci!");
				break;

			default:
				System.err.println("Attenzione scelta non valida");
				stampaMenu();
			}
		} while (i != 0);
		scanner.close();
	}
   
	private static void aggiungiProdotti(Scanner scanner) {
		boolean continua = true;
		do {
			aggiungiProdotto(scanner);
			String res;
			do {
				System.out.println("Vuoi inserire un nuovo prodotto? (S/N)");
				res = scanner.next();
			} while (!res.equalsIgnoreCase("S") && !res.equalsIgnoreCase("N"));
			if (res.equalsIgnoreCase("N"))
				continua = false;			
		} while (continua);
	}
	
	private static void aggiungiProdotto(Scanner scanner) {
		Prodotto l = leggiProdotto(scanner);
		if(m.aggiungiProdotto(l))
			System.out.println("Prodotto inserito");
		else
			System.out.println("Prodotto già presente");
	}
	
	private static Prodotto leggiProdotto(Scanner scanner) {
		System.out.println("Inserisci il codice del prodotto");
		String codice = scanner.next();
		System.out.println("Inserisci il tipo del prodotto");
		String tipo = scanner.next();
		System.out.println("Inserisci la marca del prodotto");
		String marca = scanner.next();
		System.out.println("Inserisci il modello del prodotto");
		String modello = scanner.next();

		int annoDiProduzione;
		do {
			System.out.println("Inserisci l'anno del prodotto (compreso tra 2015 e 2019)");
			annoDiProduzione = scanner.nextInt();
		} while (annoDiProduzione < 2015 || annoDiProduzione > 2019);

		System.out.println("Inserisci il prezzo del prodotto");
		double prezzo = scanner.nextDouble();
		
		Prodotto n = new Prodotto(codice,tipo,marca,modello,annoDiProduzione,prezzo);
		 return n;
	}
	
	private static void rimuoviProdotto(Scanner scanner) {
		if(m.getSize() == 0)
			System.out.println("Attenzione! Elenco prodotti vuoto!");
		
		System.out.println("Inserisci il codice del prodotto");
		String scelta = scanner.next();
		if (m.rimuoviProdotto(scelta))
			System.out.println("Eliminazione riuscita");
		else
			System.out.println("Prodotto non trovato");
	}
	
	private static void cerca(Scanner scanner, String str) {
		System.out.println("Inserisci " + str);
		if (str.equals("marca")) {
			String scelta = scanner.next();
			m.stampaPerMarca(scelta);
		} else if (str.equals("modello")) {
			String scelta = scanner.next();
			m.stampaPerModello(scelta);
		} else if (str.equals("anno")) {
			int annoDiProduzione = scanner.nextInt();
			m.stampaPerAnnoDiProduzione(annoDiProduzione);
		}
	}
	
	private static void stampa() {
		m.stampa();
	}
	
	private static void ordinaEStampa(boolean b) {
		m.ordinaEStampaPerPrezzo(b);
	}

}
