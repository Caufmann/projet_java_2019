/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3_cauffet;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


/**
 *
 * @author cleme
 */
public class MazePanel extends JPanel 
{
	public laby maze;        

	public MazePanel(laby theMaze)
	{
		maze = theMaze;
	}

	
	public void paintComponent(Graphics page) 
	{       
            try{
                          
		super.paintComponent(page);
		
		setBackground(Color.white); 
		
		this.setPreferredSize(maze.windowSize());           
		
		maze.draw(page);  
                maze.run(page);
                
                                 
                } catch(Exception e) {
    System.out.println("PAS FOU");
}
                
                  
                
	}
    
}
