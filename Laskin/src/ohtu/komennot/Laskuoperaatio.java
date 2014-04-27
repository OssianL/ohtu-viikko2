/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.komennot;

import javax.swing.JTextField;
import ohtu.Sovelluslogiikka;

/**
 *
 * @author ossian
 */
public abstract class Laskuoperaatio implements Komento{
	
	private Sovelluslogiikka sovellus;
	private JTextField tuloskenttä;
	private JTextField syötekenttä;
	protected int edellinenArvo;
	
	public Laskuoperaatio(Sovelluslogiikka sovellus, JTextField tuloskenttä, JTextField syötekenttä) {
		this.sovellus = sovellus;
		this.tuloskenttä = tuloskenttä;
		this.syötekenttä = syötekenttä;
	}
	
	@Override
	public void suorita() {
		edellinenArvo = sovellus.tulos();
		int arvo = 0;
        try {
            arvo = Integer.parseInt(syötekenttä.getText());
        } catch (Exception e) {
        }
		int tulos = laske(sovellus.tulos(), arvo); 
		sovellus.setTulos(tulos);
		
		päivitäKentät();
	}
	
	@Override
	public void peru() {
		sovellus.setTulos(edellinenArvo);
		päivitäKentät();
	}
	
	private void päivitäKentät() {
		syötekenttä.setText("");
        tuloskenttä.setText("" + sovellus.tulos());
	}
	
	protected abstract int laske(int a, int b);
}
