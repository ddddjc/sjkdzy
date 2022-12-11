package com.ruoyi.database.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.database.mapper.CustomerMapper;
import com.ruoyi.database.domain.Customer;
import com.ruoyi.database.service.ICustomerService;

/**
 * 顾客管理Service业务层处理
 * 
 * @author tinaliasd
 * @date 2022-12-11
 */
@Service
public class CustomerServiceImpl implements ICustomerService 
{
    @Autowired
    private CustomerMapper customerMapper;

    /**
     * 查询顾客管理
     * 
     * @param customerId 顾客管理主键
     * @return 顾客管理
     */
    @Override
    public Customer selectCustomerByCustomerId(Long customerId)
    {
        return customerMapper.selectCustomerByCustomerId(customerId);
    }

    /**
     * 查询顾客管理列表
     * 
     * @param customer 顾客管理
     * @return 顾客管理
     */
    @Override
    public List<Customer> selectCustomerList(Customer customer)
    {
        return customerMapper.selectCustomerList(customer);
    }

    /**
     * 新增顾客管理
     * 
     * @param customer 顾客管理
     * @return 结果
     */
    @Override
    public int insertCustomer(Customer customer)
    {
        customer.setCreateTime(DateUtils.getNowDate());
        return customerMapper.insertCustomer(customer);
    }

    /**
     * 修改顾客管理
     * 
     * @param customer 顾客管理
     * @return 结果
     */
    @Override
    public int updateCustomer(Customer customer)
    {
        customer.setUpdateTime(DateUtils.getNowDate());
        return customerMapper.updateCustomer(customer);
    }

    /**
     * 批量删除顾客管理
     * 
     * @param customerIds 需要删除的顾客管理主键
     * @return 结果
     */
    @Override
    public int deleteCustomerByCustomerIds(Long[] customerIds)
    {
        return customerMapper.deleteCustomerByCustomerIds(customerIds);
    }

    /**
     * 删除顾客管理信息
     * 
     * @param customerId 顾客管理主键
     * @return 结果
     */
    @Override
    public int deleteCustomerByCustomerId(Long customerId)
    {
        return customerMapper.deleteCustomerByCustomerId(customerId);
    }
}
