public class Dachwohnung extends Wohnung {

    private double flaecheSchraegen;
    public Dachwohnung(double flaecheInnen, double flaecheBalkon, double flaecheSchraegen) {
        super(flaecheInnen, flaecheBalkon);
        this.flaecheSchraegen = flaecheSchraegen;
    }
    public Dachwohnung() {
        super();
        this.flaecheSchraegen = 0.0;
    }

    public double getFlaecheSchraegen() {
        return flaecheSchraegen;
    }
    public void setFlaecheSchraegen(double flaecheSchraegen) {
        this.flaecheSchraegen = flaecheSchraegen;
    }

    @Override
    public double getGesamt() {

        return getFlaecheInnen() - (flaecheSchraegen / 2) + (getFlaecheBalkon() / 2);
    }

    @Override
    public String toString() {
        return String.format("Dachwohnung [Innenfläche: %.2f m², Balkonfläche: %.2f m², Schrägenfläche: %.2f m², Gesamtfläche: %.2f m²]",
                getFlaecheInnen(), getFlaecheBalkon(), flaecheSchraegen, getGesamt());
    }
}