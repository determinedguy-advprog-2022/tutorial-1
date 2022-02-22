package id.ac.ui.cs.advprog.tutorial1.tracking.core;

import id.ac.ui.cs.advprog.tutorial1.tracking.repository.EventMonitorRepository;

import java.util.ArrayList;
import java.util.List;

public class SweetsMonitor implements EventMonitor {
    private List<RoadUser> roadUserList = new ArrayList<>();
    private boolean isTriggered = false;

    @Override
    public void addRoadUser(RoadUser roadUser) {
        roadUserList.add(roadUser);
    }

    @Override
    public void notifyRoadUsers(String newSweetsLocation) {
        // Change trigger status first, then notify per user
        isTriggered = true;
        for (RoadUser roadUser : roadUserList) {
            roadUser.handleNotification("SweetsMonitor", newSweetsLocation);
        }
    }

    @Override
    public String getName() {
        return "Sweets Monitor";
    }

    @Override
    public List<RoadUser> getRoadUserList() {
        return this.roadUserList;
    }

    public boolean getIsTriggered() {
        return isTriggered;
    }

    @Override
    public void getEventMonitor(EventMonitorRepository eventMonitorRepository) {
        for (RoadUser roadUser : roadUserList) {
            roadUser.addEventMonitor(eventMonitorRepository);
        }
    }

}
