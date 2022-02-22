package id.ac.ui.cs.advprog.tutorial1.tracking.core;

import java.util.ArrayList;
import java.util.List;

public class SweetsMonitor implements EventMonitor {
    private List<RoadUser> roadUserList = new ArrayList<>();

    @Override
    public void addRoadUser(RoadUser roadUser) {
        roadUserList.add(roadUser);
    }

    @Override
    public void notifyRoadUsers(String newSweetsLocation) {
        for (RoadUser roadUser : roadUserList) {
            roadUser.handleNotification("SweetsMonitor", newSweetsLocation);
        }
    }

    @Override
    public String getName() {
        return "Sweets Monitor";
    }

    public List<RoadUser> getRoadUserList() {
        return this.roadUserList;
    }

}
