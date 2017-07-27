package entities;

import java.util.ArrayList;
import java.util.List;

public class GMap {

    private int mapId;
    private String mapName;
    private int mapZoom;
    private MapType mapType;
    private LngLat mapCenter;
    private List<Zone> zonesList = new ArrayList<>();
    private List<MarkerType> markerTypesList = new ArrayList<>();
    private List<Marker> markersList = new ArrayList<>();
    private ChangesHistory changesHistory = new ChangesHistory();

    public GMap() {
        generateMapId();
        mapName = "Default map";
        mapZoom = 15;
        mapType = MapType.ROADMAP;
        mapCenter = new LngLat(30.36, 50.46);
    }

    public GMap(String mapName) {
        super();
        this.setMapName(mapName);
    }

    public int getMapId() {
        return mapId;
    }

    private void generateMapId() {
        this.mapId = this.hashCode();
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public int getMapZoom() {
        return mapZoom;
    }

    public void setMapZoom(int mapZoom) {
        this.mapZoom = mapZoom;
    }

    public MapType getMapType() {
        return mapType;
    }

    public void setMapType(MapType mapType) {
        this.mapType = mapType;
    }

    public LngLat getMapCenter() {
        return mapCenter;
    }

    public void setMapCenter(LngLat mapCenter) {
        this.mapCenter = mapCenter;
    }

    public List<Zone> getZonesList() {
        return zonesList;
    }

    public void clearZonesList() {
        zonesList.clear();
    }

    public void addZoneToList(Zone zone) {
        zonesList.add(zone);
    }

    public void deleteZoneFromList(Zone zone) {
        zonesList.remove(zone);
    }

    public void setZonesList(List<Zone> zonesList) {
        this.zonesList = zonesList;
    }

    public List<MarkerType> getMarkerTypesList() {
        return markerTypesList;
    }

    public void setMarkerTypesList(List<MarkerType> markerTypesList) {
        this.markerTypesList = markerTypesList;
    }

    public void clearMarkerTypesList() {
        markerTypesList.clear();
    }

    public void addMarkerTypeToList(MarkerType markerType) {
        markerTypesList.add(markerType);
    }

    public void deleteMarkerTypeFromList(MarkerType markerType) {
        markerTypesList.remove(markerType);
    }

    public List<Marker> getMarkersList() {
        return markersList;
    }

    public void setMarkersList(List<Marker> markersList) {
        this.markersList = markersList;
    }

    public void clearMarkersList() {
        markersList.clear();
    }

    public void addMarkerToList(Marker marker) {
        markersList.add(marker);
    }

    public void deleteMarkerFromList(Marker marker) {
        markersList.remove(marker);
    }

    public String toJson() {
        return "{" +
                "\"mapZoom\":" + mapZoom +
                ", \"mapCenter\":" + mapCenter +
                "}";
    }

    @Override
    public String toString() {
        return "{" +
                "\"mapId\":" + mapId +
                ", \"mapName\":\"" + mapName + "\"" +
                ", \"mapZoom\":" + mapZoom +
                ", \"mapType\":\"" + mapType + "\"" +
                ", \"mapCenter\":" + mapCenter +
                ", \"zonesList\":" + zonesList +
                ", \"markerTypesList\":" + markerTypesList +
                ", \"markersList\":" + markersList +
                ", \"changesHistory\":" + changesHistory +
                '}';
    }
}
