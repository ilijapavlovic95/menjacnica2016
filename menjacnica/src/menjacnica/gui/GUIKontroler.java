package menjacnica.gui;

import java.awt.EventQueue;
import java.io.File;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import menjacnica.Menjacnica;
import menjacnica.MenjacnicaInterface;
import menjacnica.Valuta;
import menjacnica.gui.models.MenjacnicaTableModel;

public class GUIKontroler {
	private static MenjacnicaGUI glavniProzor;
	private static MenjacnicaInterface sistem;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sistem = new Menjacnica();
					glavniProzor = new MenjacnicaGUI();
					glavniProzor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void ugasiAplikaciju() {
		int opcija = JOptionPane.showConfirmDialog(glavniProzor,
				"Da li ZAISTA zelite da izadjete iz apliacije", "Izlazak",
				JOptionPane.YES_NO_OPTION);

		if (opcija == JOptionPane.YES_OPTION)
			System.exit(0);
	}
	
	public static void prikaziAboutProzor(){
		JOptionPane.showMessageDialog(glavniProzor,
				"Autor: Bojan Tomic, Verzija 1.0", "O programu Menjacnica",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void sacuvajUFajl() {
		try {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(glavniProzor);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();

				sistem.sacuvajUFajl(file.getAbsolutePath());
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(glavniProzor, e1.getMessage(),
					"Greska", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void ucitajIzFajla() {
		try {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showOpenDialog(glavniProzor);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				sistem.ucitajIzFajla(file.getAbsolutePath());
				glavniProzor.prikaziSveValute();
			}	
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(glavniProzor, e1.getMessage(),
					"Greska", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static List<Valuta> vratiKursnuListu() {
		return sistem.vratiKursnuListu();
	}
	

	public static void prikaziDodajKursGUI() {
		DodajKursGUI prozor = new DodajKursGUI(glavniProzor);
		prozor.setLocationRelativeTo(glavniProzor);
		prozor.setVisible(true);
	}

	public static void prikaziObrisiKursGUI(Valuta izabranaValuta) {
		ObrisiKursGUI prozor = new ObrisiKursGUI(glavniProzor, izabranaValuta);
		prozor.setLocationRelativeTo(glavniProzor);
		prozor.setVisible(true);
	}
	
	public static void prikaziIzvrsiZamenuGUI(Valuta izabranaValuta) {
		IzvrsiZamenuGUI prozor = new IzvrsiZamenuGUI(glavniProzor, izabranaValuta);
		prozor.setLocationRelativeTo(glavniProzor);
		prozor.setVisible(true);
	}

	public static void dodajValutu(Valuta valuta) {
		sistem.dodajValutu(valuta);
	}

	public static double izvrsiTransakciju(Valuta valuta, boolean prodaja, double iznos) {
		return sistem.izvrsiTransakciju(valuta, prodaja, iznos);
	}

	public static void obrisiValutu(Valuta valuta) {
		sistem.obrisiValutu(valuta);
	}
}
