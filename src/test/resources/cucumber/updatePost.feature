# language: fr
@txn
Fonctionnalité: Modifier une publication

  Contexte:
    Soit les publications suivantes :
      | UUID                                 | MESSAGE                                                                                                                                   |
      | 00000000-0000-0000-0000-000000000001 | Lorem ipsum dolor sit amet, consectetur adipiscing elit.                                                                                  |
      | 00000000-0000-0000-0000-000000000002 | Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Sed aliquet sem in elit pellentesque scelerisque. |
      | 00000000-0000-0000-0000-000000000003 | Ceci est un texte.                                                                                                                        |
      | 00000000-0000-0000-0000-000000000004 | Texte à ne pas modifier.                                                                                                                  |


  Plan du scénario: Modification d'une publication existante
    Quand on modifie la publication <uuid> avec le message "<text>"
    Alors la demande réussit
    Et la publication retournée contient le message : "<expected>"
    Et une publication existe avec le texte suivant : "<expected>"

    Exemples:
      | uuid                                 | text                                                                                                                                                            | expected                                                                                                                                                        |
      | 00000000-0000-0000-0000-000000000001 | Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi ornare, sapien et ultricies luctus, ipsum mi efficitur arcu, non iaculis tellus justo quis nisl. | Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi ornare, sapien et ultricies luctus, ipsum mi efficitur arcu, non iaculis tellus justo quis nisl. |
      | 00000000-0000-0000-0000-000000000002 | Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae;                                                                         | Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae;                                                                         |
      | 00000000-0000-0000-0000-000000000003 | Ceci est un texte modifié.                                                                                                                                      | Ceci est un texte modifié.                                                                                                                                      |
      | 00000000-0000-0000-0000-000000000004 |                                                                                                                                                                 | Texte à ne pas modifier.                                                                                                                                        |


  Scénario: Modification d'une publication inexistante
    Quand on modifie la publication 00000000-0000-0000-0000-000000000005 avec le message "Test d'insertion"
    Alors la demande échoue avec un code 404