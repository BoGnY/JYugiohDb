/**
 * 
 */

package it.bogny.jyugiohdb.view;

import java.time.LocalDate;
import it.bogny.jyugiohdb.MainApp;
import it.bogny.jyugiohdb.model.Card;
import it.bogny.jyugiohdb.model.CardSet;
import it.bogny.jyugiohdb.util.Log;
import it.bogny.jyugiohdb.util.LogType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * View class for CardOverviewController.
 *
 * @author BoGnY
 */
public class CardOverviewController {
    // For labels (card)
    @FXML
    private TextField cardIdItem;
    @FXML
    private Label cardIdText;
    @FXML
    private Label cardNameITText;
    @FXML
    private Label cardNameENText;
    @FXML
    private Label cardAttributeText;
    @FXML
    private Label cardLevelText;
    @FXML
    private Label cardMonsterTypeText;
    @FXML
    private Label cardTypeText;
    @FXML
    private Label cardPendulumValueText;
    @FXML
    private TextArea cardPendulumTextText;
    @FXML
    private Label cardAtkText;
    @FXML
    private Label cardDefText;
    @FXML
    private TextArea cardTextText;
    // For table columns (card sets)
    @FXML
    private TableView<CardSet> cardSetTable;
    @FXML
    private TableColumn<CardSet, Integer> listIdColumn;
    @FXML
    private TableColumn<CardSet, String> cardSetCodeColumn;
    @FXML
    private TableColumn<CardSet, LocalDate> cardSetDateColumn;
    @FXML
    private TableColumn<CardSet, String> cardSetLangColumn;
    @FXML
    private TableColumn<CardSet, String> cardSetNameColumn;
    @FXML
    private TableColumn<CardSet, String> cardSetRarityColumn;
    @FXML
    private TableColumn<CardSet, Integer> cardCountColumn;
    @FXML
    private TableColumn<CardSet, String> cardConditionColumn;
    @FXML
    private TableColumn<CardSet, Float> cardPriceHighColumn;
    @FXML
    private TableColumn<CardSet, Float> cardPriceLowColumn;
    @FXML
    private TableColumn<CardSet, Float> cardPriceAverageColumn;

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor. The constructor is called before the initialize() method.
     */
    public CardOverviewController() {}

    /**
     * Initializes the controller class. This method is automatically called after
     * the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        try {
            // Initialize the card labels
            showCardDetails(Card.cardData.get(0));
        } catch (IndexOutOfBoundsException IndexOutOfBoundsEx) {
            // Skip this exception
            Log.save(LogType.WARN, "In the current database file yugiohdb.db there are zero cards!!");
        } catch (Exception Ex) {
            Log.save(LogType.ERROR, Ex);
        }

        try {
            // Initialize the card set table with the eight columns (which one is hide).
            showCardSetDetails(Card.cardData.get(0).getCardId());
        } catch (IndexOutOfBoundsException IndexOutOfBoundsEx) {
            // Skip this exception
            Log.save(LogType.WARN, "In the current database file yugiohdb.db there are zero card sets!!");
        } catch (Exception Ex) {
            Log.save(LogType.ERROR, Ex);
        }

        // Listen for selection changes and show the card set details when changed.
        cardIdItem.textProperty().addListener((observable, oldValue, newValue) -> showCardSetDetails(Integer.parseInt(newValue)));

        // Put cardId in text field
        cardIdItem.setText(cardIdText.getText().toString());

    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the card sets table
        cardSetTable.setItems(CardSet.getCardSetData());
    }

    /**
     * Fills all text fields to show details about the card. If the specified card
     * is null, all text fields are cleared.
     * 
     * @param card
     *            The card id or null
     */
    private void showCardDetails(Card card) {
        if (card != null) {
            // Fill the labels with info from the card object.
            cardIdItem.setText(Integer.toString(card.getCardId()));
            cardIdText.setText(Integer.toString(card.getCardId()));
            cardNameITText.setText(card.getCardNameIT());
            cardNameENText.setText(card.getCardNameEN());
            cardAttributeText.setText(card.getCardAttribute());
            cardLevelText.setText(Integer.toString(card.getCardLevel()));
            cardMonsterTypeText.setText(card.getCardMonsterType());
            cardTypeText.setText(card.getCardType());
            cardPendulumValueText.setText(card.getCardPendulumValue());
            cardPendulumTextText.setText(card.getCardPendulumText());
            cardAtkText.setText(card.getCardAtk());
            cardDefText.setText(card.getCardDef());
            cardTextText.setText(card.getCardText());
            // birthdayLabel.setText(DateUtil.format(card.getBirthday()));
        } else {
            // Person is null, remove all the text.
            cardIdItem.setText("");
            cardIdText.setText("");
            cardNameITText.setText("");
            cardNameENText.setText("");
            cardAttributeText.setText("");
            cardLevelText.setText("");
            cardMonsterTypeText.setText("");
            cardTypeText.setText("");
            cardPendulumValueText.setText("");
            cardPendulumTextText.setText("");
            cardAtkText.setText("");
            cardDefText.setText("");
            cardTextText.setText("");
        }
    }

    /**
     * Fills all text fields to show details about the card sets. If the specified
     * card is null, all text fields are cleared.
     * 
     * @param cardSet
     *            The cardSet id or null
     */
    private void showCardSetDetails(int cardId) {
        int selectedIndex = 0;
        for (int i = 0; i < CardSet.cardSetData.size(); i++) {
            if ((CardSet.cardSetData.get(i).getCardId() == cardId)) {
                selectedIndex = i;
            }
        }
        CardSet cardSet = CardSet.cardSetData.get(selectedIndex);
        if (cardSet != null) {
            // Fill the labels with info from the card set object.
            listIdColumn.setCellValueFactory(new PropertyValueFactory<CardSet, Integer>("listId"));
            // listIdColumn.setCellValueFactory(cellData ->
            // cellData.getValue().listIdProperty().asObject());
            cardSetCodeColumn.setCellValueFactory(new PropertyValueFactory<CardSet, String>("cardSetCode"));
            // cardSetCodeColumn.setCellValueFactory(cellData ->
            // cellData.getValue().cardSetCodeProperty());
            cardSetDateColumn.setCellValueFactory(cellData -> cellData.getValue().cardSetDateProperty());
            cardSetLangColumn.setCellValueFactory(cellData -> cellData.getValue().cardSetLangProperty());
            cardSetNameColumn.setCellValueFactory(cellData -> cellData.getValue().cardSetNameProperty());
            cardSetRarityColumn.setCellValueFactory(cellData -> cellData.getValue().cardSetRarityProperty());
            cardCountColumn.setCellValueFactory(cellData -> cellData.getValue().cardCountProperty().asObject());
            cardConditionColumn.setCellValueFactory(cellData -> cellData.getValue().cardConditionProperty());
            cardPriceHighColumn.setCellValueFactory(cellData -> cellData.getValue().cardPriceHighProperty().asObject());
            cardPriceLowColumn.setCellValueFactory(cellData -> cellData.getValue().cardPriceLowProperty().asObject());
            cardPriceAverageColumn.setCellValueFactory(cellData -> cellData.getValue().cardPriceAverageProperty().asObject());
        } else {
            // Person is null, remove all the text.
            /*
             * listIdColumn.setCellValueFactory(new
             * PropertyValueFactory<Card,String>(Integer.toString(0)));
             * cardSetCodeColumn.setCellValueFactory(cellData ->
             * cellData.getValue().cardSetCodeProperty());
             * cardSetDateColumn.setCellValueFactory(cellData ->
             * cellData.getValue().cardSetDateProperty());
             * cardSetLangColumn.setCellValueFactory(cellData ->
             * cellData.getValue().cardSetLangProperty());
             * cardSetNameColumn.setCellValueFactory(cellData ->
             * cellData.getValue().cardSetNameProperty());
             * cardSetRarityColumn.setCellValueFactory(cellData ->
             * cellData.getValue().cardSetRarityProperty());
             * cardCountColumn.setCellValueFactory(cellData ->
             * cellData.getValue().cardCountProperty().asObject());
             * cardConditionColumn.setCellValueFactory(cellData ->
             * cellData.getValue().cardConditionProperty());
             */
        }
    }

    /**
     * Called when the user clicks on the move first button.
     */
    @FXML
    private void handleMoveFirstItem(ActionEvent actionEvent) {
        try {
            showCardDetails(Card.cardData.get(0));
            showCardSetDetails(Card.cardData.get(0).getCardId());
        } catch (Exception Ex) {
            Log.save(LogType.ERROR, Ex);
        }
    }

    /**
     * Called when the user clicks on the move previous button.
     */
    @FXML
    private void handleMovePreviousItem(ActionEvent actionEvent) {
        try {
            int cardId = Integer.parseInt(cardIdItem.getText());
            int selectedIndex = 1;
            if (cardId > Card.MIN_ID) {
                for (int i = 0; i < Card.cardData.size(); i++) {
                    if ((Card.cardData.get(i).getCardId() == cardId)) {
                        if (i != (Card.cardData.size() - Card.cardData.size())) {
                            selectedIndex = --i;
                            showCardDetails(Card.cardData.get(selectedIndex));
                            // showCardSetDetails(new Card(selectedIndex));
                            break;
                        } else {
                            actionEvent.consume();
                            break;
                        }
                    }
                }
            } else {
                actionEvent.consume();
            }
        } catch (Exception Ex) {
            Log.save(LogType.ERROR, Ex);
        }
    }

    /**
     * Called when the user clicks on the move next button.
     */
    @FXML
    private void handleMoveNextItem(ActionEvent actionEvent) {
        try {
            int cardId = Integer.parseInt(cardIdItem.getText());
            int selectedIndex = 1;
            if (cardId < Card.MAX_ID) {
                for (int i = 0; i < Card.cardData.size(); i++) {
                    if ((Card.cardData.get(i).getCardId() == cardId)) {
                        if (i != (Card.cardData.size() - 1)) {
                            selectedIndex = ++i;
                            showCardDetails(Card.cardData.get(selectedIndex));
                            // showCardSetDetails(new Card(selectedIndex));
                            break;
                        } else {
                            actionEvent.consume();
                            break;
                        }
                    }
                }
            } else {
                actionEvent.consume();
            }
        } catch (Exception Ex) {
            Log.save(LogType.ERROR, Ex);
        }
    }

    /**
     * Called when the user clicks on the move last button.
     */
    @FXML
    private void handleMoveLastItem(ActionEvent actionEvent) {
        try {
            showCardDetails(Card.cardData.get(Card.cardData.size() - 1));
            showCardSetDetails(Card.cardData.get(Card.cardData.size() - 1).getCardId());
        } catch (Exception Ex) {
            Log.save(LogType.ERROR, Ex);
        }
    }

}
