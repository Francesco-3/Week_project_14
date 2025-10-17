package francescodicecca.TravelManagement.services;

import francescodicecca.TravelManagement.entities.Trip;
import francescodicecca.TravelManagement.entities.enums.TripStatus;
import francescodicecca.TravelManagement.payloads.NewTripPayload;
import francescodicecca.TravelManagement.repositories.TripRepository;
import org.springframework.stereotype.Service;
import francescodicecca.TravelManagement.exceptions.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import java.util.UUID;

@Service
@Slf4j
public class TripService {
    @Autowired
    private TripRepository tripRepository;

    //CREATE
    public Trip saveTrip(NewTripPayload payload) {
        Trip trip = new Trip();
        trip.setDate(payload.getDate());
        trip.setDestination(payload.getDestination());

        log.info("Dipendente " + trip.getDestination() + " è stato salvato correttamente!");
        return trip;
    }

    //READ
    public Page<Trip> getTrip(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return tripRepository.findAll(pageable);
    }

    public Trip findTripById(UUID tripId) {
        return tripRepository.findById(tripId).orElseThrow(() -> new NotFoundException(tripId));
    }

    //UPDATE
    public Trip update(UUID tripId, Trip updatedTrip) {
        return tripRepository.findById(tripId)
                .map(t -> {
                    t.setDestination(updatedTrip.getDestination());
                    t.setDate(updatedTrip.getDate());
                    return tripRepository.save(t);
                })
                .orElseThrow(() -> new NotFoundException(tripId));
    }


    public Trip updateStatus(UUID tripId, TripStatus status) {
        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new NotFoundException(tripId));
        trip.setStatus(status);
        return tripRepository.save(trip);
    }

    //DELETE
    public void findTripByIdAndDelete(UUID tripId) {
        Trip found = this.findTripById(tripId);

        tripRepository.delete(found);
    }
}
