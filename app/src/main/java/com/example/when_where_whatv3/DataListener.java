package com.example.when_where_whatv3;

import java.util.List;

public interface DataListener<ApiResponse> {
    void onFetchData(List<Headlines> lst , String message);
    void onError(String message);
}
