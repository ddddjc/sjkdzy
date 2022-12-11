package com.ruoyi.database.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 仓库管理对象 depot
 * 
 * @author dujiachen
 * @date 2022-12-05
 */
public class Depot extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 仓库id */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long depotId;

    /** 仓库管理人 */
    @Excel(name = "仓库管理人")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long depotManagerId;

    /** 仓库位置 */
    @Excel(name = "仓库位置")
    private String depotLocal;

    /** 仓库名 */
    @Excel(name = "仓库名")
    private String depotName;

    /** 仓库大小 */
    @Excel(name = "仓库大小")
    private Long depotSize;

    /** 仓库描述 */
    @Excel(name = "仓库描述")
    private String depotDescription;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    public void setDepotId(Long depotId) 
    {
        this.depotId = depotId;
    }

    public Long getDepotId() 
    {
        return depotId;
    }
    public void setDepotManagerId(Long depotManagerId) 
    {
        this.depotManagerId = depotManagerId;
    }

    public Long getDepotManagerId() 
    {
        return depotManagerId;
    }
    public void setDepotLocal(String depotLocal) 
    {
        this.depotLocal = depotLocal;
    }

    public String getDepotLocal() 
    {
        return depotLocal;
    }
    public void setDepotName(String depotName) 
    {
        this.depotName = depotName;
    }

    public String getDepotName() 
    {
        return depotName;
    }
    public void setDepotSize(Long depotSize) 
    {
        this.depotSize = depotSize;
    }

    public Long getDepotSize() 
    {
        return depotSize;
    }
    public void setDepotDescription(String depotDescription) 
    {
        this.depotDescription = depotDescription;
    }

    public String getDepotDescription() 
    {
        return depotDescription;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("depotId", getDepotId())
            .append("depotManagerId", getDepotManagerId())
            .append("depotLocal", getDepotLocal())
            .append("depotName", getDepotName())
            .append("depotSize", getDepotSize())
            .append("depotDescription", getDepotDescription())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
