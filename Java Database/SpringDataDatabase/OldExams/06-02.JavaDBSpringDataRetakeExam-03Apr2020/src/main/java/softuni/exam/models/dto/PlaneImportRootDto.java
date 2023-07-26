package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "planes")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlaneImportRootDto {

    @XmlElement(name = "plane")
    private List<PlaneImportDto> planes;

    public List<PlaneImportDto> getPlanes() {
        return planes;
    }

    public void setPlanes(List<PlaneImportDto> planes) {
        this.planes = planes;
    }
}
