
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] taulu;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenMaara;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(KAPASITEETTI);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);
    }
    
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            kapasiteetti = KAPASITEETTI;
        }
        if (kasvatuskoko < 0) {
            kasvatuskoko = OLETUSKASVATUS;
        }
        taulu = new int[kapasiteetti];
        this.kasvatuskoko = kasvatuskoko;
    }
	
    public boolean lisaa(int luku) {
        if (!kuuluu(luku)) {
            lisaaLoppuun(luku);
            return true;
        }
        return false;
    }

	public void lisaa(int[] lukuja) {
		for(int luku : lukuja) {
			lisaa(luku);
		}
	}
	
    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenMaara; i++) {
            if (luku == taulu[i]) {
                return true;
            }
        }
		return false;
    }

    public boolean poista(int luku) {
        for (int i = 0; i < alkioidenMaara; i++) {
            if (luku == taulu[i]) {
                siirraAlkiotVasemmalle(i);
				return true;
            }
        }
        return false;
    }
	
	public void poista(int[] lukuja) {
		for(int luku : lukuja) {
			poista(luku);
		}
	}
	
	private void lisaaLoppuun(int luku) {
		taulu[alkioidenMaara] = luku;
        alkioidenMaara++;
		if (alkioidenMaara % taulu.length == 0) {
            kasvataTaulukkoa();
		}
	} 
	
	private void siirraAlkiotVasemmalle(int alku) {
		for(int i = alku; i < alkioidenMaara - 1; i++) {
			taulu[i] = taulu[i + 1];
		}
		taulu[alkioidenMaara] = 0;
		alkioidenMaara--;
	}

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }
    }
	
	private void kasvataTaulukkoa() {
		int[] uusiTaulukko = new int[taulu.length + kasvatuskoko];
		kopioiTaulukko(taulu, uusiTaulukko);
		taulu = uusiTaulukko;
	}

    public int mahtavuus() {
        return alkioidenMaara;
    }


    @Override
    public String toString() {
		String string = "{";
		for(int i = 0; i < alkioidenMaara; i++) {
			string += taulu[i];
			if(i != alkioidenMaara - 1) string += ", ";
		}
		string += "}";
		return string;
    }

    public int[] toIntArray() {
        int[] taulukko = new int[alkioidenMaara];
        for (int i = 0; i < taulukko.length; i++) {
            taulukko[i] = taulu[i];
        }
        return taulukko;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        x.lisaa(a.toIntArray());
		x.lisaa(b.toIntArray());
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        y.lisaa(a.toIntArray());
		for(int i : b.toIntArray()) {
			if(!a.kuuluu(i)) {
				y.poista(i);
			}
		}
        return y;
    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        z.lisaa(a.toIntArray());
		z.poista(b.toIntArray());
        return z;
    }
        
}