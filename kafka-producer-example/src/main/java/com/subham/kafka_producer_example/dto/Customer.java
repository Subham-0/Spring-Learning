package com.subham.kafka_producer_example.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Customer {
    private int id;
    private String name;
    private String email;
    private String contactNo;
}
