package br.com.futurodev.ReciclaVille_API.model.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private int  status;
    private String message;
}
