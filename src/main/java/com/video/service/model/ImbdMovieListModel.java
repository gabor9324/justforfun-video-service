package com.video.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Objects;

public class ImbdMovieListModel {

    @JsonProperty("results")
    private List<ImbdMovieModel> results;

    public ImbdMovieListModel(List<ImbdMovieModel> results) {
        this.results = results;
    }

    public List<ImbdMovieModel> getResults() {
        return results;
    }

    public static class Builder {
        private List<ImbdMovieModel> results;

        public Builder withResults(List<ImbdMovieModel> results) {
            this.results = results;
            return this;
        }

        public ImbdMovieListModel build() {
            return new ImbdMovieListModel(results);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImbdMovieListModel that = (ImbdMovieListModel) o;
        return Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }
}
