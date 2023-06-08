package CommandTest.CommandImpl;

import CommandTest.Command;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// 插入日期命令
public class InsertDateCommand implements Command {
    private final StringBuilder content;
    private final int insertionIndex;
    private final String currentDate;

    public InsertDateCommand(StringBuilder content, int insertionIndex) {
        this.content = content;
        this.insertionIndex = insertionIndex;
        this.currentDate = getCurrentDate();
    }

    private String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public void execute() {
        content.insert(insertionIndex, currentDate);
    }

    public void undo() {
        content.delete(insertionIndex, insertionIndex + currentDate.length());
    }
}