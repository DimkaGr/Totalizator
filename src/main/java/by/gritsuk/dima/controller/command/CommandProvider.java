package by.gritsuk.dima.controller.command;

import java.util.HashMap;
import java.util.Map;

/**
 * Command Provider
 */
public class CommandProvider {
    private static CommandProvider instance = new CommandProvider();
    private Map<String, Command> commandMap = new HashMap<>();

    public static CommandProvider getInstance() {
        return instance;
    }

    private CommandProvider() {
        commandMap.put("add_user", new ToSignUpCommand());
        commandMap.put("main", new MainPageCommand());
        commandMap.put("user_list", new ShowUserListCommand());
        commandMap.put("comp_list", new CompetitionsListCommand());
        commandMap.put("sign_up", new UserRegisterCommand());
        commandMap.put("to_restore", new ToRestoreCommand());
        commandMap.put("restore", new PasswordRestoreCommand());
        commandMap.put("to_sign_in", new ToSignInCommand());
        commandMap.put("sign_in", new SignInCommand());
        commandMap.put("delete", new DeleteCommand());
        commandMap.put("log_out", new LogOutCommand());
        commandMap.put("change_lang", new LangCommand());
        commandMap.put("make_bet1", new ChooseSportCommand());
        commandMap.put("make_bet2", new ChooseCompetitionCommand());
        commandMap.put("make_bet3", new ChooseEventCommand());
        commandMap.put("to_account", new ToAccountCommand());
        commandMap.put("make_bet4", new ToSetAmountCommand());
        commandMap.put("make_bet5", new SetAmountCommand());
        commandMap.put("confirm_bet", new ConfirmBetCommand());
        commandMap.put("tp_change_password", new ToChangePasswordCommand());
        commandMap.put("change_password", new ChangePasswordCommand());
        commandMap.put("verify_code", new VerifyMessageCommand());
        commandMap.put("add_bet1", new ChooseSportForBookmakerCommand());
        commandMap.put("add_bet2", new ChooseCompetitionForBookmakerCommand());
        commandMap.put("add_bet3", new ToAddBetEventCommand());
        commandMap.put("add_bet4", new AddBetEventCommand());
        commandMap.put("show_sports", new ShowSportsCommand());
        commandMap.put("comp_of_sport", new ShowCompetitionsOfSportCommand());
        commandMap.put("client_bets", new ShowClientBetsCommand());
    }

    /**
     * Return command by name
     * @param commandType name
     * @return command implementation
     */
    public Command takeCommand(String commandType) {
        return commandMap.get(commandType);
    }
}
