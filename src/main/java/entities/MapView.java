package entities;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.util.Objects;

public class MapView extends AnchorPane {

    private WebView webView;
    private WebEngine webEngine;
    private StringProperty lastEvent = new SimpleStringProperty();
    private BooleanProperty loaded = new SimpleBooleanProperty(false);
    private GMap gMap;

    public MapView() {
        webView = new WebView();
        webEngine = webView.getEngine();
        webEngine.setJavaScriptEnabled(true);
        webEngine.load(getClass().getResource("/templates/map.html").toExternalForm());
        setTopAnchor(webView, 0.0);
        setLeftAnchor(webView, 0.0);
        setBottomAnchor(webView, 0.0);
        setRightAnchor(webView, 0.0);
        this.getChildren().add(webView);
        webView.setOnMouseClicked(e->{
            lastEvent.set(null);
            lastEvent.set(runGMapFunction("getLastEvent()"));
        });
    }

    public StringProperty getLastEventProperty() {
        return lastEvent;
    }

    public BooleanProperty getLoadedProperty() {
        return loaded;
    }

    private void runGMap() {
        Worker<Void> worker = webEngine.getLoadWorker();
        if (worker.getState() == Worker.State.SUCCEEDED) {
            webEngine.executeScript("setMap('"+gMap.toJson()+"')");
        }
        worker.stateProperty().addListener(new ChangeListener<Worker.State>() {
            @Override
            public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {
                if (newValue == Worker.State.SUCCEEDED) {
                    webEngine.executeScript("setMap('"+gMap.toJson()+"')");
                    loaded.set(true);
                }
            }
        });
    }

    public void setMapMode(MapMode mapMode) {
        runGMapFunction("setMapMode('"+mapMode+"')");
    }

    public String runGMapFunction(String function) {
        return (String) webEngine.executeScript(function);
    }

    public GMap getGMap() {
        return gMap;
    }

    public void setGMap(GMap gMap) {
        this.gMap = gMap;
        runGMap();
    }
}
