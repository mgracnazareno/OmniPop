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

        //String id, nom = null, prenom = null, aNaissance = null, email, codeP;
        int tailleEtudiant = 0;
        String[][] etudiants;
        etudiants = new String[tailleEtudiant][6];
        

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
        do {
            boolean continuerTache = true;
            while (continuerTache) {
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

                    //FIN DE MENU POUR LISTER  TOUS LES COURS PAS SESSION
//                            System.out.println("Would you like to to another task? (yes or no)");
//                            response = input.next();
//                        } while (response.equalsIgnoreCase("yes"));
                    case 2:
                        System.out.println("List of all courses\n");
                        displayCourses(courseList);
                        break;
                    case 3:
                         //genererCodePermanent(etudiants);
                        getStudentInfo(etudiants, input);
                       
                        break;
                    case 4:
                        System.out.println("Lister tous les étudiants");
                       
                        listerTousLesEtudiants(etudiants);
                         

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
                System.out.println("Veuillez vous faire une autre tache? (oui ou  non): ");
                response = input.next();
                if (response.equalsIgnoreCase("no")){
                continuerTache= false;
                response = "no";
                }else{
                    printMenu();
                    System.out.println("Entrez votre choix (1 - 6): ");
                    while(true){
                        try{
                            choice = Integer.parseInt(input.nextLine());
                            if (choice >= 1&& choice <= 6) {
                                break;
                            }
                        }catch(NumberFormatException e){
                            System.out.println("Entrée invalide, entrez un valeur numeric 1 au 6: ");
                        }   
                    }
                }
            }     
        }while(response.equalsIgnoreCase("oui"));

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

    public static String genererCodePermanent(String nom, String prenom, String anneeDeNaissance) {
        String codeP = nom.substring(0, 3) + (prenom.substring(0, 1) + anneeDeNaissance);
        return codeP;
    }
    public static String genererCodePermanent(String[][] etudiants) {
         String codeP = null;
        for (int i = 0; i < etudiants.length; i++) {
           codeP= etudiants[i][1].substring(0, 3) + etudiants[i][2].substring(0,1) + etudiants[i][3];
        
        }
        return codeP;
    }
    private static void getStudentInfo(String[][] etudiants, Scanner sc) {
         int tailleEtudiant=0;
         String codeP;
        System.out.println("Combien d'étudiants voulez-vous ajouter dans le dossier ?: ");
        tailleEtudiant = sc.nextInt();
        etudiants= new String[tailleEtudiant][6];
        for (int row = 0; row < etudiants.length; row++) {
            //for (int col = 0; col < etudiants[row].length; col++) {
                 System.out.print("ID: ");
            //id= sc.next();
            etudiants[row][0] =sc.next();
            sc.nextLine();

            System.out.print("Nom de Famille: ");
            etudiants[row][1] = sc.next();
            //nom = sc.next();
            sc.nextLine();

            System.out.print("Preom: ");
            etudiants[row][2] = sc.next();
            //prenom= sc.next();
            sc.nextLine();

            System.out.print("Annee de Naissance: ");
            etudiants[row][3] = sc.next();
            //aNaissance = sc.next();

            System.out.print("Email: ");
            etudiants[row][4] = sc.next();
            sc.nextLine();

            codeP =  etudiants[row][1].substring(0,3) + etudiants[row][2].substring(0,1) + etudiants[row][3];
            System.out.println("Code Permanent: " + " " + codeP);
            
            
            System.out.println("");
        }
    }

   
    private static void listerTousLesEtudiants(String[][] etudiants) {
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s\n", "ID", "NOM", "PRÉNOM", "ANNÉE DE NAISSANCE", "EMAIL", "CODE PERMANENT");
         for(String[] etudiant: etudiants){
            System.out.printf("%-11s" ,etudiant);
        }
//        for (int i = 0; i < etudiants.length; i++) {
//            for (int j = 0; j < etudiants[i].length; j++) {
//                System.out.printf("%-10s", etudiants);
//            }
//            System.out.println("");
//        }
    }

}
