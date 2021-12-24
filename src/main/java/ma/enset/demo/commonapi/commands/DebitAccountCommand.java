package ma.enset.demo.commonapi.commands;

public class DebitAccountCommand<T> extends BaseCommand<String> {
    private double amount;
    private String currency;

    public DebitAccountCommand(String id, double amount, String currency) {
        super(id);
        this.amount = amount;
        this.currency = currency;
    }
}
