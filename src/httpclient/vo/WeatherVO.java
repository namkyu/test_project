
package httpclient.vo;

import lombok.Data;

import org.codehaus.jackson.annotate.JsonProperty;

@Data
public class WeatherVO {

	@JsonProperty("ForecastWarningUltrafineParticleOfDustService")
    private ForecastWarningUltrafineParticleOfDustService ForecastWarningUltrafineParticleOfDustService;
}
