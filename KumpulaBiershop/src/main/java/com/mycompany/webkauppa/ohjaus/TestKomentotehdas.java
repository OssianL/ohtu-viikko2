/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webkauppa.ohjaus;

import com.mycompany.webkauppa.sovelluslogiikka.Ostoskori;

/**
 *
 * @author ossian
 */
public class TestKomentotehdas extends Tehdas{

	@Override
	public Komento ostoksenLisaysKoriin(Ostoskori ostoskori, long tuoteId) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Komento ostoksenPoistoKorista(Ostoskori ostoskori, long tuoteId) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Komento ostoksenSuoritus(String nimi, String osoite, String luottokorttinumero, Ostoskori kori) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}
