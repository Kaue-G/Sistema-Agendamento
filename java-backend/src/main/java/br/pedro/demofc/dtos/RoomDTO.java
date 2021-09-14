package br.pedro.demofc.dtos;

import br.pedro.demofc.entities.Room;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "Room", description = "Entidade que representa uma Sala.")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoomDTO {
    private Long id;
    private boolean isAvailable;
    private Integer office_id;
    private String name;

    private int bookingAmount;

    public RoomDTO(Room room, boolean isAvailable, int bookingAmount){
        this.id = room.getId();
        this.office_id = room.getOffice().getId();
        this.isAvailable = isAvailable;
        this.name = room.getName();
        this.bookingAmount = bookingAmount;
    }

    public RoomDTO() {
    }

    public int getBookingsAmount() {
        return bookingAmount;
    }

    public void setBookingsAmount(int bookingAmount) {
        this.bookingAmount = bookingAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Integer getOffice_id() {
        return office_id;
    }

    public void setOffice_id(Integer office_id) {
        this.office_id = office_id;
    }
}
