package br.pedro.demofc.controllers;

import br.pedro.demofc.dtos.BookingDTO;
import br.pedro.demofc.dtos.ChairDTO;
import br.pedro.demofc.dtos.DisponibilityDTO;
import br.pedro.demofc.services.FullService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class FullController {

    private final FullService service;

    @Autowired
    FullController(FullService service){
        this.service = service;
    }

    @GetMapping(value = "/disps")
    public ResponseEntity<List<DisponibilityDTO>> findAll(){
        List<DisponibilityDTO> dtos = service.findDisponibilities();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping(value = "/chairs")
    public ResponseEntity<List<ChairDTO>> findAllChairs(){
        List<ChairDTO> dtos = service.findChairs();
        return  ResponseEntity.ok(dtos);
    }

    @PostMapping(value = "/bookings")
    public ResponseEntity<BookingDTO> insert(@RequestBody BookingDTO body){
        body = service.insert(body);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(body.getId()).toUri();
        return ResponseEntity.created(uri).body(body);
    }

    @DeleteMapping(value = "/bookings/{id}")
    public ResponseEntity<Void> remove (@PathVariable Integer id){
        service.delete(id);
        return  ResponseEntity.noContent().build();
    }
}
