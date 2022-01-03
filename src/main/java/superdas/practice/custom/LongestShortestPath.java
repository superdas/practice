package superdas.practice.custom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class LongestShortestPath {
  public static void main(String[] args) {
    System.out.println("superdas.practice.custom.LongestShortestPath by neildas@");
    // Build map.
    Node root = createMap();

    // Print map.
    printMap(root);

    // Find the shortest longest path.
    findShortestLongestPath(root);
  }

  static void findShortestLongestPath(Node root) {
    HashMap<Node, Integer> nodeToDistanceFromRoot = new HashMap<>();
    nodeToDistanceFromRoot.put(root, 0);
    findShortestLongestPathHelper(root, new HashSet<Node>(), nodeToDistanceFromRoot);
    int maxDistanceFromRoot = 0;
    Node nodeWithMaxDistanceFromRoot = root;
    for (Node node : nodeToDistanceFromRoot.keySet()) {
      int possibleNewMax = nodeToDistanceFromRoot.get(node);
      System.out.println("Shortest path from root to " + node.name + " is " + possibleNewMax + ".");
      if (possibleNewMax > maxDistanceFromRoot) {
        nodeWithMaxDistanceFromRoot = node;
        maxDistanceFromRoot = possibleNewMax;
      }
    }
    System.out.println("Shortest longest path is " + maxDistanceFromRoot
        + " from root to " + nodeWithMaxDistanceFromRoot.name + ".");
  }

  static void findShortestLongestPathHelper(Node node, HashSet<Node> visited, HashMap<Node, Integer> nodeToDistanceFromRoot) {
    visited.add(node);
    int distanceFromRoot = nodeToDistanceFromRoot.get(node);
    for (AdjacentNode adjacent : node.adjacentNodes) {
      if (visited.contains(adjacent.node)) {
        continue;
      }

      int proposedNewDistance = distanceFromRoot + adjacent.distance;
      if (!nodeToDistanceFromRoot.containsKey(adjacent.node) || nodeToDistanceFromRoot.get(adjacent.node) > proposedNewDistance) {
        nodeToDistanceFromRoot.put(adjacent.node, proposedNewDistance);
      }

      findShortestLongestPathHelper(adjacent.node, visited, nodeToDistanceFromRoot);
    }
    visited.remove(node);
  }

  // Creates a map with the following structure:
  // A --5--> B --2--> C --4--> D
  //   --3--> E          --1--> F
  //   --8--> G --6--> H
  //   --2--> H --1--> C --9--> E
  static Node createMap() {
    Node a = new Node("a");
    Node b = new Node("b");
    Node c = new Node("c");
    Node d = new Node("d");
    Node e = new Node("e");
    Node f = new Node("f");
    Node g = new Node("g");
    Node h = new Node("h");

    connectNodes(a, b, 5);
    connectNodes(a, e, 3);
    connectNodes(a, g, 8);
    connectNodes(a, h, 2);

    connectNodes(b, c, 2);
    
    connectNodes(c, d, 4);
    connectNodes(c, f, 1);

    connectNodes(g, h, 6);

    connectNodes(h, c, 1);

    connectNodes(c, e, 9);

    return a;
  }

  static void connectNodes(Node start, Node end, int distance) {
    start.adjacentNodes.add(new AdjacentNode(end, distance));
    end.adjacentNodes.add(new AdjacentNode(start, distance));
  }

  static void printMap(Node node) {
    System.out.println("Behold, the map!");
    printMapHelper(node, new HashSet<Node>());
  }

  static void printMapHelper(Node node, HashSet<Node> visited) {
    visited.add(node);
    System.out.println(node.name);
    for (AdjacentNode adjacent : node.adjacentNodes) {
      System.out.println("  --" + adjacent.distance + "--> " + adjacent.node.name);
    }
    for (AdjacentNode adjacent : node.adjacentNodes) {
      if (visited.contains(adjacent.node)) {
        continue;
      }
      printMapHelper(adjacent.node, visited);
    }
  }

  static class Node {
    final String name;
    final ArrayList<AdjacentNode> adjacentNodes = new ArrayList<>();

    Node(String name) {
      this.name = name;
    }
  }

  static class AdjacentNode {
    final Node node;
    final int distance;

    AdjacentNode(Node node, int distance) {
      this.node = node;
      this.distance = distance;
    }
  }
}
