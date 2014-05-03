package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
        
		/*
        Matcher m = new And( new HasAtLeast(10, "goals"),
                             new Not(new HasFewerThan(20, "assists")),
                             new PlaysIn("PHI")
        );*/
		
		QueryBuilder query = new QueryBuilder();
		Matcher m = query.hasAtLeast(10, "assists").hasFewerThan(20, "goals").build();
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
    }
}
