/**
 * 
 */

package it.bogny.jyugiohdb.model;

import java.time.LocalDate;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model class for a Card.
 *
 * @author BoGnY
 */

public class CardSet {
    private final IntegerProperty cardId;
    // For table columns (card sets)
    private final IntegerProperty listId;
    private final StringProperty cardSetLang;
    private final ObjectProperty<LocalDate> cardSetDate;
    private final StringProperty cardSetCode;
    private final StringProperty cardSetName;
    private final StringProperty cardSetRarity;
    private final IntegerProperty cardCount;
    private final StringProperty cardCondition;

    /**
     * Default constructor.
     */
    public CardSet() {
        this(0, 0);
    }

    /**
     * Constructor with some initial data.
     * 
     * @param listId
     */
    public CardSet(int cardId, int listId) {
        this.cardId = new SimpleIntegerProperty(cardId);
        // For table columns (card sets)
        this.listId = new SimpleIntegerProperty(listId);
        this.cardSetLang = new SimpleStringProperty();
        this.cardSetDate = new SimpleObjectProperty<LocalDate>(LocalDate.of(1969, 1, 1));
        this.cardSetCode = new SimpleStringProperty();
        this.cardSetName = new SimpleStringProperty();
        this.cardSetRarity = new SimpleStringProperty();
        this.cardCount = new SimpleIntegerProperty();
        this.cardCondition = new SimpleStringProperty();
    }

    public int getCardId() {
        return cardId.get();
    }

    public void setCardId(int cardId) {
        this.cardId.set(cardId);
    }

    public IntegerProperty cardIdProperty() {
        return cardId;
    }

    // For table columns (card sets)
    public int getListId() {
        return listId.get();
    }

    public void setListId(int listId) {
        this.listId.set(listId);
    }

    public IntegerProperty listIdProperty() {
        return listId;
    }

    public String getCardSetLang() {
        return cardSetLang.get();
    }

    public void setCardSetLang(String cardSetLang) {
        this.cardSetLang.set(cardSetLang);
    }

    public StringProperty cardSetLangProperty() {
        return cardSetLang;
    }

    public LocalDate getCardSetDate() {
        return cardSetDate.get();
    }

    public void setCardSetDate(LocalDate cardSetDate) {
        this.cardSetDate.set(cardSetDate);
    }

    public ObjectProperty<LocalDate> cardSetDateProperty() {
        return cardSetDate;
    }

    public String getCardSetCode() {
        return cardSetCode.get();
    }

    public void setCardSetCode(String cardSetCode) {
        this.cardSetCode.set(cardSetCode);
    }

    public StringProperty cardSetCodeProperty() {
        return cardSetCode;
    }

    public String getCardSetName() {
        return cardSetName.get();
    }

    public void setCardSetName(String cardSetName) {
        this.cardSetName.set(cardSetName);
    }

    public StringProperty cardSetNameProperty() {
        return cardSetName;
    }

    public String getCardSetRarity() {
        return cardSetRarity.get();
    }

    public void setCardSetRarity(String cardSetRarity) {
        this.cardSetRarity.set(cardSetRarity);
    }

    public StringProperty cardSetRarityProperty() {
        return cardSetRarity;
    }

    public int getCardCount() {
        return cardCount.get();
    }

    public void setCardCount(int cardCount) {
        this.cardCount.set(cardCount);
    }

    public IntegerProperty cardCountProperty() {
        return cardCount;
    }

    public String getCardCondition() {
        return cardCondition.get();
    }

    public void setCardCondition(String cardCondition) {
        this.cardCondition.set(cardCondition);
    }

    public StringProperty cardConditionProperty() {
        return cardCondition;
    }

}
