package application_11_1;

import java.time.LocalDate;
import java.time.temporal.TemporalAccessor;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

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
		
		
		try {
			// Room
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();
			sc.nextLine();
			// Check in
			System.out.print("Check in Date: (DD/MM/AAAA): ");
			String chkIn = sc.nextLine();
			TemporalAccessor parse = Reservation.dtf.parse(chkIn);
			LocalDate checkIn = LocalDate.from(parse);
			// Check out
			System.out.print("Check out Date: (DD/MM/AAAA): ");
			String chkOut = sc.nextLine();
			parse = Reservation.dtf.parse(chkOut);
			LocalDate checkOut = LocalDate.from(parse);
			// Cria objeto
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Resevation: " + reservation.toString());
			// Atualizando as dados...
			// Check in
			System.out.println("\nEnter data to update the reservation:");
			System.out.print("Check in Date: (DD/MM/AAAA): ");
			chkIn = sc.nextLine();
			parse = Reservation.dtf.parse(chkIn);
			checkIn = LocalDate.from(parse);
			// Check out
			System.out.print("Check out Date: (DD/MM/AAAA): ");
			chkOut = sc.nextLine();
			parse = Reservation.dtf.parse(chkOut);
			checkOut = LocalDate.from(parse);
			// Cria objeto
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation.toString());
			
		} catch (DomainException e) {
			System.out.println("Error in resrvation: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Erro inesperado!");
		}
			
		
		sc.close();
	}

}
