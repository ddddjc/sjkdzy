package com.ruoyi.database.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 仓库物品数量管理对象 product_depot
 * 
 * @author 张旭
 * @date 2022-12-05
 */
public class ProductDepot extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long productDepotId;

    /** $column.columnComment */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long productId;

    /** $column.columnComment */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long depotId;

    /** $column.columnComment */
    private Long num;

    public void setProductDepotId(Long productDepotId) 
    {
        this.productDepotId = productDepotId;
    }

    public Long getProductDepotId() 
    {
        return productDepotId;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("productDepotId", getProductDepotId())
            .append("productId", getProductId())
            .append("depotId", getDepotId())
            .append("num", getNum())
            .toString();
    }
}
