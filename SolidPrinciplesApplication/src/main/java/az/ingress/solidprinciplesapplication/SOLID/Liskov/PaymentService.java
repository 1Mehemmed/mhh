package az.ingress.solidprinciplesapplication.SOLID.Liskov;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PaymentService {
    public void makePayment(CreditCardDto creditCardDto, Double amount){
        changeCard(creditCardDto, amount);
        printReceipt(creditCardDto,amount);

    }
    private void changeCard(CreditCardDto creditCardDto,Double amount){
        log.info("Charged customer");

    }
    private void printReceipt(CreditCardDto creditCardDto, Double amount){

        log.info("Print receipt ... ");
    }
}
