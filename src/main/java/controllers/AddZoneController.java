package controllers;

import entities.ShapesProperty;
import entities.Zone;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddZoneController {

    private boolean isOkClicked = false;
    private Stage dialogStage;
    private Zone zone;

    @FXML
    TextField zoneNameField;
    @FXML
    ColorPicker zoneFillColor;
    @FXML
    Slider zoneOpacitySlider;
    @FXML
    ColorPicker strokeFillColor;
    @FXML
    Slider zoneStrokeWeightSlider;
    @FXML
    Slider zoneStrokeOpacitySlider;

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void handleAddBtn() {
        isOkClicked = true;
        zone = new Zone();
        zone.setZoneName(zoneNameField.getText());
        ShapesProperty sp = new ShapesProperty(
                zoneFillColor.getValue(),
                zoneOpacitySlider.getValue(),
                strokeFillColor.getValue(),
                zoneStrokeOpacitySlider.getValue(),
                (int)zoneStrokeWeightSlider.getValue()
        );
        zone.setShapesProperty(sp);
        dialogStage.close();
    }

    public void handleCancelAddBtn() {
        dialogStage.close();
    }

    public boolean isOkClicked() {
        return isOkClicked;
    }

    public void setOkClicked(boolean okClicked) {
        isOkClicked = okClicked;
    }
}
