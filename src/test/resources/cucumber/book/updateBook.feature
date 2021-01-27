# language: fr
@txn
Fonctionnalité: Modifier une publication

  Contexte:
    Soit les livres suivants :
      | UUID                                 | TITRE                                             | AUTEUR                               |
      | 00000000-0000-0000-0000-000000000001 | Le Seigneur des anneaux : La Communauté de l'anal | 10000000-0000-0000-0000-000000000001 |
      | 00000000-0000-0000-0000-000000000002 | Le Seigneur des anneaux : Les Deux Trous          | 10000000-0000-0000-0000-000000000001 |
      | 00000000-0000-0000-0000-000000000003 | Le Seigneur des anneaux : Le Retour du quoi ?     | 10000000-0000-0000-0000-000000000001 |
      | 00000000-0000-0000-0000-000000000004 | Eragon                                            | 10000000-0000-0000-0000-000000000001 |
    Soit les auteurs suivants :
      | UUID                                 | NAME    | FIRSTNAME   |
      | 10000000-0000-0000-0000-000000000001 | Tolkien | J. R. R     |
      | 10000000-0000-0000-0000-000000000002 | Paolini | Christopher |


  Plan du scénario: Modification du titre d'un livre existant
    Quand on modifie le livre <uuid> avec le titre "<titre>"
    Alors la demande réussit
    Et le livre retourné contient le titre : "<expected>"
    Et un livre existe avec le titre suivant : "<expected>"

    Exemples:
      | uuid                                 | titre                                               | expected                                            |
      | 00000000-0000-0000-0000-000000000001 | Le Seigneur des anneaux : La Communauté de l'anneau | Le Seigneur des anneaux : La Communauté de l'anneau |
      | 00000000-0000-0000-0000-000000000002 | Le Seigneur des anneaux : Les Deux Tours            | Le Seigneur des anneaux : Les Deux Tours            |
      | 00000000-0000-0000-0000-000000000003 | Le Seigneur des anneaux : Le Retour du Roi          | Le Seigneur des anneaux : Le Retour du Roi          |
      | 00000000-0000-0000-0000-000000000004 |                                                     | Eragon                                              |

  Plan du scénario: Modification de l'auteur d'un livre existant
    Quand on modifie le livre <uuid> avec l'auteur "<auteur>"
    Alors la demande réussit
    Et le livre retourné contient l'auteur : "<expected>"

    Exemples:
      | uuid                                 | auteur                               | expected                             |
      | 00000000-0000-0000-0000-000000000001 |                                      | 10000000-0000-0000-0000-000000000001 |
      | 00000000-0000-0000-0000-000000000004 | 10000000-0000-0000-0000-000000000002 | 10000000-0000-0000-0000-000000000002 |


  Scénario: Modification d'une publication inexistante
    Quand on modifie le livre 00000000-0000-0000-0000-000000000005 avec le titre "Test d'insertion"
    Alors la demande échoue avec un code 404