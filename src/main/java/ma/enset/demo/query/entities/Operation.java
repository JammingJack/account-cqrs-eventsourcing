package ma.enset.demo.query.entities;

import ma.enset.demo.commonapi.enums.OperationType;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Operation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private double amount;
    @Enumerated(EnumType.STRING)
    private OperationType type;
    @ManyToOne()
    private Account account;
}
