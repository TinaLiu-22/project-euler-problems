package com.projecteuler.problems.active.problem83;

import com.projecteuler.utils.ReadFileUtil;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class Problem83 {

    public void solve() {

        // Retrieve 80x80 matrix
//        var matrix = ReadFileUtil.readCSVFile("src/main/java/com/projecteuler/problems/active/problem83/0083_matrix.txt");
//        System.out.println(matrix.size());
//        System.out.println(matrix.get(0).size());
//
//        matrix.stream().map(row -> {
//            row.stream().map(vertex -> {
//               Integer.parseInt()
//            });
//        })
//
//        Graph<Integer, DefaultWeightedEdge> graph = new WeightedMultigraph<>(DefaultWeightedEdge.class);
//        for (int i = 0; i < matrix.size(); i++) {
//            for (int j = 0; j < matrix.get(0).size(); j++) {
//                graph.add(i * matrix.size() + j);
//                grao
//            }
//        }
    }

    public void solveShortestCostPath() {

    }

    public static void main(String[] args) {
        Problem83 problem83 = new Problem83();
        problem83.solve();
    }
}
