package ma.enset.demo.commands.controllers;

import lombok.AllArgsConstructor;
import ma.enset.demo.commonapi.commands.CreateAccountCommand;
import ma.enset.demo.commonapi.dtos.CreateAccountRequestDTO;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(path="/commands/account")
@AllArgsConstructor
public class AccountCommandController {

    private CommandGateway commandGateway;

    @PostMapping(path="/create")
    public CompletableFuture<String> createAccount(@RequestBody CreateAccountRequestDTO request){
        CompletableFuture<String> commandResponde = commandGateway.send(new CreateAccountCommand(
                UUID.randomUUID().toString(),
                request.getInitialBalance(),
                request.getCurrency()
        ));
        return commandResponde;
    }
}
