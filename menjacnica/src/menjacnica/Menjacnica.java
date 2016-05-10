package menjacnica;

import java.util.LinkedList;

import menjacnica.sistemskeoperacije.*;

public class Menjacnica implements MenjacnicaInterface{
	
	private LinkedList<Valuta> kursnaLista = new LinkedList<Valuta>();

	@Override
	public void dodajValutu(Valuta valuta) {
		SODodajValutu.izvrsi(kursnaLista, valuta);
	}

	@Override
	public void obrisiValutu(Valuta valuta) {
		SOObrisiValutu.izvrsi(kursnaLista, valuta);
	}

	@Override
	public double izvrsiTransakciju(Valuta valuta, boolean prodaja, double iznos) {
		return SOIzvrsiTransakciju.izvrsi(kursnaLista, valuta, prodaja, iznos);
	}

	@Override
	public LinkedList<Valuta> vratiKursnuListu() {
		return kursnaLista;
	}

	@Override
	public void ucitajIzFajla(String putanja) {
		SOUcitajIzFajla.izvrsi(kursnaLista, putanja);
	}

	@Override
	public void sacuvajUFajl(String putanja) {
		SOSacuvajUFajl.izvrsi(kursnaLista, putanja);
	}

	
}
