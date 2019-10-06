package com.video.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.Objects;

public class ImbdMovieModel {

    @JsonProperty("title")
    private String title;

    @JsonProperty("overview")
    private String overview;

    @JsonProperty("id")
    private String id;

    @JsonProperty("posterPath")
    private String posterPath;

    @JsonProperty("releaseDate")
    private LocalDate releaseDate;

    public ImbdMovieModel(String title, String overview, String id, String posterPath, LocalDate releaseDate) {
        this.title = title;
        this.overview = overview;
        this.id = id;
        this.posterPath = posterPath;
        this.releaseDate = releaseDate;
    }

    public static class Builder {
        private String title;
        private String overview;
        private String id;
        private String posterPath;
        private LocalDate releaseDate;

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withOverview(String overview) {
            this.overview = overview;
            return this;
        }

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withPosterPath(String posterPath) {
            this.posterPath = posterPath;
            return this;
        }

        public Builder withReleaseDate(LocalDate releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public ImbdMovieModel build() {
            return new ImbdMovieModel(title, overview, id, posterPath, releaseDate);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImbdMovieModel that = (ImbdMovieModel) o;
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
