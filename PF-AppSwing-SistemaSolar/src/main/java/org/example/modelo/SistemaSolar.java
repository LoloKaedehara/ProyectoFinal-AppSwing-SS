package org.example.modelo;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class SistemaSolar {
    private Integer ID;
    private String Planeta;
    private String Luna;
    private String Colores;
    private Integer DiasOrbitales;
    private String URLimagen;

    public SistemaSolar() {
    }

    public SistemaSolar(Integer ID, String planeta, String luna, String colores, int diasOrbitales, String URLimagen) {
        this.ID = ID;
        Planeta = planeta;
        Luna = luna;
        Colores = colores;
        DiasOrbitales = diasOrbitales;
        this.URLimagen = URLimagen;
    }
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }
    public String getPlaneta() {
        return Planeta;
    }

    public void setPlaneta(String planeta) {
        Planeta = planeta;
    }

    public String getLuna() {
        return Luna;
    }

    public void setLuna(String luna) {
        Luna = luna;
    }

    public String getColores() {
        return Colores;
    }

    public void setColores(String colores) {
        Colores = colores;
    }
    public int getDiasOrbitales() {
        return DiasOrbitales;
    }

    public void setDiasOrbitales(Integer diasOrbitales) {
        DiasOrbitales = diasOrbitales;
    }
    public String getURLimagen() {
        return URLimagen;
    }

    public void setURLimagen(String URLimagen) {
        this.URLimagen = URLimagen;
    }

    @Override
    public String toString() {
        return "ModeloSistemaSolar{" +
                "ID=" + ID +
                ", Planeta='" + Planeta + '\'' +
                ", Luna='" + Luna + '\'' +
                ", Colores='" + Colores + '\'' +
                ", DiasOrbitales=" + DiasOrbitales +
                ", URLimagen='" + URLimagen + '\'' +
                '}';
    }

    public ImageIcon getImagen()throws MalformedURLException {
        URL urlImagen = new URL(this.URLimagen);
        return new ImageIcon(urlImagen);
    }
}
