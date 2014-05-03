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
public class Not implements Matcher{

	private Matcher matcher;
	
	public Not(Matcher matcher) {
		this.matcher = matcher;
	}
	
	@Override
	public boolean matches(Player p) {
		return !matcher.matches(p);
	}
	
}
