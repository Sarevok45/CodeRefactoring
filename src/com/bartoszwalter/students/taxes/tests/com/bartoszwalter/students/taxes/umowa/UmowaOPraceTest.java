package com.bartoszwalter.students.taxes.umowa;

import com.bartoszwalter.students.taxes.config.Result;
import com.bartoszwalter.students.taxes.umowa.UmowaOPrace;
import junit.framework.TestCase;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class UmowaOPraceTest extends TestCase {

    UmowaOPrace umowaOPrace = null;
    public void setUp() throws Exception {
        super.setUp();
        umowaOPrace = new UmowaOPrace(new BigDecimal(4000));
    }

    public void testGetPodstawa() {
        assertEquals(umowaOPrace.GetPodstawa(), new BigDecimal(4000));
    }

    public void testCalculateSkladkaEmeryt() {
        Result  result = umowaOPrace.Calculate();
        Double skladkaEmerytalna = result.getSkladkaEmerytalna();
        assertEquals(skladkaEmerytalna,new BigDecimal(390.4).setScale(1, RoundingMode.CEILING).doubleValue());
    }

    public void testCalculateSkladaRenta() {
        Result result = umowaOPrace.Calculate();
        Double skladkaRentalna  = result.getSkladkaRentowa();
        assertEquals(skladkaRentalna, 60.0);
    }

    public void testCalculateChorobwe() {
        Result result = umowaOPrace.Calculate();
        Double chorobowe  = new BigDecimal(result.getUbezpieczenieChorobowe()).setScale(1,RoundingMode.FLOOR).doubleValue();
        assertEquals(chorobowe, 98.0);
    }

    public void testCalculateZdrowotne() {
        Result result = umowaOPrace.Calculate();
        Double zdrowotne1 = new BigDecimal(result.getUbezpieczenieZdrowotne1()).setScale(2, RoundingMode.FLOOR).doubleValue();
        Double zdrowotne2 = new BigDecimal(result.getUbezpieczenieZdrowotne2()).setScale(2, RoundingMode.FLOOR).doubleValue();

        assertEquals(zdrowotne1, 310.64);
        assertEquals(zdrowotne2,267.49);
    }

    public void testCalculateUzyskaniePrzychodu() {
        Result result = umowaOPrace.Calculate();
        Double uzyskanie = result.getKosztyUzyskania();

        assertEquals(uzyskanie, 111.25);
    }

    public void testCalculateOpodatkowanie() {
        Result result  = umowaOPrace.Calculate();
        Double opodatkowanie = result.getPodstawaOpodatkowana();

        assertEquals(opodatkowanie, 3340.35);
    }

    public void testCalculateZaliczka() {
        Result result = umowaOPrace.Calculate();
        Double zaliczka = new BigDecimal(result.getZaliczkaNaPodatekDochodowy()).setScale(2,RoundingMode.FLOOR).doubleValue();

        assertEquals(zaliczka,601.26);
    }

    public void testCaluclateKwotaWolna() {
        Result result = umowaOPrace.Calculate();
        Double kwotaWolna = result.getKwotaWolnaOdPodatku();

        assertEquals(kwotaWolna, 46.33);
    }

    public void testCalculatePodatek() {
        Result result = umowaOPrace.Calculate();
        Double podatek  = new BigDecimal(result.getPodatekPotracony()).setScale(2,RoundingMode.FLOOR).doubleValue();

        assertEquals(podatek,554.93);
    }

    public void testCalculateZaliczkaUS() {
        Result result = umowaOPrace.Calculate();
        Double zaliczkaUS = new BigDecimal(result.getZaliczkaDoUrzedu()).setScale(2,RoundingMode.FLOOR).doubleValue() ;

        assertEquals(zaliczkaUS,287.43);
    }

    public void testCalculateWynagrodzenie() {
        Result result = umowaOPrace.Calculate();
        Double wynagrodzenie = new BigDecimal(result.getWynagrodzenieNetto()).setScale(2,RoundingMode.FLOOR).doubleValue();
        assertEquals(wynagrodzenie, 2853.52);
    }
}