package entities;

import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.util.Callback;

public class ZonesListView<T extends Zone> extends ListView<T> {
    public ZonesListView() {
        this.setCellFactory(new Callback<ListView<T>, ListCell<T>>(){
            @Override
            public ListCell<T> call(ListView<T> p) {
                ListCell<T> cell = new ListCell<T>(){
                    @Override
                    protected void updateItem(T zone, boolean bln) {
                        super.updateItem(zone, bln);
                        Rectangle rect = new Rectangle(40, 20);
                        if (zone != null) {
                            ImageView iv = new ImageView(new Image(zone.isZoneVisible()?"images/eye-icon.png":"images/eye-icon-false.png"));
                            iv.setCursor(Cursor.HAND);
                            iv.setOnMouseClicked(e->{
                                zone.setZoneVisible(!zone.isZoneVisible());
                                iv.setImage(new Image(zone.isZoneVisible()?"images/eye-icon.png":"images/eye-icon-false.png"));
                            });
                            HBox hBox = new HBox(iv, rect, new Label(zone.getZoneName()));
                            hBox.setAlignment(Pos.CENTER_LEFT);
                            rect.setFill(zone.getShapesProperty().getFillColor());
                            rect.setStroke(zone.getShapesProperty().getStrokeColor());
                            rect.setStrokeWidth(zone.getShapesProperty().getStrokeWeight());
                            hBox.setSpacing(10);
                            setGraphic(hBox);
                        } else {
                            setGraphic(null);
                        }
                    }
                };
                return cell;
            }
        });
    }
}
