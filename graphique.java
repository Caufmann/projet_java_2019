
package tp3_cauffet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.*;

/**
 *
 * @author cleme
 */
public class graphique extends JFrame implements ActionListener{
    public boolean statement = false;
    JButton bouton = new JButton();
    JButton bouton2 = new JButton();
    
    
    
        
    public void dessin(int str)throws IOException, InterruptedException{
        try {         	
            
    
    laby maze = new laby(str); // on définit un objet labyrinthe
    MazePanel panel = new MazePanel(maze); // on définit le support du labyrinthe
			
    JFrame frame = new JFrame("Labyrinthe ECE");
                        
			
			JScrollPane scrollPane = new JScrollPane(panel);
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(1000, 1000);
			frame.add(scrollPane, BorderLayout.CENTER);
			frame.setVisible(true);
                        panel.setLayout(null);
                        
                        //BOUTON regenerer                       
                        bouton = new JButton("Regénérer");
                        bouton.setBounds(5,23*str,5*str,str);
                        bouton.addActionListener(this);                        
                        panel.add(bouton);
                        
                        //BOUTON DFS
                        bouton2 = new JButton("DFS");
                        bouton2.setBounds(6*str,23*str,5*str,str);
                        bouton2.addActionListener(this);                        
                        panel.add(bouton2);
                        
        }
        catch(NumberFormatException exception)
		{
			System.out.println("ERROR IN SYSTEM") ;
                        
		}
        
    

}
    
        public void dessinDFS()throws IOException, InterruptedException{
        try {         	
            int size = 30;
    
    laby maze = new laby(size); 
    research panel = new research(maze); 
			// maze
    JFrame frame = new JFrame("Labyrinthe ECE");
                        
			
			JScrollPane scrollPane = new JScrollPane(panel);
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(1000, 1000);
			frame.add(scrollPane, BorderLayout.CENTER);
			frame.setVisible(true);
                        panel.setLayout(null);
                        
                        //BOUTON regenerer                       
                        bouton = new JButton("Regénérer");
                        bouton.setBounds(5,23*size,5*size,size);
                        bouton.addActionListener(this);                        
                        panel.add(bouton);
                        
                        //BOUTON DFS
                        bouton2 = new JButton("DFS");
                        bouton2.setBounds(6*size,23*size,5*size,size);
                        bouton2.addActionListener(this);                        
                        panel.add(bouton2);
                        
        }
        catch(NumberFormatException exception)
		{
			System.out.println("ERROR IN SYSTEM") ;
                        
		}
        
    

}
        public boolean getStatement(){
           return statement;           
          }
        public void setStatement(boolean statement){
            this.statement=statement;
        }   
        
  public void actionPerformed(ActionEvent e) {
       
 Object source = e.getSource();

 if(source == bouton){
 System.out.println("REGEN");
 try{
     
 this.dessinDFS();

  } catch(Exception d){
        System.out.println("ERROR");
        }
 }
 if(source == bouton2){
 System.out.println("DFS");
 try{
     
 this.dessin(30);

  } catch(Exception d){
        System.out.println("ERROR");
        }
 }
 }
}

        
        
            
    


