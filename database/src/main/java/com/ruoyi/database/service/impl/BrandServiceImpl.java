package com.ruoyi.database.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.database.util.SnowFlakeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.database.domain.Product;
import com.ruoyi.database.mapper.BrandMapper;
import com.ruoyi.database.domain.Brand;
import com.ruoyi.database.service.IBrandService;

/**
 * 品牌管理Service业务层处理
 * 
 * @author Tinaliasd
 * @date 2022-12-05
 */
@Service
public class BrandServiceImpl implements IBrandService 
{
    @Autowired
    private BrandMapper brandMapper;
    @Autowired
    private SnowFlakeUtil snowFlakeUtil;
    /**
     * 查询品牌管理
     * 
     * @param brandId 品牌管理主键
     * @return 品牌管理
     */
    @Override
    public Brand selectBrandByBrandId(Long brandId)
    {
        return brandMapper.selectBrandByBrandId(brandId);
    }

    /**
     * 查询品牌管理列表
     * 
     * @param brand 品牌管理
     * @return 品牌管理
     */
    @Override
    public List<Brand> selectBrandList(Brand brand)
    {
        return brandMapper.selectBrandList(brand);
    }

    /**
     * 新增品牌管理
     * 
     * @param brand 品牌管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertBrand(Brand brand)
    {
        brand.setBrandId(snowFlakeUtil.nextId());

        brand.setCreateTime(DateUtils.getNowDate());
        int rows = brandMapper.insertBrand(brand);
        insertProduct(brand);
        return rows;
    }

    /**
     * 修改品牌管理
     * 
     * @param brand 品牌管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateBrand(Brand brand)
    {
        brand.setUpdateTime(DateUtils.getNowDate());
        brandMapper.deleteProductByBrandId(brand.getBrandId());
        insertProduct(brand);
        return brandMapper.updateBrand(brand);
    }

    /**
     * 批量删除品牌管理
     * 
     * @param brandIds 需要删除的品牌管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteBrandByBrandIds(Long[] brandIds)
    {
        brandMapper.deleteProductByBrandIds(brandIds);
        return brandMapper.deleteBrandByBrandIds(brandIds);
    }

    /**
     * 删除品牌管理信息
     * 
     * @param brandId 品牌管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteBrandByBrandId(Long brandId)
    {
        brandMapper.deleteProductByBrandId(brandId);
        return brandMapper.deleteBrandByBrandId(brandId);
    }

    /**
     * 新增物品信息管理信息
     * 
     * @param brand 品牌管理对象
     */
    public void insertProduct(Brand brand)
    {
        List<Product> productList = brand.getProductList();

        Long brandId = brand.getBrandId();
        if (StringUtils.isNotNull(productList))
        {
            List<Product> list = new ArrayList<Product>();
            for (Product product : productList)
            {
                product.setProductId(snowFlakeUtil.nextId());
                product.setBrandId(brandId);
                list.add(product);
            }
            if (list.size() > 0)
            {
                brandMapper.batchProduct(list);
            }
        }
    }
}
