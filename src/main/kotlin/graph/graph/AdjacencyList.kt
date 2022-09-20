package graph.graph

class AdjacencyList<T> : Graph<T> {

    private val adjacencies: HashMap<Vertex<T>, ArrayList<Edge<T>>> = HashMap()

//    companion object {
//        fun <T> createVertices(vertices: Iterable<T>) : AdjacencyList<T>  {
//            val graph = AdjacencyList<T>()
//            vertices.forEach { data ->
//                graph.createVertex(data)
//            }
//            return graph
//        }
//    }

    override fun createVertex(data: T): Vertex<T> {
        val vertex = Vertex(adjacencies.count(), data)
        adjacencies[vertex] = ArrayList()
        return vertex
    }

    override fun addDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        val edge = Edge(source, destination, weight)
        adjacencies[source]?.add(edge)
    }

    override fun addUndirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        addDirectedEdge(source, destination, weight)
        addDirectedEdge(destination, source, weight)
    }

    override fun add(edge: EdgeType, source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        when (edge) {
            EdgeType.DIRECTED -> addDirectedEdge(source, destination, weight)
            EdgeType.UNDIRECTED -> addUndirectedEdge(source, destination, weight)
        }
    }

    override fun edges(source: Vertex<T>): ArrayList<Edge<T>> =
        adjacencies[source] ?: arrayListOf()

    override fun weight(source: Vertex<T>, destination: Vertex<T>): Double? {
        return edges(source).firstOrNull { edge ->
            edge.destination == destination
        }?.weight
    }

    override fun toString(): String {
        return buildString {
            adjacencies.forEach { (vertex, edges) ->
                val edgeString = edges.joinToString { edge ->
                    edge.destination.data.toString()
                }
                append("${vertex.data} ---> [ $edgeString ]\n")
            }
        }
    }

}

//fun <T> graphOf(vararg vertices: T) : AdjacencyList<T>
//{
//    return AdjacencyList.createVertices(vertices.asList())
//}

