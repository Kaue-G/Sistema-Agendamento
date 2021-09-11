package br.pedro.demofc.controllers;

import br.pedro.demofc.dtos.*;
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
    @ApiOperation(value = "Retorna uma página de salas para reunião.", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Erro durante o uso do parâmetro 'date'.")
    })
    public ResponseEntity<Page<RoomDTO>> findChairsPaged(
            Pageable pageable,
            @PathVariable Integer id,
            @RequestParam(value = "date") String date,
            @RequestParam(value = "begin",defaultValue = "${begin.service}") Integer begin,
            @RequestParam(value = "end", defaultValue = "${end.service}") Integer end
            ){

        Page<RoomDTO> dtos = service.findChairsPaged(pageable,id,date,begin,end);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping(value = "/bookings")
    @ApiOperation(value = "Retorna uma lista de agendamentos realizados por um usuário.", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Erro durante o uso do parâmetro 'email'.")
    })
    public ResponseEntity<List<BookingDTO>> findBookings(@RequestParam(value = "email") String email){
        List<BookingDTO> dtos = service.findAllBookings(email);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping
    @ApiOperation(value = "Retorna uma lista de escritórios com dados estáticos.", produces = "application/json")
    public ResponseEntity<List<OfficeDTO>> findOffices(){
        List<OfficeDTO> offices = service.findOffices();
        return ResponseEntity.ok(offices);
    }

    @GetMapping(value = "/{id}/disps")
    @ApiOperation(value = "Retorna uma página de horários com a quantidade de pessoas naquele momento.", produces = "application/json")
    public ResponseEntity<List<DisponibilityDTO>> findAllDisps (@PathVariable Integer id,
            @RequestParam(value = "date") String date,
            @RequestParam(value = "onlyTrue",defaultValue = "false") Boolean onlyTrue){

        List<DisponibilityDTO> dtos = service.findDisponibilities(id,date,onlyTrue);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Retorna o estado do escritório em uma determinada data.", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Erro durante o uso do parâmetro 'date'.")
    })
    public ResponseEntity<OfficeStateDTO> findOfficeByState(@PathVariable Integer id,
                                                            @RequestParam(value = "date") String date,
                                                            @RequestParam(value = "begin", defaultValue = "${begin.service}") Integer begin,
                                                            @RequestParam(value = "end", defaultValue = "${end.service}") Integer end){
        OfficeStateDTO dtos = service.findOfficeStateByDate(id, date, begin, end);
        return ResponseEntity.ok(dtos);
    }


    @PostMapping(value = "/{id}/bookings")
    @ApiOperation(value = "Insere um novo agendamento no escritório.", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Falha devido a incompatibilidade dos atributos do body."),
            @ApiResponse(code = 422, message = "Falha devido a critérios de validação dos dados."),
            @ApiResponse(code = 404, message = "Data inserida não consta na base de dados do escritório."),
            @ApiResponse(code = 201, message = "Agendamento realizado.", response = BookingDTO.class)
    })
    public ResponseEntity<BookingDTO> insert(@Valid @RequestBody BookingDTO body, @PathVariable Integer id){
        body = service.insertSingleBooking(body,id);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(body.getId()).toUri();
        return ResponseEntity.created(uri).body(body);
    }

    @DeleteMapping(value = "/bookings/{id}")
    @ApiOperation(value = "Remove o agendamento através do ID.", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "ID inserido não consta no banco de dados.")
    })
    public ResponseEntity<Void> remove (@PathVariable Integer id){
        service.delete(id);
        return  ResponseEntity.noContent().build();
    }
}
