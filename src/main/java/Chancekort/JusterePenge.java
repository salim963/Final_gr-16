package chancekort;

public class JustererPenge extends Chancekort {

    private double pengeVaerdi; // Hvor mange penge man justerer med (negativ = man trækker penge fra spilleren)

    public double getPengeVaerdi(){
        return pengeVaerdi;
    }

    public JustererPenge( double pengeVaerdi, String beskrivelse ){
        super( beskrivelse, true );
        this.pengeVaerdi = pengeVaerdi;
    }

}
