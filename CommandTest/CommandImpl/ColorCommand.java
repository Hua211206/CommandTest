package CommandTest.CommandImpl;

import CommandTest.Command;

public class ColorCommand implements Command {
    private final int start;
    private final int end;
    private final String color;
    private final StringBuilder content;
    private final String beginTag;
    private final String endTag;

    public ColorCommand(int start, int end, String color, StringBuilder content) {
        this.start = start;
        this.end = end;
        this.color = color;
        this.content = content;
        beginTag = String.format("<%s>", color);
        endTag = String.format("</%s>", color);
    }

    @Override
    public void execute() {
        content.insert(start, beginTag);
        content.insert(end + beginTag.length(), endTag);
    }

    @Override
    public void undo() {
        int len1 = beginTag.length();
        int len2 = endTag.length();
        content.delete(end + len1, end + len1 + len2);
        content.delete(start, start + len1);
    }
}
