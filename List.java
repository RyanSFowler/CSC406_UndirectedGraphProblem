package project2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public abstract class List extends UndirectedGraph
{
	ArrayList<Edge> [] AL;
	public int[] adjacentVertices(int i)
	{
		int [] temp = new int[AL[i].size()];
		int hold =0;
		for(int y=0; y<vertexCount; y++)
		{
			if(existsEdge(i,y))
			{
				temp[hold]=y;
				hold++;
			}
		}
		return temp;
	}
	public boolean areAdjacent(int i, int j)
	{
		return existsEdge(i,j);
	}
	public boolean existsEdge(int i , int j)
	{
		return (AL[i].contains(new Edge(i,j,1)));
	}
	public void putEdge(int i, int j, int w)
	{	
		if(rangeCheck(i) && rangeCheck(j))
		{
			if(!existsEdge(i,j))
			{
				AL[i].add(new Edge(i,j,w));
				AL[j].add(new Edge(j,i,w));
				edgeCount ++;
				Degree[j]+=1;
				Degree[i]+=1;
			}
		}
	}
	public void removeEdge(int i, int j)
	{
		if(rangeCheck(i) && rangeCheck(j))
		{
			AL[i].remove(new Edge(i,j,1));
			AL[j].remove(new Edge(j,i,1));
			edgeCount--;
			Degree[j]-=1;
			Degree[i]-=1;
		}
	}
	public void createList(String x)
	{		
		File file = new File(x);
		Scanner myFileIn;
		{
			try
			{
				myFileIn= new Scanner(file);
				vertexCount = myFileIn.nextInt();
				AL=new ArrayList[vertexCount];
				for(int i=0; i<vertexCount;i++)
				{
					AL[i]= new ArrayList();
					
				}
				Degree = new int[vertexCount];
				while(myFileIn.hasNext())
				{
					int source = myFileIn.nextInt();
					int dest = myFileIn.nextInt();
					int w = myFileIn.nextInt();
					Edge a = new Edge (source,dest,w);
					putEdge(a);
				}
				myFileIn.close();
			}catch (FileNotFoundException e)
			{
				System.out.println("File: "+ x + " is not found");
			}
		}
	}
}

