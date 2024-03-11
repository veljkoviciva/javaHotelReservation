
package Model;

public class SpecifikacijaSobe {
    private int IDSobe;
    private boolean Klima, Sporet, Terasa, Sef;

    public SpecifikacijaSobe(int IDSobe, boolean Klima, boolean Sporet, boolean Terasa, boolean Sef) {
        this.IDSobe = IDSobe;
        this.Klima = Klima;
        this.Sporet = Sporet;
        this.Terasa = Terasa;
        this.Sef = Sef;
    }

    public SpecifikacijaSobe() {
    }

    public int getIDSobe() {
        return IDSobe;
    }

    public void setIDSobe(int IDSobe) {
        this.IDSobe = IDSobe;
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
    
    
}
