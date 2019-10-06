package com.video.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class ImbdMovieListModel {

    @JsonProperty("results")
    private List<ImbdMovieModel> results;

    @JsonProperty("numberOfResults")
    private int numberOfResults;

    @JsonProperty("numberOfPages")
    private int numberOfPages;

    public ImbdMovieListModel(List<ImbdMovieModel> results, int numberOfResults, int numberOfPages) {
        this.results = results;
        this.numberOfResults = numberOfResults;
        this.numberOfPages = numberOfPages;
    }

    public static class Builder {
        private List<ImbdMovieModel> results;
        private int numberOfResults;
        private int numberOfPages;

        public Builder withResults(List<ImbdMovieModel> results) {
            this.results = results;
            return this;
        }

        public Builder withNumberOfResults(int numberOfResults) {
            this.numberOfResults = numberOfResults;
            return this;
        }

        public Builder withNumberOfPages(int numberOfPages) {
            this.numberOfPages = numberOfPages;
            return this;
        }

        public ImbdMovieListModel build() {
            return new ImbdMovieListModel(results, numberOfResults, numberOfPages);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImbdMovieListModel that = (ImbdMovieListModel) o;
        return numberOfResults == that.numberOfResults &&
                numberOfPages == that.numberOfPages &&
                Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results, numberOfResults, numberOfPages);
    }
}
