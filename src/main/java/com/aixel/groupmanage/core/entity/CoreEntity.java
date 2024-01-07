package com.aixel.groupmanage.core.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@MappedSuperclass
@Setter(AccessLevel.PROTECTED)
@Getter
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class CoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "table-generator")
    @TableGenerator(name = "table-generator",
            table = "SequenceGenerator",
            pkColumnName = "SequenceId",
            valueColumnName = "SequenceValue")
    private Long id;

    @Version
    private Instant version;

    @Embedded
    private Audit audit;

    public CoreEntity() {
        this.id = null;
        this.version = null;
        this.audit = new Audit();
    }

    @Override
    public String toString() {
        return "CoreEntity{" +
                "id=" + id +
                ", version=" + version +
                ", audit=" + audit +
                '}';
    }
}
