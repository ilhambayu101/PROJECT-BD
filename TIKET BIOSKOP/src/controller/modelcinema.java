package controller;
    import entitas.*;
    import database.Koneksi;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.text.SimpleDateFormat;
    import java.util.ArrayList;
    import java.util.Date;

public class modelcinema {
    Koneksi koneksi;
    ArrayList<Film> arrFilm;
    ArrayList<Jadwal> arrJadwal;
    
    public modelcinema() throws SQLException {
        this.koneksi = new Koneksi();
        this.arrFilm = new ArrayList<>();
        this.arrJadwal = new ArrayList<>();
    }

    public ArrayList<Film> getDataFilm() throws SQLException {
        this.arrFilm.clear();
        ResultSet rs = this.koneksi.GetData("SELECT * FROM TIKET_07065 ORDER BY KODE_FILM ASC");
        while (rs.next()) {
            Film film = new Film();
            film.setKode_Film(rs.getInt("KODE_FILM"));
            film.setNama_Film(rs.getString("NAMA_FILM"));
            film.setGenre(rs.getString("GENRE"));
            film.setHarga(rs.getInt("HARGA"));
            this.arrFilm.add(film);
        }
        return this.arrFilm;
    }

    public ArrayList<Jadwal> getDataJadwal() throws SQLException {
        this.arrJadwal.clear();
        ResultSet rs = this.koneksi.GetData("SELECT * FROM JADWAL_07065 JOIN TIKET_07065 "
                + "ON JADWAL_07065.KODE_FILM = TIKET_07065.KODE_FILM "
                + "ORDER BY KODE_JADWAL ASC");
        while (rs.next()) {
            Film film = new Film();
            film.setKode_Film(rs.getInt("KODE_FILM"));
            film.setNama_Film(rs.getString("NAMA_FILM"));
            film.setGenre(rs.getString("GENRE"));
            film.setHarga(rs.getInt("HARGA"));
            
            Jadwal jadwal = new Jadwal();
            jadwal.setKode_Jadwal(rs.getInt("KODE_JADWAL"));
            jadwal.setfilm(film);
            jadwal.setTgl_Tayang(new Date(rs.getString("TGL_TAYANG")));
            jadwal.setWktu_Tayang(rs.getString("WKTU_TAYANG"));
            jadwal.setRuang(rs.getString("RUANG"));
            
            this.arrJadwal.add(jadwal);
        }
        return this.arrJadwal;
    }
        
    public void insertfilm(Film film) throws SQLException {
        
            this.koneksi.ManipulasiData("INSERT INTO TIKET_07065 VALUES(" + film.getKode_Film() + 
                    "," + "'" + film.getNama_Film() + "'" + "," + "'" + film.getGenre() + "'" + 
                    "," + film.getHarga().toString() + ")");
    }
    public void deletefilm(Integer i) throws SQLException {
        
            this.koneksi.ManipulasiData("DELETE FROM TIKET_07065 WHERE KODE_FILM = " + i);
    }
    public void updatefilm(Integer i, Integer x) throws SQLException {
        
            this.koneksi.ManipulasiData("UPDATE TIKET_07065 SET HARGA = " + x.toString()
                         + "WHERE KODE_FILM=" + i);
    }
    
    public void insertjdwl(Jadwal jdwl) throws SQLException {
            String tgl = new SimpleDateFormat("dd/MM/yyyy").format(jdwl.getTgl_Tayang());
            this.koneksi.ManipulasiData("INSERT INTO JADWAL_07065 VALUES(" + jdwl.getKode_Jadwal() + 
                    "," + jdwl.getFilm().getKode_Film() + 
                    ",TO_DATE('" + tgl + "','dd/MM/yyyy')," + "'" + jdwl.getWktu_Tayang() + "'" + 
                    "," + "'" + jdwl.getRuang() + "'" + ")");
    }
    public void deletejdwl(Integer i) throws SQLException {
        

        this.koneksi.ManipulasiData("DELETE FROM JADWAL_07065 WHERE KODE_JADWAL = " + i);
    }
    public void updatejdwl(Integer i, String x) throws SQLException {
        
            this.koneksi.ManipulasiData("UPDATE JADWAL_07065 SET WKTU_TAYANG = " + "'" + x.toString() + "'"
                         + "WHERE KODE_FILM=" + i);
    }

}
