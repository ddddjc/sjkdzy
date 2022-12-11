import request from '@/utils/request'

// 查询采购订单列表
export function listPurchaseOrder(query) {
  return request({
    url: '/database/purchaseOrder/list',
    method: 'get',
    params: query
  })
}

// 查询采购订单详细
export function getPurchaseOrder(purchaseOrderId) {
  return request({
    url: '/database/purchaseOrder/' + purchaseOrderId,
    method: 'get'
  })
}

// 新增采购订单
export function addPurchaseOrder(data) {
  return request({
    url: '/database/purchaseOrder',
    method: 'post',
    data: data
  })
}

// 修改采购订单
export function updatePurchaseOrder(data) {
  return request({
    url: '/database/purchaseOrder',
    method: 'put',
    data: data
  })
}

// 删除采购订单
export function delPurchaseOrder(purchaseOrderId) {
  return request({
    url: '/database/purchaseOrder/' + purchaseOrderId,
    method: 'delete'
  })
}
