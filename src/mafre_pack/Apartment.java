package mafre_pack;

/**
 * Created by mihkelm on 20/01/16.
 *
 */
public class Apartment {

    private String korteriNumber;
    private int tubadeArv;
    private double suurus;
    private double hind;
    private String olek;

    public Apartment() {
        this.korteriNumber = "";
        this.tubadeArv = 0;
        this.suurus = 0;
        this.hind = 0;
        this.olek = "Vaba";
    }

    public Apartment(String korteriNumber, int tubadeArv, double suurus, double hind, String olek) {
        this.korteriNumber = korteriNumber;
        this.tubadeArv = tubadeArv;
        this.suurus = suurus;
        this.hind = hind;
        this.olek = olek;
    }

    public String getKorteriNumber() {
        return korteriNumber;
    }

    public void setNumber(String korteriNumber) {
        this.korteriNumber = korteriNumber;
    }

    public int getTubadeArv() {
        return tubadeArv;
    }

    public void setTubadeArv(int tubadeArv) {
        this.tubadeArv = tubadeArv;
    }

    public double getSuurus() {
        return suurus;
    }

    public void setSuurus(double suurus) {
        this.suurus = suurus;
    }

    public double getHind() {
        return hind;
    }

    public void setHind(double hind) {
        this.hind = hind;
    }

    public String getOlek() {
        return olek;
    }

    public void setOlek(String olek) {
        this.olek = olek;
    }
}
