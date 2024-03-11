/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Milija
 */
public class Hotel {
    private String NazivHotela, Lokacija;
    private int IDHotela, BrojSpratova, BrojSoba, DostupnostSoba, DostupnostHotela;

    public Hotel() {
    }

    public Hotel(String NazivHotela, String Lokacija, int IDHotela, int BrojSpratova, int BrojSoba, int DostupnostSoba, int DostupnostHotela) {
        this.NazivHotela = NazivHotela;
        this.Lokacija = Lokacija;
        this.IDHotela = IDHotela;
        this.BrojSpratova = BrojSpratova;
        this.BrojSoba = BrojSoba;
        this.DostupnostSoba = DostupnostSoba;
        this.DostupnostHotela = DostupnostHotela;
    }

    public Hotel(String NazivHotela, String Lokacija, int IDHotela) {
        this.NazivHotela = NazivHotela;
        this.Lokacija = Lokacija;
        this.IDHotela = IDHotela;
    }

    
    public Hotel(String NazivHotela, int IDHotela) {
        this.NazivHotela = NazivHotela;
        this.IDHotela = IDHotela;
    }
    
    public Hotel(String NazivHotela, String Lokacija, int BrojSpratova, int BrojSoba, int DostupnostSoba, int DostupnostHotela) {
        this.NazivHotela = NazivHotela;
        this.Lokacija = Lokacija;
        this.BrojSpratova = BrojSpratova;
        this.BrojSoba = BrojSoba;
        this.DostupnostSoba = DostupnostSoba;
        this.DostupnostHotela = DostupnostHotela;
    }

    public String getNazivHotela() {
        return NazivHotela;
    }

    public String getLokacija() {
        return Lokacija;
    }

    public int getIDHotela() {
        return IDHotela;
    }

    public int getBrojSpratova() {
        return BrojSpratova;
    }

    public int getBrojSoba() {
        return BrojSoba;
    }

    public int getDostupnostSoba() {
        return DostupnostSoba;
    }

    public int getDostupnostHotela() {
        return DostupnostHotela;
    }

    public void setNazivHotela(String NazivHotela) {
        this.NazivHotela = NazivHotela;
    }

    public void setLokacija(String Lokacija) {
        this.Lokacija = Lokacija;
    }

    public void setIDHotela(int IDHotela) {
        this.IDHotela = IDHotela;
    }

    public void setBrojSpratova(int BrojSpratova) {
        this.BrojSpratova = BrojSpratova;
    }

    public void setBrojSoba(int BrojSoba) {
        this.BrojSoba = BrojSoba;
    }

    public void setDostupnostSoba(int DostupnostSoba) {
        this.DostupnostSoba = DostupnostSoba;
    }

    public void setDostupnostHotela(int DostupnostHotela) {
        this.DostupnostHotela = DostupnostHotela;
    }
    
    
}
