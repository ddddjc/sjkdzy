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
 * 出售订单对象 sale_order
 * 
 * @author ruoyi
 * @date 2022-12-05
 */
public class SaleOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 出售订单id */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long saleOrderId;

    /** 产品id */
    @Excel(name = "产品id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long productId;

    /** 仓库id */
    @Excel(name = "仓库id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long depotId;

    /** 数量 */
    @Excel(name = "数量")
    private Long num;

    /** 订单时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "订单时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date purchaseOrderTime;

    /** 顾客id */
    @Excel(name = "顾客id")
    private Long customerId;

    /** 出售订单号 */
    @Excel(name = "出售订单号")
    private Long saleOrderNumber;

    /** 备注描述 */
    @Excel(name = "备注描述")
    private String saleOrderDescription;

    public void setSaleOrderId(Long saleOrderId) 
    {
        this.saleOrderId = saleOrderId;
    }

    public Long getSaleOrderId() 
    {
        return saleOrderId;
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
    public void setPurchaseOrderTime(Date purchaseOrderTime) 
    {
        this.purchaseOrderTime = purchaseOrderTime;
    }

    public Date getPurchaseOrderTime() 
    {
        return purchaseOrderTime;
    }
    public void setCustomerId(Long customerId) 
    {
        this.customerId = customerId;
    }

    public Long getCustomerId() 
    {
        return customerId;
    }
    public void setSaleOrderNumber(Long saleOrderNumber) 
    {
        this.saleOrderNumber = saleOrderNumber;
    }

    public Long getSaleOrderNumber() 
    {
        return saleOrderNumber;
    }
    public void setSaleOrderDescription(String saleOrderDescription) 
    {
        this.saleOrderDescription = saleOrderDescription;
    }

    public String getSaleOrderDescription() 
    {
        return saleOrderDescription;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("saleOrderId", getSaleOrderId())
            .append("productId", getProductId())
            .append("depotId", getDepotId())
            .append("num", getNum())
            .append("purchaseOrderTime", getPurchaseOrderTime())
            .append("customerId", getCustomerId())
            .append("saleOrderNumber", getSaleOrderNumber())
            .append("saleOrderDescription", getSaleOrderDescription())
            .toString();
    }
}
