# Feedback DM1

> **GPB**  
> Patrick LANGLOIS (20197071)  
> Laurent BOUCHARD (20184162)  
> Qiwu Wen (20230961)  
> Le Kinh Vi PHUNG (20178538)  

## Cadre du projet

- Bonne description de projet. Ajoutez une brève description de la problématique.
- Très bon échéancier.
- Bon récapitulatif des échanges avec le client

## Compréhension du domaine

### Glossaire

Bon glossaire, mais il manque quelques éléments importants:

- Bineco*
- Signaler un problème*
- Activités*
- Capteurs

### Persona

De bons personas! Ils ne semblent pas avoir nécessairement besoin de Bineco quoique.

## Modélisation du domaine

### Cas d'utilisation

Il faut un diagramme contenant tous les cas.

- Vous avez très bien considéré Résident et Consommateur comme des spécialisations d'un Client. Vous devriez également avoir l'acteur client dans vos diagrammes. C'est l'acteur des cas d'usage commun entre Résident et Consommateur.
- Il manque un autre acteur pour le capteur.
- Les Préconditions, les postconditions et les scénarios ne sont pas bien développés.
- Quelques cas d'utilisation à considérer et à réfléchir:
  - Capteur : Envoyer des nouvelles données
  - Consommateur : S'inscrire comme consommateur
  - Consommateur : Modifier la liste des activités
  - Ville : Valider le compte
  - Résident : Trouver un consommateur
  - etc.

## Analyse

### Risques

Les risques mentionnés sont justes, mais la plupart d'entre eux sont liés à des problèmes de sécurité.  
Autres suggestions :
- Problème de communication ou synchronisation avec le système municipal
- Mal fonctionnement des capteurs
- Politique empêche la réalisation du projet
- Temps alloué insuffisant
- etc.

### Exigences non-fonctionnelles

Les éléments mentionnés ne sont pas des exigences non fonctionnelles. Vous pouvez réviser cette section en gardant à l'esprit les exigences non fonctionnelles suivantes. Par exemple :

- Utilisabilité (e.g., Bineco doit être facile d'utilisation)
- Fiabilité (e.g., Il faut s'assurer que les données sont fiables et à jour pour garantir la justesse des métriques)
- Performance (e.g., Le système doit se mettre à jour dans un temps raisonnable)
- Légalité (s'assurer de respecter les lois sur la collecte de données, l'usage des données de la ville)
- Efficacité (atteinte des objectifs)
- etc.

### Besoins matériels

À réviser.

- Pour les matériels nécessaires, il faut mentionner :
  - Capteurs pour scanner le contenu des bacs
  - Serveur pour héberger les données et programmes
  - Téléphone si application mobile
  - etc.
  
- Pour les solutions de stockage, il faut mentionner:
  - Le type de la base de données et les avantages
  - Stockage partagé: Une partie des données résident dans les serveurs (base de données) de la ville et l'autre sur les serveurs de Bineco
  - etc.
  
### Contraintes conceptuelles

- Vous avez très bien noté le langage de programmation et l'interaction en ligne de commande. Vous pouvez également mentionner :
  - Compatibilité avec le système municipal (API)
  - Format de données pour les capteurs : CSV
- etc.

### Contraintes physiques
  
Il manque les contraintes physiques.  
Suggestion de contraintes:

- Espace physique nécessaire
- Spécification des appareils et outils utilisés pour interagir avec l'application
- etc.

### Choix de métriques

Vous avez mentionné certains éléments, mais il est nécessaire de développer cette section de manière appropriée.

## Prototype

Très bien!

## Git

Bon, mais un membre n'a pas fait de commit.

## Rapport

- C'est bien d'inclure un diagramme de Gantt
- Les idées doivent être mieux développées
- Il semble que certaines Fonts et Sizes manquent. De plus, certaines images ne tiennent pas correctement dans la page.
- Les liens vers Git et VPP sont présents et fonctionnels.
