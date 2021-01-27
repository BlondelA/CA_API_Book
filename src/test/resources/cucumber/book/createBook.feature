# language: fr
@txn
Fonctionnalité: Créer un livre

  Contexte:
    Soit les auteurs suivants :
      | UUID                                 | NAME    | FIRSTNAME |
      | 10000000-0000-0000-0000-000000000001 | Tolkien | J. R. R   |

  Plan du scénario: Création d'un livre
    Quand on créé un livre contenant le titre "<titre>" et l'auteur "<auteur>"
    Alors la demande réussit
    Et un livre existe avec le titre suivant : "<titre>"
    Et le livre retourné contient le titre : "<titre>"
    Et le livre retourné contient l'auteur : "<auteur>"

    Exemples:
      | titre                                               | auteur                               |
      | Le Seigneur des anneaux : La Communauté de l'anneau | 10000000-0000-0000-0000-000000000001 |

  Scénario: Livre sans titre
    Quand on créé un livre contenant le titre suivant : ""
    Alors la demande échoue avec un code 400