package br.pedro.demofc.controllers;

import br.pedro.demofc.dtos.BookingDTO;
import br.pedro.demofc.dtos.ChairDTO;
import br.pedro.demofc.dtos.DisponibilityDTO;
import br.pedro.demofc.services.FullService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

@RestController
@RequestMapping("/offices")
public class FullController {

    private final FullService service;

    @Autowired
    FullController(FullService service){
        this.service = service;
    }

    @GetMapping(value = "/{id}/chairs")
    public ResponseEntity<Page<ChairDTO>> findChairsPaged(Pageable pageable, @PathVariable Integer id){
        Page<ChairDTO> dtos = service.findChairsPaged(pageable,id);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping(value = "/{id}/disps")
    public ResponseEntity<Page<DisponibilityDTO>> findAllDispsPaged (
            Pageable pageable, @PathVariable Integer id,
            @RequestParam(value = "date",defaultValue = "null") String date,
            @RequestParam(value = "onlyTrue",defaultValue = "null") String onlyTrue) throws DateTimeParseException {

        Boolean b = !onlyTrue.equals("null") ? true : null;
        LocalDate d = !date.equals("null") ? LocalDate.parse(date) : null;
        Page<DisponibilityDTO> dtos = service.findDisponibilities(pageable,id,d,b);
        return ResponseEntity.ok(dtos);
    }

    @PostMapping(value = "/{id}/bookings")
    public ResponseEntity<BookingDTO> insert(@RequestBody BookingDTO body, @PathVariable Integer id){
        body = service.insertSingleBooking(body,id);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(body.getId()).toUri();
        return ResponseEntity.created(uri).body(body);
    }

    @DeleteMapping(value = "/bookings/{id}")
    public ResponseEntity<Void> remove (@PathVariable Integer id){
        service.delete(id);
        return  ResponseEntity.noContent().build();
    }
}
