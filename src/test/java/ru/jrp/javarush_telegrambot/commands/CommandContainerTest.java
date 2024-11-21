package ru.jrp.javarush_telegrambot.commands;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.jrp.javarush_telegrambot.services.SendBotMessageService;

import java.util.Arrays;

@DisplayName("Unit-level testing for CommandContainer")
class CommandContainerTest {

    private CommandContainer commandContainer;

    @BeforeEach
    public void init() {
        SendBotMessageService sendBotMessageService = Mockito.mock(SendBotMessageService.class);
        commandContainer = new CommandContainer(sendBotMessageService);
    }

    @Test
    void shouldGetAllTheExistingCommands() {
        Arrays.stream(CommandName.values())
                .forEach(commandName -> {
                    Command command = commandContainer.retriveCommand(commandName.getCommandName());
                    Assertions.assertNotEquals(UnknowCommand.class, command.getClass());
                });
    }

    @Test
    void shouldReturnUnknownCommand() {

        String unknownCommand = "/safavs";

        Command command = commandContainer.retriveCommand(unknownCommand);

        Assertions.assertEquals(UnknowCommand.class, command.getClass());
    }

}