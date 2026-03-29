class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for (int[] time : times) {
            adjList.computeIfAbsent(time[0], key -> new ArrayList<>()).add(new int[] { time[1], time[2] });
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[] {0, k});
        Set<Integer> visited = new HashSet<>();
        int res = 0;
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int w1 = curr[0], n1 = curr[1];
            if (visited.contains(n1)) {
                continue;
            }
            visited.add(n1);
            res = w1;
            if (adjList.containsKey(n1)) {
                for (int[] next : adjList.get(n1)) {
                    int n2 = next[0], w2 = next[1];
                    if (!visited.contains(n2)) {
                        pq.offer(new int[] { w1 + w2, n2 });
                    }
                }
            }
        }
        return visited.size() == n ? res : -1;
    }
}
