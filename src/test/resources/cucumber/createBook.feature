# language: fr
@txn
Fonctionnalité: Créer un livre

  Plan du scénario: Création d'une publication
    Quand on créé un livre contenant le titre suivant : "<text>"
    Alors la demande réussit
    Et un livre existe avec le titre suivant : "<text>"
    Et le livre retourné contient le titre : "<text>"

    Exemples:
      | text |
      | Le Seigneur des anneaux : La Communauté de l'anneau |

  Scénario: Publication sans texte
    Quand on créé un livre contenant le titre suivant : ""
    Alors la demande échoue avec un code 400