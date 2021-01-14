package chancekort;

// Denne klasse er hvorfra al nedarvning til de andre klasser stammer fra.

public abstract class Chancekort {

    private final String beskrivelse;             // Beskrivelsen der bruges, når man bruger / trækker kortet
    private String kortBeskrivelse = "";    // Kortbeskrivelser fra ChancekortGenerator
    private final boolean direkteAktion;          // True: Kortet bruges når det trækkes, False: kortet tages op på hånden



    public Chancekort( String beskrivelse, boolean direkteAktion ){
        this.beskrivelse = beskrivelse;
        this.direkteAktion = direkteAktion;
    }



    public boolean erDirekteAktion(){
        return direkteAktion;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setKortBeskrivelse(String kortBeskrivelse){
        this.kortBeskrivelse = kortBeskrivelse;
    }

    public String getKortBeskrivelse(){return kortBeskrivelse;}

}

