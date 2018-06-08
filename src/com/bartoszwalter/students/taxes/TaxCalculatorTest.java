package com.bartoszwalter.students.taxes;

import com.bartoszwalter.students.taxes.config.ContractType;
import com.bartoszwalter.students.taxes.config.WorkParms;
import junit.framework.TestCase;

public class TaxCalculatorTest extends TestCase {



    public void testUstawParametry() {
        TaxCalculator.ustawParametry(4000.0,'P');
        assertEquals(TaxCalculator.workParms.getPodstawa().doubleValue(),4000.0);
        assertEquals(TaxCalculator.workParms.getTypUmowy(), ContractType.UMOWA_O_PRACE);

    }

    public void testObliczonaPodstawa() {
    }
}