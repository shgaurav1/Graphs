import java.util.*;

/**
 * 
 *  @author TheDarkLord a.k.a Gaurav Shrivastava
 */

public class Graph {
  public Map<Integer, Set<Integer>> edges = new TreeMap<Integer, Set<Integer>>();

  /**
   * Returns the number of vertices in this graph.
   *
   * @return the number of vertices in this graph
   */
  private final int V = 0;
  private int E = 0;
  
  public int V() {
      return V;
  }

  /**
   * Returns the number of edges in this graph.
   *
   * @return the number of edges in this graph
   */
  public int E() {
      return E;
  }
  
  /**
   * Adds the undirected edge v-w to this graph.
   *
   * @param  v one vertex in the edge
   * @param  w the other vertex in the edge
   * @throws IndexOutOfBoundsException unless both 0 <= v < V and 0 <= w < V
   */
  
  public void addNode(int u) {
    if (!edges.containsKey(u)) {
      edges.put(u, new TreeSet<Integer>());
    }
  }

  public void removeNode(int u) {
    if (!edges.containsKey(u)) {
      return;
    }
    for (int v : edges.get(u)) {
      edges.get(v).remove(u);
    }
    edges.remove(u);
  }

  public void addEdge(int u, int v) {
    addNode(u);
    addNode(v);
    edges.get(u).add(v);
    //edges.get(v).add(u);
  }

  public void removeEdge(int u, int v) {
    edges.get(u).remove(v);
    //edges.get(v).remove(u);
  }
//  private void validateVertex(int v) {
//      if (v < 0 || v >= V)
//          throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
//  }
  public Iterable<Integer> adj(int v) {
     // validateVertex(v);
      return edges.get(v);
  }

  /**
   * Returns the degree of vertex <tt>v</tt>.
   *
   * @param  v the vertex
   * @return the degree of vertex <tt>v</tt>
   * @throws IndexOutOfBoundsException unless 0 <= v < V
   */
  public int degree(int v) {
     // validateVertex(v);
      return edges.get(v).size();
  }
  // Usage example
  public static void main(String[] args) {
    Graph g = new Graph();
    g.addEdge(0, 1);
    g.addEdge(1, 2);
    System.out.println(g.adj(1));
    System.out.println(g.degree(0));
    g.removeEdge(1, 0);
    System.out.println(g.edges);
    g.removeNode(1);
    System.out.println(g.edges);

  }
}
