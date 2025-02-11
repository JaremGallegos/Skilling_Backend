package com.cibertec.skilling.backend.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class DiaConverter implements AttributeConverter<Dia, String>{

    @Override
    public String convertToDatabaseColumn(Dia attribute) {
        return attribute != null ? attribute.getDbValue() : null;
    }

    @Override
    public Dia convertToEntityAttribute(String dbData) {
        return dbData != null ? Dia.fromDbValue(dbData) : null;
    }

}
