import request from '@/utils/request'

// 查询仓库管理员管理列表
export function listManager(query) {
  return request({
    url: '/database/manager/list',
    method: 'get',
    params: query
  })
}

// 查询仓库管理员管理详细
export function getManager(depotManagerId) {
  return request({
    url: '/database/manager/' + depotManagerId,
    method: 'get'
  })
}

// 新增仓库管理员管理
export function addManager(data) {
  return request({
    url: '/database/manager',
    method: 'post',
    data: data
  })
}

// 修改仓库管理员管理
export function updateManager(data) {
  return request({
    url: '/database/manager',
    method: 'put',
    data: data
  })
}

// 删除仓库管理员管理
export function delManager(depotManagerId) {
  return request({
    url: '/database/manager/' + depotManagerId,
    method: 'delete'
  })
}
