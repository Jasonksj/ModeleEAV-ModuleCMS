package com.SamyBodio.AEVCms.model.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public  class Jsonconverter implements AttributeConverter<TString,String> {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(TString tString){
        try {
            return objectMapper.writeValueAsString(tString);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public TString convertToEntityAttribute(String jsonString){
        try{
            return objectMapper.readValue(jsonString, TString.class);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
