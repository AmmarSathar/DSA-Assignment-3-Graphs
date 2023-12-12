//package coen352.ch11.graph.am;
//
//import static org.junit.Assert.assertTrue;
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.Test;
//
///** Source code example for "A Practical Introduction to Data
//    Structures and Algorithm Analysis, 3rd Edition (Java)"
//    by Clifford A. Shaffer
//    Copyright 2008-2011 by Clifford A. Shaffer
//*/
//
//// Graph operation main function.
//// To use: java -ea GraphTest <graphfile>
//
//import java.io.*;
//import java.util.*;
//
//public class CourseSequenceTest
//
//{
//
//	static final int UNVISITED = 0;
//	static final int VISITED = 1;
//
//	String filename = "C:\\Users\\user\\Desktop\\Concordia\\FALL 2023\\COEN352\\Assignments\\40182146_COEN_352_ASSIGNMENT_3\\src\\coen352\\ch11\\graph\\graphfiles\\testfile-course-sequence.gph";
//
//	// Create a graph from file
//	static Graph createGraph(BufferedReader file, Graph G)
//	throws IOException
//	{
//			  String line = null;
//			  StringTokenizer token;
//			  boolean undirected = false;
//			  int i, v1, v2, weight;
//
//			  assert (line = file.readLine()) != null :
//			         "Unable to read number of vertices";
//			  while(line.charAt(0) == '#')
//			  assert (line = file.readLine()) != null :
//			         "Unable to read number of vertices";
//			  token = new StringTokenizer(line);
//
//			  int n = Integer.parseInt(token.nextToken());
//			  G.Init(n);
//
//			  for (i=0; i<n; i++)
//			    G.setMark(i, UNVISITED);
//
//			  assert (line = file.readLine()) != null :
//			         "Unable to read graph type";
//
//			  if (line.charAt(0) == 'U')
//			    undirected = true;
//			  else if (line.charAt(0) == 'D')
//			    undirected = false;
//			  else assert false : "Bad graph type: " + line;
//
//			  // Read in edges
//			  while((line = file.readLine()) != null) {
//				token = new StringTokenizer(line);
//			    v1 = Integer.parseInt(token.nextToken());
//			    v2 = Integer.parseInt(token.nextToken());
//			    //if (token.hasMoreTokens())
//			      //weight = Integer.parseInt(token.nextToken());
//			    //else // No weight given -- set at 1
//			      weight = 1;
//			    G.setEdge(v1, v2, weight);
//			    if (undirected) // Put in edge in other direction
//			      G.setEdge(v2, v1, weight);
//			  }
//			  return G;
//	}
//
//
//	static void Gprint(Graph G, StringBuffer out) {
//		  int i, j;
//
//		  for (i=0; i<G.n(); i++) {
//		    for(j=0; j<G.n(); j++)
//		      if (G.weight(i, j) == Integer.MAX_VALUE)
//		        out.append("0 ");
//		      else
//		        out.append(G.weight(i, j) + " ");
//		  }
//	}
//
//
//
//	@Test
//	public void testGetPrerequisites() throws IOException{
//		BufferedReader f;
//
//		f = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
//
//		Graphm G = new Graphm();
//
//		CourseSequenceSolver C = new CourseSequenceSolver(createGraph(f, G));
//
//		// Test the getPrerequisites method
//		String[] result = C.getPrerequisites("COEN244");
//
//		assertArrayEquals(new String[]{"COEN243"}, result);
//	}
//    @Test
//	public void testGetCourseSequence() throws IOException{
//		BufferedReader f;
//
//		f = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
//
//		Graphm G = new Graphm();
//
//		CourseSequenceSolver C = new CourseSequenceSolver(createGraph(f, G));
//
//		// Test the getPrerequisites method
//		String[] result = C.getCourseSequence("COEN244");
//
//		assertArrayEquals(new String[]{"COEN243","MATH204"}, result);
//	}
//
//	@Test
//	public void testIsPrerequisite() throws IOException{
//		BufferedReader f;
//
//		f = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
//
//		Graphm G = new Graphm();
//
//		CourseSequenceSolver C = new CourseSequenceSolver(createGraph(f, G));
//
//		// Test the getPrerequisites method
//		boolean result = C.isPrerequisite("COEN243","COEN244");
//
//		assertTrue("COEN243 should be a prerequisite for COEN244", result);
//	}
//	public static void printGraph(Graph graph) {
//		System.out.println("Graph (Adjacency Matrix):");
//		System.out.print("   ");
//		for (int i = 0; i < graph.n(); i++) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
//
//		for (int i = 0; i < graph.n(); i++) {
//			System.out.print(i + ": ");
//			for (int j = 0; j < graph.n(); j++) {
//				System.out.print(graph.weight(i, j) + " ");
//			}
//			System.out.println();
//		}
//	}
//
//
//
//}