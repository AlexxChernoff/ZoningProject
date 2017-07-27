package entities;

import java.util.Date;

public class ChangeItem {

    private String author;
    private Date changeDate;

    public ChangeItem(String author, Date changeDate) {
        this.author = author;
        this.changeDate = changeDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    @Override
    public String toString() {
        return "{" +
                "\"author\":\"" + author + "\"" +
                ", \"changeDate\":\"" + changeDate + "\"" +
                '}';
    }
}
