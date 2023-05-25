import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ReadTgff {

    public static void main(String[] args) throws IOException {
        readTgff("src/simple.tgff");
    }

    public static void readTgff(String path) throws IOException {
        // 判断是否是TGFF文件格式
        if (!path.endsWith(".tgff")) {
            throw new RuntimeException("文件不是TGFF类型");
        }

        // 读取文件
        InputStream fis = new FileInputStream(path);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis));
        String str;
        Map<String, DagGraph> taskGraphMap = new HashMap<>();
        Map<String, String> taskMap = new HashMap<>();

        // 循环读取
        while (true) {
            str = bufferedReader.readLine();
            if (str == null) { // 读到末尾，跳出循环
                break;
            } else {
                String[] strings = str.split(" ");
                if ("@HYPERPERIOD".equals(strings[0])) { //

                } else if ("@TASK_GRAPH".equals(strings[0])) { // 读取为任务
                    DagGraph dagGraph = new DagGraph();
                    dagGraph.setId(strings[1]);
                    while (true) {
                        String lineString = bufferedReader.readLine();
                        // 空行略过
                        if (lineString == null || "".equals(lineString) || "\n".equals(lineString)) {
                            continue;
                        }
                        // 右大括号结尾
                        if ("}".equals(lineString)) {
                            break;
                        }
                        lineString = lineString.replaceAll("\t", " ");
                        String[] lineStrings = lineString.split(" ");
                        switch (lineStrings[1]) {
                            // 周期
                            case "PERIOD":
                                dagGraph.setPeriod(Integer.parseInt(lineStrings[2]));
                                break;
                            // 任务
                            case "TASK":
                                dagGraph.getDagTaskList().add(parseDagTask(lineStrings));
                                break;
                            // 边
                            case "ARC":
                                dagGraph.getDagEdgeList().add(parseDagEdge(lineStrings));
                        }
                        /*if ("PERIOD".equals(lineStrings[1])) { // 周期
                            dagGraph.setPeriod(Integer.parseInt(lineStrings[2]));
                        } else if ("TASK".equals(lineStrings[1])) { // 任务
                            DagTask dagTask = new DagTask();
                            dagTask.setTaskID(lineStrings[2]);
                            dagTask.setType(lineStrings[4]);
                            dagGraph.getDagTaskList().add(dagTask);
                        } else if ("ARC".equals(lineStrings[1])) { // 边
                            DagEdge dagEdge = new DagEdge();
                            dagEdge.setEdgeID(lineStrings[2]);
                            dagEdge.setFrom(lineStrings[5]);
                            dagEdge.setTo(lineStrings[9]);
                            dagEdge.setType(lineStrings[11]);
                            dagGraph.getDagEdgeList().add(dagEdge);
                        }*/
                    }
                    taskGraphMap.put(strings[1], dagGraph);
                }
            }
        }
//        System.out.println(taskGraphMap);
        for (Map.Entry<String, DagGraph> dagGraphEntry : taskGraphMap.entrySet()) {
            System.out.println(dagGraphEntry.getValue());
        }
    }

    private static DagEdge parseDagEdge(String[] lineStrings) {
        DagEdge dagEdge = new DagEdge();
        dagEdge.setEdgeID(lineStrings[2]);
        dagEdge.setFrom(lineStrings[5]);
        dagEdge.setTo(lineStrings[9]);
        dagEdge.setType(lineStrings[11]);
        return dagEdge;
    }

    private static DagTask parseDagTask(String[] lineStrings) {
        DagTask dagTask = new DagTask();
        dagTask.setTaskID(lineStrings[2]);
        dagTask.setType(lineStrings[4]);
        return dagTask;
    }

}
