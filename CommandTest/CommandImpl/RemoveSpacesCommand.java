package CommandTest.CommandImpl;

import CommandTest.Command;

// 删除空格命令
public class RemoveSpacesCommand implements Command {
    private final StringBuilder content;
    private final String previousText;

    public RemoveSpacesCommand(StringBuilder content) {
        this.content = content;
        this.previousText = content.toString();
    }

    public void execute() {
        String textWithoutSpaces = previousText.replaceAll(" ", "");
        content.setLength(0);
        content.append(textWithoutSpaces);
    }

    public void undo() {
        content.setLength(0);
        content.append(previousText);
    }
}
