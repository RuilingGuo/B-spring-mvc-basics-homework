package com.thoughtworks.capacity.gtb.mvc.exception.error;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class ErrorMessage {
    private String message;
}
