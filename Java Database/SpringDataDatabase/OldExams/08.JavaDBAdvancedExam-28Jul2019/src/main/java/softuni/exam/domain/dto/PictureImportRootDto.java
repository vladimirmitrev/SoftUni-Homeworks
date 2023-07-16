package softuni.exam.domain.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "pictures")
@XmlAccessorType(XmlAccessType.FIELD)
public class PictureImportRootDto {

    @XmlElement(name = "picture")
    private List<PictureImportDto> pictures;

    public List<PictureImportDto> getPictures() {
        return pictures;
    }

    public void setPictures(List<PictureImportDto> pictures) {
        this.pictures = pictures;
    }
}
