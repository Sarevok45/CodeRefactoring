package com.bartoszwalter.students.taxes.config;

import java.math.BigDecimal;

public class WorkParms {
    private BigDecimal Podstawa;

    private double ProcentSkladkaEmerytura = 9.76;
    private double ProcentSkladkaRenta = 1.5;
    private double ProcentSkladkaZdrowotne = 2.45;
    private double kosztyUzyskania;
    private double kwotaZmiejsz;

    public WorkParms() {
        Podstawa = new BigDecimal(0);
    }

    public WorkParms(String podstawa) {
        Podstawa = new BigDecimal(podstawa);
    }

    public WorkParms(double podstawa) {
        Podstawa = new BigDecimal(podstawa);
    }


    public WorkParms(BigDecimal podstawa) {
        Podstawa = podstawa;
    }

    public WorkParms(BigDecimal podstawa, double procentSkladkaEmerytura, double procentSkladkaRenta, double procentSkladkaZdrowotne, double kosztyUzyskania, double kwotaZmiejsz) {
        Podstawa = podstawa;
        ProcentSkladkaEmerytura = procentSkladkaEmerytura;
        ProcentSkladkaRenta = procentSkladkaRenta;
        ProcentSkladkaZdrowotne = procentSkladkaZdrowotne;
        this.kosztyUzyskania = kosztyUzyskania;
        this.kwotaZmiejsz = kwotaZmiejsz;
    }


    public BigDecimal getPodstawa() {
        return Podstawa;
    }


    public void setPodstawa(BigDecimal podstawa) {
        Podstawa = podstawa;
    }

    public void setPodstawa(String podstawa) {
        Podstawa = new BigDecimal(podstawa);
    }

    public void setPodstawa(double podstawa) {
        Podstawa = new BigDecimal(podstawa);
    }


    public double getProcentSkladkaEmerytura() {
        return ProcentSkladkaEmerytura;
    }

    public void setProcentSkladkaEmerytura(double procentSkladkaEmerytura) {
        ProcentSkladkaEmerytura = procentSkladkaEmerytura;
    }

    public double getProcentSkladkaRenta() {
        return ProcentSkladkaRenta;
    }

    public void setProcentSkladkaRenta(double procentSkladkaRenta) {
        ProcentSkladkaRenta = procentSkladkaRenta;
    }

    public double getProcentSkladkaZdrowotne() {
        return ProcentSkladkaZdrowotne;
    }

    public void setProcentSkladkaZdrowotne(double procentSkladkaZdrowotne) {
        ProcentSkladkaZdrowotne = procentSkladkaZdrowotne;
    }

    public double getKosztyUzyskania() {
        return kosztyUzyskania;
    }

    public void setKosztyUzyskania(double kosztyUzyskania) {
        this.kosztyUzyskania = kosztyUzyskania;
    }

    public double getKwotaZmiejsz() {
        return kwotaZmiejsz;
    }

    public void setKwotaZmiejsz(double kwotaZmiejsz) {
        this.kwotaZmiejsz = kwotaZmiejsz;
    }
}
