package algos;

public class UnionFind {

    private int[] parent;
    private int[] size;

    public UnionFind(int n){
        parent = new int[n];
        size = new int[n];
        for (int i=0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int p){
        int root = p;
        while(root != parent[root]){
            root = parent[root];
        }
        //path compression: this makes finding the root in constant time (AFTER the initial compression).
        while(p != root){
            int next = parent[p];
            parent[p] = root;
            p = next;
        }
        return root;
    }

    public void unionFind(int p, int q){
        int px = find(p);
        int qx = find(q);
        if (px == qx) {
            System.out.println(px + " and " + qx + " are forming a cycle.");
            return;
        }

        if (size[px] >= size[qx]){
            size[px] += size[qx];
            parent[qx] = px;
            size[qx] = 0;
        }else {
            size[qx] += size[px];
            parent[px] = qx;
            size[px] = 0;
        }
    }

    public static void main(String[] args) {
        /**
         *    0 1 2 3 4
         */

        UnionFind uf = new UnionFind(5);
        int n = 3;
        int root = uf.find(n);
        System.out.println("Root of " + n + ": " + root);
        n = 1;
        root = uf.find(n);
        System.out.println("Root of " + n + ": " + root);
        System.out.println("Beginning unionFind operation...");
        uf.unionFind(0, 1);
        uf.unionFind(0, 2);
        uf.unionFind(0, 3);
        n = 0;
        root = uf.find(n);
        System.out.println("Root of " + n + ": " + root);
        n = 3;
        root = uf.find(n);
        System.out.println("Root of " + n + ": " + root);
        n = 4;
        root = uf.find(n);
        System.out.println("Root of " + n + ": " + root);
        uf.unionFind(0, 4);
        n = 4;
        root = uf.find(n);
        System.out.println("Root of " + n + ": " + root);

        System.out.println("Printing Array Size... ");
        for (int i=0; i<uf.size.length; i++){
            System.out.print(i + " : " + uf.size[i]);
            System.out.println();
        }
    }

}
