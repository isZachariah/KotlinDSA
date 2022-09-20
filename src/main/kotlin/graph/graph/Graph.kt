package graph.graph

import queue.ArrayListQueue

/***            depth first traversal
 *
 * Implemented with a Stack data structure:
 * add to the top, remove from the top. LIFO
 * Travels as far as possible in a single direction,
 * changes direction and continues exploring the graph
 * in this manor.
 *
 *              breadth first traversal
 *
 * Implemented with a Queue data structure:
 * add to the bottom, remove from the top. FIFO
 * Explores all immediate neighboring nodes, then explores
 * the immediate neighbors immediate neighbor nodes and
 * traverses the entire graph in this manor.
 *
 */

fun main() {

}


interface Graph<T> {
    fun createVertex(data: T) : Vertex<T>

    fun addDirectedEdge(source: Vertex<T>,
                        destination: Vertex<T>,
                        weight: Double?)

    fun addUndirectedEdge(source: Vertex<T>,
                          destination: Vertex<T>,
                          weight: Double?
    ) {
        addDirectedEdge(source, destination, weight)
        addDirectedEdge(destination, source, weight)
    }

    fun add(edge: EdgeType,
            source: Vertex<T>,
            destination: Vertex<T>,
            weight: Double?
    ) {
        when (edge) {
            EdgeType.DIRECTED -> addDirectedEdge(source, destination, weight)
            EdgeType.UNDIRECTED -> addUndirectedEdge(source, destination, weight)
        }
    }


    fun edges(source: Vertex<T>) : ArrayList<Edge<T>>

    fun weight(source: Vertex<T>,
               destination: Vertex<T>
    ) : Double?

    fun breadthFirstSearch(source: Vertex<T>) : ArrayList<Vertex<T>> {
        val queue = ArrayListQueue<Vertex<T>>()
        val enqueued = ArrayList<Vertex<T>>()
        val visited = ArrayList<Vertex<T>>()

        queue.enqueue(source)
        enqueued.add(source)

        while (true) {
            val vertex = queue.dequeue() ?: break

            visited.add(vertex)

            val neighborEdges = edges(vertex)
            neighborEdges.forEach { edge ->
                if (!enqueued.contains(edge.destination)) {
                    queue.enqueue(edge.destination)
                    enqueued.add(edge.destination)
                }
            }
        }

        return visited
    }






}

data class Vertex<T>(
    val index: Int,
    val data: T
    )

data class Edge<T>(
    val source: Vertex<T>,
    val destination: Vertex<T>,
    val weight: Double? = null
)

enum class EdgeType {
    DIRECTED,
    UNDIRECTED
}


