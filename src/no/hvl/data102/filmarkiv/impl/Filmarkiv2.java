package no.hvl.data102.filmarkiv.impl;

import java.util.List;
import java.util.ArrayList;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

/** En klasse for å skape et arkiv til å lagre et antall objekter Film i
 * @author Jonatan Dam, Hans Christian Gustafsson
 */
public class Filmarkiv2 implements FilmarkivADT {

    private int antall;
    private LinearNode<Film> start;

    
    public Filmarkiv2() {
        antall = 0;
        start = null;
    }

    /** Henter en film med gitt nr fra arkivet.
	 * @param nr Nummeret på filmen som skal hentes
	 * @return film med gitt nr. Om nr ikke finnes, returneres null.*/
    @Override
    public Film finnFilm(int nr) {
        LinearNode<Film> current = start;
        while (current != null) {
            if (current.data.getFilmNr() == nr) {
                return current.data;
            }
            current = current.neste;
        }
        return null;
    }

    /** Legger til en ny film.
	 * @param nyFilm Filmen som skal legges til */
    @Override
    public void leggTilFilm(Film nyFilm) {
        LinearNode<Film> newNode = new LinearNode<>(nyFilm);
        newNode.neste = start;
        start = newNode;
        antall++;
    }

    /** Sletter en film med gitt nr
	 * @param filmNr Nr på film som skal slettes
	 * @return true dersom filmen ble slettet, false ellers */
    @Override
    public boolean slettFilm(int filmNr) {
        if (start == null) {
            return false; // Kommer ingen vei om listen er tom
        }

        if (start.data.getFilmNr() == filmNr) {
            start = start.neste;
            antall--;
            return true;
        }

        LinearNode<Film> current = start;
        while (current.neste != null && current.neste.data.getFilmNr() != filmNr) {
            current = current.neste;
        }

        if (current.neste != null) {
            current.neste = current.neste.neste;
            antall--;
            return true;
        }

        return false;
    }
    
    /** Søker og henter Filmer med en gitt delstreng i tittelen
	 * @param delstreng som må være i tittel
	 * @return Film[] tabell med filmer som har delstreng i tittel */
    @Override
    public Film[] soekTittel(String delstreng) {
        LinearNode<Film> current = start;
        List<Film> result = new ArrayList<>();

        while (current != null) {
            String tittel = current.data.getFilmtittel().toUpperCase();
            if (tittel.contains(delstreng.toUpperCase())) {
                result.add(current.data);
            }
            current = current.neste;
        }

        return result.toArray(new Film[0]);
    }

    /** Søker og henter filmer med en gitt delstreng i filmprodusent
	 * @param delstreng
	 * @return Film[] tabell med filmer som har delstreng i filmprodusent */
    @Override
    public Film[] soekProdusent(String delstreng) {
        LinearNode<Film> current = start;
        List<Film> result = new ArrayList<>();

        while (current != null) {
            String produsent = current.data.getProdusent().toUpperCase();
            if (produsent.contains(delstreng.toUpperCase())) {
                result.add(current.data);
            }
            current = current.neste;
        }

        return result.toArray(new Film[0]);
    }
    
    /** Finner antall filmer med gitt sjanger
	 * @param sjanger
	 * @return antall filmer av gitt sjanger */
    @Override
    public int antall(Sjanger sjanger) {
        LinearNode<Film> current = start;
        int antallISjanger = 0;

        while (current != null) {
            if (current.data.getFilmSjanger() == sjanger) {
                antallISjanger++;
            }
            current = current.neste;
        }

        return antallISjanger;
    }
    
    /** Finner antall filmer i arkivet
	 * @return antall filmer i arkivet */
    @Override
    public int antall() {
        return antall;
    }

    // Klasse Linearnode 
    private static class LinearNode<T> {
        public T data;
        public LinearNode<T> neste;

        public LinearNode(T data) {
            this.data = data;
            this.neste = null;
        }
    }
}

