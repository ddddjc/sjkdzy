package com.ruoyi.database.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 采购订单对象 purchase_order
 * 
 * @author tinaliasd
 * @date 2022-12-05
 */
public class PurchaseOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 采购订单id */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long purchaseOrderId;

    /** 产品id */
    @JsonSerialize(using = ToStringSerializer.class)
    @Excel(name = "产品id")
    private Long productId;

    /** 仓库id */
    @JsonSerialize(using = ToStringSerializer.class)
    @Excel(name = "仓库id")
    private Long depotId;

    /** 采购数量 */
    @Excel(name = "采购数量")
    private Long num;

    /** 采购商id */
    @Excel(name = "采购商id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long providerId;

    /** 采购时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "采购时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date purchaseOrderTime;

    /** 采购订单号 */
    @Excel(name = "采购订单号")
    private Long purchaseOrderNumber;

    /** 采购单描述 */
    @Excel(name = "采购单描述")
    private String purchaseOrderDescription;

    public void setPurchaseOrderId(Long purchaseOrderId) 
    {
        this.purchaseOrderId = purchaseOrderId;
    }

    public Long getPurchaseOrderId() 
    {
        return purchaseOrderId;
    }
    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }
    public void setDepotId(Long depotId) 
    {
        this.depotId = depotId;
    }

    public Long getDepotId() 
    {
        return depotId;
    }
    public void setNum(Long num) 
    {
        this.num = num;
    }

    public Long getNum() 
    {
        return num;
    }
    public void setProviderId(Long providerId) 
    {
        this.providerId = providerId;
    }

    public Long getProviderId() 
    {
        return providerId;
    }
    public void setPurchaseOrderTime(Date purchaseOrderTime) 
    {
        this.purchaseOrderTime = purchaseOrderTime;
    }

    public Date getPurchaseOrderTime() 
    {
        return purchaseOrderTime;
    }
    public void setPurchaseOrderNumber(Long purchaseOrderNumber) 
    {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public Long getPurchaseOrderNumber() 
    {
        return purchaseOrderNumber;
    }
    public void setPurchaseOrderDescription(String purchaseOrderDescription) 
    {
        this.purchaseOrderDescription = purchaseOrderDescription;
    }

    public String getPurchaseOrderDescription() 
    {
        return purchaseOrderDescription;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("purchaseOrderId", getPurchaseOrderId())
            .append("productId", getProductId())
            .append("depotId", getDepotId())
            .append("num", getNum())
            .append("providerId", getProviderId())
            .append("purchaseOrderTime", getPurchaseOrderTime())
            .append("purchaseOrderNumber", getPurchaseOrderNumber())
            .append("purchaseOrderDescription", getPurchaseOrderDescription())
            .toString();
    }
}
