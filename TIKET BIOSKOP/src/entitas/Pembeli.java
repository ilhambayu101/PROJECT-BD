package entitas;
public class Pembeli {
    private Integer Id;
    private Register register;
    public String Nama;
    private String Alamat;
    private Integer Telp;
    private String Gender;
    
    public Integer getId(){
        return Id;
    }
    public void setId(Integer Id){
        this.Id=Id;
    }
    public Register getregister(){
        return register;
    }
    public void setregister(Register register){
        this.register=register;
    }
    public String getNama(){
        return Nama;
    }
    public void setNama(String Nama){
        this.Nama=Nama;
    }
    public String getAlamat(){
        return Alamat;
    }
    public void setAlamat(String Alamat){
        this.Alamat=Alamat;
    }
    public Integer getTelp(){
        return Telp;
    }
    public void setTelp(Integer Telp){
        this.Telp=Telp;
    }      
    public String getGender(){
        return Gender;
    }
    public void setGender(String Gender){
        this.Gender=Gender;
    }
    
}
