public enum TondeuseEnum {
    G("Gauche"),
    D("Droite"),
    A("Avancer"),
    O("Obstacle"),
    I("Item"),
    W("Ouest"),
    E("Est"),
    N("Nord"),
    S("Sud"),
    T("Tondeuse");

    private String name;

    TondeuseEnum(String direction) {
        name = direction;
    }
}
