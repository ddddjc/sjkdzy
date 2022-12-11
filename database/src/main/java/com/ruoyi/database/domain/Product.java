package com.ruoyi.database.domain;

import java.math.BigDecimal;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 物品信息管理对象 product
 * 
 * @author Tinaliasd
 * @date 2022-12-05
 */
public class Product extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商品id */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long productId;

    /** 商品名 */
    @Excel(name = "商品名")
    private String productName;

    /** 商品采购价格 */
    @Excel(name = "商品采购价格")
    private BigDecimal productPurchasePrice;

    /** 商品售出价格 */
    @Excel(name = "商品售出价格")
    private BigDecimal productSalePrice;

    /** 商品描述 */
    @Excel(name = "商品描述")
    private String productDescription;

    /** 商品品牌id */
    @Excel(name = "商品品牌id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long brandId;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }
    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public String getProductName() 
    {
        return productName;
    }
    public void setProductPurchasePrice(BigDecimal productPurchasePrice) 
    {
        this.productPurchasePrice = productPurchasePrice;
    }

    public BigDecimal getProductPurchasePrice() 
    {
        return productPurchasePrice;
    }
    public void setProductSalePrice(BigDecimal productSalePrice) 
    {
        this.productSalePrice = productSalePrice;
    }

    public BigDecimal getProductSalePrice() 
    {
        return productSalePrice;
    }
    public void setProductDescription(String productDescription) 
    {
        this.productDescription = productDescription;
    }

    public String getProductDescription() 
    {
        return productDescription;
    }
    public void setBrandId(Long brandId) 
    {
        this.brandId = brandId;
    }

    public Long getBrandId() 
    {
        return brandId;
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
            .append("productId", getProductId())
            .append("productName", getProductName())
            .append("productPurchasePrice", getProductPurchasePrice())
            .append("productSalePrice", getProductSalePrice())
            .append("productDescription", getProductDescription())
            .append("brandId", getBrandId())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
