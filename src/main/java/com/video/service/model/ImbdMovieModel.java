package com.video.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.Objects;

public class ImbdMovieModel {

    @JsonProperty("title")
    private String title;

    @JsonProperty("overview")
    private String overview;

    @JsonProperty("releaseDate")
    private LocalDate releaseDate;

    private ImbdMovieModel(String title, String overview, LocalDate releaseDate) {
        this.title = title;
        this.overview = overview;
        this.releaseDate = releaseDate;
    }

    public static class Builder {
        private String title;
        private String overview;
        private LocalDate releaseDate;

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withOverview(String overview) {
            this.overview = overview;
            return this;
        }

        public Builder withReleaseDate(LocalDate releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public ImbdMovieModel build() {
            return new ImbdMovieModel(title, overview, releaseDate);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImbdMovieModel that = (ImbdMovieModel) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(overview, that.overview) &&
                Objects.equals(releaseDate, that.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, overview, releaseDate);
    }
}
