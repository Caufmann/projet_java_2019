/* --------------------------------------------------------------------------
-------------                                           ---------------------
-------------            A LIRE ABSOLUMENT !            ---------------------
-------------                                           ---------------------
-------------                                           ---------------------
-----------------------------------------------------------------------------

J'ai passé énormément de temps à essayer de ne pas repartir du ZIP donné pour rendre ce TP3 ! 
Je me suis inspiré de 3 projets présents sur Github en essayant de me les approprier et de pouvoir generer des labyrinthes aléatoires
sans pouvoir réussir à remplir la totalité du cahier des charges. J'ai rencontré beaucoup de difficultés dans les instances de mes classes, 
me retrouvant dans l'incapacité de pouvoir retrouver le "path" correspondant au maze qui était en train d'être traité.
Je vous propose donc une version du TP3 dans lequel vous pouvez generer des labyrinthes aléatoirement et procéder à un DFS automatique.
J'ai passé énormément de temps sur ce TP pour un résultat qui ne me satisfait pas, j'aurai aimé avoir un binôme pour m'épauler.

SOURCES : 
Comment utiliser les frameworks pour le labyrinthe (code du tp à rendre réalisé par un ancien de l'ECE) :
https://github.com/RiccardiLd/Labyrinthe2018

Exmples de DFS et coment les implémenter : 
https://github.com/Kevcoq/li314

Exemple de generation auto de labyrinthes:
https://github.com/irealva/maze-gui/blob/master/Maze.java

Tutoriels SWING : 
https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html

https://www.jmdoudoux.fr/java/dej/chap-swing.htm

Problemes sur les ActionListener : 
https://openclassrooms.com/forum/sujet/fonctionnement-d-actionlistener

Creation interface SWING : 
https://pedago-ece.campusonline.me/pluginfile.php/10870/mod_resource/content/0/Creation_interface_graphique_avec_Swing.pdf


 */
package tp3_cauffet;
import java.util.Scanner;
import java.io.File;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Random;
/**
 *
 * @author cleme
 */
public class TP3_Cauffet{
     public static void main(String[] args) throws IOException, InterruptedException
	{
            
		try
		{   
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Veuillez saisir la taille du labyrinthe souhaité (30 conseillé) :");
                    int str = sc.nextInt();
                    
                    graphique test = new graphique();
                    test.dessin(str);   
                    
		}
		catch(NumberFormatException exception)
		{
			System.out.println("ERROR") ;
		}
	}
     
}



