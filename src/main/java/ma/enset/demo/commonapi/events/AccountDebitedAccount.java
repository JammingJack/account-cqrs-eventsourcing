package ma.enset.demo.commonapi.events;

import lombok.Getter;

public class AccountDebitedAccount extends BaseEvent<String>{
    @Getter private double amount;
    @Getter private String currency;
    public AccountDebitedAccount(String id, double amount, String currency) {
        super(id);
        this.amount = amount;
        this.currency = currency;

    }
}
