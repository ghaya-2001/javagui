package org.example.Connexion1ALINF7.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.example.Connexion1ALINF7.Services.UserService;
import org.example.Connexion1ALINF7.Utils.ImageUploadHelper;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SupplementsController implements Initializable {

    @FXML
    private Button confirmBtn;

    @FXML
    private Button goBackBtn;

    @FXML
    private Button sauce1BTn;

    @FXML
    private Button sauce2BTn;

    @FXML
    private Button sauce3BTn;

    @FXML
    private Button sauce4BTn;

    @FXML
    private Button sauce5BTn;

    @FXML
    private Button sauce6BTn;

    @FXML
    private TextArea txttext;

    @FXML
    private Button updatePicBtn;

    @FXML
    private Stage stage;

    @FXML
    private ImageView avatarImageView;
    private List<String> saucesSelected = new ArrayList<>();

    private int SelectedFoodId;

    public void initInfo(int selectedFoodId){
        this.SelectedFoodId = selectedFoodId;
    }


    @FXML
    void onPicUpdate(ActionEvent event) throws Exception {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Image File");

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image files", "*.png", "*.jpg", "*.jpeg");
        fileChooser.getExtensionFilters().add(extFilter);

        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            ImageUploadHelper imageUploadHelper = new ImageUploadHelper();
            String url = imageUploadHelper.upload(selectedFile.getAbsoluteFile());
            avatarImageView.setImage(new Image(url));
            UserService userService = new UserService();
            userService.updatePicture(UserService.connectedUser.getId(), url);
        }
    }

    @FXML
    void onConfirmAction(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/payment.fxml"));
        try {
            Parent root = loader.load();
            PaymentController paymentController = loader.getController();
            paymentController.setInfo(saucesSelected, txttext.getText(), 1);
            confirmBtn.getScene().setRoot(root);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void onGoBack(ActionEvent event) {

    }

    @FXML
    void sauce1BTnAction(ActionEvent event) {
        sauceBtnAction("sauce-1", sauce1BTn);

    }

    @FXML
    void sauce2BTnAction(ActionEvent event) {
        sauceBtnAction("sauce-2", sauce2BTn);

    }

    @FXML
    void sauce3BTnAction(ActionEvent event) {
        sauceBtnAction("sauce-3", sauce3BTn);

    }

    @FXML
    void sauce4BTnAction(ActionEvent event) {
        sauceBtnAction("sauce-4", sauce4BTn);
    }

    @FXML
    void sauce5BTnAction(ActionEvent event) {
        sauceBtnAction("sauce-5", sauce5BTn);
    }

    @FXML
    void sauce6BTnAction(ActionEvent event) {
        sauceBtnAction("sauce-6", sauce6BTn);

    }

    private void sauceBtnAction(String sauceName, Button button) {
        if (saucesSelected.contains(sauceName)) {
            saucesSelected.remove(sauceName);
            button.getStyleClass().clear();
            button.getStyleClass().add("primary-background");
        } else {
            saucesSelected.add(sauceName);
            button.getStyleClass().add("selected-sauce-background-btn");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(UserService.connectedUser.getProfile_pic()!=null){
            avatarImageView.setImage(new Image(UserService.connectedUser.getProfile_pic()));
        }
    }

    @FXML
    void GobackButton(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FoodList.fxml"));
        try {
            Parent root = loader.load();
            FoodListController foodListController = loader.getController();
            confirmBtn.getScene().setRoot(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
