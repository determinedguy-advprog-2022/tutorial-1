package id.ac.ui.cs.advprog.tutorial1.tracking.core;

import id.ac.ui.cs.advprog.tutorial1.tracking.repository.EventMonitorRepository;

import java.util.ArrayList;
import java.util.List;

public class Courier implements RoadUser {

    private String name;
    private int speed;
    private List<String> allowedRoutes = new ArrayList<>();
    private List<String> originalRoutes = new ArrayList<>();
    private List<EventMonitor> allEventMonitor = new ArrayList<>();

    /*
        speed: the speed of the courier
        allowedRoutes: name of all possible routes this courier can visit
    */
    public Courier(String name, int speed, List<String> allowedRoutes) {
        this.name = name;
        this.speed = speed;
        this.allowedRoutes.addAll(allowedRoutes);
        this.originalRoutes.addAll(allowedRoutes);
    }

    // Function to check if the monitor is SweetsMonitor and the courier is in it
    public SweetsMonitor getIfSweetsCourier() {
        if (!allEventMonitor.isEmpty()) {
            for (EventMonitor event : allEventMonitor) {
                if (event.getName().equals("Sweets Monitor") && event.getRoadUserList().contains(this)) {
                    return (SweetsMonitor) event;
                }
            }
        }
        return null;
    }

    @Override
    public void handleNotification(String notificationFrom, String location) {
        // Handle Raiden behavior which is attracted to Sweets
        if (notificationFrom.equals("SweetsMonitor")) {
            // Remove the locations which are not the desired location
            this.allowedRoutes.clear();
            this.allowedRoutes.add(location);
        }
        // Handle Couriers' behavior which stay away from Drago
        else if (notificationFrom.equals("DragoMonitor")) {
            // Check if the courier is not in SweetsMonitor
            if (getIfSweetsCourier() == null || !getIfSweetsCourier().getIsTriggered()) {
                // Remove the location which Drago is in it
                this.allowedRoutes.remove(location);
                // Add (or re-add) original locations to allowed routes (excluding Drago's location)
                for (String originalRoute : originalRoutes) {
                    if (!allowedRoutes.contains(originalRoute) && !originalRoute.equals(location)) {
                        allowedRoutes.add(originalRoute);
                    }
                }
            }
        }
    }

    @Override
    public int getSpeed() {
        return this.speed;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<String> getAllowedRoutes() {
        return this.allowedRoutes;
    }

    @Override
    public void addEventMonitor(EventMonitorRepository eventMonitorRepository) {
        this.allEventMonitor.addAll(eventMonitorRepository.findAll());
    }
    
}
