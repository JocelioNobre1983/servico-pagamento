package model.services;

import model.entities.Contract;
import model.entities.Installment;

import java.time.LocalDate;

public class ContractService {

    private OnlinePaymentService onlinePayment;

    public ContractService(OnlinePaymentService onlinePayment) {
        this.onlinePayment = onlinePayment;
    }

    public void processContract(Contract contract, int months){

            Double basicQuota = contract.getTotalvalue() / months;
            for(int i=1; i<=months; i++){
                LocalDate dueDate = contract.getDate().plusMonths(i);

                double interest = onlinePayment.interest(basicQuota, i);
                double fee = onlinePayment.paymentFee(basicQuota + interest);
                double totalQuota = basicQuota + interest + fee;

                contract.getInstallmentList().add(new Installment(dueDate, totalQuota));
            }


        }
    }

