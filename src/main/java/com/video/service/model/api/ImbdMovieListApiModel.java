package com.video.service.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.video.service.model.ImbdMovieListModel;
import com.video.service.model.ImbdMovieModel;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ImbdMovieListApiModel {

    @JsonProperty("results")
    private List<ImbdMovieApiModel> results;

    @JsonProperty("total_results")
    private int numberOfResults;

    @JsonProperty("total_pages")
    private int numberOfPages;

    public ImbdMovieListModel createImbdMovieListModel() {
        List<ImbdMovieModel> imbdMovieModelList = results
                .stream()
                .map(ImbdMovieApiModel::createImbdMovieModel)
                .collect(Collectors.toList());

        ImbdMovieListModel.Builder builder = new ImbdMovieListModel.Builder();
        builder.withResults(imbdMovieModelList);
        builder.withNumberOfResults(numberOfResults);
        builder.withNumberOfPages(numberOfPages);
        return builder.build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImbdMovieListApiModel that = (ImbdMovieListApiModel) o;
        return numberOfResults == that.numberOfResults &&
                Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results, numberOfResults);
    }
}
