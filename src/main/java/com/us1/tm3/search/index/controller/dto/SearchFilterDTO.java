package com.us1.tm3.search.index.controller.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
public class SearchFilterDTO {
    private UUID id;
    @NotEmpty
    @Size(max = 100)
    private String name;
    @NotEmpty
    @Size(max = 100)
    private String userId;
    @NotEmpty
    @Size(max = 100)
    private String type;
    @NotEmpty
    @Size(max = 20)
    private String branchId;
    @NotEmpty
    @Size(max = 100)
    private String branchName;
    @NotEmpty
    @Size(max = 30)
    private String carrierId;
    @NotEmpty
    @Size(max = 100)
    private String carrierName;
    @NotEmpty
    private List<FieldDTO> fields;
}
