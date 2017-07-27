package entities;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class MapView extends AnchorPane {

    private WebView webView;
    private WebEngine webEngine;
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
    }

    private void loadGMapToView() {
        Worker<Void> worker = webEngine.getLoadWorker();
        if (worker.getState() == Worker.State.SUCCEEDED) {
            webEngine.executeScript("setMap('"+gMap.toString()+"')");
        }
        worker.stateProperty().addListener(new ChangeListener<Worker.State>() {
            @Override
            public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {
                if (newValue == Worker.State.SUCCEEDED) {
                    webEngine.executeScript("setMap('"+gMap.toString()+"')");
                }
            }
        });
    }

    public GMap getGMap() {
        return gMap;
    }

    public void setGMap(GMap gMap) {
        this.gMap = gMap;
        loadGMapToView();
    }
}
