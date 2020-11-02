package com.warkoczewski.AgroAdventureBooking.model.presentation;

import org.springframework.data.domain.Sort;

public class FarmPage {
    private int pageNumber;
    private int pageSize;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

}
