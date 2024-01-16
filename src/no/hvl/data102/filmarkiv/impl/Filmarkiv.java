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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return false;
	} //end slettFilm

	
	/** Søker og henter Filmer med en gitt delstreng i tittelen
	 * @param delstreng som må være i tittel
	 * @return Film[] tabell med filmer som har delstreng i tittel */
	@Override
	public Film[] soekTittel(String delstreng) {
		// TODO Auto-generated method stub
		return null;
	} //end soekTittel

	
	/** Søker og henter filmer med en gitt delstreng i filmprodusent
	 * @param delstreng
	 * @return Film[] tabell med filmer som har delstreng i filmprodusent */
	@Override
	public Film[] soekProdusent(String delstreng) {
		// TODO Auto-generated method stub
		return null;
	} //end soekProdusent

	
	/** Finner antall filmer med gitt sjanger
	 * @param sjanger
	 * @return antall filmer av gitt sjanger */
	@Override
	public int antall(Sjanger sjanger) {
		// TODO Auto-generated method stub
		return 0;
	} //end antall

	
	/** Finner antall filmer i arkivet
	 * @return antall filmer i arkivet */
	@Override
	public int antall() {
		// TODO Auto-generated method stub
		return 0;
	} //end antall
	
	
	/** Skaper en ny, utvidet tabell slik at arkivet kan lagre flere filmer
	 * @param fullTab den fulle tabellen
	 * @return Film[] den nye, utvidet tabellen */
	private Film[] utvid(Film[] fullTab) {
		Film[] nyTab = new Film[fullTab.length*2];
		return nyTab;
	} //end utvid

}
