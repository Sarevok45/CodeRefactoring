package com.bartoszwalter.students.taxes;

import com.bartoszwalter.students.taxes.output.SendToOutput;
import com.bartoszwalter.students.taxes.umowa.UmowaOPrace;
import com.bartoszwalter.students.taxes.umowa.UmowaZlecenie;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Application {
    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader input = new BufferedReader(isr);

        SendToOutput output = new SendToOutput(System.out);

        System.out.println("Podaj kwotę dochodu: ");
        try {
            double kwota = Double.parseDouble(input.readLine());
            System.out.print("Typ umowy: (P)raca, (Z)lecenie: ");
            char typ = input.readLine().charAt(0);

            if (typ == 'P') {
                UmowaOPrace uop = new UmowaOPrace(new BigDecimal(kwota));
                output.Send(uop.Calculate());
            } else {
                UmowaZlecenie uz = new UmowaZlecenie(new BigDecimal(kwota));
                output.Send(uz.Calculate());
            }

        } catch (Exception e) {
            System.err.println("Błąd odczytu");
        }


    }
}
