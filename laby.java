/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3_cauffet;
import java.io.File;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Random;

/**
 *
 * @author cleme
 */
public class laby
{       
        
	public static final int CELL_WIDTH = 20; // taille d'une case
	public static final int MARGIN = 50; // ecart entre une case et le mur
	public static final int DOT_SIZE = 10; // taille du point pour balayage DFS
	public static final int DOT_MARGIN = 5; // ecart entre le point et les murs
	private int N;
	private Cell[] cells; 
	private boolean[] path; 

	public laby(int n)
	{
		N = n;
		cells = new Cell[N * N]; 
		
		for (int i = 0; i < N * N; i++) 
		{
			cells[i] = new Cell();
		}
	
		if(N > 0)
		{
			makeWalls(); 
			clearWalls(); 
		
			path = new boolean[N * N];
			createPath();

		}
	}

	public class Cell 
	{
		int[] walls; 
		int visitedBy; 
		
		
		public Cell()
		{
			walls = new int[4];
			visitedBy = -1;
		}
	}
	
	final int NORTH = 0 ;
	final int SOUTH = 1 ;
	final int EAST = 2 ;
	final int WEST = 3 ;

	public void makeWalls() 
	
	{
		for (int i = 0; i < N * N; i++) 
		{
			cells[i].walls[NORTH] = i - N;
			cells[i].walls[SOUTH] = i + N;
			cells[i].walls[EAST] = i + 1;
			cells[i].walls[WEST] = i - 1;
		}
		
		for (int i = 0; i < N; i++)
		{
			cells[i].walls[NORTH] = -1; 
			cells[N * N - i - 1].walls[SOUTH] = -1; 
		}
		for (int i = 0; i < N * N; i += N)
		{
			cells[N * N - i - 1].walls[EAST] = -1; 
			
			cells[i].walls[WEST] = -1; 
		}
	}
        
	public void clearWalls() 
	
	{
		int NumElements = N * N;
		
		algo ds = new algo(NumElements); 
		for (int k = 0; k < N * N; k++)
		{
			ds.find(k); 
		}
		
		Random generator = new Random();
		while (ds.allConnected() == false) 
		{
			int cell1 = generator.nextInt(N * N); 
			int wall = generator.nextInt(4);
			
			int cell2 = cells[cell1].walls[wall]; 
			
			if (cell2 != -1 && cell2 != N * N) 
			{
				if (ds.find(cell1) != ds.find(cell2)) 
				{
					cells[cell1].walls[wall] = N * N; 
					
					
					if (wall == NORTH || wall == EAST)
					{
						cells[cell2].walls[wall + 1] = N * N;
					}
					if (wall == SOUTH || wall == WEST)
					{
						cells[cell2].walls[wall - 1] = N * N;
					}
					
					ds.union(ds.find(cell1), ds.find(cell2)); 
				}
			}
		}
	}

	public void createPath() 
	{
		if( N != 1) 
		{
			depthSearch(0); 
			
			path[0] = true;
			path[N * N - 1] = true; 
			
			int current = cells[N * N - 1].visitedBy;
			
			while (current != 0) 
			{
				path[current] = true;
				current = cells[current].visitedBy;
			}
		}
		else 
		{
			path[0] = true ;
		}

		cells[0].walls[WEST] = N * N; 
		cells[N * N - 1].walls[EAST] = N * N; 
		
	}

	public void depthSearch(int cell)
	{
		Cell startCell = cells[cell]; 
		
		for (int i = 0; i < 4; i++)
		{
			int adjacent = -1;
			
			if (startCell.walls[i] == N * N) 
			{
				if (i == NORTH)
				{
					adjacent = cell - N;
				}
				if (i == SOUTH)
				{
					adjacent = cell + N;
				}
				if (i == EAST)
				{
					adjacent = cell + 1;
				}
				if (i == WEST)
				{
					adjacent = cell - 1;
				}
				
				if (cells[adjacent].visitedBy == -1)
				{
					cells[adjacent].visitedBy = cell; 
					depthSearch(adjacent);
				}
			}
		}
	}

	public void draw(Graphics g) 
	{
           
		g.setColor(Color.BLACK);
		
		for (int i = 0; i < N; i++)
		{ 
			int count = i;
			for (int j = 0; j < N; j++)
			{
				if (j != 0)
				{
					count += N;
				}
				
				if (cells[count].walls[NORTH] != N * N) 
				{
					g.drawLine((i * CELL_WIDTH + MARGIN), (j * CELL_WIDTH + MARGIN),
						((i + 1) * CELL_WIDTH + MARGIN), (j * CELL_WIDTH + MARGIN));
				}
				
				if (cells[count].walls[SOUTH] != N * N) 
				{
					g.drawLine(i * CELL_WIDTH + MARGIN, (j + 1) * CELL_WIDTH
						+ MARGIN, (i + 1) * CELL_WIDTH + MARGIN, (j + 1) * CELL_WIDTH
						+ MARGIN);
				}
				
				if (cells[count].walls[EAST] != N * N)
				{
					g.drawLine((i + 1) * CELL_WIDTH + MARGIN, j * CELL_WIDTH
						+ MARGIN, (i + 1) * CELL_WIDTH + MARGIN, (j + 1) * CELL_WIDTH
						+ MARGIN);
				}
				
				if (cells[count].walls[WEST] != N * N) 
				{
					g.drawLine(i * CELL_WIDTH + MARGIN, j * CELL_WIDTH + MARGIN, i
						* CELL_WIDTH + MARGIN, (j + 1) * CELL_WIDTH + MARGIN);
				}
			}
		}
		
		
	}
        
        public void run(Graphics g){
            g.setColor(Color.RED); 
                
                    //DESSINER LA TRACE DU joueur 
                    try{             
                    
		for (int i = 0; i < N; i++)
		{                    
			int count = i;
			for (int j = 0; j < N; j++)
			{
				if (j != 0)
				{
					count += N;
				}
				
				if (path[count] == true) 
				{
					g.fillOval(i * CELL_WIDTH + MARGIN + DOT_MARGIN, j * CELL_WIDTH
						+ MARGIN + DOT_MARGIN, DOT_SIZE, DOT_SIZE); 

				}
			}
		}
                    }
                    catch(Exception e){
                        System.out.println("OK");
                    }
           
        }

	public Dimension windowSize(){
		return new Dimension(N * CELL_WIDTH + MARGIN * 2, N * CELL_WIDTH + MARGIN
			* 2);
	}
}

    

