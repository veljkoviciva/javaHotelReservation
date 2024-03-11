package Baza;

import Model.Hotel;
import Model.Klijent;
import Model.Rezervacija;
import Model.Soba;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Queries {

    public static void main(String[] args) {
//        tipSoba(3001);
//        selectTipSobe("Cetvorokrevetna", 3001);
//Klijent k = new Klijent();
//k.setImeKlijenta("Marko");
//k.setPrezimeKlijenta("Petrovic");
//k.setDatumRodjenja("14.07.1998");
//k.setKorisnickoIme("maremare");
//k.setLozinka("marko");
//k.setIDKlijenta(0);
//k.setBrojPoena(0);
//        insertKlijent(k);
//        System.out.println(k);
//sveSobe();
//naziviHotela();
    }

    public static int brojSoba(int idHotela) {

        String upit = "select count(*) from soba where IDHotela=?";
        //System.out.println(upit);
        int brojSoba = 0;

        try {
            try (Connection db = dbConnection.konekcija()) {
                PreparedStatement ps = db.prepareStatement(upit);
                ps.setInt(1, idHotela);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    brojSoba = rs.getInt(1);
                }
                db.close();
            }
        } catch (SQLException ex) {
            System.out.println("greskaaaaaaaaaaa");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("BROJ SOBAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" + brojSoba);
        return brojSoba;

    }

    public static int brojSpratova(int idHotela) {

        String upit = "select max(BrojSprata) from soba where IDHotela=?";
        //System.out.println(upit);
        int brojSoba = 0;

        try {
            try (Connection db = dbConnection.konekcija()) {
                PreparedStatement ps = db.prepareStatement(upit);
                ps.setInt(1, idHotela);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    brojSoba = rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            System.out.println("greskaaaaaaaaaaa");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("BROJ SOBAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" + brojSoba);
        return brojSoba;

    }

    public static ArrayList<Soba> tipSoba(int idHotela) {
        ArrayList<Soba> tipoviSoba = new ArrayList<>();
        String upit = "select distinct(TipSobe) from soba where IDHotela=? order by TipSobe asc";
        //System.out.println(upit);

        try {
            try (Connection db = dbConnection.konekcija()) {
                PreparedStatement ps = db.prepareStatement(upit);
                ps.setInt(1, idHotela);

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String tipSobe = rs.getString("TipSobe");
                    Soba s = new Soba(tipSobe);
                    tipoviSoba.add(s);
                }
                db.close();
            }
        } catch (SQLException ex) {
            System.out.println("greskaaaaaaaaaaa");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Soba so : tipoviSoba) {
            System.out.println("BROJ SOBAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" + so.getTipSobe());
        }
        return tipoviSoba;
    }

    public static ArrayList<Soba> selectTipSobe(String tipSobe, int idHotela) {
        ArrayList<Soba> tipoviSoba = new ArrayList<>();
        String upit = "SELECT * FROM soba where TipSobe=? and IDHotela=?";

        try {
            Connection db = dbConnection.konekcija();
            PreparedStatement ps = db.prepareStatement(upit);
            ps.setString(1, tipSobe);
            ps.setInt(2, idHotela);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idSobe = rs.getInt("IDSobe");
                int brojSobe = rs.getInt("BrojSobe");
                int brojSprata = rs.getInt("BrojSprata");
                boolean imaKlimu = rs.getBoolean("Klima");
                boolean imaSporet = rs.getBoolean("Sporet");
                boolean imaTerasu = rs.getBoolean("Terasa");
                boolean imaSef = rs.getBoolean("Sef");

                Soba s = new Soba(tipSobe, idSobe, brojSobe, brojSprata, idHotela, imaKlimu, imaSporet, imaTerasu, imaSef);
                tipoviSoba.add(s);
            }

            db.close();
            return tipoviSoba;

        } catch (SQLException ex) {
            System.out.println("greskaaaaaaaaaaa");
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static void insertKlijent(Klijent k) {
        String upit = "insert into klijent "
                + "(ImeKlijenta, PrezimeKlijenta, DatumRodjenja, KorisnickoIme, Lozinka) values(?,?,?,?,?)";

        try {
            Connection db = dbConnection.konekcija();
            PreparedStatement ps = db.prepareStatement(upit);
            ps.setString(1, k.getImeKlijenta());
            ps.setString(2, k.getPrezimeKlijenta());
            ps.setString(3, k.getDatumRodjenja());
            ps.setString(4, k.getKorisnickoIme());
            ps.setString(5, k.getLozinka());
            ps.execute();

        } catch (SQLException ex) {
            System.out.println("greskaaaaaaaaaaa");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int proveraLogin(String korisnickoIme, String lozinka) {
        String upit = "select * from klijent where KorisnickoIme=? and Lozinka=?";
//        System.out.println(upit);
        try {
            Connection db = dbConnection.konekcija();
            PreparedStatement ps = db.prepareStatement(upit);
            ps.setString(1, korisnickoIme);
            ps.setString(2, lozinka);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("IDKlijenta");
            } else {
                return 0;
            }

        } catch (SQLException ex) {
            System.out.println("greskaaaaaaaaaaa");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static void promenaLozinke(String korisnickoIme, String trenutnaLozinka, String novaLozinka) {
//        Za sve(klijenti, menadzeri, administrator)
        String upit = "update klijent set Lozinka=? where KorisnickoIme=? and Lozinka=?";
        System.out.println(upit);
        try {
            Connection db = dbConnection.konekcija();
            PreparedStatement ps = db.prepareStatement(upit);
            ps.setString(1, novaLozinka);
            ps.setString(2, korisnickoIme);
            ps.setString(3, trenutnaLozinka);
            ps.execute();

        } catch (SQLException ex) {
            System.out.println("greskaaaaaaaaaaa");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Klijent selectKlijent(String korisnickoIme, String lozinka) {
        Klijent k = null;
        String upit = "select * from klijent where KorisnickoIme=? and Lozinka=?";
        System.out.println(upit);
        try {
            Connection db = dbConnection.konekcija();
            PreparedStatement ps = db.prepareStatement(upit);
            ps.setString(1, korisnickoIme);
            ps.setString(1, lozinka);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int idKlijenta = rs.getInt("IDKlijenta");
                String ime = rs.getString("ImeKlijenta");
                String prezime = rs.getString("PrezimeKlijenta");
                String datumRodjenja = rs.getString("DatumRodjenja");
                int brojPoena = rs.getInt("BrojPoena");
                String uloga = rs.getString("Uloga");

                k = new Klijent(idKlijenta, ime, prezime, datumRodjenja, korisnickoIme, lozinka, uloga, brojPoena);
            }
            db.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Proba");
        return k;
    }

    public static int vratiIDKlijenta(String korisnickoIme, String lozinka) {
        String upit = "select IDKlijenta from Klijent where KorisnickoIme=? and Lozinka=?";

        try {
            Connection db = dbConnection.konekcija();
            PreparedStatement ps = db.prepareStatement(upit);
            ps.setString(1, korisnickoIme);
            ps.setString(1, lozinka);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("IDKlijenta");
            }
            db.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    public static ArrayList<Soba> izborSobaPoHotelu(int idHotela) {
        ArrayList<Soba> sveSobe = new ArrayList<>();
        String upit = "select * from soba where IDHotela=?";

        try {
            Connection db = dbConnection.konekcija();
            PreparedStatement ps = db.prepareStatement(upit);
            ps.setInt(1, idHotela);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idSobe = rs.getInt("IDSobe");
                int brojSobe = rs.getInt("BrojSobe");
                String tipSobe = rs.getString("TipSobe");
                int brojSprata = rs.getInt("BrojSprata");
                boolean imaKlimu = rs.getBoolean("Klima");
                boolean imaSporet = rs.getBoolean("Sporet");
                boolean imaTerasu = rs.getBoolean("Terasa");
                boolean imaSef = rs.getBoolean("Sef");

                Soba sobe = new Soba(tipSobe, idSobe, brojSobe, brojSprata, idHotela, imaKlimu, imaSporet, imaTerasu, imaSef);
                sveSobe.add(sobe);
            }
            db.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sveSobe;
    }

    public static String vratiUlogu(String korisnickoIme, String lozinka) {
        String upit = "select Uloga from klijent where KorisnickoIme=? and Lozinka=?";

        try {
            Connection db = dbConnection.konekcija();
            PreparedStatement ps = db.prepareStatement(upit);
            ps.setString(1, korisnickoIme);
            ps.setString(2, lozinka);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("Uloga");
            } else {
                return null;
            }

        } catch (SQLException ex) {
            System.out.println("greskaaaaaaaaaaa");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static int vratiBrojPoena(int idHotela) {
        String upit = "select distinct Poeni from soba where IDHotela=?";

        try {
            Connection db = dbConnection.konekcija();
            PreparedStatement ps = db.prepareStatement(upit);
            ps.setInt(1, idHotela);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("Poeni");
            } else {
                return 0;
            }

        } catch (SQLException ex) {
            System.out.println("greskaaaaaaaaaaa");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static ArrayList<Soba> sveSobe() {
        ArrayList<Soba> listaSoba = new ArrayList<>();
        String upit = "select * from soba";

        try {
            Connection db = dbConnection.konekcija();
            PreparedStatement ps = db.prepareStatement(upit);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idSobe = rs.getInt("IDSobe");
                int brojSobe = rs.getInt("BrojSobe");
                String tipSobe = rs.getString("TipSobe");
                int brojSprata = rs.getInt("BrojSprata");
                int idHotela = rs.getInt("IDHotela");
                boolean imaKlimu = rs.getBoolean("Klima");
                boolean imaSporet = rs.getBoolean("Sporet");
                boolean imaTerasu = rs.getBoolean("Terasa");
                boolean imaSef = rs.getBoolean("Sef");

                Soba sobe = new Soba(tipSobe, idSobe, brojSobe, brojSprata, idHotela, imaKlimu, imaSporet, imaTerasu, imaSef);
                listaSoba.add(sobe);
            }
            db.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaSoba;
    }

    public static ArrayList<Hotel> naziviHotela() {
        ArrayList<Hotel> listaHotela = new ArrayList<>();
        String upit = "select NazivHotela, IDHotela from hotel";

        try {
            Connection db = dbConnection.konekcija();
            PreparedStatement ps = db.prepareStatement(upit);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idHotela = rs.getInt("IDHotela");
                String nazivHotela = rs.getString("NazivHotela");
                Hotel hoteli = new Hotel(nazivHotela, idHotela);
                listaHotela.add(hoteli);
            }
            db.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(upit);
        return listaHotela;
    }

    public static void insertSoba(Soba s) {
        String upit = "insert into soba (IDSobe, BrojSobe, TipSobe, BrojSprata, IDHotela, "
                + " Klima, Sporet, Terasa, Sef, Dostupnost, Poeni) values (?,?,?,?,?,?,?,?,?,?,?)";

        try {
            Connection db = dbConnection.konekcija();
            PreparedStatement ps = db.prepareStatement(upit);
            ps.setInt(1, s.getIDSobe());
            ps.setInt(2, s.getBrojSobe());
            ps.setString(3, s.getTipSobe());
            ps.setInt(4, s.getBrojSprata());
            ps.setInt(5, s.getIDHotela());
            ps.setBoolean(6, s.isKlima());
            ps.setBoolean(7, s.isSporet());
            ps.setBoolean(8, s.isTerasa());
            ps.setBoolean(9, s.isSef());
            ps.setBoolean(10, s.isDostupnost());
            ps.setInt(11, s.getPoeni());

            ps.execute();

//            db.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(upit);
    }

    public static int vratiIDKlijentaPremaUlozi(String korisnickoIme, String uloga) {
        String upit = "select IDKlijenta from Klijent where KorisnickoIme=? and Uloga=?";

        try {
            Connection db = dbConnection.konekcija();
            PreparedStatement ps = db.prepareStatement(upit);
            ps.setString(1, korisnickoIme);
            ps.setString(2, uloga);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("IDKlijenta");
            }
            db.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    public static Hotel izborHotela(int idHotela) {
        Hotel h = null;
        String upit = "select * from hotel where IDHotela=?";

        try {
            Connection db = dbConnection.konekcija();
            PreparedStatement ps = db.prepareStatement(upit);
            ps.setInt(1, idHotela);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String nazivHotela = rs.getString("NazivHotela");
                String lokacija = rs.getString("Lokacija");

                h = new Hotel(nazivHotela, lokacija, idHotela);
            }
            db.close();

        } catch (SQLException ex) {
            System.out.println("greskaaaaaaaaaaa");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return h;
    }

    public static void deleteSoba(int idSobe) {
        String upit = "delete from soba where IDSobe=?";

        try {
            Connection db = dbConnection.konekcija();
            PreparedStatement ps = db.prepareStatement(upit);
            ps.setInt(1, idSobe);

            ps.executeUpdate();

//            db.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(upit);
    }

    public static Soba jednaSoba(int id) {
        Soba s = null;
        String upit = "select * from soba where IDSobe=?";

        try {
            Connection db = dbConnection.konekcija();
            PreparedStatement ps = db.prepareStatement(upit);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int idSobe = rs.getInt("IDSobe");
                int brojSobe = rs.getInt("BrojSobe");
                String tipSobe = rs.getString("TipSobe");
                int brojSprata = rs.getInt("BrojSprata");
                int idHotela = rs.getInt("IDHotela");
                boolean imaKlimu = rs.getBoolean("Klima");
                boolean imaSporet = rs.getBoolean("Sporet");
                boolean imaTerasu = rs.getBoolean("Terasa");
                boolean imaSef = rs.getBoolean("Sef");
                boolean dostupnost = rs.getBoolean("Dostupnost");
                int brojPoena = rs.getInt("Poeni");

                s = new Soba(tipSobe, idSobe, brojSobe, brojSprata, idHotela, brojPoena, imaKlimu, imaSporet, imaTerasu, imaSef, dostupnost);

            }
            db.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }

        return s;
    }

    public static void updateSobe(Soba s) {
        Soba soba = null;
        String upit = "update soba set BrojSobe=?, TipSobe=?, BrojSprata=?, Klima=?, Sporet=?, "
                + "Terasa=?, Sef=? where IDSobe=?";

        try {
            Connection db = dbConnection.konekcija();
            PreparedStatement ps = db.prepareStatement(upit);
            ps.setInt(1, s.getBrojSobe());
            ps.setString(2, s.getTipSobe());
            ps.setInt(3, s.getBrojSprata());
            ps.setBoolean(4, s.isKlima());
            ps.setBoolean(5, s.isSporet());
            ps.setBoolean(6, s.isTerasa());
            ps.setBoolean(7, s.isSef());
            ps.setInt(8, s.getIDSobe());

            ps.executeUpdate();
            db.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(upit);
    }

    public static Klijent podaciOKlijentu(int idKlijenta) {
        Klijent k = null;
        String upit = "select ImeKlijenta, PrezimeKlijenta, DatumRodjenja, BrojPoena from klijent where IDKlijenta=?";

        try {
            Connection db = dbConnection.konekcija();
            PreparedStatement ps = db.prepareStatement(upit);
            ps.setInt(1, idKlijenta);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String imeKlijenta = rs.getString("ImeKlijenta");
                String prezimeKlijenta = rs.getString("PrezimeKlijenta");
                String datumRodjenja = rs.getString("DatumRodjenja");
                int brojPoena = rs.getInt("BrojPoena");

                k = new Klijent(imeKlijenta, prezimeKlijenta, datumRodjenja, brojPoena);
            }
            db.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }

        return k;
    }

    public static Hotel podaciOHotelu() {
        Hotel h = null;
        String upit = "select * from hotel";

        try {
            Connection db = dbConnection.konekcija();
            PreparedStatement ps = db.prepareStatement(upit);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int idHotela = rs.getInt("IDHotela");
                String nazivHotela = rs.getString("NazivHotela");
                int brojSpratova = rs.getInt("BrojSpratova");
                int brojSoba = rs.getInt("BrojSoba");
                String lokacija = rs.getString("Lokacija");
                int dostupnostSoba = rs.getInt("DostupnostSoba");
                int dostupnostHotela = rs.getInt("DostupnostHotela");

                h = new Hotel(nazivHotela, lokacija, idHotela, brojSpratova, brojSoba, dostupnostSoba, dostupnostHotela);
            }
            db.close();

        } catch (SQLException ex) {
            System.out.println("greskaaaaaaaaaaa");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return h;
    }

    public static void napraviRezervaciju(Rezervacija r) {
        String upit = "insert into rezervacija(IDKlijenta, IDSobe, DatumPocetka, DatumKraja, OstvareniPoeni, Ugovoreno)"
                + "values (?,?,?,?,?,1)";
        try {
            Connection db = dbConnection.konekcija();
            PreparedStatement ps = db.prepareStatement(upit);
            ps.setInt(1, r.getIDKlijenta());
            ps.setInt(2, r.getIDSobe());
            ps.setString(3, r.getDatumPocetka());
            ps.setString(4, r.getDatumKraja());
            ps.setInt(5, r.getOstvareniPoeni());

            ps.execute();

//            db.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(upit);
    }

    public static ArrayList<Rezervacija> sveRezervacije() {
        ArrayList<Rezervacija> listaRezervacija = new ArrayList<>();
        String upit = "select * from rezervacija";

        try {
            Connection db = dbConnection.konekcija();
            PreparedStatement ps = db.prepareStatement(upit);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idRezervacije = rs.getInt("IDRezervacije");
                int idKlijenta = rs.getInt("IDKlijenta");
                int idSobe = rs.getInt("IDSobe");
                String datumPocetka = rs.getString("DatumPocetka");
                String datumKraja = rs.getString("DatumKraja");
                boolean ugovoreno = rs.getBoolean("Ugovoreno");
                int ostvareniPoeni = rs.getInt("OstvareniPoeni");

                Rezervacija r = new Rezervacija(idRezervacije, idKlijenta, idSobe, ostvareniPoeni, datumPocetka, datumKraja, ugovoreno);
                listaRezervacija.add(r);
            }
            db.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaRezervacija;
    }

    public static void deleteRezervacija(int idRezervacije) {
        String upit = "delete from rezervacija where IDRezervacije=?";

        try {
            Connection db = dbConnection.konekcija();
            PreparedStatement ps = db.prepareStatement(upit);
            ps.setInt(1, idRezervacije);

            ps.executeUpdate();

//            db.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(upit);
    }

    public static ArrayList<Klijent> listaKlijenata() {
        ArrayList<Klijent> klijenti = new ArrayList<>();
        String upit = "select * from klijent";

        try {
            Connection db = dbConnection.konekcija();
            PreparedStatement ps = db.prepareStatement(upit);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idKlijenta = rs.getInt("IDKlijenta");
                String imeKlijenta = rs.getString("ImeKlijenta");
                String prezimeKlijenta = rs.getString("PrezimeKlijenta");
                String datumRodjenja = rs.getString("DatumRodjenja");
                String korisnickoIme = rs.getString("KorisnickoIme");
                int brojPoena = rs.getInt("BrojPoena");
                String uloga = rs.getString("Uloga");

                Klijent k = new Klijent(idKlijenta, imeKlijenta, prezimeKlijenta, datumRodjenja, korisnickoIme, brojPoena, uloga);
                klijenti.add(k);
            }
            db.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }

        return klijenti;
    }

    public static void deleteKlijenta(int idKlijenta) {
        String upit = "delete from klijent where IDKlijenta=?";

        try {
            Connection db = dbConnection.konekcija();
            PreparedStatement ps = db.prepareStatement(upit);
            ps.setInt(1, idKlijenta);

            ps.executeUpdate();

//            db.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(upit);
    }

    public static void updateUloga(String uloga, int id) {
        
        String upit = "update klijent set Uloga=? where IDKlijenta=?";
System.out.println(upit);
        try {
            Connection db = dbConnection.konekcija();
            PreparedStatement ps = db.prepareStatement(upit);
            ps.setString(1, uloga);
            ps.setInt(2, id);
           

            ps.executeUpdate();
            db.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(upit);
    }
    
    public static Klijent jedanKlijent(int idKlijenta) {
        Klijent k = null;
        String upit = "select * from klijent where IDKlijenta=?";

        try {
            Connection db = dbConnection.konekcija();
            PreparedStatement ps = db.prepareStatement(upit);
            ps.setInt(1, idKlijenta);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String imeKlijenta = rs.getString("ImeKlijenta");
                String prezimeKlijenta = rs.getString("PrezimeKlijenta");
                String datumRodjenja = rs.getString("DatumRodjenja");
                String korisnickoIme = rs.getString("KorisnickoIme");
                int brojPoena = rs.getInt("BrojPoena");
                String uloga = rs.getString("Uloga");

                k = new Klijent(idKlijenta, imeKlijenta, prezimeKlijenta, datumRodjenja, korisnickoIme, brojPoena, uloga);

            }
            db.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }

        return k;
    }
    
    public static ArrayList<Soba> sveSobeIzHotela(int idHotela) {
        ArrayList<Soba> listaSoba = new ArrayList<>();
        String upit = "select * from soba where IDHotela=?";

        try {
            Connection db = dbConnection.konekcija();
            PreparedStatement ps = db.prepareStatement(upit);
            ps.setInt(1, idHotela);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idSobe = rs.getInt("IDSobe");
                int brojSobe = rs.getInt("BrojSobe");
                String tipSobe = rs.getString("TipSobe");
                int brojSprata = rs.getInt("BrojSprata");
                boolean imaKlimu = rs.getBoolean("Klima");
                boolean imaSporet = rs.getBoolean("Sporet");
                boolean imaTerasu = rs.getBoolean("Terasa");
                boolean imaSef = rs.getBoolean("Sef");
                boolean dostupnost = rs.getBoolean("Dostupnost");
                int brojPoena = rs.getInt("Poeni");

                Soba s = new Soba(tipSobe, idSobe, brojSobe, brojSprata, 
                        idHotela, brojPoena, imaKlimu, imaSporet, 
                        imaTerasu, imaSef, dostupnost);
                listaSoba.add(s);

            }
            db.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaSoba;
    }
    
    public static ArrayList<Rezervacija> sveRezervacijePoKorisniku(int idKorisnika) {
        ArrayList<Rezervacija> listaRezervacija = new ArrayList<>();
        String upit = "select * from rezervacija where IDKlijenta=?";

        try {
            Connection db = dbConnection.konekcija();
            PreparedStatement ps = db.prepareStatement(upit);
            ps.setInt(1, idKorisnika);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idRezervacije = rs.getInt("IDRezervacije");
                int idKlijenta = rs.getInt("IDKlijenta");
                int idSobe = rs.getInt("IDSobe");
                String datumPocetka = rs.getString("DatumPocetka");
                String datumKraja = rs.getString("DatumKraja");
                boolean ugovoreno = rs.getBoolean("Ugovoreno");
                int ostvareniPoeni = rs.getInt("OstvareniPoeni");

                Rezervacija r = new Rezervacija(idRezervacije, idKlijenta, idSobe, ostvareniPoeni, datumPocetka, datumKraja, ugovoreno);
                listaRezervacija.add(r);
            }
            db.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaRezervacija;
    }
}
