package softuni.exam.instagraphlite.models.dto;

import javax.validation.constraints.*;

public class PictureImportDto {


    @NotNull
    private String path;

    @Min(500)
    @Max(60000)
    @NotNull
    private double size;

    public PictureImportDto() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
