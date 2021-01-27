# language: fr
@txn
Fonctionnalité: Modifier une publication

  Contexte:
    Soit les livres suivants :
      | UUID                                 | MESSAGE                                               |
      | 00000000-0000-0000-0000-000000000001 | Le Seigneur des anneaux : La Communauté de l'anal     |
      | 00000000-0000-0000-0000-000000000002 | Le Seigneur des anneaux : Les Deux Fours              |
      | 00000000-0000-0000-0000-000000000003 | Le Seigneur des anneaux : Le Retour du moi            |
      | 00000000-0000-0000-0000-000000000004 | Titre à ne pas modifier.                              |


  Plan du scénario: Modification d'une publication existante
    Quand on modifie le livre <uuid> avec le titre "<text>"
    Alors la demande réussit
    Et le livre retourné contient le titre : "<expected>"
    Et un livre existe avec le titre suivant : "<expected>"

    Exemples:
      | uuid                                 | text                                                | expected                                            |
      | 00000000-0000-0000-0000-000000000001 | Le Seigneur des anneaux : La Communauté de l'anneau | Le Seigneur des anneaux : La Communauté de l'anneau |
      | 00000000-0000-0000-0000-000000000002 | Le Seigneur des anneaux : Les Deux Tours            | Le Seigneur des anneaux : Les Deux Tours            |
      | 00000000-0000-0000-0000-000000000003 | Le Seigneur des anneaux : Le Retour du Roi          | Le Seigneur des anneaux : Le Retour du Roi          |
      | 00000000-0000-0000-0000-000000000004 |                                                     | Titre à ne pas modifier.                            |


  Scénario: Modification d'une publication inexistante
    Quand on modifie le livre 00000000-0000-0000-0000-000000000005 avec le titre "Test d'insertion"
    Alors la demande échoue avec un code 404