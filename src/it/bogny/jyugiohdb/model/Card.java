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

public class Card {
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
     * Default constructor with some initial data.
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
        // For table columns (card sets)
        this.listId = new SimpleIntegerProperty();
        this.cardSetLang = new SimpleStringProperty();
        this.cardSetDate = new SimpleObjectProperty<LocalDate>(LocalDate.of(1969, 1, 1));
        this.cardSetCode = new SimpleStringProperty();
        this.cardSetName = new SimpleStringProperty();
        this.cardSetRarity = new SimpleStringProperty();
        this.cardCount = new SimpleIntegerProperty();
        this.cardCondition = new SimpleStringProperty();
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
