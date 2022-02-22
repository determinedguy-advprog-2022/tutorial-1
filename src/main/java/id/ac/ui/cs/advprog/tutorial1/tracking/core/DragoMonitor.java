package id.ac.ui.cs.advprog.tutorial1.tracking.core;

import java.util.ArrayList;
import java.util.List;

public class DragoMonitor implements EventMonitor {
    private List<RoadUser> roadUserList  = new ArrayList<>();

    @Override
    public void addRoadUser(RoadUser roadUser) {
        roadUserList.add(roadUser);
    }

    @Override
    public void notifyRoadUsers(String newDragoLocation) {
        for (RoadUser roadUser : roadUserList) {
            roadUser.handleNotification("DragoMonitor", newDragoLocation);
        }
    }

    @Override
    public String getName() {
        return "Drago Monitor";
    }
    
}
