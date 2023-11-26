import it.unibo.generics.graph.api.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GraphImpl<N> implements Graph<N>{
      /**
     * Aggiunge un nodo: non succede nulla se il nodo è nullo o è già presente.
     * 
     * @param node
     *            the node to add
     */
    Set<ArrayList<N>> Graph;
    public void addNode(N node){
       
    }

    /**
     * Adds an edge: nothing happens if source or target are null.
     * 
     * @param source
     *            starting node
     * @param target
     *            ending node
     */
    public void addEdge(N source, N target){

    }

    /**
     * @return all the nodes
     */
    public Set<N> nodeSet(){
        return null;
    }

    /**
     * Returns all the nodes directly targeted from a node.
     * 
     * @param node
     *            the node
     * @return all the nodes directly targeted from the passed node
     */
    public Set<N> linkedNodes(N node){
        return null;
    }

    /**
     * Gets one sequence of nodes connecting source to target.
     * 
     * @param source
     *            the source node
     * @param target
     *            the target node
     * @return a sequence of nodes connecting sources and target
     */
    public List<N> getPath(N source, N target){
        return null;
    }

    
}
