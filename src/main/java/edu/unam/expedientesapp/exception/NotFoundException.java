package edu.unam.expedientesapp.exception;

import edu.unam.expedientesapp.utils.ErrorType;
import lombok.Data;

@Data
public class NotFoundException extends RuntimeException {
    public final ErrorType type;
    private String additionalInfo;

    public NotFoundException(ErrorType errorDefinition) {
        this.type = errorDefinition;
    }

    public NotFoundException(ErrorType errorDefinition, String additionalInfo) {
        this.type = errorDefinition;
        this.additionalInfo = additionalInfo;
    }
}
