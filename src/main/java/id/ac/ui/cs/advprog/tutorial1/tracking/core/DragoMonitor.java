package id.ac.ui.cs.advprog.tutorial1.tracking.core;

import id.ac.ui.cs.advprog.tutorial1.tracking.repository.EventMonitorRepository;

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

    @Override
    public List<RoadUser> getRoadUserList() {
        return this.roadUserList;
    }

    @Override
    public void getEventMonitor(EventMonitorRepository eventMonitorRepository) {
        for (RoadUser roadUser : roadUserList) {
            roadUser.addEventMonitor(eventMonitorRepository);
        }
    }
    
}
