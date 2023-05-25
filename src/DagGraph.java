import java.util.ArrayList;
import java.util.List;

public class DagGraph {

    private String id;

    private List<DagTask> dagTaskList = new ArrayList<>();
    private List<DagEdge> dagEdgeList = new ArrayList<>();
    private int hyperPeriod;
    private int period;
    private int taskCnt;
    private int edgeCnt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<DagTask> getDagTaskList() {
        return dagTaskList;
    }

    public void setDagTaskList(List<DagTask> dagTaskList) {
        this.dagTaskList = dagTaskList;
    }

    public List<DagEdge> getDagEdgeList() {
        return dagEdgeList;
    }

    public void setDagEdgeList(List<DagEdge> dagEdgeList) {
        this.dagEdgeList = dagEdgeList;
    }

    public int getHyperPeriod() {
        return hyperPeriod;
    }

    public void setHyperPeriod(int hyperPeriod) {
        this.hyperPeriod = hyperPeriod;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getTaskCnt() {
        return taskCnt;
    }

    public void setTaskCnt(int taskCnt) {
        this.taskCnt = taskCnt;
    }

    public int getEdgeCnt() {
        return edgeCnt;
    }

    public void setEdgeCnt(int edgeCnt) {
        this.edgeCnt = edgeCnt;
    }

    @Override
    public String toString() {
        return "DagGraph{" +
                "id='" + id + '\'' +
                ", dagTaskList=" + dagTaskList +
                ", dagEdgeList=" + dagEdgeList +
                ", hyperPeriod=" + hyperPeriod +
                ", period=" + period +
                ", taskCnt=" + taskCnt +
                ", edgeCnt=" + edgeCnt +
                '}';
    }
}
