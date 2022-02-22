package id.ac.ui.cs.advprog.tutorial1.tracking.core;

import id.ac.ui.cs.advprog.tutorial1.tracking.repository.EventMonitorRepository;

import java.util.ArrayList;
import java.util.List;

public class Courier implements RoadUser {

    private String name;
    private int speed;
    private List<String> allowedRoutes = new ArrayList<>();
    private List<String> originalRoutes = new ArrayList<>();
    private EventMonitorRepository eventMonitorRepository;

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

    // Function to make list of sweets monitors
    public List<SweetsMonitor> makeSweetsMonitorList() {
        List<EventMonitor> eventMonitors = new ArrayList<>();
        List<SweetsMonitor> sweetsMonitorList = new ArrayList<>();

        if (eventMonitorRepository != null) {
            eventMonitors = eventMonitorRepository.findAll();
        }

        if (!eventMonitors.isEmpty()) {
            for (EventMonitor event : eventMonitors) {
                if (event.getName().equals("Sweets Monitor")) {
                    sweetsMonitorList.add((SweetsMonitor) event);
                }
            }
        }

        return sweetsMonitorList;
    }

    // Function to check if the courier (this) is in SweetsMonitor
    public boolean isSweetsMonitorsContainCourier(List<SweetsMonitor> sweetsMonitorList) {
        if (!sweetsMonitorList.isEmpty()) {
            for (SweetsMonitor event : sweetsMonitorList) {
                if (event.getRoadUserList().contains(this)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void handleNotification(String notificationFrom, String location) {
        // Handle Raiden behavior which is attracted to Sweets
        if (notificationFrom.equals("SweetsMonitor")) {
            // Remove the locations which are not the desired location
            for (int i = 0;i < this.allowedRoutes.size(); i++) {
                if (!this.allowedRoutes.get(i).equals(location)) {
                    this.allowedRoutes.remove(i);
                }
            }
        }
        // Handle Couriers' behavior which stay away from Drago
        else if (notificationFrom.equals("DragoMonitor")) {
            // Check if the courier is not in SweetsMonitor
            if (!makeSweetsMonitorList().isEmpty() && !isSweetsMonitorsContainCourier(makeSweetsMonitorList())) {
                // Remove the location which Drago is in it
                this.allowedRoutes.remove(location);
                // Add (or re-add) original locations to allowed routes (excluding Drago's location)
                for (String str : originalRoutes) {
                    if (!allowedRoutes.contains(str) && !str.equals(location)) {
                        allowedRoutes.add(str);
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
    
}
