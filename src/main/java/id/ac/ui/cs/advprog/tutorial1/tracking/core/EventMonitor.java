package id.ac.ui.cs.advprog.tutorial1.tracking.core;

import id.ac.ui.cs.advprog.tutorial1.tracking.repository.EventMonitorRepository;

import java.util.List;

public interface EventMonitor {
    
    void addRoadUser(RoadUser roadUser);
    void notifyRoadUsers(String newLocation);
    String getName();
    List<RoadUser> getRoadUserList();
    void getEventMonitor(EventMonitorRepository eventMonitorRepository);
}
