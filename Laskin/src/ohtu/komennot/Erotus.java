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
public class Erotus extends Laskuoperaatio {
	
	public Erotus(Sovelluslogiikka sovellus, JTextField tuloskenttä, JTextField syötekenttä) {
		super(sovellus, tuloskenttä, syötekenttä);
	}
	
	@Override
	protected int laske(int a, int b) {
		return a - b;
	}
}
