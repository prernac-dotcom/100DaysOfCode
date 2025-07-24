import java.util.*;

class Solution {
    private void dfs(int v, boolean[] visited, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack) {
        visited[v] = true;
        for (int neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, adj, stack);
            }
        }
        stack.push(v);
    }

    private void reverseDfs(int v, boolean[] visited, ArrayList<ArrayList<Integer>> transpose) {
        visited[v] = true;
        for (int neighbor : transpose.get(v)) {
            if (!visited[neighbor]) {
                reverseDfs(neighbor, visited, transpose);
            }
        }
    }

    private ArrayList<ArrayList<Integer>> getTranspose(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            transpose.add(new ArrayList<>());
        }
        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                transpose.get(v).add(u);
            }
        }
        return transpose;
    }

    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, adj, stack);
            }
        }

        ArrayList<ArrayList<Integer>> transpose = getTranspose(V, adj);
        Arrays.fill(visited, false);
        int count = 0;

        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {
                reverseDfs(v, visited, transpose);
                count++;
            }
        }

        return count;
    }
}
