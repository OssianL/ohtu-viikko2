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
public class Nollaa extends Laskuoperaatio{
	
	public Nollaa(Sovelluslogiikka sovellus, JTextField tuloskenttä, JTextField syötekenttä) {
		super(sovellus, tuloskenttä, syötekenttä);
	}
	
	@Override
	protected int laske(int a, int b) {
		return 0;
	}
}
