package CommandTest.CommandImpl;

import CommandTest.Command;

// 转换为大写命令
public class ToUpperCommand implements Command {
    private final StringBuilder content;
    private String previousText;

    public ToUpperCommand(StringBuilder content) {
        this.content = content;
    }

    public void execute() {
        previousText = content.toString();
        content.setLength(0);
        content.append(previousText.toUpperCase());
    }

    public void undo() {
        content.setLength(0);
        content.append(previousText);
    }
}