# language: fr
@txn
Fonctionnalité: Créer une publication

  Plan du scénario: Création d'une publication
    Quand on créé une publication contenant le texte suivant : "<text>"
    Alors la demande réussit
    Et une publication existe avec le texte suivant : "<text>"
    Et la publication retournée contient le message : "<text>"

    Exemples:
      | text                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  |
      | Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi ornare, sapien et ultricies luctus, ipsum mi efficitur arcu, non iaculis tellus justo quis nisl. Suspendisse aliquet nisi eget erat elementum cursus. Cras tincidunt dictum mauris vel pellentesque. Integer eu enim non nisl euismod molestie. Mauris congue nisl congue posuere placerat. Curabitur eu maximus leo, in dictum ligula. Cras efficitur hendrerit nulla, a sollicitudin erat aliquet in.                                                                                                                                                                                                |
      | Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Sed aliquet sem in elit pellentesque scelerisque. Nulla hendrerit nulla non ante eleifend, ac rhoncus ligula condimentum. Duis luctus vestibulum pharetra. Etiam egestas tempor ante sit amet molestie. Mauris in nulla eget urna pharetra pellentesque vitae quis sem. Pellentesque sed pharetra ligula, ut porttitor ex. Donec porta ultricies elit sit amet molestie. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Mauris bibendum porta massa non suscipit. Sed eget libero odio. Vivamus convallis iaculis ullamcorper. |
      | Maecenas elit augue, pretium id dolor at, pellentesque vulputate magna. Quisque auctor sollicitudin purus sed hendrerit. Fusce nec vulputate ligula. Etiam ac ipsum velit. Nunc at mi ut ante interdum hendrerit. Nullam congue cursus mauris, vel mollis lacus iaculis ac. Cras ullamcorper imperdiet sapien. Donec tortor felis, euismod sed felis non, blandit dignissim risus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Phasellus quis vehicula dolor, vitae condimentum quam. Mauris erat lorem, finibus quis dictum sed, luctus ac velit. Cras facilisis ut libero vel ultricies.                            |


  Scénario: Publication sans texte
    Quand on créé une publication contenant le texte suivant : ""
    Alors la demande échoue avec un code 400