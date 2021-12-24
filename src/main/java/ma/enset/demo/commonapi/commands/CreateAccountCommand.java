package ma.enset.demo.commonapi.commands;

public class CreateAccountCommand<T> extends BaseCommand<String> {
    private double intialBalance;
    private String currency;

    public CreateAccountCommand(String id) {
        super(id);
    }
}
