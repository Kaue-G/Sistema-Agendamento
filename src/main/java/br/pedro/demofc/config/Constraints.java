package br.pedro.demofc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Constraints {

    private int BEGIN;
    private int END;
    private float PERCENTAGE;

    @Autowired
    public void setValues(@Value("${begin.service}") String BEGIN, @Value("${end.service}") String END, @Value("${capacity.rule}") String PERCENTAGE) throws Exception {
        try {
            this.BEGIN = Integer.parseInt(BEGIN);
            this.END = Integer.parseInt(END);
            this.PERCENTAGE = Float.parseFloat(PERCENTAGE);
        } catch (NumberFormatException e) {
            throw new Exception(e.getMessage());
        }
    }

    public int getBEGIN() {
        return BEGIN;
    }

    public int getEND() {
        return END;
    }

    public float getPERCENTAGE() {
        return PERCENTAGE;
    }
}
