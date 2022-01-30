package sk.uniza.fri;

public class Main {
    /**
     * Overenie zatvoriek
     * - program overi spravnost (zacatie a ukoncenie, spravne vnorenie, etc...) zatvoriek v zadanom Stringu
     */
    public static void main(String[] args) {
        //priklady overenia
        vypis("{3*(78+2)}");        //nespravne
        vypis("{(})");              //spravne
        vypis("(1+2)*(7/8+2)-a");   //spravne

    }

    private static void vypis(String overovanyString) {
        System.out.printf("  %s  : %s zatvorkovanie\n", overovanyString,
                Zatvorkovanie.over(overovanyString) ? "spravne" : "nespravne");
    }
}
