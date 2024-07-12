package org.example.Connexion1ALINF7.controllers;

import com.stripe.exception.StripeException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import org.example.Connexion1ALINF7.Entite.Cart;
import org.example.Connexion1ALINF7.Entite.Commande;
import org.example.Connexion1ALINF7.Services.CommandeService;
import org.example.Connexion1ALINF7.Services.UserService;
import org.example.Connexion1ALINF7.Utils.StripeService;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class PaymentController implements Initializable {


    ToggleGroup paymentTypeGroup = new ToggleGroup();
    ToggleGroup cardTypeGroup = new ToggleGroup();
    private List<String> sauces = new ArrayList<>();
    private String comment;
    private int foodId;
    private float totalToCharge;
    @FXML
    private RadioButton bankCardBtn;
    @FXML
    private TextArea box;
    @FXML
    private TextArea box2;
    @FXML
    private RadioButton cashPayAction;
    @FXML
    private RadioButton onlinePay;
    @FXML
    private RadioButton postCardBtn;
    @FXML
    private Button confirmBtn;
    @FXML
    private Button goBackButton;

    private String selectedPaymentType, selectedCardType;

    @FXML
    void buttonpressed(ActionEvent event) {

    }

    public void setInfo(List<String> sauces, String comment, int foodId) {
        this.sauces = sauces;
        this.comment = comment;

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cashPayAction.setToggleGroup(paymentTypeGroup);
        onlinePay.setToggleGroup(paymentTypeGroup);
        postCardBtn.setToggleGroup(cardTypeGroup);
        bankCardBtn.setToggleGroup(cardTypeGroup);

        cardTypeGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

                if (cardTypeGroup.getSelectedToggle() != null) {
                    selectedCardType = cardTypeGroup.getSelectedToggle().getUserData().toString();

                }

            }
        });

        paymentTypeGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

                if (paymentTypeGroup.getSelectedToggle() != null) {
                    selectedPaymentType = paymentTypeGroup.getSelectedToggle().getUserData().toString();

                }

            }
        });

        box2.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d{0,4}(\\s\\d{0,4}){0,3}")) {
                String formattedValue = newValue.replaceAll("[^\\d\\s]", "").trim();
                formattedValue = formattedValue.replaceAll("\\s", "");
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < formattedValue.length(); i++) {
                    if (i > 0 && i % 4 == 0) {
                        sb.append(" ");
                    }
                    sb.append(formattedValue.charAt(i));
                }
                box2.setText(sb.toString().trim());
            }
        });
    }

    @FXML
    void bankCardAction(ActionEvent event) {

    }

    @FXML
    void cashPayAction(ActionEvent event) {

    }

    @FXML
    void onlinePayAction(ActionEvent event) {

    }

    @FXML
    void postCardBtnAction(ActionEvent event) {

    }

    @FXML
    void confirmBtnAction(ActionEvent event) throws StripeException {
        if (!box2.getText().isEmpty()) {
            StripeService stripeService = new StripeService();
            String id = stripeService.createNewCustomer("tok_visa", "test@gmail.com", UserService.connectedUser.getUsername());
//            stripeService.chargeNewCustomer(id, (long) totalToCharge);
            long total = 0L;

            for (var item : Cart.getInstance().getItems()) {
                total = total + (long) (item.getQuantity() * item.getFood().getPrix());
            }

            if (stripeService.chargeNewCustomer(id, total * 100)) {
                Commande commande = new Commande();
                commande.setComment(this.comment);
                commande.setSauces(String.join(", ", sauces));
                commande.setTotal((int)total);
                commande.setUserid(UserService.connectedUser.getId());
                commande.setCardNumber(box2.getText());
                commande.setPaymentType(selectedPaymentType);
                commande.setCardType(selectedCardType);
                CommandeService commandeService = new CommandeService();
                commandeService.ajouterCommande(commande);




                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Payment Successful", ButtonType.OK);
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Payment error", ButtonType.OK);
                alert.showAndWait();
            }


        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Invalid credit card");
            alert.showAndWait();
        }
    }

    @FXML
    void gobackButton(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/supplements.fxml"));
        try {
            Parent root = loader.load();
            SupplementsController paymentController = loader.getController();
            confirmBtn.getScene().setRoot(root);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
