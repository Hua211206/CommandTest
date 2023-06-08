package CommandTest.CommandImpl;

import CommandTest.Command;

// 反转文本命令
public class ReverseTextCommand implements Command {
    private final StringBuilder content;
    private final String previousText;

    public ReverseTextCommand(StringBuilder content) {
        this.content = content;
        this.previousText = content.toString();
    }

    public void execute() {
        content.setLength(0);
        content.append(new StringBuilder(previousText).reverse());
    }

    public void undo() {
        content.setLength(0);
        content.append(previousText);
    }
}
