package CommandTest.CommandImpl;

import CommandTest.Command;

// 删除命令
public class DeleteCommand implements Command {
    private final int start;
    private final int end;
    private final StringBuilder content;
    private String deletedText;

    public DeleteCommand(int start, int end, StringBuilder content) {
        this.start = start;
        this.end = end;
        this.content = content;
    }

    public void execute() {
        deletedText = content.substring(start, end);
        content.delete(start, end);
    }

    public void undo() {
        content.insert(start, deletedText);
    }
}// 粘贴命令
