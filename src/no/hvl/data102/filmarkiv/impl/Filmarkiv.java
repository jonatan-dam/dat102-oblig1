package no.hvl.data102.filmarkiv.impl;

import java.util.Arrays;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

/** En klasse for å skape et arkiv til å lagre et antall objekter Film i
 * @author Jonatan Dam, Hans Christian Gustafsson
 */
public class Filmarkiv implements FilmarkivADT {

	private Film[] arkiv;
	private int antall;
	private static final int DEFAULT_KAPASITET = 25;
	private boolean initialized = false;
	private static final int MAKS_KAPASITET= 10000;
	
	
	/** Konstruktør som skaper et tomt arkiv med den gitte kapasiteten, såfremt at kapasiteten ikke overskrider maks kapasitet.
	 * @param kapasitet */
	public Filmarkiv(int kapasitet) {
		
		sjekkKapasitet(kapasitet); // Lar ikke arkivet opprettes dersom ønsket kapasitet er større enn tillatt maks kapasitet
		arkiv = new Film[kapasitet];
		antall = 0;
		initialized = true; //Bekrefter at objektet har blitt opprettet.
		
	} //end konstruktør
	
	
	/** Default konstruktør */
	public Filmarkiv() {
		this(DEFAULT_KAPASITET);
	} //end default konstruktør
	
	
	
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
		sjekkInitialisering(); // Lar ikke metoden kjøre på arkiv som ikke er opprettet på skikkelig måte
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
		sjekkInitialisering(); // Lar ikke metoden kjøre på arkiv som ikke er opprettet på skikkelig måte
		arkiv[antall] = nyFilm;
		antall++;
		
	} //end leggTilFilm

	
	/** Sletter en film med gitt nr
	 * @param filmNr Nr på film som skal slettes
	 * @return true dersom filmen ble slettet, false ellers */
	@Override
	public boolean slettFilm(int filmNr) {
		sjekkInitialisering(); // Lar ikke metoden kjøre på arkiv som ikke er opprettet på skikkelig måte
		for(int i = 0; i < antall; i++) {
			if(filmNr == arkiv[i].getFilmNr()){
				arkiv[i] = arkiv[antall-1]; // Flytter den siste filmen i arkivet til arkiv[i], for å overta plassen til film med filmNr
				arkiv[antall-1] = null; // Setter den siste filmen i arkivet lik null, da vi har laget et duplikat i arkiv[i]
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
		sjekkInitialisering(); // Lar ikke metoden kjøre på arkiv som ikke er opprettet på skikkelig måte
		
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
		
		sjekkInitialisering(); // Lar ikke metoden kjøre på arkiv som ikke er opprettet på skikkelig måte
		
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
		sjekkInitialisering(); // Lar ikke metoden kjøre på arkiv som ikke er opprettet på skikkelig måte
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
		sjekkInitialisering(); // Lar ikke metoden kjøre på arkiv som ikke er opprettet på skikkelig måte
		return antall;
	} //end antall
	
	
	/** Skaper en ny, utvidet tabell og kopierer over den gamle tabellen.
	 * @param fullTab den fulle tabellen
	 * @return Film[] den nye, utvidet tabellen */
	private Film[] utvid(Film[] fullTab) {
		
		sjekkInitialisering(); // Lar ikke metoden kjøre på arkiv som ikke er opprettet på skikkelig måte
		int nyLengde = fullTab.length*2;
		sjekkKapasitet(nyLengde); // Lar ikke metoden kjøre på arkiv dersom ønsket ny lengde er større enn tillatt makslengde
		fullTab = Arrays.copyOf(fullTab, nyLengde);
		
		return fullTab;
	} //end utvid
	
	
	/** Trimmer en tabell slik at vi alltid har en full tabell av referanser til objekter.
	 * @param tab Tabellen som skal trimmes
	 * @param n int antall elementer
	 * @return En ny, kopiert og trimmet tabell som er full. */
	private Film[] trimTab(Film[] tab, int n) {
		sjekkInitialisering(); // Lar ikke metoden kjøre på arkiv som ikke er opprettet på skikkelig måte
		//n er antall elementer
		Film[] nyTab = new Film[n];
		int i = 0;
		while (i < n) {
			nyTab[i] = tab[i];
			i++;
		}
		return nyTab;
	} //end trimTab
	
	/** Kaster et SecurityException om objektet ikke er intialisert skikkelig */
	private void sjekkInitialisering() {
		if(!initialized) {
			throw new SecurityException("Filmarkiv objektet er ikke initialisert skikkelig");
		}
	} //end sjekkInitialisering
	
	/** Sjekker om ønsket kapasitet er større enn tillatt maks kapasitet
	 * @param kapasitet */
	private void sjekkKapasitet(int kapasitet) {
		if(kapasitet > MAKS_KAPASITET) {
			throw new IllegalStateException("Forsøkte å utvide arkivet til et arkiv som er større enn tillatt maks kapasitet");
		}
	} //end sjekkKapasitet

}
