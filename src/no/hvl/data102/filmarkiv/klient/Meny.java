package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Meny {

	private Tekstgrensesnitt tekstgr;
	private FilmarkivADT filmarkiv;
	
	public Meny(FilmarkivADT filmarkiv) {
		tekstgr = new Tekstgrensesnitt();
		this.filmarkiv = filmarkiv;
	}
	
	public void start() {
		Film førsteFilm = new Film(1, "Haisommer", 1987, Sjanger.THRILLER, "David Brown", "Universal Pictures");
		Film andreFilm = new Film(2, "The Dark Knight", 2008, Sjanger.ACTION, "Emma Thomas", "Warner Bros. Pictures");
		Film tredjeFilm = new Film(3, "Scarface", 1983, Sjanger.THRILLER, "Martin Bregman", "Universal Pictures");
		Film fjerdeFilm = new Film(4, "The Shawshank Redemption", 1994, Sjanger.DRAMA, "Niki Marvin", "Castle Rock Entertainment");
		Film femteFilm = new Film(5, "The Godfather", 1972, Sjanger.KRIM, "Albert S. Ruddy", "Paramount Pictures");
		Film sjetteFilm = new Film(6, "12 Angry Men", 1957, Sjanger.DRAMA, "Henry Fonda", "United Artists");
		Film syvendeFilm = new Film(7, "The Godfather Part 2", 1974, Sjanger.KRIM, "Francis Ford Coppola", "Paramount Pictures");
		Film aattendeFilm = new Film(8, "Schindler's list", 1993, Sjanger.THRILLER, "Steven Spielberg", "Universal Pictures");
		Film niendeFilm = new Film(9, "The Lord of the Rings: The Return of the King", 2003, Sjanger.FANTASY, "Peter Jackson", "Warner Bros. Pictures");
		Film tiendeFilm = new Film(10, "Pulp Fiction", 1994, Sjanger.KRIM, "Lawrence Bender", "Miramax Films");
		Film ellevteFilm = new Film(11, "The Lord of the Rings: The Fellowship of the Ring", 2001, Sjanger.FANTASY, "Peter Jackson", "New Line Cinema");
		Film tolvteFilm = new Film(12, "The Good, the Bad and the Ugly", 1966, Sjanger.WESTERN, "Alberto Grimaldi", "Produzioni Europee");
		Film trettendeFilm = new Film(13, "Forrest Gump", 1983, Sjanger.DIVERSE, "Wendy Finerman", "Paramount Pictures");
		Film fjortendeFilm = new Film(14, "Fight Club", 1999, Sjanger.DIVERSE, "Art Linson", "20th Century Fox");
		Film femtendeFilm = new Film(15, "The Lord of the Rings: The Two Towers", 2002, Sjanger.FANTASY, "Peter Jackson", "New Line Cinema");
		Film sekstendeFilm = new Film(16, "Inception", 2010, Sjanger.SCIFI, "Christopher Nolan", "Warner Bros. Pictures");
		Film syttendeFilm = new Film(17, "Star Wars Episode V: The Empire Strikes Back", 1980, Sjanger.DIVERSE, "Gary Kurtz", "20th Century Fox");
		Film attendeFilm = new Film(18, "The Matrix", 1999, Sjanger.SCIFI, "Joel Silver", "Warner Bros. Pictures");
		Film nittendeFilm = new Film(19, "Scarface", 1983, Sjanger.THRILLER, "Martin Bregman", "Universal Pictures");
		Film tyvendeFilm = new Film(20, "Scarface", 1983, Sjanger.THRILLER, "Martin Bregman", "Universal Pictures");
		
	}
}
