package com.bartoszwalter.students.taxes.umowa;

import com.bartoszwalter.students.taxes.config.Result;
import com.bartoszwalter.students.taxes.config.WorkParms;
import com.bartoszwalter.students.taxes.umowa.Umowa;

import java.math.BigDecimal;

public class UmowaZlecenie extends Umowa {
    public UmowaZlecenie() {
        parms.setProcentSkladkaEmerytura(9.76);
        parms.setProcentSkladkaRenta(1.5);
        parms.setProcentSkladkaZdrowotne(2.45);
        parms.setKwotaZmiejsz(0);
    }

    public UmowaZlecenie(BigDecimal podstawa) {
        this();
        parms.setPodstawa(podstawa);
    }


    public UmowaZlecenie(WorkParms parms) {
        super(parms);
    }

    public BigDecimal GetPodstawa() {
        return parms.getPodstawa();
    }

    public void SetPodstawa(BigDecimal podstawa) {
        parms.setPodstawa(podstawa);
    }

    public Result Calculate() {
        Result result = new Result();
        double podstawa = parms.getPodstawa().doubleValue();

        result.setSkladkaEmerytalna((podstawa * parms.getProcentSkladkaEmerytura() ) / 100 );
        result.setSkladkaRentowa( (podstawa * parms.getProcentSkladkaRenta() ) / 100 );
        result.setUbezpieczenieChorobowe( (podstawa * parms.getProcentSkladkaZdrowotne()) / 100 );

        result.setPodstawaUbezpieczenieZdrowotne(podstawa - result.getSkladkaEmerytalna() - result.getSkladkaRentowa() - result.getUbezpieczenieChorobowe() );

        double podstawa_ubezpieczenie = result.getPodstawaUbezpieczenieZdrowotne();

        result.setUbezpieczenieZdrowotne1( (podstawa_ubezpieczenie * 9) / 100 );
        result.setUbezpieczenieZdrowotne2( (podstawa_ubezpieczenie * 7.75) / 100);
        result.setKosztyUzyskania( (podstawa_ubezpieczenie * 20) / 100 );

        result.setPodstawaOpodatkowana(podstawa_ubezpieczenie - result.getKosztyUzyskania() );

        result.setZaliczkaNaPodatekDochodowy( (result.getPodstawaOpodatkowana() * 18) / 100 );
        result.setKwotaWolnaOdPodatku( parms.getKwotaZmiejsz() );
        result.setPodatekPotracony(result.getZaliczkaNaPodatekDochodowy() );
        result.setZaliczkaDoUrzedu(result.getZaliczkaNaPodatekDochodowy() - result.getUbezpieczenieZdrowotne2() - parms.getKwotaZmiejsz() );

        result.setWynagrodzenieNetto(podstawa - ( result.getSkladkaEmerytalna() + result.getSkladkaRentowa() + result.getUbezpieczenieChorobowe() + result.getUbezpieczenieZdrowotne1() + result.getZaliczkaDoUrzedu() ) );

        return result;

    }
}
