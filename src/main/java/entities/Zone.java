package entities;

import java.util.ArrayList;
import java.util.List;

public class Zone {

    private int zoneId;
    private String zoneName;
    private Limits zoneLimits;
    private boolean zoneVisible = true;
    private boolean zoneSelected = false;
    private ShapesProperty shapesProperty;
    private List<MapShapes> mapShapesList = new ArrayList<>();

    public Zone() {
        generateZoneId();
    }

    public int getZoneId() {
        return zoneId;
    }

    public void generateZoneId() {
        this.zoneId = this.hashCode();
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public Limits getZoneLimits() {
        return zoneLimits;
    }

    public void setZoneLimits(Limits zoneLimits) {
        this.zoneLimits = zoneLimits;
    }

    public boolean isZoneVisible() {
        return zoneVisible;
    }

    public void setZoneVisible(boolean zoneVisible) {
        this.zoneVisible = zoneVisible;
    }

    public boolean isZoneSelected() {
        return zoneSelected;
    }

    public void setZoneSelected(boolean zoneSelected) {
        this.zoneSelected = zoneSelected;
    }

    public ShapesProperty getShapesProperty() {
        return shapesProperty;
    }

    public void setShapesProperty(ShapesProperty shapesProperty) {
        this.shapesProperty = shapesProperty;
    }

    public List<MapShapes> getMapShapesList() {
        return mapShapesList;
    }

    public void setMapShapesList(List<MapShapes> mapShapesList) {
        this.mapShapesList = mapShapesList;
    }

    public String toJson() {
        return toString();
    }

    @Override
    public String toString() {
        return "{" +
                "\"zoneId\":" + zoneId +
                ", \"zoneName\":\"" + zoneName + "\"" +
                ", \"zoneLimits\":" + zoneLimits +
                ", \"zoneVisible\":" + zoneVisible +
                ", \"zoneSelected\":" + zoneSelected +
                ", \"shapesProperty\":" + shapesProperty +
                ", \"mapShapesList\":" + mapShapesList +
                '}';
    }
}
