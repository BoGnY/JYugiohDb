/**
 * 
 */

package it.bogny.jyugiohdb.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model class for a Card.
 *
 * @author BoGnY
 */

public class Card {
    // Current MIN and MAX values for cardId
    public final static Integer MIN_ID = 4007;
    public final static Integer MAX_ID = 13191;

    // For labels (card)
    private final IntegerProperty cardId;
    private final StringProperty cardNameIT;
    private final StringProperty cardNameEN;
    private final StringProperty cardAttribute;
    private final IntegerProperty cardLevelInt;
    private final StringProperty cardMonsterType;
    private final StringProperty cardType;
    private final StringProperty cardPendulumValue;
    private final StringProperty cardPendulumText;
    private final StringProperty cardAtk;
    private final StringProperty cardDef;
    private final StringProperty cardText;

    /**
     * Default constructor.
     */
    public Card() {
        this(0);
    }

    /**
     * Constructor with some initial data.
     * 
     * @param cardId
     */
    public Card(int cardId) {
        // For labels (card)
        this.cardId = new SimpleIntegerProperty(cardId);
        this.cardNameIT = new SimpleStringProperty();
        this.cardNameEN = new SimpleStringProperty();
        this.cardAttribute = new SimpleStringProperty();
        this.cardLevelInt = new SimpleIntegerProperty();
        this.cardMonsterType = new SimpleStringProperty();
        this.cardType = new SimpleStringProperty();
        this.cardPendulumValue = new SimpleStringProperty();
        this.cardPendulumText = new SimpleStringProperty();
        this.cardAtk = new SimpleStringProperty();
        this.cardDef = new SimpleStringProperty();
        this.cardText = new SimpleStringProperty();
    }

    // For labels (card)
    public int getCardId() {
        return cardId.get();
    }

    public void setCardId(int cardId) {
        this.cardId.set(cardId);
    }

    public IntegerProperty cardIdProperty() {
        return cardId;
    }

    public String getCardNameIT() {
        return cardNameIT.get();
    }

    public void setCardNameIT(String cardNameIT) {
        this.cardNameIT.set(cardNameIT);
    }

    public StringProperty cardNameITProperty() {
        return cardNameIT;
    }

    public String getCardNameEN() {
        return cardNameEN.get();
    }

    public void setCardNameEN(String cardNameEN) {
        this.cardNameEN.set(cardNameEN);
    }

    public StringProperty cardNameENProperty() {
        return cardNameEN;
    }

    public String getCardAttribute() {
        return cardAttribute.get();
    }

    public void setCardAttribute(String cardAttribute) {
        this.cardAttribute.set(cardAttribute);
    }

    public StringProperty cardAttributeProperty() {
        return cardAttribute;
    }

    public int getCardLevelInt() {
        return cardLevelInt.get();
    }

    public void setCardLevelInt(int cardLevelInt) {
        this.cardLevelInt.set(cardLevelInt);
    }

    public IntegerProperty cardLevelIntProperty() {
        return cardLevelInt;
    }

    public String getCardMonsterType() {
        return cardMonsterType.get();
    }

    public void setCardMonsterType(String cardMonsterType) {
        this.cardMonsterType.set(cardMonsterType);
    }

    public StringProperty cardMonsterTypeProperty() {
        return cardMonsterType;
    }

    public String getCardType() {
        return cardType.get();
    }

    public void setCardType(String cardType) {
        this.cardType.set(cardType);
    }

    public StringProperty cardTypeProperty() {
        return cardType;
    }

    public String getCardPendulumValue() {
        return cardPendulumValue.get();
    }

    public void setCardPendulumValue(String cardPendulumValue) {
        this.cardPendulumValue.set(cardPendulumValue);
    }

    public StringProperty cardPendulumValueProperty() {
        return cardPendulumValue;
    }

    public String getCardPendulumText() {
        return cardPendulumText.get();
    }

    public void setCardPendulumText(String cardPendulumText) {
        this.cardPendulumText.set(cardPendulumText);
    }

    public StringProperty cardPendulumTextProperty() {
        return cardPendulumText;
    }

    public String getCardAtk() {
        return cardAtk.get();
    }

    public void setCardAtk(String cardAtk) {
        this.cardAtk.set(cardAtk);
    }

    public StringProperty cardAtkProperty() {
        return cardAtk;
    }

    public String getCardDef() {
        return cardDef.get();
    }

    public void setCardDef(String cardDef) {
        this.cardDef.set(cardDef);
    }

    public StringProperty cardDefProperty() {
        return cardDef;
    }

    public String getCardText() {
        return cardText.get();
    }

    public void setCardText(String cardText) {
        this.cardText.set(cardText);
    }

    public StringProperty cardTextProperty() {
        return cardText;
    }

}
