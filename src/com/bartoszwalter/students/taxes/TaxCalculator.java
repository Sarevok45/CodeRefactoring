package com.bartoszwalter.students.taxes;

import com.bartoszwalter.students.taxes.config.ContractType;
import com.bartoszwalter.students.taxes.config.WorkParms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class TaxCalculator {
	
	//public static double podstawa = 0;
	//public static char umowa = ' ';
	// składki na ubezpieczenia społeczne
	public static double skladkaEmerytalna = 0; // 9,76% podstawyy
	public static double skladkaRentowa = 0; // 1,5% podstawy
	public static double ubezpieczenieChorobowe = 0; // 2,45% podstawy
	// składki na ubezpieczenia zdrowotne
	public static double kosztyUzyskania = 111.25; 
	public static double skladkaZdrowotna1 = 0; // od podstawy wymiaru 9%
	public static double skladkaZdrowotna2 = 0; // od podstawy wymiaru 7,75 %
	public static double zaliczkaNaPod = 0; // zaliczka na podatek dochodowy 18%
	public static double kwotaZmiejsz = 46.33; // kwota zmienjszająca podatek 46,33 PLN
	public static double zaliczkaUS = 0;
	public static WorkParms workParms = new WorkParms();
	public static double zaliczkaUS0 = 0;

	public static void main(String[] args) {
		try {

			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader kwotaDochodu = new BufferedReader(isr);
			
			System.out.print("Podaj kwotę dochodu: ");
			double kwota = Double.parseDouble(kwotaDochodu.readLine());
			
			System.out.print("Typ umowy: (P)raca, (Z)lecenie: ");
			char typ = kwotaDochodu.readLine().charAt(0);

			ustawParametry(kwota, typ);
		} catch (Exception ex) {
			System.out.println("Błędna kwota");
			System.err.println(ex);
			return;
		}
		
		DecimalFormat df00 = new DecimalFormat("#.00");
		DecimalFormat df = new DecimalFormat("#");
		
		if (workParms.getTypUmowy() == ContractType.UMOWA_O_PRACE) {
			System.out.println("UMOWA O PRACĘ");
			System.out.println("Podstawa wymiaru składek " + workParms.getPodstawa());
			double oPodstawa = obliczonaPodstawa(workParms.getPodstawa().doubleValue());
			System.out.println("Składka na ubezpieczenie emerytalne " + skladkaEmerytalna);
					/*+ df00.format(skladkaEmerytalna));*/
			System.out.println("Składka na ubezpieczenie rentowe " + skladkaRentowa);
//					+ df00.format(skladkaRentowa));
			System.out.println("Składka na ubezpieczenie chorobowe " + ubezpieczenieChorobowe);
//					+ df00.format(ubezpieczenieChorobowe));
			System.out.println("Podstawa wymiaru składki na ubezpieczenie zdrowotne: "
							+ oPodstawa);
			obliczUbezpieczenia(oPodstawa);
			System.out.println("Składka na ubezpieczenie zdrowotne: 9% = " + skladkaZdrowotna1
					/*+ df00.format(skladkaZdrowotna1)*/ + " 7,75% = " + skladkaZdrowotna2 /*+ df00.format(skladkaZdrowotna2)*/);
			System.out.println("Koszty uzyskania przychodu w stałej wysokości "
					+ kosztyUzyskania);
			double podstawaOpodat = oPodstawa - kosztyUzyskania;
			double podstawaOpodat0 = Double
					.parseDouble(df.format(podstawaOpodat));
			System.out.println("Podstawa opodatkowania " + podstawaOpodat
					+ " zaokrąglona " + df.format(podstawaOpodat0));
			obliczPodatek(podstawaOpodat0);
			System.out.println("Zaliczka na podatek dochodowy 18 % = "
					+ zaliczkaNaPod);
			System.out.println("Kwota wolna od podatku = " + kwotaZmiejsz);
			double podatekPotracony = zaliczkaNaPod - kwotaZmiejsz;
			System.out.println("Podatek potrącony = "
					+ df00.format(podatekPotracony));
			obliczZaliczke();
			zaliczkaUS0 = Double.parseDouble(df.format(zaliczkaUS));
			System.out.println("Zaliczka do urzędu skarbowego = "
					+ df00.format(zaliczkaUS) + " po zaokrągleniu = "
					+ df.format(zaliczkaUS0));
			double wynagrodzenie = workParms.getPodstawa().doubleValue()
					- ((skladkaEmerytalna + skladkaRentowa + ubezpieczenieChorobowe) + skladkaZdrowotna1 + zaliczkaUS0);
			System.out.println();
			System.out
					.println("Pracownik otrzyma wynagrodzenie netto w wysokości = "
							+ df00.format(wynagrodzenie));
		} else if (workParms.getTypUmowy() == ContractType.UMOWA_ZLECENIE) {
			System.out.println("UMOWA-ZLECENIE");
			System.out.println("Podstawa wymiaru składek " + workParms.getPodstawa().doubleValue());
			double oPodstawa = obliczonaPodstawa(workParms.getPodstawa().doubleValue());
			System.out.println("Składka na ubezpieczenie emerytalne "
					+ df00.format(skladkaEmerytalna));
			System.out.println("Składka na ubezpieczenie rentowe    "
					+ df00.format(skladkaRentowa));
			System.out.println("Składka na ubezpieczenie chorobowe  "
					+ df00.format(ubezpieczenieChorobowe));
			System.out.println("Podstawa wymiaru składki na ubezpieczenie zdrowotne: "
							+ oPodstawa);
			obliczUbezpieczenia(oPodstawa);
			System.out.println("Składka na ubezpieczenie zdrowotne: 9% = "
					+ df00.format(skladkaZdrowotna1) + " 7,75% = " + df00.format(skladkaZdrowotna2));
			kwotaZmiejsz = 0;
			kosztyUzyskania = (oPodstawa * 20) / 100;
			System.out.println("Koszty uzyskania przychodu (stałe) "
					+ kosztyUzyskania);
			double podstawaOpodat = oPodstawa - kosztyUzyskania;
			double podstawaOpodat0 = Double.parseDouble(df.format(podstawaOpodat));
			System.out.println("Podstawa opodatkowania " + podstawaOpodat
					+ " zaokrąglona " + df.format(podstawaOpodat0));
			obliczPodatek(podstawaOpodat0);
			System.out.println("Zaliczka na podatek dochodowy 18 % = "
					+ zaliczkaNaPod);
			double podatekPotracony = zaliczkaNaPod;
			System.out.println("Podatek potrącony = "
					+ df00.format(podatekPotracony));
			obliczZaliczke();
			zaliczkaUS0 = Double.parseDouble(df.format(zaliczkaUS));
			System.out.println("Zaliczka do urzędu skarbowego = "
					+ df00.format(zaliczkaUS) + " po zaokrągleniu = "
					+ df.format(zaliczkaUS0));
			double wynagrodzenie = workParms.getPodstawa().doubleValue()
					- ((skladkaEmerytalna + skladkaRentowa + ubezpieczenieChorobowe) + skladkaZdrowotna1 + zaliczkaUS0);
			System.out.println();
			System.out
					.println("Pracownik otrzyma wynagrodzenie netto w wysokości = "
							+ df00.format(wynagrodzenie));
		} else {
			System.out.println("Nieznany typ umowy!");
		}
	}

	public static void ustawParametry(double podstawa, char umowa) {
		workParms.setPodstawa(podstawa);
		switch (umowa) {
			case 'P':
				workParms.setTypUmowy(ContractType.UMOWA_O_PRACE);
				break;
			case 'U':
				workParms.setTypUmowy(ContractType.UMOWA_ZLECENIE);
				break;
		}
	}

	public static void obliczZaliczke() {
		zaliczkaUS = zaliczkaNaPod - skladkaZdrowotna2 - kwotaZmiejsz;
	}

	public static void obliczPodatek(double podstawa) {
		zaliczkaNaPod = (podstawa * 18) / 100;
	}

	public static double obliczonaPodstawa(double podstawa) {
		skladkaEmerytalna = (podstawa * 9.76) / 100;
		skladkaRentowa = (podstawa * 1.5) / 100;
		ubezpieczenieChorobowe = (podstawa * 2.45) / 100;
		return (podstawa - skladkaEmerytalna - skladkaRentowa - ubezpieczenieChorobowe);
	}

	public static void obliczUbezpieczenia(double podstawa) {
		skladkaZdrowotna1 = (podstawa * 9) / 100;
		skladkaZdrowotna2 = (podstawa * 7.75) / 100;
	}
}
