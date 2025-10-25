package model.aplicattion;

import model.entities.Contract;
import model.services.ContractService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter the contract details:");
        System.out.print("Number contract: ");
        int number = sc.nextInt();
        System.out.print("Data contract (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(sc.nextLine(), dtf);
        System.out.print("Contract value:");
        Double value = sc.nextDouble();

        Contract obj = new Contract(number, date, value);

        System.out.print("Number of installments in the contract: ");
        int months = sc.nextInt();
        ContractService contractService = new ContractService(obj, months);


        sc.close();
    }
}