/**
 * 
 */

package it.bogny.jyugiohdb.model;

import it.bogny.jyugiohdb.MainApp;

/**
 * @author BoGnY
 *
 */
public enum CardCondition {
    MINT("M"), NEAR_MINT("NM"), EXCELLENT("EXC"), FINE("FINE"), GOOD("GOOD"), POOR("POOR");
    /**
     * It's the acronym of card condition, and <b>MUST BE</b> an element of this
     * array [M, NM, EXC, FINE, GOOD, POOR].
     */
    private final String conditionCode;
    private String conditionDescription;

    private CardCondition(String conditionCode) {
        this.conditionCode = conditionCode;
        // this.conditionDescription = conditionDescription;
    }

    public String getConditionCode() {
        return this.conditionCode;
    }

    /**
     * This return the condition description of Enum {@link#CardCondition} from the
     * specified {@link#conditionCode condition code}.
     * 
     * @param lang
     *            The language of description
     * @param conditionCode
     *            The {@link#conditionCode condition code}
     * @return The condition description.
     */
    public String getConditionDescription(String lang, String conditionCode) {
        switch (lang) {
            case "it":
                switch (conditionCode) {
                    case "M":
                        conditionDescription = "E' il più alto grado che possiamo usare per classificare lo stato di una carta. La carta in questione si presenta in uno stato di assoluta perfezione. A volte viene utilizzata la definizione \"sbustata\" per rendere l'idea della sua assoluta \"freschezza\".";
                    case "NM":
                        conditionDescription = "E' una carta che si differenzia dalla Mint per uno al massimo due segni molto piccoli normalmente non visibili di primo impatto. In tutti i casi non compromettono la freschezza della carta.";
                    case "EXC":
                        conditionDescription = "Queste carte presentano una leggera usura sui bordi ed angoli, nello stesso modo può essere presente anche al centro della carta . Non sono presenti pieghe, curvature o danni derivati da esposizione ad acqua e/o agenti atmosferici." + MainApp.lineSeparator + "Il grado di usura si chiarisce solo quando viene osservata attentamente. La carta tende ad avere lievi scolorimenti sul retro.";
                    case "FINE":
                        conditionDescription = "Questa è una carta ovviamente giocata, ma non in maniera pesante. Presenta dei segni che però la rendono facilmente identificabile. Presenta in maniera più o meno grave dei graffi o segni di usura. Può presentare anche alcune pieghe visibili controluce.";
                    case "GOOD":
                        conditionDescription = "Questa carta è stata giocata e si vede. Riporta scolorimenti ampi sui bordi, oppure si notano altri fattori di distintivi quali, pieghe, intagli o strappi. Questa carta è da ritenersi porcheria.";
                    case "POOR":
                        conditionDescription = "La carta con questa classificazione presenta danni consistenti, e permanenti. Possono presentare curvature, le pieghe con arricciamento della superficie lucida della carta, danni da contatto con acqua e umidità con rigonfiature sulla superficie." + MainApp.lineSeparator + "In alcuni casi i bordi oltre ad essere pesantemente scoloriti e usurati perdono anche la geometria e la loro integrità. In alcuni casi la superficie lucida della carta può staccarsi dal cartone sottostante. Queste carte possono ancora essere giocate con bustine per evitare la loro facile identificazione. Quando la vedi la riconosci. Questa è la carta DISGUSTOSA!";
                }
            case "jp":
                switch (conditionCode) {
                    case "M":
                        conditionDescription = "";
                    case "NM":
                        conditionDescription = "";
                    case "EXC":
                        conditionDescription = "";
                    case "FINE":
                        conditionDescription = "";
                    case "GOOD":
                        conditionDescription = "";
                    case "POOR":
                        conditionDescription = "";
                }
            case "fr":
                switch (conditionCode) {
                    case "M":
                        conditionDescription = "";
                    case "NM":
                        conditionDescription = "";
                    case "EXC":
                        conditionDescription = "";
                    case "FINE":
                        conditionDescription = "";
                    case "GOOD":
                        conditionDescription = "";
                    case "POOR":
                        conditionDescription = "";
                }
            case "de":
                switch (conditionCode) {
                    case "M":
                        conditionDescription = "";
                    case "NM":
                        conditionDescription = "";
                    case "EXC":
                        conditionDescription = "";
                    case "FINE":
                        conditionDescription = "";
                    case "GOOD":
                        conditionDescription = "";
                    case "POOR":
                        conditionDescription = "";
                }
            case "en":
            default:
                switch (conditionCode) {
                    case "M":
                        conditionDescription = "";
                    case "NM":
                        conditionDescription = "";
                    case "EXC":
                        conditionDescription = "";
                    case "FINE":
                        conditionDescription = "";
                    case "GOOD":
                        conditionDescription = "";
                    case "POOR":
                        conditionDescription = "";
                }
        }
        return conditionDescription;
    }
}
