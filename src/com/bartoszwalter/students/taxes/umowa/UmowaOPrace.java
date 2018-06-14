package com.bartoszwalter.students.taxes.umowa;

import com.bartoszwalter.students.taxes.config.Result;
import com.bartoszwalter.students.taxes.config.WorkParms;

import java.math.BigDecimal;

public class UmowaOPrace extends Umowa {
    public UmowaOPrace() {
        parms.setProcentSkladkaEmerytura(9.76);
        parms.setProcentSkladkaRenta(1.5);
        parms.setProcentSkladkaZdrowotne(2.45);
        parms.setKwotaZmiejsz(46.33);
        parms.setKosztyUzyskania(111.25);
    }

    public UmowaOPrace(BigDecimal podstawa) {
        this();
        parms.setPodstawa(podstawa);
    }


    public UmowaOPrace(WorkParms parms) {
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

        result.setPodstawaOpodatkowana(podstawa_ubezpieczenie - parms.getKosztyUzyskania() );
        result.setKosztyUzyskania(parms.getKosztyUzyskania() );

        result.setZaliczkaNaPodatekDochodowy( (result.getPodstawaOpodatkowana() * 18) / 100 );
        result.setKwotaWolnaOdPodatku( parms.getKwotaZmiejsz() );
        result.setPodatekPotracony(result.getZaliczkaNaPodatekDochodowy() - parms.getKwotaZmiejsz() );
        result.setZaliczkaDoUrzedu(result.getZaliczkaNaPodatekDochodowy() - result.getUbezpieczenieZdrowotne2() - parms.getKwotaZmiejsz() );

        result.setWynagrodzenieNetto(podstawa - ( result.getSkladkaEmerytalna() + result.getSkladkaRentowa() + result.getUbezpieczenieChorobowe() + result.getUbezpieczenieZdrowotne1() + result.getZaliczkaDoUrzedu() ) );

        return result;

    }

}
