package domein;

public enum  DierSoort {
    KAT( new String[]{"geboortejaar"}),
    HOND( new String[]{"naam", "geboortejaar"});

    private final String[] attribuutNamen;

    DierSoort( String[] attributen)  {  attribuutNamen = attributen; }
    public String[] attribuutNamen() { return attribuutNamen; }
}
