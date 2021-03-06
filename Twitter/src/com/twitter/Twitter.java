package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;

/**
 * 	Klasa Twitter
 * @author Valentina Andjelkovic
 *
 */
public class Twitter {
	/**
	 * Predstavlja listu Objekata klase TwitterPoruka
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();

	/**
	 * Vraca listu poruke
	 * @return poruke
	 * 
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke() {
		
		return poruke;
	}
	
	/**
	 * Kreira objekat klase TwitterPoruka i ubacuje na kraj liste 
	 * @param korisnik
	 * 		Username korisnika
	 * @param poruka
	 * 		Twitt poruka
	 */
	public void unesi(String korisnik, String poruka) {
		if(korisnik==null || poruka==null || korisnik.isEmpty() || poruka.length()>140){
			throw new RuntimeException("Greska prilikom unosa");
		}
		// Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);

		// Poruka se unosi u listu na kraj

		poruke.addLast(tp);
	}

	/**
	 * Pronalazi sve poruke koje sadrze prosledjeni tag
	 * @param maxBroj
	 * 		Maksimalni broj poruka koji je moguce pronaci
	 * @param tag
	 * 		Hash tag na osnovu kog se traze poruke
	 * @return TwitterPoruka[] 
	 * 		Niz poruka sa odgovarajucim tagom 
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag == null || tag == "")
			throw new RuntimeException("Morate uneti tag");
		// Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj <= 0)
			maxBroj = 100;
		// Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		// Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		// sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];

		// Pretrazuju se poruke i traze se one koje sadrze tag.
		// Ako se nadje neka takva, i ako nije prekoracen maxBroj
		// ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		// se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag) != -1)
				if (brojac < maxBroj) {
					rezultat[brojac] = poruke.get(i);
					brojac++;
				} else
					break;
		return rezultat;
	}

}
