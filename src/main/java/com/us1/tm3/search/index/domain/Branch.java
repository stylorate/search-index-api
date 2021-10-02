package com.us1.tm3.search.index.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
public class Branch extends BaseEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false, length = 100)
    @Type(type = "uuid-char")
    private UUID id;
    private String branchName;
    private String address;
    private String cityId;
    private String adminId;

    public void setData(Branch branch) {
        this.branchName = branch.getBranchName();
        this.address = branch.getAddress();
        this.cityId = branch.getCityId();
        this.adminId = branch.getAdminId();
    }
    //    @Column(name = "created_date")
//    private String createdDate;
//    @Column(name = "disabled_date")
//    private String disableDate;
//    @ManyToOne
//    @JoinColumn(name = "filterId")
//    private SearchFilter searchFilter;
}
