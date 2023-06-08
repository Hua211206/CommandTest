package CommandTest;

import CommandTest.CommandImpl.*;

//文本编辑器
public class TextEditor {
    private final StringBuilder content = new StringBuilder();// 文档的内容
    private final StringBuilder clipboard = new StringBuilder();//剪贴板
    private final CommandHistory history = new CommandHistory();//命令历史
    private static TextEditor editor = new TextEditor();

    public static void main(String[] args) {
        editor.insertText(0, "We are 二元一次方程组!");
        editor.showContent();

        editor.copyText(7, editor.content.length() - 1); // 复制 "二元一次方程组"
        editor.showContent();

        editor.deleteText(7, editor.content.length() - 1); // 删除 "二元一次方程组"
        editor.showContent();

        editor.insertText(7, "3班某小组"); // 插入 "3班某小组"，结果为 "We are 3班某小组!"
        editor.showContent();

        editor.undo(); //撤销插入操作，结果为”We are !“
        editor.undo();//撤销插入操作，结果为”We are 二元一次方程组!“

        editor.setColor(7, editor.content.length(), "red"); // 改变“二元一次方程组”的颜色为红色，结果为“Hello, <red>Java!</red>”
        editor.showContent();
        editor.undo(); // 撤销改变颜色操作，结果为 "We are 二元一次方程组!"

        System.out.println();

        editor.toLower(); // 将文本转换为小写，结果为 "we are 二元一次方程组!"
        editor.showContent();
        editor.undo(); // 撤销转换为小写操作，结果为 "We are 二元一次方程组!"

        editor.toUpper(); // 将文本转换为大写，结果为 "WE ARE 二元一次方程组!"
        editor.showContent();
        editor.undo(); // 撤销转换为大写操作，结果为 "We are 二元一次方程组!"

        System.out.println();

        editor.removeSpaces(); // 删除所有空格，结果为 "Weare二元一次方程组!"
        editor.showContent();
        editor.undo(); // 撤销删除空格操作，结果为 "We are 二元一次方程组!"

        editor.reverseText(); // 反转文本，结果为 "!组程方次一元二 era eW"
        editor.showContent();
        editor.undo(); // 撤销反转文本操作，结果为 "We are 二元一次方程组!"

        System.out.println();

        editor.insertDate(editor.content.length()); // 插入日期，结果为 "We are 二元一次方程组!2023-06-08"
        editor.showContent();
        editor.undo(); // 撤销插入日期操作，结果为 "We are 二元一次方程组!"
    }

    public void insertText(int position, String text) {
        clipboard.setLength(0); // 清空剪切板
        clipboard.append(text);
        history.execute(new PasteCommand(position, clipboard, content));
    }

    public void copyText(int start, int end) {
        String text = content.substring(start, end);
        history.execute(new CopyCommand(text, clipboard));
    }

    public void deleteText(int start, int end) {
        history.execute(new DeleteCommand(start, end, content));
    }

    private void setColor(int start, int end, String color) {
        history.execute(new ColorCommand(start, end, color, content));
    }

    private void showContent() {
        System.out.println(content);
    }

    public void undo() {
        history.undoLastCommand();
        System.out.println("撤销:" + editor.content);
    }

    public void toLower() {
        history.execute(new ToLowerCommand(content));
    }

    public void toUpper() {
        history.execute(new ToUpperCommand(content));
    }

    public void removeSpaces() {
        history.execute(new RemoveSpacesCommand(content));
    }

    public void reverseText() {
        history.execute(new ReverseTextCommand(content));
    }

    public void insertDate(int position) {
        history.execute(new InsertDateCommand(content, position));
    }
}