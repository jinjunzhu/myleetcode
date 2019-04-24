package leetcode.Graph;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 无向图定义
 * Created by jinjunzhu on 2019/4/20.
 */
public class Graph {
    //定点个数
    private int v;
    //邻接表
    private LinkedList<Integer> adj[];
    public Graph(int v){
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i){
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t){
        adj[s].add(t);
        adj[t].add(s);
    }

    /**
     * 广度优先
     * @param s
     * @param t
     */
    public void bfs(int s,int t){
        if (s == t){
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        boolean[] visited = new boolean[v];
        visited[s] = true;
        int[] pre = new int[v];
        for (int i = 0; i < v; i++){
            pre[i] = -1;
        }
        while (!queue.isEmpty()){
            int cur = queue.poll();
            for (int i = 0; i < adj[cur].size(); ++i){
                int q = adj[cur].get(i);
                if (visited[q]){
                    continue;
                }
                if (q == t){
                    return;
                }
                pre[q] = cur;
                queue.add(q);
            }
        }
    }

    private void print(int[] pre, int s, int t){
        if (pre[t] != -1 && t != s){
            print(pre, s, pre[t]);
        }
        System.out.println(t + " ");
    }

    /**
     * 深度优先
     * @param s
     * @param t
     */
    boolean found = false;
    public void dfs(int s, int t){
        if (s == t){
            return;
        }
        found = false;
        boolean[] visited = new boolean[v];
        int[] pre = new int[v];
        for (int i = 0; i < v; ++i){
            pre[i] = -1;
        }
        recurDfs(s, t, visited, pre);
        print(pre, s, t);
    }

    public void recurDfs(int s, int t, boolean[] visited, int[] pre){
        if (found){
            return;
        }
        visited[s] = true;
        if (s == t){
            found = true;
            return;
        }
        for (int i = 0; i < adj[s].size(); ++i){
            int q = adj[s].get(i);
            if (!visited[q]){
                pre[q] = s;
                recurDfs(q, t, visited, pre);
            }
        }
    }
}
