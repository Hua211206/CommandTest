package CommandTest.CommandImpl;

import CommandTest.Command;

public class PasteCommand implements Command {
    private final int position;
    private final StringBuilder clipboard;
    private final StringBuilder content;

    public PasteCommand(int position, StringBuilder clipboard, StringBuilder content) {
        this.position = position;
        this.clipboard = clipboard;
        this.content = content;
    }

    public void execute() {
        content.insert(position, clipboard);
    }

    public void undo() {
        content.delete(position, position + clipboard.length());
    }
}
