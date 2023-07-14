package softuni.exam.instagraphlite.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "post")
@XmlAccessorType(XmlAccessType.FIELD)
public class PostImportDto {

    @XmlElement(name = "caption")
    @NotNull
    @Size(min = 21)
    private String caption;

    @XmlElement(name = "user")
    @NotNull
    private UserDto user;

    @XmlElement(name = "picture")
    @NotNull
    private PictureDto picture;

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public PictureDto getPicture() {
        return picture;
    }

    public void setPicture(PictureDto picture) {
        this.picture = picture;
    }
}
