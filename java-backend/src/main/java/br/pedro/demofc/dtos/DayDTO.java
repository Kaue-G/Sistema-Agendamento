package br.pedro.demofc.dtos;

import io.swagger.annotations.ApiModel;

import java.time.LocalDate;

@ApiModel(value = "Day", description = "Entidade que representa uma formatação para os dias disponíveis.")
public class DayDTO {

    private int day;
    private String verbose;
    private LocalDate date;

    private String dictionary(int day){
        String verbose;

        switch (day){
            case 0:
                verbose = "Segunda";
                break;
            case 1:
                verbose = "Terça";
                break;
            case 2:
                verbose = "Quarta";
                break;
            case 3:
                verbose = "Quinta";
                break;
            case 4:
                verbose = "Sexta";
                break;
            case 5:
                verbose = "Sábado";
                break;
            case 6:
                verbose = "Domingo";
                break;
            default:
                verbose = "Not a day";
                break;
        }
        return verbose;
    }

    public DayDTO() {
    }

    public DayDTO(LocalDate date){
        this.day = date.getDayOfWeek().ordinal();
        this.verbose = dictionary(day);
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getVerbose() {
        return verbose;
    }

    public void setVerbose(String verbose) {
        this.verbose = verbose;
    }
}
