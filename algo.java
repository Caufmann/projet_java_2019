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

//ON RAFRAICHIT LE PATH
public class algo
{
    
    public algo( int numElements )
    {
        s = new int [ numElements ];
        for( int i = 0; i < s.length; i++ )
            s[ i ] = -1;
    }

    //RELIER L'ENTREE A LA SORTIE
    public void union( int root1, int root2 )
    {
        if( s[ root2 ] < s[ root1 ] )  
            s[ root1 ] = root2;       
        else
        {
            if( s[ root1 ] == s[ root2 ] )
                s[ root1 ]--;         
            s[ root2 ] = root1;        
        }
    }

   
    public int find( int x )
    {
        if( s[ x ] < 0 )
            return x;
        else
            return s[ x ] = find( s[ x ] );
    }

    public int [ ] s;
    
   //VERIFIER QUE LE PATH N'EST PAS DISJOINT
    public boolean allConnected()
    {
   	 int count = 0 ;
   	 for(int i = 0 ; i < s.length ; i++)
   	 {
   		 if(s[i] < 0)
   		 {
   			 count++ ;
   		 }
   		 if(count > 1)
   		 {
   			 return false ;
   		 }
   	 }
   	 
   	 return true ;
    }
}
