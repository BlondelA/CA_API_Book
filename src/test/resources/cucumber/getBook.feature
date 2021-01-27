# language: fr
@txn
Fonctionnalité: Consulter une publication

  Contexte:
    Soit les livres suivants :
      | UUID                                 | MESSAGE                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               |
      | 00000000-0000-0000-0000-000000000001 |  Le Seigneur des anneaux : La Communauté de l'anneau     |
      | 00000000-0000-0000-0000-000000000002 |  Le Seigneur des anneaux : Les Deux Tours                |
      | 00000000-0000-0000-0000-000000000003 |  Le Seigneur des anneaux : Le Retour du roi              |

  Plan du scénario: Consultation d'une publication existante
    Quand on consulte le livre <uuid>
    Alors la demande réussit
    Et le livre retourné contient le titre : "<text>"

    Exemples:
      | uuid                                 | text                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  |
      | 00000000-0000-0000-0000-000000000001 |  Le Seigneur des anneaux : La Communauté de l'anneau     |
      | 00000000-0000-0000-0000-000000000002 |  Le Seigneur des anneaux : Les Deux Tours                |
      | 00000000-0000-0000-0000-000000000003 |  Le Seigneur des anneaux : Le Retour du roi              |

  Scénario: Consultation d'une publication inexistante
    Quand on consulte le livre 00000000-0000-0000-0000-000000000004
    Alors la demande échoue avec un code 404