package ma.enset.demo.query.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.demo.commonapi.events.AccountCreatedEvent;
import ma.enset.demo.commonapi.events.AccountCreditedEvent;
import ma.enset.demo.query.entities.Account;
import ma.enset.demo.query.repositories.AccountRepository;
import ma.enset.demo.query.repositories.OperationRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class AccountServiceHandler {
    private AccountRepository accountRepository;
    private OperationRepository operationRepository;
    @EventHandler
    public void on(AccountCreatedEvent event){
        log.info("*******************************");
        log.info("AccountCreatedEvent received");
        Account account = new Account();
        account.setId(event.getId());
        account.setBalance(event.getInitialBalance());
        account.setCurrency(event.getCurrency());
        account.setStatus(event.getStatus());
        account.setOperations(null);
        accountRepository.save(account);
    }
}
