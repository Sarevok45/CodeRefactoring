package com.bartoszwalter.students.taxes.umowa;

import com.bartoszwalter.students.taxes.config.Result;
import junit.framework.TestCase;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class UmowaZlecenieTest extends TestCase {

    UmowaZlecenie umowaZlecenie = null;
    public void setUp() throws Exception {
        super.setUp();
        umowaZlecenie = new UmowaZlecenie(new BigDecimal(4000));
    }

    public void testGetPodstawa() {
        assertEquals(umowaZlecenie.GetPodstawa(),new BigDecimal(4000));
    }

    public void testCalculateSkladkaEmeryt() {
        Result result = umowaZlecenie.Calculate();
        Double skladkaEmerytalna = result.getSkladkaEmerytalna();
        assertEquals(skladkaEmerytalna,new BigDecimal(390.4).setScale(1, RoundingMode.CEILING).doubleValue());
    }

    public void testCalculateSkladaRenta() {
        Result result = umowaZlecenie.Calculate();
        Double skladkaRentalna  = result.getSkladkaRentowa();
        assertEquals(skladkaRentalna, 60.0);
    }

    public void testCalculateChorobwe() {
        Result result = umowaZlecenie.Calculate();
        Double chorobowe  = new BigDecimal(result.getUbezpieczenieChorobowe()).setScale(1,RoundingMode.FLOOR).doubleValue();
        assertEquals(chorobowe, 98.0);
    }

    public void testCalculateZdrowotne() {
        Result result = umowaZlecenie.Calculate();
        Double zdrowotne1 = new BigDecimal(result.getUbezpieczenieZdrowotne1()).setScale(2, RoundingMode.FLOOR).doubleValue();
        Double zdrowotne2 = new BigDecimal(result.getUbezpieczenieZdrowotne2()).setScale(2, RoundingMode.FLOOR).doubleValue();

        assertEquals(zdrowotne1, 310.64);
        assertEquals(zdrowotne2,267.49);
    }

    public void testCalculateUzyskaniePrzychodu() {
        Result result = umowaZlecenie.Calculate();
        Double uzyskanie = result.getKosztyUzyskania();

        assertEquals(uzyskanie, 690.32);
    }

    public void testCalculateOpodatkowanie() {
        Result result  = umowaZlecenie.Calculate();
        Double opodatkowanie = new BigDecimal(result.getPodstawaOpodatkowana()).setScale(2,RoundingMode.FLOOR).doubleValue();

        assertEquals(opodatkowanie, 2761.27);
    }

    public void testCalculateZaliczka() {
        Result result = umowaZlecenie.Calculate();
        Double zaliczka = new BigDecimal(result.getZaliczkaNaPodatekDochodowy()).setScale(2,RoundingMode.FLOOR).doubleValue();

        assertEquals(zaliczka,497.03);
    }

    public void testCaluclateKwotaWolna() {
        Result result = umowaZlecenie.Calculate();
        Double kwotaWolna = result.getKwotaWolnaOdPodatku();

        assertEquals(kwotaWolna, 0.0);
    }

    public void testCalculatePodatek() {
        Result result = umowaZlecenie.Calculate();
        Double podatek  = new BigDecimal(result.getPodatekPotracony()).setScale(2,RoundingMode.FLOOR).doubleValue();

        assertEquals(podatek,497.03);
    }

    public void testCalculateZaliczkaUS() {
        Result result = umowaZlecenie.Calculate();
        Double zaliczkaUS = new BigDecimal(result.getZaliczkaDoUrzedu()).setScale(2,RoundingMode.FLOOR).doubleValue() ;

        assertEquals(zaliczkaUS,229.53);
    }

    public void testCalculateWynagrodzenie() {
        Result result = umowaZlecenie.Calculate();
        Double wynagrodzenie = new BigDecimal(result.getWynagrodzenieNetto()).setScale(2,RoundingMode.FLOOR).doubleValue();
        assertEquals(wynagrodzenie, 2911.42);
    }

}