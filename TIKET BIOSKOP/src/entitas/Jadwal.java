package entitas;

import java.util.Date;

public class Jadwal {
    private Integer Kode_Jadwal;
    private Film film;
    private Date Tgl_Tayang;
    private String Wktu_Tayang;
    private String Ruang;
    
    public Integer getKode_Jadwal(){
        return Kode_Jadwal;
    }
    public void setKode_Jadwal(Integer Kode_Jadwal){
        this.Kode_Jadwal=Kode_Jadwal;
    }
    public Film getFilm(){
        return film;
    }
    public void setfilm(Film film){
        this.film=film;
    }
    public Date getTgl_Tayang(){
        return Tgl_Tayang;
    }
    public void setTgl_Tayang(Date Tgl_Tayang){
        this.Tgl_Tayang=Tgl_Tayang;
    }
    public String getWktu_Tayang(){
        return Wktu_Tayang;
    }
    public void setWktu_Tayang(String Wktu_Tayang){
        this.Wktu_Tayang=Wktu_Tayang;
    }
    public String getRuang(){
        return Ruang;
    }
    public void setRuang(String Ruang){
        this.Ruang=Ruang;
    }

}
