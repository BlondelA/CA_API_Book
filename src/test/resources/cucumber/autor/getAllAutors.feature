# language: fr
@txn
Fonctionnalité: Consulter tous les livres

  Contexte:
    Soit les auteurs suivants :
      | UUID                                 | NAME    | FIRSTNAME   |
      | 10000000-0000-0000-0000-000000000001 | Tolkien | J. R. R     |
      | 10000000-0000-0000-0000-000000000002 | Paolini | Christopher |

  Scénario: Consultation des auteurs
    Quand on consulte la liste des auteurs
    Alors la demande réussit
    Et la liste retournée contient l'ensemble des auteurs suivants :
      | UUID                                 | NAME    | FIRSTNAME   |
      | 10000000-0000-0000-0000-000000000001 | Tolkien | J. R. R     |
      | 10000000-0000-0000-0000-000000000002 | Paolini | Christopher |