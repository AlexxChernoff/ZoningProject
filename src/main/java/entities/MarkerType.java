package entities;

import java.util.ArrayList;
import java.util.List;

public class MarkerType {

    private int markerTypeId;
    private String markerTypeName;
    private boolean markerTypeVisible = true;
    private boolean markerTypeSelected = false;
    private List<Marker> markersList = new ArrayList<>();

}
