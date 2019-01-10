public enum TondeuseEnum {
    G("Gauche"),
    D("Droite"),
    A("Avancer"),
    O("Obstacle"),
    I("Item"),
    T("Tondeuse");

    private String name;

    TondeuseEnum(String direction) {
        name = direction;
    }
}
