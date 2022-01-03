package superdas.practice.custom;

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ArrayList;

public class MeshMessage {

  public static void main(String[] args) {
    System.out.println("Start superdas.practice.custom.MeshMessage.");

    Map<String, String[]> network = new HashMap<>();
    network.put("Min", new String[] {"William", "Jayden", "Omar"});
    network.put("William", new String[] {"Min", "Noam"});
    network.put("Jayden", new String[] {"Min", "Amelia", "Ren", "Noam"});
    network.put("Ren", new String[] {"Jayden", "Omar"});
    network.put("Amelia", new String[] {"Jayden", "Adam", "Miguel"});
    network.put("Adam", new String[] {"Amelia", "Miguel", "Sofia", "Lucas"});
    network.put("Miguel", new String[] {"Amelia", "Adam", "Liam", "Nathan"});
    network.put("Noam", new String[] {"Nathan", "Jayden", "William"});
    network.put("Omar", new String[] {"Ren", "Min", "Scott"});

    String fromUser = "Jayden";
    String toUser = "Neil";
    System.out.println("Shortest path from " + fromUser + " to " + toUser + ": "
    + Arrays.toString(findShortestPath(fromUser, toUser, network)));

    System.out.println("End superdas.practice.custom.MeshMessage.");
  }

  private static String[] findShortestPath(String fromUser, String toUser, Map<String, String[]> network) {
    if (fromUser.equals(toUser)) {
      return new String[] {fromUser};
    }

    Map<String, String> childToParent = new HashMap<>();
    childToParent.put(fromUser, null);
    LinkedList<String> queue = new LinkedList<>();
    queue.add(fromUser);

    while (!queue.isEmpty()) {
      String node = queue.remove();

      if (node.equals(toUser)) {
        LinkedList<String> path = new LinkedList<>();
        while (node != null) {
          path.addFirst(node);
          node = childToParent.get(node);
        }
        return path.toArray(new String[0]);
      }

      if (!network.containsKey(node)) {
        continue;
      }

      String[] adjacentNodes = network.get(node);
      for (String adjacentNode : adjacentNodes) {
        if (childToParent.containsKey(adjacentNode)) {
          continue;
        }
        childToParent.put(adjacentNode, node);
        queue.add(adjacentNode);
      }
    }

    return new String[] {"Error: No path exists."};
  }

}
