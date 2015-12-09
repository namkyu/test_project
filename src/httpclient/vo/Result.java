
package httpclient.vo;

import lombok.Data;

import org.codehaus.jackson.annotate.JsonProperty;

@Data
public class Result {

    @JsonProperty("CODE")
    private String CODE;
    @JsonProperty("MESSAGE")
    private String MESSAGE;
}
