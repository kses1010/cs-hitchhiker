package leetcode.number301to400.number331to340.number332;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

    private Map<String, PriorityQueue<String>> flightsMap = new HashMap<>();
    private List<String> path = new ArrayList<>();

    public List<String> findItinierary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            flightsMap.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            flightsMap.get(ticket.get(0)).add(ticket.get(1));
        }
        dfs("JFK");
        return path;
    }

    private void dfs(String start) {
        PriorityQueue<String> arrivals = flightsMap.get(start);

        while (arrivals != null && !arrivals.isEmpty()) {
            // 첫번째 값을 읽어 어휘순으로 방문시작
            dfs(arrivals.poll());
        }
        path.add(0, start);
    }
}
