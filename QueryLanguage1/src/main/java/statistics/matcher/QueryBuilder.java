/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author ossian
 */
public class QueryBuilder {
	
	private List<Matcher> matchers;
	
	public QueryBuilder() {
		matchers = new ArrayList<Matcher>();
	}
	
	public QueryBuilder playsIn(String team) {
		matchers.add(new PlaysIn(team));
		return this;
	}
	
	public QueryBuilder hasAtLeast(int value, String category) {
		matchers.add(new HasAtLeast(value, category));
		return this;
	}
	
	public QueryBuilder hasFewerThan(int value, String category) {
		matchers.add(new HasFewerThan(value, category));
		return this;
	}
	
	public QueryBuilder oneOf(Matcher... orMatchers) {
		matchers.add(new Or(orMatchers));
		return this;
	}
	
	public QueryBuilder not(Matcher matcher) {
		matchers.add(new Not(matcher));
		return this;
	}
	
	public Matcher build() {
		return new And(matchers.toArray(new Matcher[0]));
	}
}
