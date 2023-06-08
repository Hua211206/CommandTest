package CommandTest.CommandImpl;

import CommandTest.Command;

// 转换为小写命令
public class ToLowerCommand implements Command {
    private final StringBuilder content;
    private final String previousText;

    public ToLowerCommand(StringBuilder content) {
        this.content = content;
        this.previousText = content.toString();
    }

    public void execute() {
        content.setLength(0);
        content.append(previousText.toLowerCase());
    }

    public void undo() {
        content.setLength(0);
        content.append(previousText);
    }
}
