# language: fr
@txn
Fonctionnalité: Consulter une publication

  Contexte:
    Soit les auteurs suivants :
      | UUID                                 | NAME    | FIRSTNAME   |
      | 10000000-0000-0000-0000-000000000001 | Tolkien | J. R. R     |
      | 10000000-0000-0000-0000-000000000002 | Paolini | Christopher |

  Plan du scénario: Consultation d'un auteur existant
    Quand on consulte l'auteur <uuid>
    Alors la demande réussit
    Et l'auteur retourné contient le nom : "<name>"

    Exemples:
      | uuid                                  | name    |
      | 010000000-0000-0000-0000-000000000001 | Tolkien |
      | 10000000-0000-0000-0000-000000000002  | Paolini |

  Scénario: Consultation d'une publication inexistante
    Quand on consulte le livre 00000000-0000-0000-0000-000000000004
    Alors la demande échoue avec un code 404