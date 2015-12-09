
package httpclient.vo;

import lombok.Data;

import org.codehaus.jackson.annotate.JsonProperty;

@Data
public class Row {

    @JsonProperty("APPLC_DT")
    private String APPLCDT;
    @JsonProperty("FA_ON")
    private String FAON;
    @JsonProperty("POLLUTANT")
    private String POLLUTANT;
    @JsonProperty("CAISTEP")
    private String CAISTEP;
    @JsonProperty("ALARM_CNDT")
    private String ALARMCNDT;
    @JsonProperty("ALERTSTEP")
    private String ALERTSTEP;
    @JsonProperty("CNDT1")
    private String CNDT1;
}
