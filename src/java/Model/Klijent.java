
package Model;

import java.io.Serializable;

public class Klijent implements Serializable{
    private int IDKlijenta;
    private String imeKlijenta, prezimeKlijenta, datumRodjenja, korisnickoIme, lozinka, uloga;
    private int brojPoena;

    public Klijent() {
    }

    public Klijent(int IDKlijenta, String imeKlijenta, String prezimeKlijenta, String datumRodjenja, String korisnickoIme, String lozinka, String uloga, int brojPoena) {
        this.IDKlijenta = IDKlijenta;
        this.imeKlijenta = imeKlijenta;
        this.prezimeKlijenta = prezimeKlijenta;
        this.datumRodjenja = datumRodjenja;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.uloga = uloga;
        this.brojPoena = brojPoena;
    }

    public Klijent(int IDKlijenta) {
        this.IDKlijenta = IDKlijenta;
    }

    public Klijent(String imeKlijenta, String prezimeKlijenta, String datumRodjenja, int brojPoena) {
        this.imeKlijenta = imeKlijenta;
        this.prezimeKlijenta = prezimeKlijenta;
        this.datumRodjenja = datumRodjenja;
        this.brojPoena = brojPoena;
    }

    public Klijent(int IDKlijenta, String imeKlijenta, String prezimeKlijenta, String datumRodjenja, String korisnickoIme, int brojPoena, String uloga) {
        this.IDKlijenta = IDKlijenta;
        this.imeKlijenta = imeKlijenta;
        this.prezimeKlijenta = prezimeKlijenta;
        this.datumRodjenja = datumRodjenja;
        this.korisnickoIme = korisnickoIme;
        this.brojPoena = brojPoena;
        this.uloga = uloga;
    }
    
    public Klijent(int IDKlijenta, String imeKlijenta, String prezimeKlijenta, String datumRodjenja, String korisnickoIme, String lozinka, int brojPoena) {
        this.IDKlijenta = IDKlijenta;
        this.imeKlijenta = imeKlijenta;
        this.prezimeKlijenta = prezimeKlijenta;
        this.datumRodjenja = datumRodjenja;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.brojPoena = brojPoena;
    }

    public Klijent(String imeKlijenta, String prezimeKlijenta, String datumRodjenja, String korisnickoIme, String lozinka) {
        this.imeKlijenta = imeKlijenta;
        this.prezimeKlijenta = prezimeKlijenta;
        this.datumRodjenja = datumRodjenja;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    public Klijent(int IDKlijenta, String imeKlijenta, String prezimeKlijenta, String datumRodjenja, int brojPoena) {
        this.IDKlijenta = IDKlijenta;
        this.imeKlijenta = imeKlijenta;
        this.prezimeKlijenta = prezimeKlijenta;
        this.datumRodjenja = datumRodjenja;
        this.brojPoena = brojPoena;
    }

    public String getUloga() {
        return uloga;
    }

    public void setUloga(String uloga) {
        this.uloga = uloga;
    }

    public int getIDKlijenta() {
        return IDKlijenta;
    }

    public void setIDKlijenta(int IDKlijenta) {
        this.IDKlijenta = IDKlijenta;
    }

    public int getBrojPoena() {
        return brojPoena;
    }

    public void setBrojPoena(int brojPoena) {
        this.brojPoena = brojPoena;
    }

    public String getImeKlijenta() {
        return imeKlijenta;
    }

    public void setImeKlijenta(String imeKlijenta) {
        this.imeKlijenta = imeKlijenta;
    }

    public String getPrezimeKlijenta() {
        return prezimeKlijenta;
    }

    public void setPrezimeKlijenta(String prezimeKlijenta) {
        this.prezimeKlijenta = prezimeKlijenta;
    }

    public String getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(String datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }
    
    
}
