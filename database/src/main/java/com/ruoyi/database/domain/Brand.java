package com.ruoyi.database.domain;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 品牌管理对象 brand
 * 
 * @author Tinaliasd
 * @date 2022-12-05
 */
public class Brand extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 品牌id */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long brandId;

    /** 品牌名 */
    @Excel(name = "品牌名")
    private String brandName;

    /** 品牌公司 */
    @Excel(name = "品牌公司")
    private String brandCompany;

    /** 品牌描述 */
    @Excel(name = "品牌描述")
    private String brandDescript;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 物品信息管理信息 */
    private List<Product> productList;

    public void setBrandId(Long brandId) 
    {
        this.brandId = brandId;
    }

    public Long getBrandId() 
    {
        return brandId;
    }
    public void setBrandName(String brandName) 
    {
        this.brandName = brandName;
    }

    public String getBrandName() 
    {
        return brandName;
    }
    public void setBrandCompany(String brandCompany) 
    {
        this.brandCompany = brandCompany;
    }

    public String getBrandCompany() 
    {
        return brandCompany;
    }
    public void setBrandDescript(String brandDescript) 
    {
        this.brandDescript = brandDescript;
    }

    public String getBrandDescript() 
    {
        return brandDescript;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public List<Product> getProductList()
    {
        return productList;
    }

    public void setProductList(List<Product> productList)
    {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("brandId", getBrandId())
            .append("brandName", getBrandName())
            .append("brandCompany", getBrandCompany())
            .append("brandDescript", getBrandDescript())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("productList", getProductList())
            .toString();
    }
}
