package ma.enset.demo.commands.aggregates;

import ma.enset.demo.commonapi.commands.CreateAccountCommand;
import ma.enset.demo.commonapi.enums.AccountStatus;
import ma.enset.demo.commonapi.events.AccountActivatedEvent;
import ma.enset.demo.commonapi.events.AccountCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class AccountAggregate {
    @AggregateIdentifier
    private String accountId;
    private double balance;
    private String currency;
    private AccountStatus status;

    //in an aggregate we have to have a constructor without params
    public AccountAggregate(){
        //required by axon
    }

    @CommandHandler //meaning this constructor listens to a command and when it's there it handles it, we call this handle la fonction de decision
    public AccountAggregate(CreateAccountCommand createAccountCommand){
        //specify the bisuness logic
        if(createAccountCommand.getInitialBalance() < 0) throw new RuntimeException("Cannot create an account with negative balance");
        //if all is good we emit an event
        AggregateLifecycle.apply(new AccountCreatedEvent(
                createAccountCommand.getId(),
                createAccountCommand.getInitialBalance(),
                createAccountCommand.getCurrency()
        ));
    }

    @EventSourcingHandler //fonction d'evolution de l'etat de l'application ... executed immmedialtly after the commandHandler
    public void on(AccountCreatedEvent accountCreatedEvent){
        this.accountId = accountCreatedEvent.getId();
        this.balance = accountCreatedEvent.getInitialBalance();
        this.currency = accountCreatedEvent.getCurrency();
        this.status = AccountStatus.CREATED;

        AggregateLifecycle.apply(new AccountActivatedEvent(
                accountCreatedEvent.getId(),
                AccountStatus.ACTIVATED
        ));
    }

    public void on(AccountActivatedEvent accountActivatedEvent){
        this.status = accountActivatedEvent.getStatus();
    }

}
