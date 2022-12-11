import request from '@/utils/request'

// 查询出售订单列表
export function listSaleOrder(query) {
  return request({
    url: '/database/saleOrder/list',
    method: 'get',
    params: query
  })
}

// 查询出售订单详细
export function getSaleOrder(saleOrderId) {
  return request({
    url: '/database/saleOrder/' + saleOrderId,
    method: 'get'
  })
}

// 新增出售订单
export function addSaleOrder(data) {
  return request({
    url: '/database/saleOrder',
    method: 'post',
    data: data
  })
}

// 修改出售订单
export function updateSaleOrder(data) {
  return request({
    url: '/database/saleOrder',
    method: 'put',
    data: data
  })
}

// 删除出售订单
export function delSaleOrder(saleOrderId) {
  return request({
    url: '/database/saleOrder/' + saleOrderId,
    method: 'delete'
  })
}
