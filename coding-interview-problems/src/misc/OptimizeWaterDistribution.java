package misc;


import algos.UnionFind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * There are n houses in a village. We want to supply water for all the houses by building wells and laying pipes.
 *
 * For each house i, we can either build a well inside it directly with cost wells[i],
 * or pipe in water from another well to it. The costs to lay pipes between houses are given by the array pipes,
 * where each pipes[i] = [house1, house2, cost] represents the cost to connect house1 and house2 together using a pipe.
 * Connections are bidirectional.
 *
 * Find the minimum total cost to supply water to all houses.
 *
 * Example 1:
 *
 * Input: n = 3, wells = [1,2,2], pipes = [[1,2,1],[2,3,1]]
 * Output: 3
 * Explanation:
 * The image shows the costs of connecting houses using pipes.
 * The best strategy is to build a well in the first house with cost 1 and connect the other houses to it with cost 2 so the total cost is 3.
 *
 * Constraints:
 *
 * 1 <= n <= 10000
 * wells.length == n
 * 0 <= wells[i] <= 10^5
 * 1 <= pipes.length <= 10000
 * 1 <= pipes[i][0], pipes[i][1] <= n
 * 0 <= pipes[i][2] <= 10^5
 * pipes[i][0] != pipes[i][1]
 *
 */
public class OptimizeWaterDistribution {

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        List<EdgeCost> edgeCostList = new ArrayList<>();
        for (int i=1; i<=n; i++){
            edgeCostList.add(new EdgeCost(0, i, wells[i-1]));
        }
        for (int i=0; i<pipes.length; i++){
            edgeCostList.add(new EdgeCost(pipes[i][0], pipes[i][1], pipes[i][2]));
        }
        Collections.sort(edgeCostList);
        UnionFind uf = new UnionFind(n+1);
        int minCost = 0;
        for (EdgeCost edge : edgeCostList){
            int x = uf.find(edge.node1);
            int y = uf.find(edge.node2);
            if (x == y) continue;

            uf.unionFind(x, y);
            minCost += edge.cost;
            n--;

            if (n == 0){
                return minCost;
            }
        }
        return minCost;
    }

    class EdgeCost implements Comparable<EdgeCost>{
        int node1;
        int node2;
        int cost;
        public EdgeCost(int node1, int node2, int cost){
            this.node1 = node1;
            this.node2 = node2;
            this.cost = cost;
        }

        @Override
        public int compareTo(EdgeCost o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int[] wells = new int[] {1,2,2};
        int[][] pipes = new int[][] {{1,2,1}, {2,3,1}};
        OptimizeWaterDistribution owd = new OptimizeWaterDistribution();
        int result = owd.minCostToSupplyWater(n, wells, pipes);
        System.out.println("Minimum Cost to be: " + result);

        //input 2:
        int n2 = 2;
        int[] wells2 = new int[]{1,1};
        int[][] pipes2 = new int[][]{{1,2,1}, {1,2,2}};
        result = owd.minCostToSupplyWater(n2, wells2, pipes2);
        System.out.println("Minimum Cost to be: " + result);

    }

}
