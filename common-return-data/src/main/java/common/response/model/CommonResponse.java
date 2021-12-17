package common.response.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
public class CommonResponse<T> {

    private static String DATE_FORMATTER = "yyyy-MM-dd HH:mm:ss.SSS";
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);

    private int status;

    private String message;

    private T result;

    private String timestamp;

    public CommonResponse(int status, String message, T result) {
        this.status = status;
        this.message = message;
        this.result = result;
        this.timestamp = LocalDateTime.now().format(dateTimeFormatter);
    }
}
