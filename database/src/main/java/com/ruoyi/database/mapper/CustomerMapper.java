package com.ruoyi.database.mapper;

import java.util.List;
import com.ruoyi.database.domain.Customer;

/**
 * 顾客管理Mapper接口
 * 
 * @author tinaliasd
 * @date 2022-12-05
 */
public interface CustomerMapper 
{
    /**
     * 查询顾客管理
     * 
     * @param customerId 顾客管理主键
     * @return 顾客管理
     */
    public Customer selectCustomerByCustomerId(Long customerId);

    /**
     * 查询顾客管理列表
     * 
     * @param customer 顾客管理
     * @return 顾客管理集合
     */
    public List<Customer> selectCustomerList(Customer customer);

    /**
     * 新增顾客管理
     * 
     * @param customer 顾客管理
     * @return 结果
     */
    public int insertCustomer(Customer customer);

    /**
     * 修改顾客管理
     * 
     * @param customer 顾客管理
     * @return 结果
     */
    public int updateCustomer(Customer customer);

    /**
     * 删除顾客管理
     * 
     * @param customerId 顾客管理主键
     * @return 结果
     */
    public int deleteCustomerByCustomerId(Long customerId);

    /**
     * 批量删除顾客管理
     * 
     * @param customerIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCustomerByCustomerIds(Long[] customerIds);
}
