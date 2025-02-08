public class Wohnung {
    private double flaecheInnen;
    private double flaecheBalkon;
    public Wohnung(double flaecheInnen, double flaecheBalkon) {
        if (flaecheInnen < 0 || flaecheBalkon < 0) {
            throw new IllegalArgumentException("Fläche darf nicht negativ sein."); // Prevent negative values
        }
        this.flaecheInnen = flaecheInnen;
        this.flaecheBalkon = flaecheBalkon;
    }
    public Wohnung() {
        this.flaecheInnen = 80.0;
        this.flaecheBalkon = 12.0;
    }
    public double getFlaecheInnen() {
        return flaecheInnen;
    }

    public void setFlaecheInnen(double flaecheInnen) {
        if (flaecheInnen < 0) {
            throw new IllegalArgumentException("Innenfläche darf nicht negativ sein.");
        }
        this.flaecheInnen = flaecheInnen;
    }

    public double getFlaecheBalkon() {
        return flaecheBalkon;
    }

    public void setFlaecheBalkon(double flaecheBalkon) {
        if (flaecheBalkon < 0) {
            throw new IllegalArgumentException("Balkonfläche darf nicht negativ sein.");
        }
        this.flaecheBalkon = flaecheBalkon;
    }

    public double getGesamt() {
        return flaecheInnen + (flaecheBalkon / 2);
    }


    public double berechneMietzins() throws FalscheMieteException {
        double mietzins = getGesamt() * 8.50;


        if (mietzins < 200.0) {
            throw new FalscheMieteException("Der berechnete Mietzins ist zu niedrig: " + mietzins + " EUR.");
        } else if (mietzins > 5000.0) {
            throw new FalscheMieteException("Der berechnete Mietzins ist zu hoch: " + mietzins + " EUR.");
        }

        return mietzins;
    }

    public void ausgabeWohnung() throws FalscheMieteException {
        System.out.printf("Innenfläche: %.2f m²\n", flaecheInnen);
        System.out.printf("Balkonfläche: %.2f m²\n", flaecheBalkon);
        System.out.printf("Gesamtfläche: %.2f m²\n", getGesamt());

//        try {
            System.out.printf("Mietzins: %.2f EUR\n", berechneMietzins());
//        } catch (FalscheMieteException e) {
//            System.err.println("Fehler: " + e.getMessage());
//        }
    }


    public static Wohnung einlesenWohnung() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        double innen = 0.0;
        double balkon = 0.0;


            System.out.print("Geben Sie die Innenfläche an: ");
            innen = scanner.nextDouble();
            if (innen < 0) {
                throw new IllegalArgumentException("Innenfläche darf nicht negativ sein.");
            }

            System.out.print("Geben Sie die Balkonfläche an: ");
            balkon = scanner.nextDouble();
            if (balkon < 0) {
                throw new IllegalArgumentException("Balkonfläche darf nicht negativ sein.");
            }



        return new Wohnung(innen, balkon);
    }

    @Override
    public String toString() {
        return "Wohnung {" +
                "flaecheInnen = " + flaecheInnen +
                ", flaecheBalkon = " + flaecheBalkon +
                '}';
    }
}
