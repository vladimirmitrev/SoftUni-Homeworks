package com.softuni.pathfinder.model.binding;

import com.softuni.pathfinder.model.entity.CategoryEntity;
import com.softuni.pathfinder.model.entity.enums.CategoryNameEnum;
import com.softuni.pathfinder.model.entity.enums.LevelEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

public class RouteAddBindingModel {

    @NotEmpty
    @Size(min = 3, max = 20, message = "Route name must be between 3 and 20 characters")
    private String name;
    @Size(min = 5)
    private String description;
    private MultipartFile gpxCoordinates;
    @NotNull
    private LevelEnum level;
    private String videoUrl;

    private Set<CategoryNameEnum> categories;

    public RouteAddBindingModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getGpxCoordinates() {
        return gpxCoordinates;
    }

    public void setGpxCoordinates(MultipartFile gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public void setLevel(LevelEnum level) {
        this.level = level;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Set<CategoryNameEnum> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryNameEnum> categories) {
        this.categories = categories;
    }
}
