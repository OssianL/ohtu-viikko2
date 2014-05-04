/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webkauppa.ohjaus;

import com.mycompany.webkauppa.sovelluslogiikka.Ostoskori;
import com.mycompany.webkauppa.sovelluslogiikka.Varasto;
import com.mycompany.webkauppa.ulkoiset_rajapinnat.PankkiFasaadi;
import com.mycompany.webkauppa.ulkoiset_rajapinnat.ToimitusjarjestelmaFasaadi;

/**
 *
 * @author ossian
 */
public class Komentotehdas extends Tehdas{
	
	public Komento ostoksenLisaysKoriin(Ostoskori ostoskori, long tuoteId) {
		return new OstoksenLisaysKoriin(ostoskori, Varasto.getInstance(), tuoteId);
	}
	
	public Komento ostoksenPoistoKorista(Ostoskori ostoskori, long tuoteId) {
		return new OstoksenPoistoKorista(ostoskori, Varasto.getInstance(), tuoteId);
	}
	
	public Komento ostoksenSuoritus(String nimi, String osoite, String luottokorttinumero, Ostoskori kori) {
		return new OstoksenSuoritus(nimi, osoite, luottokorttinumero, kori, Varasto.getInstance(), PankkiFasaadi.getInstance(), ToimitusjarjestelmaFasaadi.getInstance());
	}
}
