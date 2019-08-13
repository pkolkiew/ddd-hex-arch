package pl.pkolkiew.dddhexarch.user.dto;

import lombok.Builder;
import lombok.Value;

/**
 * @author pkolkiew
 * Created 8/13/2019
 */
@Builder
@Value
public class ErrorMessageDto {

    private final String code;
    private final String message;
    private final String details;
    private final String path;
    private final String userMessage;

    public static ErrorMessageDto createErrorMessage(String code, String message, String details,
                                              String path, String userMessage){
        return ErrorMessageDto.builder()
                .code(code)
                .message(message)
                .details(details)
                .path(path)
                .userMessage(userMessage)
                .build();
    }

}
