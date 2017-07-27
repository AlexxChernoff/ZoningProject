package controllers;

import entities.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import mainApp.ZoningProject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MapPageController extends Controller implements Initializable {

    @FXML
    private MapView mapView;
    @FXML
    private TabPane toolsTabPane;
    @FXML
    private ZonesListView zonesListView;

    private ZoningProject mainApp;
    private ObservableList<Zone> zonesList = FXCollections.observableArrayList();

    private MapMode mapMode;
    private GMap gMap;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        zonesListView.setItems(zonesList);
        initMapMode();
        toolsTabPane.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            initMapMode();
            mapView.setMapMode(mapMode);
        });
        mapView.getLastEventProperty().addListener((observable, oldEvent, lastEvent) -> {
            if (lastEvent != null) {
                switch(mapMode) {
                    case ZONES:
                        switch(lastEvent) {
                            case "polygon_drawing_end":
                                break;
                            case "polygon_edit_end":
                                break;
                        }
                        break;
                    case MARKERS:
                        switch(lastEvent) {
                            case "marker_added":
                                break;
                            case "marker_changed":
                                break;
                        }
                        break;
                    case STATISTIC:
                        break;
                    case PRINTER:
                        break;
                }
                System.out.println("Map mode " + mapMode);
                System.out.println("Last event " + lastEvent);
            }
        });
        mapView.setGMap(new GMap());
        mapView.getLoadedProperty().addListener((observable, notLoaded, isLoaded) -> {
            if (isLoaded) {
                mapView.setMapMode(mapMode);
            }
        });
    }

    public void addZone() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/views/AddZone.fxml"));
            GridPane page = (GridPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Добавление зоны");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(getMainApp().getMainAppStage());
            Scene scene = new Scene(page, 400, 300);
            dialogStage.setScene(scene);
            dialogStage.setResizable(false);

            //dialogStage.initStyle(StageStyle.UNDECORATED);

            AddZoneController controller = loader.getController();
            controller.setDialogStage(dialogStage);

            dialogStage.showAndWait();

            if (controller.isOkClicked()){
                zonesList.add(controller.getZone());
                mapView.getGMap().addZoneToList(controller.getZone());
                System.out.println(mapView.getGMap());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initMapMode() {
        String mapModeId = toolsTabPane.getSelectionModel().getSelectedItem().getId();
        switch(mapModeId) {
            case "zonesMode":
                mapMode = MapMode.ZONES;
                break;
            case "markersMode":
                mapMode = MapMode.MARKERS;
                break;
            case "statisticMode":
                mapMode = MapMode.STATISTIC;
                break;
            case "printerMode":
                mapMode = MapMode.PRINTER;
                break;
            default:
                mapMode = null;
                break;
        }
    }

}
