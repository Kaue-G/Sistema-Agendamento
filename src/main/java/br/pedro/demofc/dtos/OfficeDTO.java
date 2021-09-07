package br.pedro.demofc.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Office", description = "Estado do escritório")
public class OfficeDTO {

    @ApiModelProperty(value = "Identificador")
    private Integer officeId;

    @ApiModelProperty(value = "Nome do escritório")
    private String name;

    @ApiModelProperty(value = "Salas ocupadas")
    private Long roomsOccupied;

    @ApiModelProperty(value = "Cadeiras ocupadas")
    private Long chairsOccupied;

    @ApiModelProperty(value = "Total de salas disponíveis")
    private Integer totalRooms;

    @ApiModelProperty(value = "Total de cadeiras disponíveis")
    private Integer totalChairs;

    public OfficeDTO() {
    }

    public OfficeDTO(Integer officeId, String name, Long roomsOccupied, Long chairsOccupied, Integer totalRooms, Integer totalChairs) {
        this.officeId = officeId;
        this.name = name;
        this.roomsOccupied = roomsOccupied;
        this.chairsOccupied = chairsOccupied;
        this.totalRooms = totalRooms;
        this.totalChairs = totalChairs;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }

    public Long getRoomsOccupied() {
        return roomsOccupied;
    }

    public void setRoomsOccupied(Long roomsOccupied) {
        this.roomsOccupied = roomsOccupied;
    }

    public Long getChairsOccupied() {
        return chairsOccupied;
    }

    public void setChairsOccupied(Long chairsOccupied) {
        this.chairsOccupied = chairsOccupied;
    }

    public Integer getTotalRooms() {
        return totalRooms;
    }

    public void setTotalRooms(Integer totalRooms) {
        this.totalRooms = totalRooms;
    }

    public Integer getTotalChairs() {
        return totalChairs;
    }

    public void setTotalChairs(Integer totalChairs) {
        this.totalChairs = totalChairs;
    }
}
