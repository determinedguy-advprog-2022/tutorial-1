package id.ac.ui.cs.advprog.tutorial1.tracking.core;

import java.util.List;

public class DragoHunter implements RoadUser {

    private String name;
    /*
        speed: the speed of the courier
        allowedRoutes: name of all possible routes this courier can visit
    */
    public DragoHunter(String name, int speed, List<String> allowedRoutes) {
        this.name = name; 
        // TODO complete me
    }

    @Override
    public void handleNotification(String notificationFrom, String location) {
        // TODO complete me
        
    }

    @Override
    public int getSpeed() {
        // TODO complete me
        return 0;
    }

    @Override
    public String getName() {
        return name;
    }
    
}
