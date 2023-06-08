package CommandTest.CommandImpl;

import CommandTest.Command;

//复制命令
public class CopyCommand implements Command {
    private final String text;
    private final StringBuilder clipboard;

    public CopyCommand(String text, StringBuilder clipboard) {
        this.text = text;
        this.clipboard = clipboard;
    }

    public void execute() {
        clipboard.setLength(0); // 清空剪切板
        clipboard.append(text);
    }

    public void undo() {
        clipboard.setLength(0); // 清空剪切板
    }
}
