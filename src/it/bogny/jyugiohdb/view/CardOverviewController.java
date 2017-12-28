/**
 * 
 */

package it.bogny.jyugiohdb.view;

import java.time.LocalDate;
import it.bogny.jyugiohdb.MainApp;
import it.bogny.jyugiohdb.model.Card;
import it.bogny.jyugiohdb.model.CardSet;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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

    // Reference to the main application.
    private MainApp MainApp;

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
        // Initialize the card labels
        showCardDetails(new Card(Card.MIN_ID));

        // Initialize the card set table with the eight columns (which one is hide).
        // showCardSetDetails(new Card(Card.MIN_ID));

        // Listen for selection changes and show the card set details when changed.
        cardSetTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showCardSetDetails(newValue));

        // Put cardId in text field
        cardIdItem.setText(cardIdText.getText().toString());

    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param MainApp
     */
    public void setMainApp(MainApp MainApp) {
        this.MainApp = MainApp;

        // Add observable list data to the card sets table
        cardSetTable.setItems(MainApp.getCardSetData());
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
            cardLevelText.setText(Integer.toString(card.getCardLevelInt()));
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
     * @param card
     *            The card id or null
     */
    private void showCardSetDetails(CardSet cardSet) {
        if (cardSet != null) {
            // Fill the labels with info from the card set object.
            listIdColumn.setCellValueFactory(cellData -> cellData.getValue().listIdProperty().asObject());
            cardSetCodeColumn.setCellValueFactory(cellData -> cellData.getValue().cardSetCodeProperty());
            cardSetDateColumn.setCellValueFactory(cellData -> cellData.getValue().cardSetDateProperty());
            cardSetLangColumn.setCellValueFactory(cellData -> cellData.getValue().cardSetLangProperty());
            cardSetNameColumn.setCellValueFactory(cellData -> cellData.getValue().cardSetNameProperty());
            cardSetRarityColumn.setCellValueFactory(cellData -> cellData.getValue().cardSetRarityProperty());
            cardCountColumn.setCellValueFactory(cellData -> cellData.getValue().cardCountProperty().asObject());
            cardConditionColumn.setCellValueFactory(cellData -> cellData.getValue().cardConditionProperty());
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
    private void handleMoveFirstItem() {
        try {
            int selectedIndex = Integer.parseInt(cardIdItem.getText());
            showCardDetails(null);
            showCardSetDetails(null);
            if ((selectedIndex >= Card.MIN_ID) && (selectedIndex <= Card.MAX_ID)) {
                showCardDetails(new Card(MainApp.cardData.indexOf(selectedIndex)));
                // showCardSetDetails(new Card(selectedIndex + 1));
            } else {
                showCardDetails(new Card(Card.MIN_ID));
                // showCardSetDetails(new Card(Card.MIN_ID));
            }
        } catch (NumberFormatException NumberFormatEx) {
            showCardDetails(new Card(Card.MIN_ID));
            // showCardSetDetails(new Card(Card.MIN_ID));
        }
    }

    /**
     * Called when the user clicks on the move previous button.
     */
    @FXML
    private void handleMovePreviousItem() {
        try {
            int selectedIndex = Integer.parseInt(cardIdItem.getText());
            showCardDetails(null);
            showCardSetDetails(null);
            if ((selectedIndex > Card.MIN_ID) && (selectedIndex <= Card.MAX_ID)) {
                showCardDetails(new Card(selectedIndex - 1));
                // showCardSetDetails(new Card(selectedIndex - 1));
            } else {
                showCardDetails(new Card(Card.MIN_ID));
                // showCardSetDetails(new Card(Card.MIN_ID));
            }
        } catch (NumberFormatException NumberFormatEx) {
            showCardDetails(new Card(Card.MIN_ID));
            // showCardSetDetails(new Card(Card.MIN_ID));
        }
    }

    /**
     * Called when the user clicks on the move next button.
     */
    @FXML
    private void handleMoveNextItem() {
        try {
            int selectedIndex = Integer.parseInt(cardIdItem.getText());
            showCardDetails(null);
            showCardSetDetails(null);
            if ((selectedIndex >= Card.MIN_ID) && (selectedIndex < Card.MAX_ID)) {
                showCardDetails(new Card(selectedIndex + 1));
                // showCardSetDetails(new Card(selectedIndex + 1));
            } else {
                showCardDetails(new Card(Card.MAX_ID));
                // showCardSetDetails(new Card(Card.MAX_ID));
            }
        } catch (NumberFormatException NumberFormatEx) {
            showCardDetails(new Card(Card.MAX_ID));
            // showCardSetDetails(new Card(Card.MAX_ID));
        }
    }

    /**
     * Called when the user clicks on the move last button.
     */
    @FXML
    private void handleMoveLastItem() {
        try {
            int selectedIndex = Integer.parseInt(cardIdItem.getText());
            showCardDetails(null);
            showCardSetDetails(null);
            if ((selectedIndex >= Card.MIN_ID) && (selectedIndex <= Card.MAX_ID)) {
                showCardDetails(new Card(MainApp.cardData.lastIndexOf(selectedIndex)));
                // showCardSetDetails(new Card(selectedIndex + 1));
            } else {
                showCardDetails(new Card(Card.MAX_ID));
                // showCardSetDetails(new Card(Card.MAX_ID));
            }
        } catch (NumberFormatException NumberFormatEx) {
            showCardDetails(new Card(Card.MAX_ID));
            // showCardSetDetails(new Card(Card.MAX_ID));
        }
    }

}
