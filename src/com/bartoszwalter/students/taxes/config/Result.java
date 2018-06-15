package com.bartoszwalter.students.taxes.config;

import java.text.NumberFormat;

public class Result {
    private double skladkaEmerytalna;
    private double skladkaRentowa;
    private double ubezpieczenieChorobowe;
    private double podstawaUbezpieczenieZdrowotne;

    private double ubezpieczenieZdrowotne1;
    private double ubezpieczenieZdrowotne2;

    private double kosztyUzyskania;
    private double podstawaOpodatkowana;

    private double zaliczkaNaPodatekDochodowy;
    private double kwotaWolnaOdPodatku;
    private double podatekPotracony;
    private double zaliczkaDoUrzedu;

    private double wynagrodzenieNetto;


    public Result() {
    }


    public Result(double skladkaEmerytalna, double skladkaRentowa, double ubezpieczenieChorobowe, double podstawaUbezpieczenieZdrowotne, double ubezpieczenieZdrowotne1, double ubezpieczenieZdrowotne2, double kosztyUzyskania, double podstawaOpodatkowana, double zaliczkaNaPodatekDochodowy, double kwotaWolnaOdPodatku, double podatekPotracony, double zaliczkaDoUrzedu, double wynagrodzenieNetto) {
        this.skladkaEmerytalna = skladkaEmerytalna;
        this.skladkaRentowa = skladkaRentowa;
        this.ubezpieczenieChorobowe = ubezpieczenieChorobowe;
        this.podstawaUbezpieczenieZdrowotne = podstawaUbezpieczenieZdrowotne;
        this.ubezpieczenieZdrowotne1 = ubezpieczenieZdrowotne1;
        this.ubezpieczenieZdrowotne2 = ubezpieczenieZdrowotne2;
        this.kosztyUzyskania = kosztyUzyskania;
        this.podstawaOpodatkowana = podstawaOpodatkowana;
        this.zaliczkaNaPodatekDochodowy = zaliczkaNaPodatekDochodowy;
        this.kwotaWolnaOdPodatku = kwotaWolnaOdPodatku;
        this.podatekPotracony = podatekPotracony;
        this.zaliczkaDoUrzedu = zaliczkaDoUrzedu;
        this.wynagrodzenieNetto = wynagrodzenieNetto;
    }



    public double getSkladkaEmerytalna() {
        return skladkaEmerytalna;
    }

    public void setSkladkaEmerytalna(double skladkaEmerytalna) {
        this.skladkaEmerytalna = skladkaEmerytalna;
    }

    public double getSkladkaRentowa() {
        return skladkaRentowa;
    }

    public void setSkladkaRentowa(double skladkaRentowa) {
        this.skladkaRentowa = skladkaRentowa;
    }

    public double getUbezpieczenieChorobowe() {
        return ubezpieczenieChorobowe;
    }

    public void setUbezpieczenieChorobowe(double ubezpieczenieChorobowe) {
        this.ubezpieczenieChorobowe = ubezpieczenieChorobowe;
    }

    public double getPodstawaUbezpieczenieZdrowotne() {
        return podstawaUbezpieczenieZdrowotne;
    }

    public void setPodstawaUbezpieczenieZdrowotne(double podstawaUbezpieczenieZdrowotne) {
        this.podstawaUbezpieczenieZdrowotne = podstawaUbezpieczenieZdrowotne;
    }

    public double getUbezpieczenieZdrowotne1() {
        return ubezpieczenieZdrowotne1;
    }

    public void setUbezpieczenieZdrowotne1(double ubezpieczenieZdrowotne1) {
        this.ubezpieczenieZdrowotne1 = ubezpieczenieZdrowotne1;
    }

    public double getUbezpieczenieZdrowotne2() {
        return ubezpieczenieZdrowotne2;
    }

    public void setUbezpieczenieZdrowotne2(double ubezpieczenieZdrowotne2) {
        this.ubezpieczenieZdrowotne2 = ubezpieczenieZdrowotne2;
    }

    public double getKosztyUzyskania() {
        return kosztyUzyskania;
    }

    public void setKosztyUzyskania(double kosztyUzyskania) {
        this.kosztyUzyskania = kosztyUzyskania;
    }

    public double getPodstawaOpodatkowana() {
        return podstawaOpodatkowana;
    }

    public void setPodstawaOpodatkowana(double podstawaOpodatkowana) {
        this.podstawaOpodatkowana = podstawaOpodatkowana;
    }

    public double getZaliczkaNaPodatekDochodowy() {
        return zaliczkaNaPodatekDochodowy;
    }

    public void setZaliczkaNaPodatekDochodowy(double zaliczkaNaPodatekDochodowy) {
        this.zaliczkaNaPodatekDochodowy = zaliczkaNaPodatekDochodowy;
    }

    public double getKwotaWolnaOdPodatku() {
        return kwotaWolnaOdPodatku;
    }

    public void setKwotaWolnaOdPodatku(double kwotaWolnaOdPodatku) {
        this.kwotaWolnaOdPodatku = kwotaWolnaOdPodatku;
    }

    public double getPodatekPotracony() {
        return podatekPotracony;
    }

    public void setPodatekPotracony(double podatekPotracony) {
        this.podatekPotracony = podatekPotracony;
    }

    public double getZaliczkaDoUrzedu() {
        return zaliczkaDoUrzedu;
    }

    public void setZaliczkaDoUrzedu(double zaliczkaDoUrzedu) {
        this.zaliczkaDoUrzedu = zaliczkaDoUrzedu;
    }

    public double getWynagrodzenieNetto() {
        return wynagrodzenieNetto;
    }

    public void setWynagrodzenieNetto(double wynagrodzenieNetto) {
        this.wynagrodzenieNetto = wynagrodzenieNetto;
    }


    @Override
    public String toString() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        return
                "Składka na ubezpieczenie emerytalne = " + formatter.format(skladkaEmerytalna) +
                "\n Składka na ubezpieczenie rentowe =" + formatter.format(skladkaRentowa) +
                "\n Składka na ubezpieczenie chorobowe =" + formatter.format(ubezpieczenieChorobowe) +
                "\n Podstawa wymiaru składki na ubezpieczenie zdrowotne =" + formatter.format(podstawaUbezpieczenieZdrowotne) +
                "\n Składka na ubezpieczenie zdrowotne: 9% =" + formatter.format(ubezpieczenieZdrowotne1) +
                "\n Składka na ubezpieczenie zdrowotne: 7.75% =" + formatter.format(ubezpieczenieZdrowotne2) +
                "\n Koszty uzyskania przychodu w stałej wysokości =" + formatter.format(kosztyUzyskania) +
                "\n Podstawa opodatkowania =" + formatter.format(podstawaOpodatkowana) +
                "\n Zaliczka na podatek dochodowy 18% =" + formatter.format(zaliczkaNaPodatekDochodowy) +
                "\n Kwota wolna od podatku =" + formatter.format(kwotaWolnaOdPodatku) +
                "\n Podatek potrącony =" + formatter.format(podatekPotracony) +
                "\n Zaliczka do urzędu skarbowego =" + formatter.format(zaliczkaDoUrzedu) +
                "\n Pracownik otrzyma wynagrodzenie netto w wysokości =" + formatter.format(wynagrodzenieNetto) +
                '\n';
    }
}
