
package Model;

public class Rezervacija {
    private int IDRezervacije, IDKlijenta, IDSobe, OstvareniPoeni;
    private String datumPocetka, datumKraja;
    private boolean ugovoreno;

    public Rezervacija() {
    }

    public Rezervacija(int IDRezervacije, int IDKlijenta, int IDSobe, int OstvareniPoeni, String datumPocetka, String datumKraja, boolean ugovoreno) {
        this.IDRezervacije = IDRezervacije;
        this.IDKlijenta = IDKlijenta;
        this.IDSobe = IDSobe;
        this.OstvareniPoeni = OstvareniPoeni;
        this.datumPocetka = datumPocetka;
        this.datumKraja = datumKraja;
        this.ugovoreno = ugovoreno;
    }
    
    

    public Rezervacija(int IDKlijenta, int IDSobe, int OstvareniPoeni, String datumPocetka, String datumKraja, boolean ugovoreno) {
        this.IDKlijenta = IDKlijenta;
        this.IDSobe = IDSobe;
        this.OstvareniPoeni = OstvareniPoeni;
        this.datumPocetka = datumPocetka;
        this.datumKraja = datumKraja;
        this.ugovoreno = ugovoreno;
    }


    public int getIDRezervacije() {
        return IDRezervacije;
    }

    public void setIDRezervacije(int IDRezervacije) {
        this.IDRezervacije = IDRezervacije;
    }

    public int getIDKlijenta() {
        return IDKlijenta;
    }

    public void setIDKlijenta(int IDKlijenta) {
        this.IDKlijenta = IDKlijenta;
    }

    public int getIDSobe() {
        return IDSobe;
    }

    public void setIDSobe(int IDSobe) {
        this.IDSobe = IDSobe;
    }

    public String getDatumPocetka() {
        return datumPocetka;
    }

    public void setDatumPocetka(String datumPocetka) {
        this.datumPocetka = datumPocetka;
    }

    public String getDatumKraja() {
        return datumKraja;
    }

    public void setDatumKraja(String datumKraja) {
        this.datumKraja = datumKraja;
    }

    public boolean isUgovoreno() {
        return ugovoreno;
    }

    public void setUgovoreno(boolean ugovoreno) {
        this.ugovoreno = ugovoreno;
    }

    public int getOstvareniPoeni() {
        return OstvareniPoeni;
    }

    public void setOstvareniPoeni(int OstvareniPoeni) {
        this.OstvareniPoeni = OstvareniPoeni;
    }
    
    
}
