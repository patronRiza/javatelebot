package ru.jrp.javarush_telegrambot.commands;

import org.junit.jupiter.api.DisplayName;

import static ru.jrp.javarush_telegrambot.commands.HelpCommand.HELP_MESSAGE;

@DisplayName("Unit-level testing for HelpCommand")
class HelpCommandTest extends AbstractCommandTest {
    @Override
    String getCommandName() {
        return CommandName.HELP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return HELP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new HelpCommand(sendBotMessageService);
    }
}