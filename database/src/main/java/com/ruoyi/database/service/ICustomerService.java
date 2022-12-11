package com.ruoyi.database.service;

import java.util.List;
import com.ruoyi.database.domain.Customer;

/**
 * 顾客管理Service接口
 * 
 * @author tinaliasd
 * @date 2022-12-11
 */
public interface ICustomerService 
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
     * 批量删除顾客管理
     * 
     * @param customerIds 需要删除的顾客管理主键集合
     * @return 结果
     */
    public int deleteCustomerByCustomerIds(Long[] customerIds);

    /**
     * 删除顾客管理信息
     * 
     * @param customerId 顾客管理主键
     * @return 结果
     */
    public int deleteCustomerByCustomerId(Long customerId);
}
