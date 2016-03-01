package project2;

public class Edge
	{
	private int sourceVertex;
	private int destinationVertex;
	private int weight;
	public Edge(int source, int dest, int w)
	{
		sourceVertex = source;
		destinationVertex = dest;
		weight = w;
	}
	public int getWeight()
	{
		return weight;
	}
	public int getDestination()
	{
		return destinationVertex;
	}
	public int getSource()
	{
		return sourceVertex;
	}
	public void setDestination(int in)
	{
		destinationVertex = in;
	}
	public void setSource(int out){
		sourceVertex = out;
	}
	public void setWeight(int w){
		weight =w;
	}
	public boolean equals(Object e){
		Edge e1 =(Edge)e;
		return ((e1.getSource() == sourceVertex && e1.getDestination() == destinationVertex));
	}
	public String toString(Edge e){
		return ("There is and edge from "+ sourceVertex + " to "+ destinationVertex+" with the weight of "+ weight);
	}
}
