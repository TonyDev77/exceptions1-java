package application_11_1;

import java.time.LocalDate;
import java.time.temporal.TemporalAccessor;
import java.util.Scanner;

import model.entities.Reservation;

public class Program11 {

	/*
	 * Fazer um programa para ler os dados de uma reserva de hotel (número do
	 * quarto, data de entrada e data de saída) e mostrar os dados da reserva,
	 * inclusive sua duração em dias. Em seguida, ler novas datas de entrada e
	 * saída, atualizar a reserva, e mostrar novamente a reserva com os dados
	 * atualizados. O programa não deve aceitar dados inválidos para a reserva,
	 * conforme as seguintes regras: - Alterações de reserva só podem ocorrer para
	 * datas futuras - A data de saída deve ser maior que a data de entrada
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Checkin Date: (DD/MM/AAAA): ");
		String chkIn = sc.nextLine();
		TemporalAccessor parse = Reservation.dtf.parse(chkIn);
		LocalDate checkIn = LocalDate.from(parse);
		
		System.out.print("Checkin Date: (DD/MM/AAAA): ");
		String chkOut = sc.nextLine();
		parse = Reservation.dtf.parse(chkOut);
		LocalDate checkOut = LocalDate.from(parse);
		
		if (checkOut.isBefore(checkIn)) {
			System.out.println("Error in Reservation: Check-out date must be after check-in date");
		} else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Resevation: " + reservation.toString());
			
			// Atualizando as datas
			System.out.println("\nEnter data to update the reservation:");
			System.out.print("Checkin Date: (DD/MM/AAAA): ");
			chkIn = sc.nextLine();
			parse = Reservation.dtf.parse(chkIn);
			checkIn = LocalDate.from(parse);
			
			System.out.print("Checkin Date: (DD/MM/AAAA): ");
			chkOut = sc.nextLine();
			parse = Reservation.dtf.parse(chkOut);
			checkOut = LocalDate.from(parse);
			
			LocalDate now = LocalDate.now();
			if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
				System.out.println("Error in reservation: Reservation dates must be after check-in date");
			} else if (checkOut.isBefore(checkIn)) {
				System.out.println("Error in Reservation: Check-out date must be after check-in date");
			} else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Resevation: " + reservation.toString());
			}
		}
		
		sc.close();
	}

}
