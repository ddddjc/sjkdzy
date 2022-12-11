package com.ruoyi.database.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 顾客管理对象 customer
 * 
 * @author tinaliasd
 * @date 2022-12-05
 */
public class Customer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 顾客id */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long customerId;

    /** 顾客姓名 */
    @Excel(name = "顾客姓名")
    private String customerName;

    /** 顾客电话 */
    @Excel(name = "顾客电话")
    private String customerTelephone;

    /** 顾客城市 */
    @Excel(name = "顾客城市")
    private String customerCity;

    /** 顾客描述 */
    @Excel(name = "顾客描述")
    private String customerDescription;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    public void setCustomerId(Long customerId) 
    {
        this.customerId = customerId;
    }

    public Long getCustomerId() 
    {
        return customerId;
    }
    public void setCustomerName(String customerName) 
    {
        this.customerName = customerName;
    }

    public String getCustomerName() 
    {
        return customerName;
    }
    public void setCustomerTelephone(String customerTelephone) 
    {
        this.customerTelephone = customerTelephone;
    }

    public String getCustomerTelephone() 
    {
        return customerTelephone;
    }
    public void setCustomerCity(String customerCity) 
    {
        this.customerCity = customerCity;
    }

    public String getCustomerCity() 
    {
        return customerCity;
    }
    public void setCustomerDescription(String customerDescription) 
    {
        this.customerDescription = customerDescription;
    }

    public String getCustomerDescription() 
    {
        return customerDescription;
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
            .append("customerId", getCustomerId())
            .append("customerName", getCustomerName())
            .append("customerTelephone", getCustomerTelephone())
            .append("customerCity", getCustomerCity())
            .append("customerDescription", getCustomerDescription())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
