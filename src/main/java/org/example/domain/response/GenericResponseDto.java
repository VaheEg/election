package org.example.domain.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.error.Error;

@Data
@NoArgsConstructor
public class GenericResponseDto<T> {

    private T content;

    private Error error;

    public GenericResponseDto(T content) {
        this.content = content;
    }

    public GenericResponseDto(Error error) {
        this.error = error;
    }
}
