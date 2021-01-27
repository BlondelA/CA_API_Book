# language: fr
@txn
Fonctionnalité: Consulter une publication

  Contexte:
    Soit les livres suivants :
      | UUID                                 | TITRE                                               | AUTEUR                               |
      | 00000000-0000-0000-0000-000000000001 | Le Seigneur des anneaux : La Communauté de l'anneau | 10000000-0000-0000-0000-000000000001 |
      | 00000000-0000-0000-0000-000000000002 | Le Seigneur des anneaux : Les Deux Tours            | 10000000-0000-0000-0000-000000000001 |
      | 00000000-0000-0000-0000-000000000003 | Le Seigneur des anneaux : Le Retour du roi          | 10000000-0000-0000-0000-000000000001 |
    Soit les auteurs suivants :
      | UUID                                 | NAME    | FIRSTNAME |
      | 10000000-0000-0000-0000-000000000001 | Tolkien | J. R. R   |

  Plan du scénario: Consultation d'un livre existant
    Quand on consulte le livre <uuid>
    Alors la demande réussit
    Et le livre retourné contient le titre : "<text>"

    Exemples:
      | uuid                                 | text                                                | Auteur                               |
      | 00000000-0000-0000-0000-000000000001 | Le Seigneur des anneaux : La Communauté de l'anneau | 10000000-0000-0000-0000-000000000001 |
      | 00000000-0000-0000-0000-000000000002 | Le Seigneur des anneaux : Les Deux Tours            | 10000000-0000-0000-0000-000000000001 |
      | 00000000-0000-0000-0000-000000000003 | Le Seigneur des anneaux : Le Retour du roi          | 10000000-0000-0000-0000-000000000001 |

  Scénario: Consultation d'une publication inexistante
    Quand on consulte le livre 00000000-0000-0000-0000-000000000004
    Alors la demande échoue avec un code 404