/**
 * 
 */

package it.bogny.jyugiohdb.model;

import java.time.LocalDate;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
    private final FloatProperty cardPriceHigh;
    private final FloatProperty cardPriceLow;
    private final FloatProperty cardPriceAverage;
    /**
     * The data as an observable list of Cards.
     */
    public static ObservableList<CardSet> cardSetData = FXCollections.observableArrayList();

    /**
     * Returns the data as an observable list of CardSets.
     * 
     * @return
     */
    public static ObservableList<CardSet> getCardSetData() {
        return cardSetData;
    }

    /**
     * Constructor with one data.
     * 
     * @param cardId
     */
    public CardSet(int cardId) {
        int selectedIndex = 0;
        for (int i = 0; i < cardSetData.size(); i++) {
            if ((cardSetData.get(i).getCardId() == cardId)) {
                selectedIndex = i;
            }
        }
        this.cardId = cardSetData.get(selectedIndex).cardIdProperty();
        this.listId = cardSetData.get(selectedIndex).listIdProperty();
        this.cardSetLang = cardSetData.get(selectedIndex).cardSetLangProperty();
        this.cardSetDate = cardSetData.get(selectedIndex).cardSetDateProperty();
        this.cardSetCode = cardSetData.get(selectedIndex).cardSetCodeProperty();
        this.cardSetName = cardSetData.get(selectedIndex).cardSetNameProperty();
        this.cardSetRarity = cardSetData.get(selectedIndex).cardSetRarityProperty();
        this.cardCount = cardSetData.get(selectedIndex).cardCountProperty();
        this.cardCondition = cardSetData.get(selectedIndex).cardConditionProperty();
        this.cardPriceHigh = cardSetData.get(selectedIndex).cardPriceHighProperty();
        this.cardPriceLow = cardSetData.get(selectedIndex).cardPriceLowProperty();
        this.cardPriceAverage = cardSetData.get(selectedIndex).cardPriceAverageProperty();
    }

    /**
     * Constructor with all data.
     * 
     * @param cardId
     * @param listId
     * @param cardSetLang
     * @param cardSetDate
     * @param cardSetCode
     * @param cardSetName
     * @param cardSetRarity
     * @param cardCount
     * @param cardCondition
     * @param cardPriceHigh
     * @param cardPriceLow
     * @param cardPriceAverage
     */
    public CardSet(int cardId, int listId, String cardSetLang, LocalDate cardSetDate, String cardSetCode, String cardSetName, String cardSetRarity, int cardCount, String cardCondition, float cardPriceHigh, float cardPriceLow, float cardPriceAverage) {
        this.cardId = new SimpleIntegerProperty(cardId);
        // For table columns (card sets)
        this.listId = new SimpleIntegerProperty(listId);
        this.cardSetLang = new SimpleStringProperty(cardSetLang);
        this.cardSetDate = new SimpleObjectProperty<LocalDate>(cardSetDate);
        this.cardSetCode = new SimpleStringProperty(cardSetCode);
        this.cardSetName = new SimpleStringProperty(cardSetName);
        this.cardSetRarity = new SimpleStringProperty(cardSetRarity);
        this.cardCount = new SimpleIntegerProperty(cardCount);
        this.cardCondition = new SimpleStringProperty(cardCondition);
        this.cardPriceHigh = new SimpleFloatProperty(cardPriceHigh);
        this.cardPriceLow = new SimpleFloatProperty(cardPriceLow);
        this.cardPriceAverage = new SimpleFloatProperty(cardPriceAverage);
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

    public float getCardPriceHigh() {
        return cardPriceHigh.get();
    }

    public void setCardPriceHigh(float cardPriceHigh) {
        this.cardPriceHigh.set(cardPriceHigh);
    }

    public FloatProperty cardPriceHighProperty() {
        return cardPriceHigh;
    }

    public float getCardPriceLow() {
        return cardPriceLow.get();
    }

    public void setCardPriceLow(float cardPriceLow) {
        this.cardPriceLow.set(cardPriceLow);
    }

    public FloatProperty cardPriceLowProperty() {
        return cardPriceLow;
    }

    public float getCardPriceAverage() {
        return cardPriceAverage.get();
    }

    public void setCardPriceAverage(float cardPriceAverage) {
        this.cardPriceAverage.set(cardPriceAverage);
    }

    public FloatProperty cardPriceAverageProperty() {
        return cardPriceAverage;
    }

}
