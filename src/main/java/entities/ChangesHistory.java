package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChangesHistory {

    private List<ChangeItem> changesHistoryList = new ArrayList<>();

    public ChangesHistory() {
        makeChange();
    }

    public void makeChange() {
        changesHistoryList.add(new ChangeItem(System.getProperty("user.name"), new Date()));
    }

    public ChangeItem getFirstChange() {
        if (!changesHistoryList.isEmpty()) {
            return changesHistoryList.get(0);
        }
        return null;
    }

    public ChangeItem getLastChange() {
        if (!changesHistoryList.isEmpty()) {
            return changesHistoryList.get(changesHistoryList.size()-1);
        }
        return null;
    }

    public List<ChangeItem> getChangesHistoryList() {
        return changesHistoryList;
    }

    public void setChangesHistoryList(List<ChangeItem> changesHistoryList) {
        this.changesHistoryList = changesHistoryList;
    }

    @Override
    public String toString() {
        return "{" +
                "\"changesHistoryList\":" + changesHistoryList +
                '}';
    }
}
