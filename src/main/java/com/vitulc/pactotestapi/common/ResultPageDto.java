package com.vitulc.pactotestapi.common;

import java.io.Serializable;
import java.util.List;

public class ResultPageDto<S, T> implements Serializable {
    private long totalResults;
    private int totalPages;
    private int currentPage;
    private List<T> result;

    public ResultPageDto() {}

    public static <T, D> ResultPageDto<T, D> of(long totalResults, int totalPages, int currentPage, List<D> result) {
        ResultPageDto<T, D> dto = new ResultPageDto<>();
        dto.setTotalResults(totalResults);
        dto.setTotalPages(totalPages);
        dto.setCurrentPage(currentPage);
        dto.setResult(result);
        return dto;
    }

    public long getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(long totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }
}
