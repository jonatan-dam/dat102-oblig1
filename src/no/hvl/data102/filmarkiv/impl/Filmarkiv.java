package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

/** En klasse for å skape et arkiv til å lagre et antall objekter Film i
 * @author Jonatan Dam, Hans Christian Gustafsson
 */
public class Filmarkiv implements FilmarkivADT {

	private Film[] arkiv;
	private int antall;
	
	
	/** Konstruktør som skaper et tomt arkiv med den gitte kapasiteten
	 * @param kapasitet */
	public Filmarkiv(int kapasitet) {
		arkiv = new Film[kapasitet];
		antall = 0;
	} //end konstruktør
	
	
	
	public Film[] getArkiv() {
		return arkiv;
	}



	public void setArkiv(Film[] arkiv) {
		this.arkiv = arkiv;
	}



	public int getAntall() {
		return antall;
	}



	public void setAntall(int antall) {
		this.antall = antall;
	}



	/** Henter en film med gitt nr fra arkivet.
	 * @param nr Nummeret på filmen som skal hentes
	 * @return film med gitt nr. Om nr ikke finnes, returneres null.*/
	@Override
	public Film finnFilm(int nr) {
		for(int i = 0; i < antall; i++) {
			if(nr == arkiv[i].getFilmNr()){
				return arkiv[i];
			}
		}
		
		return null;
	} //end finnFilm

	
	/** Legger til en ny film.
	 * @param nyFilm Filmen som skal legges til */
	@Override
	public void leggTilFilm(Film nyFilm) {
		arkiv[antall] = nyFilm;
		antall++;
	} //end leggTilFilm

	
	/** Sletter en film med gitt nr
	 * @param filmNr Nr på film som skal slettes
	 * @return true dersom filmen ble slettet, false ellers */
	@Override
	public boolean slettFilm(int filmNr) {
		for(int i = 0; i < antall; i++) {
			if(filmNr == arkiv[i].getFilmNr()){
				arkiv[i] = arkiv[antall]; // Flytter den siste filmen i arkivet til arkiv[i], for å overta plassen til film med filmNr
				arkiv[antall] = null; // Setter den siste filmen i arkivet lik null, da vi har laget et duplikat i arkiv[i]
				antall--; // Reduserer antall med 1
				return true;
			}
		}
		return false;
	} //end slettFilm

	
	/** Søker og henter Filmer med en gitt delstreng i tittelen
	 * @param delstreng som må være i tittel
	 * @return Film[] tabell med filmer som har delstreng i tittel */
	@Override
	public Film[] soekTittel(String delstreng) {
		Film[] søkeResultat = new Film[antall];
		int antallResultat = 0;
		for(int i = 0; i < antall; i++) {
			String tittel = arkiv[i].getFilmtittel().toUpperCase();
			if(tittel.contains(delstreng.toUpperCase())) {
				søkeResultat[antallResultat] = arkiv[i];
				antallResultat++;
			}
		}
		
		søkeResultat = trimTab(søkeResultat, antallResultat);	
		return søkeResultat;
	} //end soekTittel

	
	/** Søker og henter filmer med en gitt delstreng i filmprodusent
	 * @param delstreng
	 * @return Film[] tabell med filmer som har delstreng i filmprodusent */
	@Override
	public Film[] soekProdusent(String delstreng) {
		Film[] søkeResultat = new Film[antall];
		int antallResultat = 0;
		for(int i = 0; i < antall; i++) {
			String produsent = arkiv[i].getProdusent().toUpperCase();
			if(produsent.contains(delstreng.toUpperCase())) {
				søkeResultat[antallResultat] = arkiv[i];
				antallResultat++;
			}
		}
		
		søkeResultat = trimTab(søkeResultat, antallResultat);	
		return søkeResultat;
	} //end soekProdusent

	
	/** Finner antall filmer med gitt sjanger
	 * @param sjanger
	 * @return antall filmer av gitt sjanger */
	@Override
	public int antall(Sjanger sjanger) {
		// TODO Auto-generated method stub
		int antallISjanger = 0;
		for(int i = 0; i < antall; i++) {
			if(arkiv[i].getFilmSjanger() == sjanger) {
				antallISjanger++;
			}
		}
		
		return antallISjanger;
	} //end antall

	
	/** Finner antall filmer i arkivet
	 * @return antall filmer i arkivet */
	@Override
	public int antall() {
		
		return antall;
	} //end antall
	
	
	/** Skaper en ny, utvidet tabell og kopierer over den gamle tabellen.
	 * @param fullTab den fulle tabellen
	 * @return Film[] den nye, utvidet tabellen */
	private Film[] utvid(Film[] fullTab) {
		Film[] nyTab = new Film[fullTab.length*2];
		
		for(int i = 0; i < antall; i++) {
			nyTab[i] = fullTab[i];
		}
		return nyTab;
	} //end utvid
	
	
	/** Trimmer en tabell slik at vi alltid har en full tabell av referanser til objekter.
	 * @param tab Tabellen som skal trimmes
	 * @param n int antall elementer
	 * @return En ny, kopiert og trimmet tabell som er full. */
	private Film[] trimTab(Film[] tab, int n) {
		//n er antall elementer
		Film[] nyTab = new Film[n];
		int i = 0;
		while (i < n) {
			nyTab[i] = tab[i];
			i++;
		}
		return nyTab;
	} //end trimTab

}
