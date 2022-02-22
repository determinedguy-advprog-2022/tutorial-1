package id.ac.ui.cs.advprog.tutorial1.tracking.service;

import id.ac.ui.cs.advprog.tutorial1.tracking.core.RoadUser;
import id.ac.ui.cs.advprog.tutorial1.tracking.repository.EventMonitorRepository;
import id.ac.ui.cs.advprog.tutorial1.tracking.repository.RoadUserRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.ArrayList;

@Service
public class TrackingServiceImpl implements TrackingService {

    @Autowired
    private RoadUserRepository roadUserRepository;

    @Autowired
    private EventMonitorRepository eventMonitorRepository;

    @Override
    public List<RoadUser> getRoadUsers() {
        return roadUserRepository.findAll();
    }

    @Override
    public void handleNewEventLocation(String eventName, String location) {
        // Notify users and update monitors
        eventMonitorRepository.findByName(eventName).notifyRoadUsers(location);
        eventMonitorRepository.findByName(eventName).getEventMonitor(eventMonitorRepository);
    }
    
}
