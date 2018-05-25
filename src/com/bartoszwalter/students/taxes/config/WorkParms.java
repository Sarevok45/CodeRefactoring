package com.bartoszwalter.students.taxes.config;

import java.math.BigDecimal;

public class WorkParms {
    private BigDecimal Podstawa;
    private ContractType TypUmowy;

    private double ProcentSkladkaEmerytura = 9.76;
    private double ProcentSkladkaRenta = 1.5;
    private double ProcentSkladkaZdrowotne = 2.45;

    public WorkParms() {
        Podstawa = new BigDecimal(0);
        TypUmowy = ContractType.UMOWA_O_PRACE;
    }

    public WorkParms(String podstawa, ContractType typUmowy) {
        Podstawa = new BigDecimal(podstawa);
        TypUmowy = typUmowy;
    }

    public WorkParms(double podstawa, ContractType typUmowy) {
        Podstawa = new BigDecimal(podstawa);
        TypUmowy = typUmowy;
    }


    public WorkParms(BigDecimal podstawa, ContractType typUmowy) {
        Podstawa = podstawa;
        TypUmowy = typUmowy;
    }


    public WorkParms(BigDecimal podstawa, ContractType typUmowy, double procentSkladkaEmerytura, double procentSkladkaRenta, double procentSkladkaZdrowotne) {
        Podstawa = podstawa;
        TypUmowy = typUmowy;
        ProcentSkladkaEmerytura = procentSkladkaEmerytura;
        ProcentSkladkaRenta = procentSkladkaRenta;
        ProcentSkladkaZdrowotne = procentSkladkaZdrowotne;
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
    

    public ContractType getTypUmowy() {
        return TypUmowy;
    }

    public void setTypUmowy(ContractType typUmowy) {
        TypUmowy = typUmowy;
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
}
