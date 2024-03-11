
package Model;

public class Soba {
    private String TipSobe;
    private int IDSobe, BrojSobe, BrojSprata, IDHotela, Poeni;
    private boolean Klima, Sporet, Terasa, Sef, Dostupnost;

    public Soba(String TipSobe, int IDHotela) {
        this.TipSobe = TipSobe;
        this.IDHotela = IDHotela;
    }

    public Soba() {
    }

    public Soba(String TipSobe, int IDSobe, int BrojSobe, int BrojSprata, int IDHotela, boolean Klima, boolean Sporet, boolean Terasa, boolean Sef) {
        this.TipSobe = TipSobe;
        this.IDSobe = IDSobe;
        this.BrojSobe = BrojSobe;
        this.BrojSprata = BrojSprata;
        this.IDHotela = IDHotela;
        this.Klima = Klima;
        this.Sporet = Sporet;
        this.Terasa = Terasa;
        this.Sef = Sef;
    }

    public Soba(String TipSobe, int IDSobe, int BrojSobe, int BrojSprata, int IDHotela, int Poeni, boolean Klima, boolean Sporet, boolean Terasa, boolean Sef, boolean Dostupnost) {
        this.TipSobe = TipSobe;
        this.IDSobe = IDSobe;
        this.BrojSobe = BrojSobe;
        this.BrojSprata = BrojSprata;
        this.IDHotela = IDHotela;
        this.Poeni = Poeni;
        this.Klima = Klima;
        this.Sporet = Sporet;
        this.Terasa = Terasa;
        this.Sef = Sef;
        this.Dostupnost = Dostupnost;
    }

    public int getPoeni() {
        return Poeni;
    }

    public void setPoeni(int Poeni) {
        this.Poeni = Poeni;
    }

    public boolean isDostupnost() {
        return Dostupnost;
    }

    public void setDostupnost(boolean Dostupnost) {
        this.Dostupnost = Dostupnost;
    }

    
    public boolean isKlima() {
        return Klima;
    }

    public void setKlima(boolean Klima) {
        this.Klima = Klima;
    }

    public boolean isSporet() {
        return Sporet;
    }

    public void setSporet(boolean Sporet) {
        this.Sporet = Sporet;
    }

    public boolean isTerasa() {
        return Terasa;
    }

    public void setTerasa(boolean Terasa) {
        this.Terasa = Terasa;
    }

    public boolean isSef() {
        return Sef;
    }

    public void setSef(boolean Sef) {
        this.Sef = Sef;
    }

    

    public Soba(String TipSobe) {
        this.TipSobe = TipSobe;
    }

    public String getTipSobe() {
        return TipSobe;
    }

    public int getIDSobe() {
        return IDSobe;
    }

    public int getBrojSobe() {
        return BrojSobe;
    }

    public int getBrojSprata() {
        return BrojSprata;
    }

    public int getIDHotela() {
        return IDHotela;
    }

    public void setTipSobe(String TipSobe) {
        this.TipSobe = TipSobe;
    }

    public void setIDSobe(int IDSobe) {
        this.IDSobe = IDSobe;
    }

    public void setBrojSobe(int BrojSobe) {
        this.BrojSobe = BrojSobe;
    }

    public void setBrojSprata(int BrojSprata) {
        this.BrojSprata = BrojSprata;
    }

    public void setIDHotela(int IDHotela) {
        this.IDHotela = IDHotela;
    }
    
    
}
