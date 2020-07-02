package entitas;

import java.util.ArrayList;

public class Register {
    private Integer Kode_Reg;
    private Pembeli pembeli;
    private String Username;
    private String Password;
    
    public Integer getKode_Reg(){
        return Kode_Reg;
    }
    public void setKode_Reg(Integer Kode_Reg){
        this.Kode_Reg=Kode_Reg;
    }
    public Pembeli getpembeli(){
        return pembeli;
    }
    public void setpembeli(Pembeli pembeli){
        this.pembeli=pembeli;
    }
    public String getUsername(){
        return Username;
    }
    public void setUsername(String Username){
        this.Username=Username;
    }
    public String getPassword(){
        return Password;
    }
    public void setPassword(String Password){
        this.Password=Password;
    }

}
