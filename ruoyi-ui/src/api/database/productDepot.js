import request from '@/utils/request'

// 查询仓库物品数量管理列表
export function listProductDepot(query) {
  return request({
    url: '/database/productDepot/list',
    method: 'get',
    params: query
  })
}

// 查询仓库物品数量管理详细
export function getProductDepot(productDepotId) {
  return request({
    url: '/database/productDepot/' + productDepotId,
    method: 'get'
  })
}

// 新增仓库物品数量管理
export function addProductDepot(data) {
  return request({
    url: '/database/productDepot',
    method: 'post',
    data: data
  })
}

// 修改仓库物品数量管理
export function updateProductDepot(data) {
  return request({
    url: '/database/productDepot',
    method: 'put',
    data: data
  })
}

// 删除仓库物品数量管理
export function delProductDepot(productDepotId) {
  return request({
    url: '/database/productDepot/' + productDepotId,
    method: 'delete'
  })
}
