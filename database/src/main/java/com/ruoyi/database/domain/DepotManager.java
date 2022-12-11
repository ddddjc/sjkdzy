package com.ruoyi.database.domain;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 仓库管理员管理对象 depot_manager
 * 
 * @author tinaliasd
 * @date 2022-12-05
 */
public class DepotManager extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 仓库管理人id */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long depotManagerId;

    /** 仓库管理人电话 */
    @Excel(name = "仓库管理人电话")
    private String depotManagerTelephone;

    /** 仓库管理员性别 */
    @Excel(name = "仓库管理员性别")
    private Long depotSex;

    /** 仓库管理员工资 */
    @Excel(name = "仓库管理员工资")
    private Long depotSalary;

    /** 仓库管理员年龄 */
    @Excel(name = "仓库管理员年龄")
    private Long depotAge;

    /** 仓库管理员描述 */
    @Excel(name = "仓库管理员描述")
    private String depotDescription;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 仓库管理信息 */
    private List<Depot> depotList;

    public void setDepotManagerId(Long depotManagerId) 
    {
        this.depotManagerId = depotManagerId;
    }

    public Long getDepotManagerId() 
    {
        return depotManagerId;
    }
    public void setDepotManagerTelephone(String depotManagerTelephone) 
    {
        this.depotManagerTelephone = depotManagerTelephone;
    }

    public String getDepotManagerTelephone() 
    {
        return depotManagerTelephone;
    }
    public void setDepotSex(Long depotSex) 
    {
        this.depotSex = depotSex;
    }

    public Long getDepotSex() 
    {
        return depotSex;
    }
    public void setDepotSalary(Long depotSalary) 
    {
        this.depotSalary = depotSalary;
    }

    public Long getDepotSalary() 
    {
        return depotSalary;
    }
    public void setDepotAge(Long depotAge) 
    {
        this.depotAge = depotAge;
    }

    public Long getDepotAge() 
    {
        return depotAge;
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

    public List<Depot> getDepotList()
    {
        return depotList;
    }

    public void setDepotList(List<Depot> depotList)
    {
        this.depotList = depotList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("depotManagerId", getDepotManagerId())
            .append("depotManagerTelephone", getDepotManagerTelephone())
            .append("depotSex", getDepotSex())
            .append("depotSalary", getDepotSalary())
            .append("depotAge", getDepotAge())
            .append("depotDescription", getDepotDescription())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("depotList", getDepotList())
            .toString();
    }
}
