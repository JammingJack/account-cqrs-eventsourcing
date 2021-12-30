package ma.enset.demo.commonapi.events;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Getter;

public class AccountCreditedEvent extends BaseEvent<String> {
    @Getter private double amount;
    @Getter private String currency;

    public AccountCreditedEvent(String id, double amount, String currency) {
        super(id);
        this.amount = amount;
        this.currency = currency;
    }
}
