package misc;

import algos.UnionFind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * There are n houses in a village. We want to supply water for all the houses by building wells and laying pipes.
 * For each house i, we can either build a well inside it directly with cost wells[i], or pipe in water from another well to it.
 * The costs to lay pipes between houses are given by the array pipes,
 * where each pipes[i] = [house1, house2, cost] represents the cost to connect house1 and house2 together using a pipe.
 * Connections are bidirectional. Find the minimum total cost to supply water to all houses.
 *
 * Example:
 * Input: n = 3, wells = [1,2,2], pipes = [[1,2,1],[2,3,1]]
 * Output: 3
 *
 * Explanation:
 * The image shows the costs of connecting houses using pipes.
 * The best strategy is to build a well in the first house with cost 1 and connect the other houses to it with cost 2
 * so the total cost is 3.
 *
 * Constraints:
 * 1 <= n <= 10000
 * wells.length == n
 * 0 <= wells[i] <= 10^5
 * 1 <= pipes.length <= 10000
 * 1 <= pipes[i][0], pipes[i][1] <= n
 * 0 <= pipes[i][2] <= 10^5
 * pipes[i][0] != pipes[i][1]
 *
 */

public class VillageWaterDistribution {

    // Step: 1 join edges and sort based on lowest cost.
    // Step: 2 start joining based on lowest cost and not forming a cycle.
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        List<EdgeC> edgeCosts = new ArrayList<>();
        for (int i=0; i< pipes.length; i++){
            edgeCosts.add(new EdgeC(pipes[i][0], pipes[i][1], pipes[i][2]));
        }
        for (int i=1; i< wells.length; i++){
            edgeCosts.add(new EdgeC(0, i, wells[i-1]));
        }
        Collections.sort(edgeCosts);
        UnionF uf = new UnionF(n+1);
        // finding minimum spanning tree
        int minCost = 0;
        for (EdgeC edgeC : edgeCosts){
            int x = uf.findRoot(edgeC.node1);
            int y = uf.findRoot(edgeC.node2);
            if (x == y) continue;
            minCost += edgeC.cost;
            uf.union(edgeC.node1, edgeC.node2);
            n--;
            if (n <= 0){
                return minCost;
            }
        }
        return minCost;
    }

    public static void main(String[] args) {
        int n = 3;
        int[] wells = new int[] {1,2,2};
        int[][] pipes = new int[][] {{1,2,1}, {2,3,1}};
        VillageWaterDistribution vwd = new VillageWaterDistribution();
        int result = vwd.minCostToSupplyWater(n, wells, pipes);
        System.out.println("Minimum Cost to be: " + result);

        //input 2:
        int n2 = 2;
        int[] wells2 = new int[]{1,1};
        int[][] pipes2 = new int[][]{{1,2,1}, {1,2,2}};
        result = vwd.minCostToSupplyWater(n2, wells2, pipes2);
        System.out.println("Minimum Cost to be: " + result);
    }

    class UnionF {
        int[] parent;
        int[] size;

        UnionF(int n){
            this.parent = new int[n];
            this.size = new int[n];
            for (int i=0; i<n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        int findRoot(int p){
            int root = p;
            while(root != parent[root]){
                root = parent[root];
            }
            return root;
        }

        void union(int node1, int node2){
            int s1 = findRoot(node1);
            int s2 = findRoot(node2);
            if (size[s1] >= size[s2]){
                parent[node2] = node1;
                size[node1] += size[node2];
                size[node2] = 0;
            }else {
                parent[node1] = node2;
                size[node2] += size[node1];
                size[node1] = 0;
            }
        }
    }


    class EdgeC implements Comparable<EdgeC>{
        int cost;
        int node1;
        int node2;
        EdgeC(int node1, int node2, int cost){
            this.cost = cost;
            this.node1 = node1;
            this.node2 = node2;
        }
        @Override
        public int compareTo(EdgeC o) {
            return this.cost - o.cost;
        }
    }



}
