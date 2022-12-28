# IFT2255_projet

UDEM - IFT2255 - A22 projet

Pour les fichers .vpp, les membres de notre équipe ont utilisé des versions différents de visual paradigm, alors il faut ouvrir 
le ficher "cas d'utilisation" avec la version 17.0, et les autres fichers avec la version 16.3.

Le fichier principal de l'application est nommé AppMenu.java, qui est stocké dans le dossier projet_2255/implementation/src/main. Le diagramme de classes est stocké dans le dossier visual_p. test est stocké dans src/test. Les vidéos javaDoc et de démonstration sont stockées dans le dossier implementation/doc

Exécution de prototype:
- Les codes de prototype se trouvent dans le répertoire Implementation. La fichier App.java contient l'exécution du programme.
- À l'exécution du programme, on vous demande si vous avez déjà un compte. Veuillez entrer choisir N et créer un nouvel compte pour vous inscrire.
- Après l'inscription, le menu va afficher des differentes options à choisir, notée par des numéros 1-7. Vous devez entrer l'un de ces nombres pour choisir l'activité désirée. Choisissez 0 pour quitter le programme!


Nous pouvons commencer par exécuter le fichier AppMenu via cmd.
L'application est divisée en deux parties, les consommateurs et les résidents. L'interface d'entrée est l'interface d'inscription et de connexion, où l'utilisateur peut choisir le type de compte à créer et entrer des informations personnelles pour s'inscrire. Une fois l'inscription réussie, l'utilisateur peut utiliser l'adresse e-mail comme identifiant et mot de passe pour se connecter. Selon le type de compte, différentes options s'afficheront : à tout moment, l'utilisateur peut entrer 0 pour revenir au menu précédent, et l'utilisateur peut également revenir au menu principal pour changer de compte.

Des comptes exisitants sont fournies aux utilisateurs: (id: cons1 password:123 type: consommateur) et (id:res1 password:123 type:resident)
