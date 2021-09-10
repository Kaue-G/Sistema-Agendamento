package br.pedro.demofc.dtos;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "OfficeState", description = "Estado do escritório em uma data.")
public class OfficeStateDTO {

    private Integer officeId;

    private int restrictedCapacity;
    private int totalEmployees;

    private int totalRooms;

    public OfficeStateDTO() {
    }

    public OfficeStateDTO(Integer officeId, int restrictedCapacity, int totalEmployees, int totalRooms) {
        this.officeId = officeId;
        this.restrictedCapacity = restrictedCapacity;
        this.totalEmployees = totalEmployees;
        this.totalRooms = totalRooms;
    }

    public Integer getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }

    public int getRestrictedCapacity() {
        return restrictedCapacity;
    }

    public void setRestrictedCapacity(int restrictedCapacity) {
        this.restrictedCapacity = restrictedCapacity;
    }

    public int getTotalEmployees() {
        return totalEmployees;
    }

    public void setTotalEmployees(int totalEmployees) {
        this.totalEmployees = totalEmployees;
    }

    public int getTotalRooms() {
        return totalRooms;
    }

    public void setTotalRooms(int totalRooms) {
        this.totalRooms = totalRooms;
    }
}
