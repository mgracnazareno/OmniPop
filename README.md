# OmniPop
Concevoir et implémenter une application nommée OMNIPOP, en utilisant le software NetBeans ainsi que le langage Java, cette application va être utilisée par des enseignants
On considère que nous avons un seul  enseignant pour le moment
Automne 2021	Hiver 2022	Été 2022
Base de données	Orienté objet	Structures de données
Algorithme	Base de données	Orienté objet
	Algorithme	

Un enseignant avant d’accéder à son application doit d’abord se loguer avec un nom d’utilisateur mlazar et un mot de passe 1234
Dans le cas où le nom d’utilisateur ou le mot de passe sont erronés, l’utilisateur a le droit à 3 essais seulement, sinon il quitte le programme
A chaque mauvais essai, le programme doit lui indiquer le nombre de fois qu’il lui reste.
Si le login est bon, un menu est affiché à cet enseignant qui lui permettra de :
1.	Lister tous les cours qu’il enseigne à chaque session, lorsqu’il choisit cette option le programme doit lui demander pour quelle session il veut voir les cours, et en fonction de la session, les cours seront affichés
2.	Lister tous les cours qu’il enseigne pour les trois sessions.
3.	Entrer un nouvel étudiant dans la liste des étudiants, suivant le modèle suivant :
Lorsque l’enseignant choisit cette option, le programme doit lui demander les champs suivants : 
-	id de l’étudiant : qui doit être vérifié qu’il n’existait pas avant
-	le nom et le prénom de l’étudiant
-	l’année de naissance d’un étudiant
-	courriel de l’étudiant
à partir de ces information, le programme doit être en mesure de construire
le nom d’utilisateur de l’étudiant, ce nom doit être composé des 3 premières lettre du nom de famille + la première lettre du prénom +l’année de naissance
-	utilisez les expressions régulières pour vérifier la validité des entrées de l’enseignant (nom, prénom, courriel)
-	stockez ces étudiant dans un tableau a deux dimension comme suite :


1	Meriem	Lazar	1900	mlazar@gmail.com
Lazm1900
2	Yann	Valle	1900	yvalle@yahoo.com
Valy1900
3	Nathalie	Dion	1900	ndion@gmail.com

4.	Lister tous les étudiants de la liste
5.	Afficher les informations d’un étudiant donné en fournissant son nom et son prénom
6.	 Quitter le programme
Après chaque fin de tache, permettre à l’enseignant de réaliser une autre tâche, en lui affichant le menu de nouveau.