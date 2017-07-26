package entities;

import java.util.ArrayList;
import java.util.List;

public class Zone {

    private int zoneId;
    private String zoneName;
    private Limits zoneLimits;
    private boolean zoneVisible = true;
    private boolean zoneSelected = false;
    private List<MapShapes> mapShapesList = new ArrayList<>();

}
