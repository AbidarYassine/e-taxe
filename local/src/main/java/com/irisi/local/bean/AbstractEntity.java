package com.irisi.local.bean;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@FieldDefaults(level = AccessLevel.PROTECTED)
@Data
public class AbstractEntity implements Serializable {
    @Id @GeneratedValue
    Long id;
    @Column(unique = true)
    String ref;
    @CreatedDate
    Instant createdAt;
    @LastModifiedDate
    Instant updatedAt;

}
