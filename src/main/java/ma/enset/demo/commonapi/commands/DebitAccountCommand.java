package ma.enset.demo.commonapi.commands;

import lombok.Getter;

public class DebitAccountCommand<T> extends BaseCommand<String> {
    @Getter private double amount;
    @Getter private String currency;

    public DebitAccountCommand(String id, double amount, String currency) {
        super(id);
        this.amount = amount;
        this.currency = currency;
    }
}
