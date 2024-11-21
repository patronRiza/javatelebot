package ru.jrp.javarush_telegrambot.commands;

import org.junit.jupiter.api.DisplayName;

import static ru.jrp.javarush_telegrambot.commands.NoCommand.NO_MESSAGE;

@DisplayName("Unit-level testing for NoCommand")
class NoCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return CommandName.NO.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return NO_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new NoCommand(sendBotMessageService);
    }
}