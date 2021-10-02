package com.us1.tm3.search.index.controller.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.UUID;

@Getter
@Setter
@ToString
public class FieldDTO {
    private UUID id;
    @NotEmpty
    @Size(max = 100)
    private String name;
    @NotEmpty
    @Size(max = 100)
    private String labelName;
    @NotEmpty
    @Size(max = 100)
    private String value;
    @NotEmpty
    @Size(max = 100)
    private String labelValue;
    @NotEmpty
    @Size(max = 100)
    private String keyId;
}
