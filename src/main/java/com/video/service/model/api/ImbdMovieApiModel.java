package com.video.service.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.video.service.model.ImbdMovieModel;

import java.time.LocalDate;
import java.util.Objects;

public class ImbdMovieApiModel {

    @JsonProperty("title")
    private String title;

    @JsonProperty("overview")
    private String overview;

    @JsonProperty("id")
    private String id;

    @JsonProperty("poster_path")
    private String posterPath;

    @JsonProperty("release_date")
    private LocalDate releaseDate;

    public ImbdMovieModel createImbdMovieModel() {
        ImbdMovieModel.Builder builder = new ImbdMovieModel.Builder();
        builder.withTitle(title);
        builder.withOverview(overview);
        builder.withId(id);
        builder.withPosterPath(posterPath);
        builder.withReleaseDate(releaseDate);
        return builder.build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImbdMovieApiModel that = (ImbdMovieApiModel) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(overview, that.overview) &&
                Objects.equals(id, that.id) &&
                Objects.equals(posterPath, that.posterPath) &&
                Objects.equals(releaseDate, that.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, overview, id, posterPath, releaseDate);
    }
}
