class Solution {
    int[] color;
    public boolean isBipartite(int[][] g) {
        int n = g.length;
        color = new int[n];
        for (int i = 0; i < n; i++)
            if (color[i] == 0 && !dfs(g, i, 1)) return false;
        return true;
    }
    boolean dfs(int[][] g, int u, int c) {
        if (color[u] != 0) return color[u] == c;
        color[u] = c;
        for (int v : g[u])
            if (!dfs(g, v, -c)) return false;
        return true;
    }
}
