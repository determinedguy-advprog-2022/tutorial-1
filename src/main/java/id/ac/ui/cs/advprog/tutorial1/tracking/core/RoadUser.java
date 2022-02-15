package id.ac.ui.cs.advprog.tutorial1.tracking.core;

public interface RoadUser {
    void handleNotification(String notificationFrom, String location);
    String getName();
    int getSpeed();
}
