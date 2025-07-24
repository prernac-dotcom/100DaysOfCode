class Solution {
    private void dfs(int v, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[v] = true;
        for (int neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, adj);
            }
        }
    }

    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        int candidate = -1;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, adj);
                candidate = i;
            }
        }

        visited = new boolean[V];
        dfs(candidate, visited, adj);

        for (boolean v : visited) {
            if (!v) {
                return -1; 
            }
        }

        return candidate; 
    }
}
