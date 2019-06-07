/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1.exo1;

/**
 *
 * @author cleme
 */
public class Essais {
public static void main(String args[]) {
	/*  Identifiez l’erreur 1 et corrigez   */

for (int i = 0; i < 5; i++)
System.out.print(i + ", ");
System.out.print("\n");

/*  Identifiez l’erreur 2 et corrigez  */
double a = 3.0;
double b = 4;
double c;
c = Math.sqrt(a * a + b * b);
System.out.println("c = " + c);

/*  Identifiez l’erreur 3 et corrigez  */
		byte b4 = 42;
 		char c2 = 'a'; 
 		short s = 1024; 
 		int i = 50000;   
float f = 5.67f;
 		double d = .1234;
 		double resultat = (f * b) + (i / c) - (d * s);
 		System.out.print((f * b) + " + " + (i / c) + " - " + (d * s));
 		System.out.println(" = " + resultat); 
 		double b2 = 10;
 		double b3 = b2 * b; 
 		System.out.println("b3 = " + b3);
}
}

