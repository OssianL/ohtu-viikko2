
package com.mycompany.ohmawebkauppa.sovelluslogiikka.ohjaus;

import com.mycompany.webkauppa.ohjaus.Komento;
import com.mycompany.webkauppa.ohjaus.Komentotehdas;
import com.mycompany.webkauppa.ohjaus.OstoksenSuoritus;
import com.mycompany.webkauppa.sovelluslogiikka.*;
import com.mycompany.webkauppa.ulkoiset_rajapinnat.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class OstoksenSuoritusTest {
    PankkiFasaadi pankki = PankkiFasaadi.getInstance();
    PankkiFasaadi hylkaavaPankki = teeHylkaavaPankki();
    ToimitusjarjestelmaFasaadi toimitusJarjestelma = ToimitusjarjestelmaFasaadi.getInstance();
    Varasto varasto = Varasto.getInstance();
    
    long tuoteId1;
    long tuoteId2;
    Tuote tuote1;
    Tuote tuote2;
    Ostoskori kori;
    String nimi;
    String osoite;
    String luottokortti;

    Komento ostoksenSuoritus;
	Komentotehdas komennot;
    
    @Before
    public void setUp() {
        nimi = "Arto Vihavainen";
        osoite = "Herttoniemenranta 10 Helsinki";
        luottokortti = "12345";
        
        tuoteId1 = 1;
        tuote1 = varasto.etsiTuote(tuoteId1);
        tuoteId2 = 2;
        tuote2 = varasto.etsiTuote(tuoteId2);
        
        kori = new Ostoskori();
        kori.lisaaTuote(tuote1);        
        kori.lisaaTuote(tuote2);
		
		komennot = new Komentotehdas();
    }
    
    @Test
    public void josMaksuOnnistuuKoriTyhjenee() {
        ostoksenSuoritus = komennot.ostoksenSuoritus(nimi, osoite, luottokortti, kori);
        ostoksenSuoritus.suorita();

        assertEquals(0, kori.ostokset().size());
        assertEquals(0, kori.hinta()); 
        assertEquals(0, kori.tuotteitaKorissa());         
    }
    
    @Test
    public void josMaksuOnnistuuPankinRajapintaaKaytetty() {
        ostoksenSuoritus = komennot.ostoksenSuoritus(nimi, osoite, luottokortti, kori);
        ostoksenSuoritus.suorita();       
    }   

    @Test
    public void josMaksuOnnistuuToiRajmituksenapintaaKaytetty() {
        ostoksenSuoritus = komennot.ostoksenSuoritus(nimi, osoite, luottokortti, kori);
        ostoksenSuoritus.suorita();       
    }             

    // - tyhjä kori, nimi tai osoite -> ei kutsuta pankkia, ei toimitusta
     
    @Test
    public void josPankkiEiHyvaksyMaksuaPalautetaanFalseToimitustaEiTehda() {        
        OstoksenSuoritus suoritus = (OstoksenSuoritus) komennot.ostoksenSuoritus(nimi, osoite, luottokortti, kori);
        suoritus.setPankki(hylkaavaPankki);
 
        
        assertFalse( suoritus.suorita() );
        
        // assertSomething
    } 
    
    // epäonnistuessa kori säilyy ennallaan
    
    private PankkiFasaadi teeHylkaavaPankki() {
        return new PankkiFasaadi(){

            @Override
            public boolean maksa(String nimi, String luottokortti, int hinta) {
                return false;
            }
                        
        };
    }
}
