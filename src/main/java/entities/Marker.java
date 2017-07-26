package entities;

public class Marker {

    private int markerId;
    private LngLat markerPosition;
    private LngLat markerLabelPosition;
    private String externalLink = "";
    private boolean markerVisible = true;
    private boolean markerSelected = false;
    private boolean markerLabeled = false;

    public Marker() {
        generateMarkerId();
    }

    public int getMarkerId() {
        return markerId;
    }

    private void generateMarkerId() {
        this.markerId = this.hashCode();
    }

    public LngLat getMarkerPosition() {
        return markerPosition;
    }

    public void setMarkerPosition(LngLat markerPosition) {
        this.markerPosition = markerPosition;
    }

    public LngLat getMarkerLabelPosition() {
        return markerLabelPosition;
    }

    public void setMarkerLabelPosition(LngLat markerLabelPosition) {
        this.markerLabelPosition = markerLabelPosition;
    }

    public String getExternalLink() {
        return externalLink;
    }

    public void setExternalLink(String externalLink) {
        this.externalLink = externalLink;
    }

    public boolean isMarkerVisible() {
        return markerVisible;
    }

    public void setMarkerVisible(boolean markerVisible) {
        this.markerVisible = markerVisible;
    }

    public boolean isMarkerSelected() {
        return markerSelected;
    }

    public void setMarkerSelected(boolean markerSelected) {
        this.markerSelected = markerSelected;
    }

    public boolean isMarkerLabeled() {
        return markerLabeled;
    }

    public void setMarkerLabeled(boolean markerLabeled) {
        this.markerLabeled = markerLabeled;
    }
}
