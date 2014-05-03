/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import statistics.Player;

/**
 *
 * @author ossian
 */
public class HasFewerThan extends HasAtLeast {
	
	public HasFewerThan(int value, String category) {
		super(value, category);
	}
	
	@Override
	public boolean matches(Player p) {
		return !super.matches(p);
	}
}
