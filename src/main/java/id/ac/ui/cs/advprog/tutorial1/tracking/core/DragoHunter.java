package id.ac.ui.cs.advprog.tutorial1.tracking.core;

import id.ac.ui.cs.advprog.tutorial1.tracking.repository.EventMonitorRepository;

import java.util.ArrayList;
import java.util.List;

public class DragoHunter implements RoadUser {

    private String name;
    private int speed;
    private List<String> allowedRoutes  = new ArrayList<>();
    private List<String> originalRoutes  = new ArrayList<>();
    private List<EventMonitor> allEventMonitor = new ArrayList<>();

    /*
        speed: the speed of the courier
        allowedRoutes: name of all possible routes this courier can visit
    */
    public DragoHunter(String name, int speed, List<String> allowedRoutes) {
        this.name = name;
        this.speed = speed;
        this.allowedRoutes.addAll(allowedRoutes);
        this.originalRoutes.addAll(allowedRoutes);
    }

    @Override
    public void handleNotification(String notificationFrom, String location) {
        // As its name, it will hunt Drago, so make the location equals to Drago's hunter
        this.allowedRoutes.clear();
        this.allowedRoutes.add(location);
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
