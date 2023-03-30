/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package omnipop;

import java.util.Scanner;

/**
 *
 * @author mgrac
 */
public class Omnipop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        final String USERNAME = "mlazar";
        final String PASSWORD = "1234";
        final int MAX_TENTATIVES = 3;

        String inputUsername;
        String inputPassword;

        String response = null;
        int infructueseTentative = 0;
        int choice = 0;

        String[][] courseList = {
            {"Fall 2021", "Database", "Algorithme"},
            {"Winter 2021", "Object Oriented", "Database", "Alogirthme"},
            {"Summer 2022", "Data Structure", "Object Oriented"}
        };

        //String id = "", nom = "", prenom = "", aNaissance = "", email = "", codeP;
        int tEtudiant = 0;
        String[][] etudiant;
        etudiant = new String[tEtudiant][6];

        System.out.println("Bienvenue au OMNIPOP");
        while (infructueseTentative < MAX_TENTATIVES) {
            System.out.println("Entrez votre username: ");
            inputUsername = input.nextLine();
            System.out.println("Entrez votre mot de passe: ");
            inputPassword = input.nextLine();

            if (USERNAME.equals(inputUsername) && PASSWORD.equals(inputPassword)) {
                System.out.println("Connexion reussi\n");
                // clearScreen();
                break;
            } else {
                infructueseTentative++;
                if (infructueseTentative < MAX_TENTATIVES) {
                    System.out.println("Les informations d'identification invalides, essayez à nouveau. "
                            + "Tentatives restants " + (MAX_TENTATIVES - infructueseTentative));
                } else {
                    System.out.println(" Trop de tentatives échouées. Connexion désactivée.");
                }
            }
        }
        do {
            printMenu();
            System.out.println("Entrez votre choix: (1 to 6)");
            while (true) {
                try {
                    choice = Integer.parseInt(input.nextLine());
                    if (choice >= 1 && choice <= 6) //break;
                    {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input, enter a number 1 to 6");
                }
            }
            //MENU PRINCIPAL

            switch (choice) {
                case 1:
                    int courseListChoice = 0;
                    getCourseListMenu();
                    System.out.println("");
                    System.out.println("Entrez votre choix: ");
                    courseListChoice = input.nextInt();
                    input.nextLine();
                    System.out.println("");

                    //MENU POUR LISTER TOUS LES COURS PAS SESSION
                    switch (courseListChoice) {
                        case 1:
                            System.out.println("Cours pour l'Automne 2021\n");
                            String courseFall = "";
                            for (int row = 0; row < courseList.length; row++) {
                                for (int col = 0; col < courseList[row].length; col++) {
                                    courseFall = courseList[0][0] + "\t" + courseList[0][1] + "\t" + courseList[0][2];
                                }
                            }
                            System.out.println(courseFall);
                            System.out.println("");
                            break;
                        case 2:
                            System.out.println("Cours pour d'Hiver 2021\n");
                            String courseWinter = "";
                            for (int row = 0; row < courseList.length; row++) {
                                for (int col = 0; col < courseList[row].length; col++) {
                                    courseWinter = courseList[1][0] + "\n" + courseList[1][1] + "\n" + courseList[1][2] + "\n" + courseList[1][3];
                                }
                            }
                            System.out.println(courseWinter);
                            System.out.println("");
                            break;
                        case 3:
                            System.out.println("Cours pour l'Été 2022\n");
                            String courseSummer = "";
                            for (int row = 0; row < courseList.length; row++) {
                                for (int col = 0; col < courseList[row].length; col++) {
                                    courseSummer = courseList[2][0] + "\n" + courseList[2][1] + "\n" + courseList[2][2];
                                }
                            }
                            System.out.println(courseSummer);
                            System.out.println("");
                            break;
                        case 4:
                            displayMenu();
                            //printMenu();
                            break;
                        default:
                            System.out.println("Éntrée invalide, entrez une numeric valeur de 1 à 4");
                            break;
                    }
                    break;

                case 2:
                    System.out.println("List of all courses\n");
                    displayCourses(courseList);
                    break;
                case 3:
                    System.out.println("Combien d'étudiants voulez-vous ajouter dans le dossier ?: ");
                    tEtudiant = input.nextInt();
                    input.nextLine();
                    etudiant= new String[tEtudiant][6];
                    getStudentInfo(etudiant, input);

                    break;
                case 4:
                    System.out.println("Lister tous les étudiants");
                     displayStudents(etudiant);
                    break;
                case 5:
                    System.out.println("Rechercher un étudiant par nom");
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    break;
            }

            // Prompt user to continue or exit
            System.out.println("Veuillez vous faire une autre tache? (oui ou non): ");
            response = input.next();
            input.nextLine();

        } while (response.equalsIgnoreCase("oui"));

        input.close();
    }

    public static void printMenu() {
        System.out.println("------- OMNIPOP MENU -------");
        System.out.println("1. Afficher les cours par saison");
        System.out.println("2. Afficher tous les cours");
        System.out.println("3. Ajouter un étudiant");
        System.out.println("4. Lister tous les étudiants");
        System.out.println("5. Rechercher un étudiant par nom");
        System.out.println("6. Quit");
    }

    private static void displayMenu() {
        int choice;
        String reponse;
        Scanner input = new Scanner(System.in);

        do {
            printMenu();
            System.out.println("Choissisez dés options ci-dessus. (1 to 6) ");
            System.out.println("Entrez votre choix: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    getCourseListMenu();
                    break;
                case 2:

                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    break;
            }
            System.out.println("Voulez vous faire un autre chose? ");
            reponse = input.nextLine();
        } while (reponse.equalsIgnoreCase("oui"));
    }

    private static void getCourseListMenu() {

        System.out.println("Display Courses by Season");
        System.out.println("1- Automne 2021");
        System.out.println("2- Hiver 2021");
        System.out.println("3- Été 2022");
        System.out.println("4- Retour au menu principal");
    }

    private static void displayCourses(String[][] courseList) {
        for (var courseList1 : courseList) {
            for (var courseList11 : courseList1) {
                System.out.printf("%-18s\t", courseList11);
            }
            System.out.println("");
        }
        System.out.println("");
    }
    public static String genererCodePermanent(String nom, String prenom, String aNaissance) {
        if (prenom.length() >= 3 && nom.length() >= 1) {
            String codeP = prenom.substring(0, 3) + nom.substring(0, 1) + aNaissance;
            return codeP;
        } else {
            throw new IllegalArgumentException("Error: invalid student information for Code Permanent.");
        }
    }
    private static void afficheStudents(String[][] etudiant) {
        //System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s\n", "ID", "Nom", "Prenom", "Naissance", "Email", "Code Permanent");
        for (String[] etud : etudiant) {
            for (String etudCol : etud) {
                System.out.printf("%-10s ", etudCol);
            }
            System.out.println();
        }
    }
    private static void getStudentInfo(String[][] etudiant, Scanner input) {

        int id= 1;
        for (int row = 0; row < etudiant.length; row++) {
            System.out.println("Entrez l'information d'Etudiant " + id++);
            //input.nextLine();
            System.out.print("Nom de famille: ");
            String nom = input.nextLine();
            System.out.print("Prenom: ");
            String prenom =  input.nextLine();
            System.out.print("Année de naissance: ");
            String aNaissance = input.nextLine();
            System.out.print("Email: ");
            String email = input.nextLine();

            try {
                String codeP = genererCodePermanent(nom, prenom, aNaissance);
                etudiant[row][0] = String.valueOf(row + 1);
                etudiant[row][1] = nom;
                etudiant[row][2] = prenom;
                etudiant[row][3] = aNaissance;
                etudiant[row][4] = email;
                etudiant[row][5] = codeP;
                System.out.println("Id: " + etudiant[row][0] + " Code Permanent: " + codeP);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                row--;
                continue;
            }

        }
            System.out.println();
    }
    

    private static void displayStudents(String[][] students) {
       //Print column headers
        System.out.printf("%-4s%-15s%-15s%-20s%-25s%-15s\n", "Id", "Prenom", "Nom", "Date de naissance", "Email", "Code Permanent");

        // Print the student data
        for (int row = 0; row < students.length; row++) {
            System.out.printf("%-4s%-15s%-15s%-20s%-25s%-15s\n", students[row][0], students[row][1], students[row][2], students[row][3], students[row][4], students[row][5]);
        }
    }

    private static int validerEntree() {
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) {
            System.out.println("Entree invalide, essayez de nouveau! ");
            sc.next();
        }
        int validatedInput = sc.nextInt();
        return validatedInput;
    }

    private static void listerTousLesEtudiants(String[][] etudiants) {
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s\n", "ID", "NOM", "PRÉNOM", "ANNÉE DE NAISSANCE", "EMAIL", "CODE PERMANENT");
        for (int i = 0; i < etudiants.length; i++) {
            for (int j = 0; j < etudiants[i].length; j++) {
                System.out.printf("%-11s", etudiants[i][j]);
            }
            System.out.println("");
        }
    }
}
