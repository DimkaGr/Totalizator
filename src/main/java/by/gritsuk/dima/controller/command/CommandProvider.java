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
