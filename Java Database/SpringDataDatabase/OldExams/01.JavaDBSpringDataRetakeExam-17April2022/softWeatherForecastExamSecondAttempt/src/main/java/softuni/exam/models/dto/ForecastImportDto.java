package softuni.exam.models.dto;

import softuni.exam.models.entity.DayOfWeek;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalTime;

@XmlRootElement(name = "forecast")
@XmlAccessorType(XmlAccessType.FIELD)
public class ForecastImportDto {

    @XmlElement(name = "day_of_week")
    @NotNull
    private DayOfWeek dayOfWeek;
    @XmlElement(name = "max_temperature")
    @NotNull
    @Min(-20)
    @Max(60)
    private Double maxTemperature;


    @XmlElement(name = "min_temperature")
    @NotNull
    @Min(-50)
    @Max(40)
    private Double minTemperature;

    @NotNull
    private String sunrise;
    @NotNull
    private String  sunset;

    @NotNull
    private Long city;

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public Double getMinTemperature() {
        return minTemperature;
    }

    public String getSunrise() {
        return sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public Long getCity() {
        return city;
    }
}
