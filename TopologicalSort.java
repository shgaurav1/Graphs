import java.util.Stack;
/**
 * 
 *  @author TheDarkLord a.k.a Gaurav Shrivastava
 */
public class DepthFirstOrder {

	private boolean marked[];
	private Stack<Integer> reversePost;
	public DepthFirstOrder(Graph G){
		reversePost = new Stack<Integer>();
		marked = new boolean[G.V()];
		for(int v = 0; v < G.V(); v++){
			if(!marked[v])dfs(G,v);
		}
	}
	
	private void dfs(Graph G, int v){
		marked[v] = true;
		for(int w:G.adj(v)){
			if(!marked[w]){
				dfs(G,w);
			}
		}
		reversePost.push(v);
	}
	/**
	 * 
	 * @return all vertices in 'reverse DFS postorder'
	 */
	public Iterable<Integer> reversePost()
	{
		return reversePost;
	}
	
}