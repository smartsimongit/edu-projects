package org.smart.simon.edu.app.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PersonShortResponse {
    private Integer id;
    private String fullName;
}
