package com.video.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ImbdMovieModel {

    @JsonProperty("title")
    private String title;

    @JsonProperty("releaseDate")
    private String releaseDate;

    public ImbdMovieModel(String title, String releaseDate) {
        this.title = title;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public static class Builder {
        private String title;
        private String releaseDate;

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public ImbdMovieModel build() {
            return new ImbdMovieModel(title, releaseDate);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImbdMovieModel that = (ImbdMovieModel) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(releaseDate, that.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, releaseDate);
    }
}
