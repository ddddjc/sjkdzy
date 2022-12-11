import request from '@/utils/request'

// 查询顾客管理列表
export function listCustomer(query) {
  return request({
    url: '/database/customer/list',
    method: 'get',
    params: query
  })
}

// 查询顾客管理详细
export function getCustomer(customerId) {
  return request({
    url: '/database/customer/' + customerId,
    method: 'get'
  })
}

// 新增顾客管理
export function addCustomer(data) {
  return request({
    url: '/database/customer',
    method: 'post',
    data: data
  })
}

// 修改顾客管理
export function updateCustomer(data) {
  return request({
    url: '/database/customer',
    method: 'put',
    data: data
  })
}

// 删除顾客管理
export function delCustomer(customerId) {
  return request({
    url: '/database/customer/' + customerId,
    method: 'delete'
  })
}
