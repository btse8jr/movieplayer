package com.xander.movieplayer.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Xander on 2018-08-12.
 */
@Entity
@Table(name = "type", schema = "movieplayer", catalog = "")
public class Type {
    private long typeId;
    private String typeName;

    @Id
    @Column(name = "type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "type_name")
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type that = (Type) o;
        return typeId == that.typeId &&
                Objects.equals(typeName, that.typeName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(typeId, typeName);
    }
}
