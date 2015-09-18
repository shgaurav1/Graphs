import java.util.Stack;

/**
 * 
 *  @author TheDarkLord a.k.a Gaurav Shrivastava
 */


public class DepthFirstPaths {

	private boolean[] marked;    // marked[v] = is there an s-v path?
    private int[] edgeTo;        // edgeTo[v] = last edge on s-v path
    private final int s;         // source vertex
    
    /**
     * Computes a path between <tt>s</tt> and every other vertex in graph <tt>G</tt>.
     * @param G the graph
     * @param s the source vertex
     */
    private void DFS(Graph G, int v){
    	marked[v] = true;
    	for(int w : G.adj(v))
    		if(!marked[w]){
    			DFS(G,w);
    			edgeTo[w] = v;
    		}
    }
	public DepthFirstPaths(Graph G, int s){
		this.s = s;
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        DFS(G,s);
		
	}
	public boolean hasPathTo(int v){
		return marked[v];
	}
	public  Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<Integer>();
		for (int x = v; x != s; x = edgeTo[x])
			path.push(x);
		path.push(s);
		return path;
	}
}
