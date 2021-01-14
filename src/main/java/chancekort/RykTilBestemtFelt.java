package chancekort;


public class RykTilBestemtFelt extends Chancekort {

    private int feltNummer; // Feltets placering paa braettet

    public int getFeltNummer() {
        return feltNummer;
    }

    public RykTilBestemtFelt(int feltNummer, String beskrivelse ){
        super( beskrivelse, true );
        this.feltNummer = feltNummer;
    }

}

