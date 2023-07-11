package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "apartments")
@XmlAccessorType(XmlAccessType.FIELD)
public class ApartmentSeedRootDto {

    @XmlElement(name = "apartment")
    private List<ApartmentSeedDto> aparments;

    public List<ApartmentSeedDto> getAparments() {
        return aparments;
    }

    public void setAparments(List<ApartmentSeedDto> aparments) {
        this.aparments = aparments;
    }
}
