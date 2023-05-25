import java.util.ArrayList;
import java.util.List;

public class DagTask {

    private String taskID;
    private String type;
    private List<DagTask> dagTaskList = new ArrayList<>();

    public String getTaskID() {
        return taskID;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "DagTask{" +
                "taskID='" + taskID + '\'' +
                ", type=" + type +
                '}';
    }
}
