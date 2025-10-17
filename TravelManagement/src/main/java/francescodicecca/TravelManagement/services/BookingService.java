package francescodicecca.TravelManagement.services;

import francescodicecca.TravelManagement.entities.*;
import francescodicecca.TravelManagement.repositories.*;
import francescodicecca.TravelManagement.payloads.NewBookingPayload;
import francescodicecca.TravelManagement.exceptions.*;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import java.util.UUID;
import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private TripRepository tripRepository;

    public Booking saveBooking(NewBookingPayload payload, UUID employeeId, UUID tripId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new NotFoundException(employeeId));
        Trip trip = tripRepository.findById(tripId).orElseThrow(() -> new NotFoundException(tripId));

        List<Booking> existing = bookingRepository
                .findByEmployeeIdAndRequestDate(employeeId, payload.getRequestDate());

        if (!existing.isEmpty()) {
            log.warn("Prenotazione già esistente per il dipendente ID {} alla data {}", payload.getEmployeeId(), payload.getRequestDate());
            throw new BadRequestException("Esiste già una prenotazione per questo dipendente in questa data.");
        }

        Booking booking = new Booking();
        booking.setEmployee(employee);
        booking.setTrip(trip);
        booking.setRequestDate(payload.getRequestDate());
        booking.setNotes(payload.getNotes());

        log.info("Prenotazione creata con successo con ID: {}", booking.getId());
        return booking;
    }
}