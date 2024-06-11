package com.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MostDistantNode {

    class Node {
        int n;
        List<Node> linkedNodes = new LinkedList<>();
        boolean visited = false;
        int distance = 0;

        public Node(int n) {
            this.n = n;
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3, 6},{4, 3},{3, 2},{1, 3},{1, 2},{2, 4}, {5, 2}};

        int answer = new MostDistantNode().solution(n, edge);
        System.out.println("answer = " + answer);
    }

    public int solution(int n, int[][] edge) {
        int answer = 0;

        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodes.add(new Node(i + 1));
        }

        for (int[] link : edge) {
            int node1 = link[0];
            int node2 = link[1];
            Node nodeA = nodes.get(node1 - 1);
            Node nodeB = nodes.get(node2 - 1);
            nodeA.linkedNodes.add(nodeB);
            nodeB.linkedNodes.add(nodeA);
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(nodes.get(0));
        nodes.get(0).visited = true;

        int maxDistance = 0;
        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (Node linkedNode : now.linkedNodes) {
                if (linkedNode.visited) {
                    continue;
                }
                linkedNode.visited = true;
                linkedNode.distance = now.distance + 1;

                maxDistance = Math.max(maxDistance, linkedNode.distance);
                queue.offer(linkedNode);
            }
        }

        for (Node node : nodes) {
            if (node.distance == maxDistance) {
                answer++;
            }
        }

        return answer;
    }
}
