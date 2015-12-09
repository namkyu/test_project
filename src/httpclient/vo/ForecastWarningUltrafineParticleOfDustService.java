
package httpclient.vo;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import org.codehaus.jackson.annotate.JsonProperty;

@Data
public class ForecastWarningUltrafineParticleOfDustService {

    @JsonProperty("list_total_count")
    private Integer listTotalCount;
    @JsonProperty("RESULT")
    private Result result;
    @JsonProperty("row")
    private List<Row> row = new ArrayList<Row>();


}
