package com.talitanunes.FluxoDeCaixa.Controllers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.talitanunes.FluxoDeCaixa.Models.TypeErrorAPI;
import lombok.Data;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Data
public class ErrorDTO {

    String codError;
    String desTypeERRO;
    String message;

    public ErrorDTO(TypeErrorAPI type, String message) {
        this.codError = type.getCod();
        this.desTypeERRO = type.getDesc();
        this.message = message;
    }
}
