# CA_API_Book

Api de gestion des livres et auteurs.

Connexion BDD ok

Problème de désérialisation du JSON dans les services

----------------------------------------------------------

# Automate

src/main/java/com/poc/Automate

Tentative de création d'un automate permettant de mettre a jour des etats en parametre
Je n'ai pas du tout saisis l'interret d'un automate... Surement que le petit tutoriel suivi n'était pas assez explicite.

# SonarLint

J'utilise SonarLint depuis presque 3 ans donc je ne peux pas vous montrer l'avant / aprés. 
Sonarlint est vraiment interessant pour verrifier la qualitée de son code avant chaque commit, et surtout, ce que je trouve bien c'est que pour chaque "erreur",
sonar donne un lien vers la documentation et un exemple dans le quel votre erreur est reproduite et un second exemple de solution.

Outil formidable surtout si dans une équipe tout le monde l'utilise !!

# SonarQube

Dans mon entreprise nous avons mis en place un SonarQube mais le chef de projet nous l'a fait utiliser pendant une semaine et depuis plus personne n'y va.
Nous l'avons surtout utilisé pour analyser du vieux code...
J'ai mieux compris son interet pendant votre intervention.

Installation :
Pas de difficulté particulière, 1h de travail maximum (installation de docker et maven comprise).

Sur ce projet voici ce qu'il me retourne: 
![image](https://user-images.githubusercontent.com/25242328/119835651-4f39e980-bf01-11eb-9798-9d6470cefd42.png)
Les problèmes relevés sont:
- Un import innutilisé
- Un bloc commenté qui doit etre supprimé (je le garde consiement)
- beaucoup de regular expression '^[a-z_]+(\.[a-z_][a-z0-9_]*)*$'. (habitude prise à cause des conventions de nommage au travail ou, cette regle a été désactivée)

