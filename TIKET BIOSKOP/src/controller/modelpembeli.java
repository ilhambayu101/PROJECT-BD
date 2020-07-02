package controller;
import entitas.*;
import formpembeli.*;
import database.Koneksi;
import formpembeli.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class modelpembeli {
    Koneksi koneksi;
    ArrayList<Register> arrReg; 
    ArrayList<Tempat> arrTemp;
    ArrayList<Transaksi>arrtrans;
    ArrayList<Pilih>arrPil;
    ArrayList<Have>arrHave;
    
    
    
    public modelpembeli() throws SQLException {
        this.koneksi = new Koneksi();
        this.arrReg = new ArrayList<>();
        this.arrTemp = new ArrayList<>();
        this.arrtrans = new ArrayList<>();
        this.arrPil = new ArrayList<>();
        this.arrHave = new ArrayList<>();
    }
    
    public ArrayList<Transaksi> getDataTransaksi() throws SQLException {
        this.arrtrans.clear();
        ResultSet rs = this.koneksi.GetData("SELECT * FROM REGISTER_07065 JOIN PEMBELI_07065"
                + " ON REGISTER_07065.ID = PEMBELI_07065.ID"
                + " JOIN TRANSAKSI_07065"
                + " ON TRANSAKSI_07065.KODE_REG = REGISTER_07065.KODE_REG"
                + " ORDER BY TRANSAKSI_07065.KODE_TIKET");
        while (rs.next()) {
            Pembeli pembeli = new Pembeli();
            pembeli.setId(rs.getInt("ID"));
            pembeli.setNama(rs.getString("NAMA"));
            pembeli.setAlamat(rs.getString("ALAMAT"));
            pembeli.setTelp(rs.getInt("TELP"));
            pembeli.setGender(rs.getString("GENDER"));

            Register reg = new Register();
            reg.setKode_Reg(rs.getInt("KODE_REG"));
            reg.setpembeli(pembeli);
            reg.setUsername(rs.getString("USERNAME"));
            reg.setPassword(rs.getString("PASSWORD"));
            
            pembeli.setregister(reg);
            
            Transaksi trans = new Transaksi();
            trans.setreg(reg);
            trans.setKode_Tiket(rs.getInt("KODE_TIKET"));
            trans.setBanyak(rs.getInt("BANYAK"));

            ResultSet rsHave = this.koneksi.GetData("SELECT * FROM HAVE_07065 JOIN JADWAL_07065 "
                    + "ON HAVE_07065.KODE_JADWAL = JADWAL_07065.KODE_JADWAL "
                    + "JOIN TIKET_07065 "
                    + "ON JADWAL_07065.KODE_FILM = TIKET_07065.KODE_FILM "
                    + "WHERE HAVE_07065.KODE_TIKET = " + rs.getString("KODE_TIKET")
                    + " ORDER BY HAVE_07065.KODE_TIKET");
            ArrayList<Have> hv = new ArrayList<>();

            while (rsHave.next()) {
                Film film = new Film();
                film.setKode_Film(rsHave.getInt("KODE_FILM"));
                film.setNama_Film(rsHave.getString("NAMA_FILM"));
                film.setGenre(rsHave.getString("GENRE"));
                film.setHarga(rsHave.getInt("HARGA"));

                Jadwal jdwl = new Jadwal();
                jdwl.setKode_Jadwal(rsHave.getInt("KODE_JADWAL"));
                jdwl.setfilm(film);
                jdwl.setTgl_Tayang(new Date(rsHave.getString("TGL_TAYANG")));
                jdwl.setWktu_Tayang(rsHave.getString("WKTU_TAYANG"));
                jdwl.setRuang(rsHave.getString("RUANG"));

                Have have = new Have();
                have.setjdwl(jdwl);
                have.settotal(rsHave.getInt("TOTAL"));
                hv.add(have);
            }
            trans.setarrHave(hv);

            ResultSet rsPilih = this.koneksi.GetData("SELECT * FROM PILIH_07065 JOIN TEMPAT_07065 "
                    + "ON PILIH_07065.DUDUK = TEMPAT_07065.DUDUK "
                    + "WHERE PILIH_07065.KODE_TIKET = " + rs.getString("KODE_TIKET")
                    + " ORDER BY PILIH_07065.KODE_TIKET");
            ArrayList<Pilih> ph = new ArrayList<>();

            while (rsPilih.next()) {
                Tempat temp = new Tempat();
                temp.setDuduk(rsPilih.getString("DUDUK"));

                Pilih pilih = new Pilih();
                pilih.settpt(temp);
                ph.add(pilih);
            }
            trans.setarrPilih(ph);
            
            this.arrtrans.add(trans);
        }
        return this.arrtrans;
    }

    
    public ArrayList<Tempat> getDataTempat() throws SQLException {
        this.arrTemp.clear();
        ResultSet rs = this.koneksi.GetData("SELECT * FROM TEMPAT_07065");
        while (rs.next()) {
            Tempat temp = new Tempat();
            temp.setDuduk(rs.getString("DUDUK"));
            this.arrTemp.add(temp);

        }
        return this.arrTemp;
    }

    public ArrayList<Pilih> getDataDUDUK() throws SQLException {
        this.arrTemp.clear();
            ResultSet rs = this.koneksi.GetData("SELECT * FROM PILIH_07065 JOIN TEMPAT_07065 "
                    + "ON PILIH_07065.DUDUK = TEMPAT_07065.DUDUK "
                    + "ORDER BY PILIH_07065.KODE_TIKET");
        while (rs.next()) {
                Tempat temp = new Tempat();
                temp.setDuduk(rs.getString("DUDUK"));

                Pilih pilih = new Pilih();
                pilih.settpt(temp);
            this.arrPil.add(pilih);
        }
        return this.arrPil;
    }

    public ArrayList<Have> getDatacinema() throws SQLException {
        this.arrTemp.clear();
            ResultSet rs = this.koneksi.GetData("SELECT * FROM HAVE_07065 JOIN JADWAL_07065 "
                    + "ON HAVE_07065.KODE_JADWAL = JADWAL_07065.KODE_JADWAL "
                    + "JOIN TIKET_07065 "
                    + "ON JADWAL_07065.KODE_FILM = TIKET_07065.KODE_FILM "
                    + " ORDER BY HAVE_07065.KODE_TIKET");
        while (rs.next()) {
                Film film = new Film();
                film.setKode_Film(rs.getInt("KODE_FILM"));
                film.setNama_Film(rs.getString("NAMA_FILM"));
                film.setGenre(rs.getString("GENRE"));
                film.setHarga(rs.getInt("HARGA"));

                Jadwal jdwl = new Jadwal();
                jdwl.setKode_Jadwal(rs.getInt("KODE_JADWAL"));
                jdwl.setfilm(film);
                jdwl.setTgl_Tayang(new Date(rs.getString("TGL_TAYANG")));
                jdwl.setWktu_Tayang(rs.getString("WKTU_TAYANG"));
                jdwl.setRuang(rs.getString("RUANG"));

                Have have = new Have();
                have.setjdwl(jdwl);
                have.settotal(rs.getInt("TOTAL"));
            this.arrHave.add(have);
        }
        return this.arrHave;
    }

    
    public ArrayList<Register> getDataReg() throws SQLException {
        this.arrReg.clear();
        ResultSet rs = this.koneksi.GetData("SELECT * FROM REGISTER_07065 JOIN PEMBELI_07065 ON REGISTER_07065.ID = PEMBELI_07065.ID ORDER BY REGISTER_07065.KODE_REG");
        while (rs.next()) {
                Pembeli pem = new Pembeli();
                pem.setId(rs.getInt("ID"));
                pem.setNama(rs.getString("NAMA"));
                pem.setTelp(rs.getInt("TELP"));
                pem.setGender(rs.getString("GENDER"));
           
                Register reg = new Register();
                reg.setKode_Reg(rs.getInt("KODE_REG"));
                reg.setUsername(rs.getString("USERNAME"));
                reg.setPassword(rs.getString("PASSWORD"));

                pem.setregister(reg);
                reg.setpembeli(pem);
            
            this.arrReg.add(reg);
        }
        return this.arrReg;
    }

    
    public void login(String user, String pass) throws SQLException
    {
        try {
        ResultSet rs0 = this.koneksi.GetData("CREATE VIEW LOGIN AS"
                + " SELECT a.KODE_REG, b.ID, a.USERNAME, a.PASSWORD, b.NAMA, b.ALAMAT, b.TELP, b.GENDER"
                + " FROM REGISTER_07065 a JOIN PEMBELI_07065 b"
                + " ON a.ID = b.ID");
        
        ResultSet rs = this.koneksi.GetData("SELECT * FROM LOGIN"
                + " WHERE USERNAME = '" + user + "' AND PASSWORD = '" + pass + "'");

        int baris = 0;
     
            while (rs.next()) {
                baris = rs.getRow();
           
            if (baris ==1) {
                Pembeli pem = new Pembeli();
                pem.setId(rs.getInt("ID"));
                pem.setNama(rs.getString("NAMA"));
                pem.setTelp(rs.getInt("TELP"));
                pem.setGender(rs.getString("GENDER"));
           
                Register reg = new Register();
                reg.setKode_Reg(rs.getInt("KODE_REG"));
                reg.setUsername(rs.getString("USERNAME"));
                reg.setPassword(rs.getString("PASSWORD"));

                pem.setregister(reg);
                reg.setpembeli(pem);
                new transaksi(reg.getpembeli().getNama(), reg.getKode_Reg()).setVisible(true);
                
            }else {
                
            }
            }
        } catch (SQLException ex) {
            Logger.getLogger(modelpembeli.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void caridatareg(String cari) throws SQLException
    {
        
        ResultSet rs = this.koneksi.GetData("SELECT * FROM REGISTER_07065 JOIN PEMBELI_07065 "
                + "ON REGISTER_07065.ID = PEMBELI_07065.ID ORDER BY REGISTER_07065.KODE_REG "
                + "WHERE PEMBELI_07065.NAMA = " + "'" + cari + "'" );
        while (rs.next()) {
                Pembeli pem = new Pembeli();
                pem.setId(rs.getInt("ID"));
                pem.setNama(rs.getString("NAMA"));
                pem.setTelp(rs.getInt("TELP"));
                pem.setGender(rs.getString("GENDER"));
           
                Register reg = new Register();
                reg.setKode_Reg(rs.getInt("KODE_REG"));
                reg.setUsername(rs.getString("USERNAME"));
                reg.setPassword(rs.getString("PASSWORD"));

                pem.setregister(reg);
                reg.setpembeli(pem);
        }
    }
    
    
    public void insertuser(Pembeli pem) throws SQLException {
                this.koneksi.ManipulasiData("INSERT INTO PEMBELI_07065 VALUES (ID.NEXTVAL, " + 
                    null + ", " + "'" + pem.getNama() + "'" + 
                    "," + "'" + pem.getAlamat() + "'" + 
                    "," + "'" + pem.getTelp() + "'" +
                    "," + "'" + pem.getGender() + "'" + ")");
    
            ResultSet rs = this.koneksi.GetData("SELECT ID.CURRVAL FROM DUAL");
            rs.next();
            int id = rs.getInt("CURRVAL");
                this.koneksi.ManipulasiData("INSERT INTO REGISTER_07065 VALUES (" + 
                        pem.getregister().getKode_Reg() + "," + id + 
                        "," + "'" + pem.getregister().getUsername() + "'" + 
                        "," + "'" + pem.getregister().getPassword() + "'" + ")");
                this.koneksi.ManipulasiData("UPDATE PEMBELI_07065 SET KODE_REG=" + 
                        pem.getregister().getKode_Reg() + "WHERE ID=" + id);
    }
    
    public void inserttrans(Transaksi trans) throws SQLException {
            
        this.koneksi.ManipulasiData("INSERT INTO TRANSAKSI_07065 VALUES(" + trans.getKode_Tiket() + 
                "," + trans.getreg().getKode_Reg() +  
                "," + "'" + trans.getBanyak() + "'" + ")");
                    
        for (Have h : trans.getarrHave()) {
                this.koneksi.ManipulasiData("INSERT INTO HAVE_07065 VALUES (" + 
                        "'" + trans.getKode_Tiket() + "'" +  
                        "," + "'" + h.getjdwl().getKode_Jadwal() + "'" +
                        "," + "'" + h.gettotal() + "'" +")");
            }
    }
    
    public void insertDuduk(String s, Integer i) throws SQLException {
            
        
                this.koneksi.ManipulasiData("INSERT INTO PILIH_07065 VALUES (" + 
                        "'" + i + "'" +  
                        "," + "'" + s + "'" +")");
            
        
    }

}
