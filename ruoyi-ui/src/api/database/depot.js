import request from '@/utils/request'

// 查询仓库管理列表
export function listDepot(query) {
  return request({
    url: '/database/depot/list',
    method: 'get',
    params: query
  })
}

// 查询仓库管理详细
export function getDepot(depotId) {
  return request({
    url: '/database/depot/' + depotId,
    method: 'get'
  })
}

// 新增仓库管理
export function addDepot(data) {
  return request({
    url: '/database/depot',
    method: 'post',
    data: data
  })
}

// 修改仓库管理
export function updateDepot(data) {
  return request({
    url: '/database/depot',
    method: 'put',
    data: data
  })
}

// 删除仓库管理
export function delDepot(depotId) {
  return request({
    url: '/database/depot/' + depotId,
    method: 'delete'
  })
}
