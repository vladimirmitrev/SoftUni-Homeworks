package com.example.spotifyplaylistapp.model.dto.song;

import com.example.spotifyplaylistapp.model.entity.enums.StyleNameEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class SongAddBindingModel {

    @Size(min = 3, max = 20,message = "Performer name length must be between 3 and 20 characters!")
    private String performer;

    @Size(min = 2, max = 20,message = "Title length must be between 3 and 20 characters!")
    private String title;

    @Positive
    @NotNull
    private int duration;

    @PastOrPresent(message = "The Date cannot be in future!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    @NotNull(message = "You must select a style!")
    private StyleNameEnum style;

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public StyleNameEnum getStyle() {
        return style;
    }

    public void setStyle(StyleNameEnum style) {
        this.style = style;
    }
}
