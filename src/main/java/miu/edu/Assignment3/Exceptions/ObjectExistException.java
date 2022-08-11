package miu.edu.Assignment3.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ObjectExistException extends RuntimeException {
    private String errorMessage;
}
