package model.aplicattion;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

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
        sc.nextLine();
        System.out.print("Data contract (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(sc.nextLine(), dtf);
        System.out.print("Contract value: ");
        Double value = sc.nextDouble();

        Contract obj = new Contract(number, date, value);

        System.out.print("Number of installments in the contract: ");
        int n = sc.nextInt();
        ContractService contractService = new ContractService(new PaypalService());

        contractService.processContract(obj, n);
        System.out.println();
        System.out.println("Installments: ");
        for(Installment installment : obj.getInstallmentList()){
            System.out.println(installment);
        }
        sc.close();
    }
}