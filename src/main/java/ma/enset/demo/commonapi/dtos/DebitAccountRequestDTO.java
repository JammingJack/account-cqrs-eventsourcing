package ma.enset.demo.commonapi.dtos;

import lombok.Getter;

public class DebitAccountRequestDTO {
    @Getter private String accountId;
    @Getter private double amount;
    @Getter private String currency;
}
