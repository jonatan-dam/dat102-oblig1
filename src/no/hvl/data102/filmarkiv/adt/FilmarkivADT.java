package no.hvl.data102.filmarkiv.adt;

import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

/** Et interface som beskriver operasjoner som skal gjøres på en samling med filmer
 * @author Jonatan Dam, Hans Christian Gustafsson
 */

public interface FilmarkivADT {

	/** Henter en film med gitt nr fra arkivet.
	 * @param nr Nummeret på filmen som skal hentes
	 * @return film med gitt nr. Om nr ikke finnes, returneres null.*/
	Film finnFilm(int nr);
	
	/** Legger til en ny film.
	 * @param nyFilm Filmen som skal legges til */
	void leggTilFilm(Film nyFilm);
	
	/** Sletter en film med gitt nr
	 * @param filmNr Nr på film som skal slettes
	 * @return true dersom filmen ble slettet, false ellers */
	boolean slettFilm(int filmNr);
	
	/** Søker og henter Filmer med en gitt delstreng i tittelen
	 * @param delstreng som må være i tittel
	 * @return Film[] tabell med filmer som har delstreng i tittel */
	Film[] soekTittel(String delstreng);
	
	/** Søker og henter filmer med en gitt delstreng i filmprodusent
	 * @param delstreng
	 * @return Film[] tabell med filmer som har delstreng i filmprodusent */
	Film[] soekProdusent(String delstreng);
	
	/** Finner antall filmer med gitt sjanger
	 * @param sjanger
	 * @return antall filmer av gitt sjanger */
	int antall(Sjanger sjanger);
	
	/** Finner antall filmer i arkivet
	 * @return antall filmer i arkivet */
	int antall();
}
