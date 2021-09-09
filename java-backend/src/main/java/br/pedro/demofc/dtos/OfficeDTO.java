package br.pedro.demofc.dtos;

import java.util.ArrayList;
import java.util.List;

public class OfficeDTO {

    private Integer id;
    private String name;
    private String address;

    private int totalRooms;
    private int restrictedCapacity;

    private final List<DayDTO> days = new ArrayList<>();

    public OfficeDTO() {
    }

    public OfficeDTO(Integer id, String name, String address, int totalRooms, int restrictedCapacity, List<DayDTO> days) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.totalRooms = totalRooms;
        this.restrictedCapacity = restrictedCapacity;
        this.days.addAll(days);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTotalRooms() {
        return totalRooms;
    }

    public void setTotalRooms(int totalRooms) {
        this.totalRooms = totalRooms;
    }

    public int getRestrictedCapacity() {
        return restrictedCapacity;
    }

    public void setRestrictedCapacity(int restrictedCapacity) {
        this.restrictedCapacity = restrictedCapacity;
    }

    public List<DayDTO> getDays() {
        return days;
    }
}
