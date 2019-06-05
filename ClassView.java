package View;

import Controller.*;

import Model.Eleve;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class ClassView extends JFrame implements ActionListener, ItemListener {
        private Connexion maconnexion;
        private JLabel Search;
        private List Result, ListJButton;
        private JTextField lookingFor;
        private JButton Validate;
        private JPanel p0, p1, p2, nord;

        public ClassView(String tableFromDataBase) {

            super(" Projet : Gestion d'une Ecole : Update the Bdd");
            setLayout(new BorderLayout());
            setBounds(0, 0, 800, 800);
            setResizable(true);
            setVisible(true);

            try {
                try {
                    /**
                     * On essaye de se connecter Ã  la base de donnÃ©es rentrÃ©e
                     */
                    maconnexion = new Connexion("gestion_ecole", "root", "");
                    System.out.println("Succes to connect");

                    /**
                     * CrÃ©ation des Jbuttons de la fentre
                     * JButton connection Base de Donnees
                     * JButton pour appeller la modification dans la base de donnee d'un Object
                     */
                    Validate = new JButton("Search");

                    /**
                     * CrÃ©ation des JTextField
                     * Pouvoir se connecter Ã  la base de donnÃ©es
                     */
                    lookingFor = new JTextField();

                    /**
                     * Creation des labels
                     */

                    Search = new JLabel("Search : ");

                    /**
                     * initialisation des List pour afficher les resultat de la recherche
                     */

                    Result = new List(2, false);
                    ListJButton = new List(1, false);
                    /**
                     * Initialition des panels de la fenetre
                     */
                    p0 = new JPanel();
                    p1 = new JPanel();
                    p2 = new JPanel();
                    nord = new JPanel();


                    /**
                     * Mise en page des panels de la fenetre
                     */
                    p0.setLayout(new GridLayout(1, 3));
                    p1.setLayout(new GridLayout(1, 1));
                    nord.setLayout(new GridLayout(2, 1));
                    p2.setLayout(new GridLayout(1, 1));

                    /**
                     * Ajout des objets graphique dans les panels
                     */

                    p0.add(Search);
                    p0.add(lookingFor);
                    p0.add(Validate);
                    nord.add("North", p0);
                    nord.add("North", p1);


                    p2.add(Result);
                    p2.add(ListJButton);

                    /**
                     * Ajout des Actionlisteners sur les JButtons
                     */
                    Validate.addActionListener(this);
                    lookingFor.addActionListener(this);

                    /**
                     * Ajout des Itemlisteners sur les list
                     */
                    Result.addItemListener(this);

                    /**
                     * Ajout Couleur sur les panels et autre
                     */
                    p0.setBackground(Color.blue);
                    Result.setBackground(Color.GREEN);
                    ListJButton.setBackground(Color.orange);
                    /**
                     * Disposition Graphique des panels
                     */
                    nord.add("North", p0);
                    nord.add("North", p1);
                    add("North", nord);
                    add(p2);
                    /**
                     * Pour pouvoir fermer la fenetre
                     */
                    addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            System.exit(0);
                        }
                    });


                } catch (ClassNotFoundException e) {
                    System.out.println(e);
                    e.printStackTrace();
                }
            } catch (SQLException sqlE) {
                System.out.println(sqlE);
                sqlE.printStackTrace();
            }
        }

        /**
         * Utilisation de la fonction actionPerformed pour gÃ©rer les actions sur les boutons
         *
         * @param evt
         */
        @Override
        @SuppressWarnings("CallThreadDumpStack")
        public void actionPerformed(ActionEvent evt) {
            Object source = evt.getSource();

            /**
             * MÃ©thode appellÃ©e lors de l'appui sur le bouton Connect
             * On se connecte Ã  la base de donnÃ©es
             */

            if (source == Validate) {
                String requete = lookingFor.getText();
                Result.removeAll();
                if (requete == "") {
                    System.out.println("There no search to do.");
                    Result.add("there no result in your requeste");
                } else {
                    Controleur<Eleve> Eleve = new EleveDAO(maconnexion);
                    for (int i = 0; i < 10; i++) {
                        Eleve student = Eleve.recherch(i, requete);
                        if (student.getId() != 0) {
                            Result.add(student.getNom() + " " + student.getPrenom());
                        }
                    }
                }
            }

        }

        @Override
        @SuppressWarnings("CallThreadDumpStack")
        public void itemStateChanged(ItemEvent e) {

            if (e.getSource() == Result) {
                String personne = Result.getSelectedItem();
                System.out.println("Choix Personne : " + personne);
                ListJButton.removeAll();
                ListJButton.add("Add Object at your database");
                ListJButton.add("Update Object at your database");
                ListJButton.add("Delete Object at your database");
            }

        }
    }





