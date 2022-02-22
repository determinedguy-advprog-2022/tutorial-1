package id.ac.ui.cs.advprog.tutorial1.tracking.core;

import id.ac.ui.cs.advprog.tutorial1.tracking.repository.EventMonitorRepository;

import java.util.List;

public interface RoadUser {
    void handleNotification(String notificationFrom, String location);
    String getName();
    int getSpeed();
    List<String> getAllowedRoutes();
    void addEventMonitor(EventMonitorRepository eventMonitorRepository);
}
