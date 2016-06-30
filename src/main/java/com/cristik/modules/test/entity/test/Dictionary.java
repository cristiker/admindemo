package com.cristik.modules.test.entity.test;

import javax.persistence.*;
import java.io.Serializable;

@Table(name="dictionary")
public class Dictionary implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String tableName;
    @Column
    private String columnName;
    @Column
    private String keyStr;
    @Column
    private String valueStr;

    public Dictionary(Integer id, String tableName, String columnName, String keyStr, String valueStr) {
        this.id = id;
        this.tableName = tableName;
        this.columnName = columnName;
        this.keyStr = keyStr;
        this.valueStr = valueStr;
    }

    public Dictionary() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String table) {
        this.tableName = table;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String column) {
        this.columnName = column;
    }

    public String getKeyStr() {
        return keyStr;
    }

    public void setKeyStr(String keyStr) {
        this.keyStr = keyStr;
    }

    public String getValueStr() {
        return valueStr;
    }

    public void setValueStr(String valueStr) {
        this.valueStr = valueStr;
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "id=" + id +
                ", table='" + tableName + '\'' +
                ", column='" + columnName + '\'' +
                ", key='" + keyStr + '\'' +
                ", value='" + valueStr + '\'' +
                '}';
    }
}