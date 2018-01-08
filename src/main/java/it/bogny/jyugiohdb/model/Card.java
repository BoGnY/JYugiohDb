/**
 * 
 */

package it.bogny.jyugiohdb.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
    private final IntegerProperty cardLevel;
    private final StringProperty cardMonsterType;
    private final StringProperty cardType;
    private final StringProperty cardPendulumValue;
    private final StringProperty cardPendulumText;
    private final StringProperty cardAtk;
    private final StringProperty cardDef;
    private final StringProperty cardText;
    /**
     * The data as an observable list of Cards.
     */
    public static ObservableList<Card> cardData = FXCollections.observableArrayList();

    /**
     * Returns the data as an observable list of Cards.
     * 
     * @return
     */
    public ObservableList<Card> getCardData() {
        FXCollections.sort(cardData, null);
        return cardData;
    }

    /**
     * Constructor with one data.
     * 
     * @param cardId
     */
    public Card(int cardId) {
        int selectedIndex = 0;
        for (int i = 0; i < cardData.size(); i++) {
            if ((cardData.get(i).getCardId() == cardId)) {
                selectedIndex = i;
            }
        }
        this.cardId = cardData.get(selectedIndex).cardIdProperty();
        this.cardNameIT = cardData.get(selectedIndex).cardNameITProperty();
        this.cardNameEN = cardData.get(selectedIndex).cardNameENProperty();
        this.cardAttribute = cardData.get(selectedIndex).cardAttributeProperty();
        this.cardLevel = cardData.get(selectedIndex).cardLevelProperty();
        this.cardMonsterType = cardData.get(selectedIndex).cardMonsterTypeProperty();
        this.cardType = cardData.get(selectedIndex).cardTypeProperty();
        this.cardPendulumValue = cardData.get(selectedIndex).cardPendulumValueProperty();
        this.cardPendulumText = cardData.get(selectedIndex).cardPendulumTextProperty();
        this.cardAtk = cardData.get(selectedIndex).cardAtkProperty();
        this.cardDef = cardData.get(selectedIndex).cardDefProperty();
        this.cardText = cardData.get(selectedIndex).cardTextProperty();
    }

    /**
     * Constructor with all data.
     * 
     * @param cardId
     * @param cardNameIT
     * @param cardNameEN
     * @param cardAttribute
     * @param cardLevel
     * @param cardMonsterType
     * @param cardType
     * @param cardPendulumValue
     * @param cardPendulumText
     * @param cardAtk
     * @param cardDef
     * @param cardText
     */
    public Card(int cardId, String cardNameIT, String cardNameEN, String cardAttribute, int cardLevel, String cardMonsterType, String cardType, String cardPendulumValue, String cardPendulumText, String cardAtk, String cardDef, String cardText) {
        // For labels (card)
        this.cardId = new SimpleIntegerProperty(cardId);
        this.cardNameIT = new SimpleStringProperty(cardNameIT);
        this.cardNameEN = new SimpleStringProperty(cardNameEN);
        this.cardAttribute = new SimpleStringProperty(cardAttribute);
        this.cardLevel = new SimpleIntegerProperty(cardLevel);
        this.cardMonsterType = new SimpleStringProperty(cardMonsterType);
        this.cardType = new SimpleStringProperty(cardType);
        this.cardPendulumValue = new SimpleStringProperty(cardPendulumValue);
        this.cardPendulumText = new SimpleStringProperty(cardPendulumText);
        this.cardAtk = new SimpleStringProperty(cardAtk);
        this.cardDef = new SimpleStringProperty(cardDef);
        this.cardText = new SimpleStringProperty(cardText);
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

    public int getCardLevel() {
        return cardLevel.get();
    }

    public void setCardLevel(int cardLevel) {
        this.cardLevel.set(cardLevel);
    }

    public IntegerProperty cardLevelProperty() {
        return cardLevel;
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
