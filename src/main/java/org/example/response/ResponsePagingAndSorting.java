package org.example.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponsePagingAndSorting<T> {

    String message;
    int status_code;
    List<T> body = new ArrayList<>();

    int currentPage;
    long totalItems;
    int totalPages;

}
