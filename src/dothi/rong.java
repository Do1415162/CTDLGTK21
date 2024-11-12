package dothi;

import java.util.*;

public class rong {
    private int V; // Số đỉnh
    private LinkedList<Integer> adj[]; // Danh sách kề

    // Hàm khởi tạo
    rong(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    // Phương thức thêm cạnh vào đồ thị
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // Phương thức duyệt BFS
    void BFS(int s) {
        // Đánh dấu tất cả các đỉnh là chưa được thăm
        boolean visited[] = new boolean[V];

        // Tạo một hàng đợi cho BFS
        LinkedList<Integer> queue = new LinkedList<>();

        // Đánh dấu đỉnh hiện tại là đã thăm và thêm nó vào hàng đợi
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            // Lấy đỉnh ra khỏi hàng đợi và in ra
            s = queue.poll();
            System.out.print(s + " ");

            // Lấy tất cả các đỉnh kề của đỉnh đã được lấy ra
            // Nếu một đỉnh kề chưa được thăm, đánh dấu nó là đã thăm và thêm vào hàng đợi
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    // Phương thức main
    public static void main(String args[]) {
        rong g = new rong(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal starting from vertex 2:");
        g.BFS(2);
    }
}
