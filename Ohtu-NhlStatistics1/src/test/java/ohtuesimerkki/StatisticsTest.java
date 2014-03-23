package ohtuesimerkki;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ossian
 */
public class StatisticsTest {
    
    Statistics stats;
    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };
    
    public StatisticsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void searchReturnsRightPlayer() {
        Player player = stats.search("Kurri");
        
        assertNotNull(player);
        assertEquals(player.getName(), "Kurri");
    }
    
    @Test
    public void searchReturnsNullIfNotFound() {
        Player player = stats.search("nullipulli");
        
        assertNull(player);
    }
    
    @Test
    public void teamReturnsRightTeam() {
        List<Player> team = stats.team("EDM");
        
        assertEquals(team.size(), 3);
    }
    
    @Test
    public void teamReturnsEmptyListIfDoesntExist() {
        List<Player> notTeam = stats.team("asdf");
        
        assertNotNull(notTeam);
        assertEquals(notTeam.size(), 0);
    }
    
    @Test
    public void topScorersWithNegativeParameter() {
        List<Player> scorers = stats.topScorers(-5);
        
        assertNotNull(scorers);
        assertEquals(scorers.size(), 0);
    }
    
    @Test
    public void topScorersWithSmallParameter() {
        List<Player> scorers = stats.topScorers(3);
        
        assertNotNull(scorers);
        assertEquals(scorers.size(), 3);
        assertEquals(scorers.get(0).getName(), "Gretzky");
        assertEquals(scorers.get(1).getName(), "Lemieux");
        assertEquals(scorers.get(2).getName(), "Yzerman");
    }
}
