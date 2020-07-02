package entitas;

public class Film {
    private Integer Kode_Film;
    private String Nama_Film;
    private String Genre;
    private Integer Harga;
    
    public Integer getKode_Film(){
        return Kode_Film;
    }
    public void setKode_Film(Integer Kode_Film){
        this.Kode_Film=Kode_Film;
    }
    public String getNama_Film(){
        return Nama_Film;
    }
    public void setNama_Film(String Nama_Film){
        this.Nama_Film=Nama_Film;
    }
    public String getGenre(){
        return Genre;
    }
    public void setGenre(String Genre){
        this.Genre=Genre;
    }
    public Integer getHarga(){
        return Harga;
    }
    public void setHarga(Integer Harga){
        this.Harga=Harga;
    }
    
}
