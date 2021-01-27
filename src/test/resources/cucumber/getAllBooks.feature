# language: fr
@txn
Fonctionnalité: Consulter tous les livres

  Contexte:
    Soit les livres suivants :
      | UUID                                 | TITLE |
      | 00000000-0000-0000-0000-000000000001 |  Le Seigneur des anneaux : La Communauté de l'anneau     |
      | 00000000-0000-0000-0000-000000000002 |  Le Seigneur des anneaux : Les Deux Tours                |
      | 00000000-0000-0000-0000-000000000003 |  Le Seigneur des anneaux : Le Retour du roi              |


  Scénario: Consultation des publications
    Quand on consulte la liste des livres
    Alors la demande réussit
    Et la liste retournée contient l'ensemble des livres suivants :
      | uuid                                 | title                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  |
      | 00000000-0000-0000-0000-000000000001 |  Le Seigneur des anneaux : La Communauté de l'anneau     |
      | 00000000-0000-0000-0000-000000000002 |  Le Seigneur des anneaux : Les Deux Tours                |
      | 00000000-0000-0000-0000-000000000003 |  Le Seigneur des anneaux : Le Retour du roi              |