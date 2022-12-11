package com.ruoyi.database.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 供应者管理对象 provider
 * 
 * @author tinaliasd
 * @date 2022-12-05
 */
public class Provider extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 供应商id */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long providerId;

    /** 供应商姓名 */
    @Excel(name = "供应商姓名")
    private String providerName;

    /** 供应商电话 */
    @Excel(name = "供应商电话")
    private String providerTelephone;

    /** 供应商城市 */
    @Excel(name = "供应商城市")
    private String providerCity;

    /** 供应商描述 */
    @Excel(name = "供应商描述")
    private String provideDescription;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    public void setProviderId(Long providerId) 
    {
        this.providerId = providerId;
    }

    public Long getProviderId() 
    {
        return providerId;
    }
    public void setProviderName(String providerName) 
    {
        this.providerName = providerName;
    }

    public String getProviderName() 
    {
        return providerName;
    }
    public void setProviderTelephone(String providerTelephone) 
    {
        this.providerTelephone = providerTelephone;
    }

    public String getProviderTelephone() 
    {
        return providerTelephone;
    }
    public void setProviderCity(String providerCity) 
    {
        this.providerCity = providerCity;
    }

    public String getProviderCity() 
    {
        return providerCity;
    }
    public void setProvideDescription(String provideDescription) 
    {
        this.provideDescription = provideDescription;
    }

    public String getProvideDescription() 
    {
        return provideDescription;
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
            .append("providerId", getProviderId())
            .append("providerName", getProviderName())
            .append("providerTelephone", getProviderTelephone())
            .append("providerCity", getProviderCity())
            .append("provideDescription", getProvideDescription())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
