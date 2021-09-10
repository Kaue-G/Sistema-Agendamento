package br.pedro.demofc.controllers;

import br.pedro.demofc.dtos.*;
import br.pedro.demofc.entities.Type;
import br.pedro.demofc.services.FullService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
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
    @ApiOperation(value = "Retorna uma página de locais para trabalho", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna página de locais para trabalho"),
            @ApiResponse(code = 400, message = "Data inválida"),
    })
    public ResponseEntity<Page<ChairDTO>> findChairsPaged(
            Pageable pageable,
            @PathVariable Integer id,
            @RequestParam(value = "date") String date,
            @RequestParam(value = "begin",defaultValue = "${begin.service}") Integer begin,
            @RequestParam(value = "end", defaultValue = "${end.service}") Integer end
            ) throws DateTimeParseException {

        Page<ChairDTO> dtos = service.findChairsPaged(pageable,id,LocalDate.parse(date),begin,end);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping(value = "/bookings")
    public ResponseEntity<List<BookingDTO>> findBookings(@RequestParam(value = "email") String email){
        List<BookingDTO> dtos = service.findAllBookings(email);
        return ResponseEntity.ok(dtos);

    }

    @GetMapping
    public ResponseEntity<List<OfficeDTO>> findOffices(){
        List<OfficeDTO> offices = service.findOffices();
        return ResponseEntity.ok(offices);
    }

    @GetMapping(value = "/{id}/disps")
    @ApiOperation(value = "Retorna uma página de horários com a quantidade de pessoas naquele momento", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna página de horários"),
            @ApiResponse(code = 400, message = "Data inválida"),
    })
    public ResponseEntity<Page<DisponibilityDTO>> findAllDispsPaged (
            Pageable pageable, @PathVariable Integer id,
            @RequestParam(value = "date") String date,
            @RequestParam(value = "onlyTrue",defaultValue = "false") Boolean onlyTrue) throws DateTimeParseException {

        Page<DisponibilityDTO> dtos = service.findDisponibilities(pageable,id,LocalDate.parse(date),onlyTrue);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Retorna o estado do escritório em uma determinada data", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna informações do estado do escritório"),
            @ApiResponse(code = 400, message = "Formato inválido para data"),
    })
    public ResponseEntity<OfficeStateDTO> findOfficeByState(@PathVariable Integer id, @RequestParam(value = "date") String date){
        OfficeStateDTO dtos = service.findOfficeStateByDate(id,LocalDate.parse(date));
        return ResponseEntity.ok(dtos);
    }


    @PostMapping(value = "/{id}/bookings")
    @ApiOperation(value = "Insere um novo agendamento no escritório", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Agendamento cadastrado no sistema"),
            @ApiResponse(code = 404, message = "Data não consta no sistema"),
            @ApiResponse(code = 400, message = "Formato inválido de data"),
            @ApiResponse(code = 422, message = "Falha no cadastro devido a critérios de validação")
    })
    public ResponseEntity<BookingDTO> insert(@Valid @RequestBody BookingDTO body, @PathVariable Integer id){
        body = service.insertSingleBooking(body,id);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(body.getId()).toUri();
        return ResponseEntity.created(uri).body(body);
    }

    @DeleteMapping(value = "/bookings/{id}")
    @ApiOperation(value = "Remove o agendamento dado o ID", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Reserva removida"),
            @ApiResponse(code = 404, message = "ID da reserva não encontrado"),
    })
    public ResponseEntity<Void> remove (@PathVariable Integer id){
        service.delete(id);
        return  ResponseEntity.noContent().build();
    }
}
