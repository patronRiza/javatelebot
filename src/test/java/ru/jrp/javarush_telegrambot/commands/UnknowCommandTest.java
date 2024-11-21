package ru.jrp.javarush_telegrambot.commands;

import org.junit.jupiter.api.DisplayName;

import static ru.jrp.javarush_telegrambot.commands.UnknowCommand.UNKNOWN_MESSAGE;

@DisplayName("Unit-level testing for UnknownCommand")
class UnknowCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return "/fdgdfgdfgdbd";
    }

    @Override
    String getCommandMessage() {
        return UNKNOWN_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new UnknowCommand(sendBotMessageService);
    }
}