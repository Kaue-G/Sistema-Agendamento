package br.pedro.demofc.dtos;

import java.util.ArrayList;
import java.util.List;

public class OfficeDTO {

    private Integer id;
    private String name;

    private final List<DayDTO> days = new ArrayList<>();

    private int totalChairs;
    private int totalRooms;

    public OfficeDTO() {
    }

    public OfficeDTO(Integer id, String name, List<DayDTO> days, int totalChairs, int totalRooms){
        this.id = id;
        this.name = name;
        this.days.addAll(days);
        this.totalChairs = totalChairs;
        this.totalRooms = totalRooms;
    }

    public int getTotalChairs() {
        return totalChairs;
    }

    public void setTotalChairs(int totalChairs) {
        this.totalChairs = totalChairs;
    }

    public int getTotalRooms() {
        return totalRooms;
    }

    public void setTotalRooms(int totalRooms) {
        this.totalRooms = totalRooms;
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

    public List<DayDTO> getDays() {
        return days;
    }
}
