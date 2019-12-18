package com.example.minimo2dsaexample;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Element {

    @SerializedName("punt_id")
    @Expose
    private String puntId;

    @SerializedName("adress_name")
    @Expose
    private String adrecaNom;

    @SerializedName("descrip")
    @Expose
    private String descrip;

    @SerializedName("image")
    @Expose
    private List<String> image=null ;

    @SerializedName("grupadreca")
    @Expose
    private GrupAdreca grupadreca;

    @SerializedName("url_general")
    @Expose
    private String urlGeneral;

    @SerializedName("email")
    @Expose
    private List<String> email=null;



    public String getPuntId() {
        return puntId;
    }

    public void setPuntId(String puntId) {
        this.puntId = puntId;
    }

    public String getAdrecaNom() {
        return adrecaNom;
    }

    public void setAdrecaNom(String adrecaNom) {
        this.adrecaNom = adrecaNom;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public List<String> getImage() {
        return image;
    }

    public void setImage(List<String> image) {
        this.image = image;
    }

    public GrupAdreca getGrupadreca() {
        return grupadreca;
    }

    public void setGrupadreca(GrupAdreca grupadreca) {
        this.grupadreca = grupadreca;
    }

    public String getUrlGeneral() {
        return urlGeneral;
    }

    public void setUrlGeneral(String urlGeneral) {
        this.urlGeneral = urlGeneral;
    }

    public List<String> getEmail() {
        return email;
    }

    public void setEmail(List<String> email) {
        this.email = email;
    }
}
