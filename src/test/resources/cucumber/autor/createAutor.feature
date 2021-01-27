# language: fr
@txn
Fonctionnalité: Créer un auteur

Soit les auteurs suivants :
| UUID                                 | NAME    | FIRSTNAME   |
| 10000000-0000-0000-0000-000000000001 | Tolkien | J. R. R     |
| 10000000-0000-0000-0000-000000000002 | Paolini | Christopher |

  Plan du scénario: Création d'un auteur
    Quand on créé un auteur contenant le nom "<nom>" et le prenom "<prenom>"
    Alors la demande réussit
    Et un auteur existe avec le nom suivant : "<nom>"

    Exemples:
      | nom     | prenom  |
      | Tolkien | J. R. R |

  Scénario: Auteur sans Nom
    Quand on créé un auteur contenant le nom suivant : ""
    Alors la demande échoue avec un code 400