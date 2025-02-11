package com.cibertec.skilling.backend.model;

public enum Dia {
    LUNES("LUNES"), 
    MARTES("MARTES"), 
    MIERCOLES("MIÃRCOLES"), 
    JUEVES("JUEVES"), 
    VIERNES("VIERNES");

    private final String dbValue;
    
    Dia(String dbValue) {
        this.dbValue = dbValue;
    }

    public String getDbValue() {
        return dbValue;
    }

    public static Dia fromDbValue(String dbValue) {
        for (Dia dia : Dia.values()) {
            if (dia.getDbValue().equals(dbValue)) {
                return dia;
            }
        }

        throw new IllegalArgumentException("Valor de día no reconocido: " + dbValue);
    }
}
