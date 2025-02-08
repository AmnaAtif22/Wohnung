public class WohnungTest {
    public static void main(String[] args) {


        Wohnung[] wohnungen = new Wohnung[5];

        wohnungen[0] = new Wohnung(80.0, 12.0);

        wohnungen[1] = new Wohnung(100.0, 20.0);

        wohnungen[2] = new Dachwohnung(120.0, 20.0, 30.0);
        try {
            wohnungen[3] = Wohnung.einlesenWohnung();

            wohnungen[4] = Wohnung.einlesenWohnung();
        } catch (java.util.InputMismatchException e) {
            System.err.println("Fehler: Bitte geben Sie eine gültige Zahl ein.");

        } catch (IllegalArgumentException e) {
            System.err.println("Fehler: " + e.getMessage());
        }

        System.out.println("\nWohnungsinformationen:");
        for (Wohnung w : wohnungen) {
            if (w != null) {
                try {
                    w.ausgabeWohnung();
                } catch (FalscheMieteException e) {
                    System.out.println("Fehler: " + e.getMessage());
                }
                System.out.println();
            } else {
                System.out.println("Keine gültige Wohnung erstellt.");
            }
        }
    }
}