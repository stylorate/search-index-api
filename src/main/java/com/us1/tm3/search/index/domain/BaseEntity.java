package com.us1.tm3.search.index.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Setter
@Getter
@MappedSuperclass
public class BaseEntity {
    protected boolean visible = true;
    protected boolean enable = true;
    protected ZonedDateTime createdDate;
    protected ZonedDateTime disabledDate;

    @PrePersist
    @PreUpdate
    public void beforePersist() {
        if (createdDate == null)
            setCreatedDate(ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("America/Chicago")));

        if (enable == false && disabledDate == null)
            setDisabledDate(ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("America/Chicago")));
    }
}
