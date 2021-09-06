package br.pedro.demofc.dtos;

public class OfficeDTO {

    private Integer officeId;
    private String name;
    private Long roomsOccupied;
    private Long chairsOccupied;
    private Integer totalRooms;
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
