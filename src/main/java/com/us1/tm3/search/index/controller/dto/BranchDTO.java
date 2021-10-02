package com.us1.tm3.search.index.controller.dto;

import com.us1.tm3.search.index.domain.Branch;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.UUID;

@Getter
@Setter
@ToString
public class BranchDTO {
    private UUID id;
    @NotEmpty
    @Size(max = 100)
    private String branchName;
    @NotEmpty
    @Size(max = 100)
    private String address;
    @NotEmpty
    @Size(max = 100)
    private String cityId;
    @NotEmpty
    @Size(max = 100)
    private String adminId;

    public BranchDTO setData(Branch branch) {
        this.id = branch.getId();
        this.branchName = branch.getBranchName();
        this.address = branch.getAddress();
        this.cityId = branch.getCityId();
        this.adminId = branch.getAdminId();
        return this;
    }
}
