package sk.uniza.fri;

import java.util.*;

public class Zatvorkovanie {
    /**
     * zname zatvorky, kt. je mozne testovat
     * key: koncova zatvorka, value: zaciatocna zatvorka
     */
    private static final Map<Character, Character> KONCOVE_ZACIATOCNE =
            Map.of(
                    ')', '(',
                    '}', '{',
                    ']', '[',
                    '>', '<',
                    '⟩', '⟨'
            );

    /**
     * otvaracie zatvorky (values z KONCOVE_ZACIATOCNE)
     */
    private static final Set<Character> ZACIATOCNE = new HashSet<>(KONCOVE_ZACIATOCNE.values());

    /**
     * overi spravnost zatvoriek (overuje len tie, kt. su v KONCOVE_ZACIATOCNE)
     *
     * @return jeSpravne/nieJeSpravneZatvorkovanie
     */
    public static boolean over(String str) {
        Stack<Character> stack = new Stack<>();

        for (Character c : str.toCharArray()) {
            // ak sa jedna sa a ZACIATOCNU zatvorku
            if (ZACIATOCNE.contains(c)) {
                stack.push(c);
            }
            // ak sa jedna o KONCOVU, over
            else if (KONCOVE_ZACIATOCNE.containsKey(c)) {
                try {
                    Character opener = stack.pop();

                    // zatvorky nesedia
                    if (!KONCOVE_ZACIATOCNE.get(c).equals(opener)) {
                        return false;
                    }
                }
                // stack je prazdny, najdena KONCOVA zatvorka
                catch (EmptyStackException ex) {
                    return false;
                }
            }
        }

        //stack jePrazdny --> spravne zatvorkovanie
        //stak nieJePrazdny --> nespravne zatvorkovanie
        return stack.empty();
    }
}
