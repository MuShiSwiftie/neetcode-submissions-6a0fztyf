class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            indegree[pre[1]]++;
            adj.get(pre[0]).add(pre[1]);
        }  
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int[] res = new int[numCourses];
        int finish = 0;
        while (!q.isEmpty()) {
            int course = q.poll();
            res[numCourses - finish - 1] = course;
            finish++;
            for (int pre : adj.get(course)) {
                indegree[pre]--;
                if (indegree[pre] == 0) {
                    q.add(pre);
                }
            }
        }
        if (finish != numCourses) {
            return new int[0];
        }
        return res;
    }
}
