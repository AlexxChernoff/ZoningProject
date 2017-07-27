package controllers;

import entities.GMap;
import entities.LngLat;
import entities.MapView;
import javafx.fxml.FXML;

public class MapPageController {

    @FXML
    private MapView mapView;

    public void toMap1() {
        mapView.setGMap(new GMap(16, new LngLat(30.35998821285193, 50.459785358356854)));
    }
    public void toMap2() {
        mapView.setGMap(new GMap(16, new LngLat(30.361717772707834, 50.460443863472776)));
    }
    public void toMap3() {
        mapView.setGMap(new GMap(16, new LngLat(30.36485059468157, 50.4606077895278)));
    }

}
