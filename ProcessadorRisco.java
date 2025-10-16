package AnaliseDeRiscoEconomico;

import java.util.Scanner;

public class ProcessadorRisco {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int[] notasRisco = new int[15];

		double somaPonderada = 0;
		int somaPesos = 0;
		int analistasOtimistas = 0;
		int analistasAlarmantes = 0;
		double mediaPonderada = 0;

		System.out.println("Por favor, digite as " + notasRisco.length + " notas de risco (0 a 100):");

		for (int i = 0; i < notasRisco.length; i++) {
			int nota;
			boolean notaValida;

			do {
				System.out.print("Digite Nota " + (i + 1) + " (0-100): ");
				nota = scanner.nextInt();

				if (nota >= 0 && nota <= 100) {
					notasRisco[i] = nota;
					notaValida = true;
				} else {
					System.out.println("Valor digitado é inválido! A nota deve ser entre 0 e 100.");
					notaValida = false;
				}
			} while (!notaValida);
		}

		scanner.close();

		for (int i = 0; i < notasRisco.length; i++) {
			int nota = notasRisco[i];
			int peso;

			if (i >= 0 && i <= 4) {
				peso = 3;
			} else {
				peso = 1;
			}

			somaPonderada += (nota * peso);
			somaPesos += peso;
		}

		if (somaPesos > 0) {
			mediaPonderada = somaPonderada / somaPesos;
		}

		for (int nota : notasRisco) {

			if (nota <= 20) {
				analistasOtimistas++;
			}

			if (nota >= 90) {
				analistasAlarmantes++;
			}
		}

		System.out.printf("Média Ponderada do Risco: %.2f\n", mediaPonderada);
		System.out.println("Analistas Otimistas (Nota <= 20): " + analistasOtimistas);
		System.out.println("Analistas Alarmantes (Nota >= 90): " + analistasAlarmantes);

		if (mediaPonderada > 70) {
			System.out.println("Alto Risco: Venda ou reajuste de portfólio recomendado.");
		} else if (mediaPonderada >= 40 && mediaPonderada <= 70) {
			System.out.println("Risco Moderado: Acompanhar de perto, mas manter os ativos.");
		} else {
			System.out.println("Baixo Risco: Excelente momento para capitalização.");
		}

	}
}