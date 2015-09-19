import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
	 * 
	 *  @author TheDarkLord a.k.a Gaurav Shrivastava
	 * 
*/


public class Digraph {

	public Map<Integer, Set<Integer>> edges = new TreeMap<Integer, Set<Integer>>();
	private ArrayList<Integer>[] adj;    // adj[v] = adjacency list for vertex v
    private int[] indegree;
	  /**
	   * Returns the number of vertices in this graph.
	   *
	   * @return the number of vertices in this graph
	   */
	  private int V = 0;
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
	  
	  public Digraph(int V) {
	        if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
	        this.V = V;
	        this.E = 0;
	        indegree = new int[V];
	        adj = (ArrayList<Integer>[]) new ArrayList[V];
	        for (int v = 0; v < V; v++) {
	            adj[v] = new ArrayList<Integer>();
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
//	      if (v < 0 || v >= V)
//	          throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
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
	public int outdegree(int v) {
       // validateVertex(v);
        return adj[v].size();
    }

    /**
     * Returns the number of directed edges incident to vertex <tt>v</tt>.
     * This is known as the <em>indegree</em> of vertex <tt>v</tt>.
     *
     * @param  v the vertex
     * @return the indegree of vertex <tt>v</tt>               
     * @throws IndexOutOfBoundsException unless 0 <= v < V
     */
    public int indegree(int v) {
        return indegree[v];
    }

    /**
     * Returns the reverse of the digraph.
     *
     * @return the reverse of the digraph
     */
    public Digraph reverse() {
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj(v)) {
                R.addEdge(w, v);
            }
        }
        return R;
    }
}
