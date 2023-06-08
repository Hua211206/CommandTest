package CommandTest;

import java.util.ArrayList;
import java.util.List;

// 命令历史记录类
public class CommandHistory {
    private final List<Command> history = new ArrayList<>();

    void execute(Command command) {
        command.execute();
        history.add(command);
    }

    void undoLastCommand() {
        if (!history.isEmpty()) {
            Command lastCommand = history.remove(history.size() - 1);
            lastCommand.undo();
        }
    }
}