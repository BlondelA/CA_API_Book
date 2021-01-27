# language: fr
@txn
Fonctionnalité: Modifier une publication

  Contexte:   | 10000000-0000-0000-0000-000000000001 |
    Soit les auteurs suivants :
      | UUID                                 | NAME      | FIRSTNAME   |
      | 10000000-0000-0000-0000-000000000001 | Tachienne | J. R. R     |
      | 10000000-0000-0000-0000-000000000002 | Paolini   | Christopher |


  Plan du scénario: Modification du nom d'un auteur existant
    Quand on modifie l'auteur <uuid> avec le nom "<nom>"
    Alors la demande réussit
    Et l'auteur retourné contient le nom : "<expected>"
    Et un auteur existe avec le nom suivant : "<expected>"

    Exemples:
      | uuid                                 | nom     | expected |
      | 10000000-0000-0000-0000-000000000001 | Tolkien | Tolkien  |