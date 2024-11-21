package ru.jrp.javarush_telegrambot.commands;

import org.junit.jupiter.api.DisplayName;

import static ru.jrp.javarush_telegrambot.commands.StopCommand.STOP_MESSAGE;

@DisplayName("Unit-level testing for StopCommand")
class StopCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return CommandName.STOP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return STOP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StopCommand(sendBotMessageService);
    }
}