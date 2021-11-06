package com.pwp.netflux.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Movie {

    @MongoId
    private String id;

    @NonNull
    private String title;
}
