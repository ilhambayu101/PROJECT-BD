package entitas;

import java.util.ArrayList;

public class Transaksi {
    private Integer Kode_Tiket;
    private Register reg;
    private Integer Banyak;
    private ArrayList<Have>arrHave;
    private ArrayList<Pilih>arrPilih;
    
    
    public Integer getKode_Tiket(){
        return Kode_Tiket;
    }
    public void setKode_Tiket(Integer Kode_Tiket){
        this.Kode_Tiket=Kode_Tiket;
    }
    public Register getreg(){
        return reg;
    }
    public void setreg(Register reg){
        this.reg=reg;
    }
    public Integer getBanyak(){
        return Banyak;
    }
    public void setBanyak(Integer Banyak){
        this.Banyak=Banyak;
    }
    public void setarrHave(ArrayList<Have>arrHave){
        this.arrHave=arrHave;
    }
    public ArrayList<Have>getarrHave(){
        return arrHave;
    }
    public void setarrPilih(ArrayList<Pilih>arrPilih){
        this.arrPilih=arrPilih;
    }
    public ArrayList<Pilih>getarrPilih(){
        return arrPilih;
    }

}
