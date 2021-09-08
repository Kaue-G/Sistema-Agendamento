package br.pedro.demofc.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "OfficeState", description = "Estado do escritório")
public class OfficeStateDTO {

    @ApiModelProperty(value = "Identificador")
    private Integer officeId;

    @ApiModelProperty(value = "Salas ocupadas")
    private int roomsOccupied;

    @ApiModelProperty(value = "Cadeiras ocupadas")
    private int chairsOccupied;

    @ApiModelProperty(value = "Total de salas disponíveis")
    private int totalRooms;

    @ApiModelProperty(value = "Total de cadeiras disponíveis")
    private int totalChairs;

    public OfficeStateDTO() {
    }

    public OfficeStateDTO(Integer officeId, int roomsOccupied, int chairsOccupied, int totalRooms, int totalChairs) {
        this.officeId = officeId;
        this.roomsOccupied = roomsOccupied;
        this.chairsOccupied = chairsOccupied;
        this.totalRooms = totalRooms;
        this.totalChairs = totalChairs;
    }

    public Integer getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }

    public int getRoomsOccupied() {
        return roomsOccupied;
    }

    public void setRoomsOccupied(int roomsOccupied) {
        this.roomsOccupied = roomsOccupied;
    }

    public int getChairsOccupied() {
        return chairsOccupied;
    }

    public void setChairsOccupied(int chairsOccupied) {
        this.chairsOccupied = chairsOccupied;
    }

    public int getTotalRooms() {
        return totalRooms;
    }

    public void setTotalRooms(int totalRooms) {
        this.totalRooms = totalRooms;
    }

    public int getTotalChairs() {
        return totalChairs;
    }

    public void setTotalChairs(int totalChairs) {
        this.totalChairs = totalChairs;
    }
}
