class Solution {
    int[] parent;
    
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        
        for (int[] e : edges) {
            int a = find(e[0]), b = find(e[1]);
            if (a == b) return false;   
            parent[a] = b;           
        }
        return true;
    }
    
    private int find(int x) {
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }
}
