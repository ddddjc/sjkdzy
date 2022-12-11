import request from '@/utils/request'

// 查询物品信息管理列表
export function listProduct(query) {
  return request({
    url: '/database/product/list',
    method: 'get',
    params: query
  })
}

// 查询物品信息管理详细
export function getProduct(productId) {
  return request({
    url: '/database/product/' + productId,
    method: 'get'
  })
}

// 新增物品信息管理
export function addProduct(data) {
  return request({
    url: '/database/product',
    method: 'post',
    data: data
  })
}

// 修改物品信息管理
export function updateProduct(data) {
  return request({
    url: '/database/product',
    method: 'put',
    data: data
  })
}

// 删除物品信息管理
export function delProduct(productId) {
  return request({
    url: '/database/product/' + productId,
    method: 'delete'
  })
}
