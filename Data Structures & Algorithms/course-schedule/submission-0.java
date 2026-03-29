class Solution {
    private Map<Integer, List<Integer>> preMap = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            preMap.get(prereq[0]).add(prereq[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if(!dfs(i)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int c) {
        if (visited.contains(c)) {
            return false;
        }

        if (preMap.get(c).isEmpty()) {
            return true;
        }

        visited.add(c);
        for (int pre : preMap.get(c)) {
            if (!dfs(pre)) {
                return false;
            }
        }
        visited.remove(c);
        preMap.put(c, new ArrayList<>());
        return true;
    }
}
