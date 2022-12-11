import request from '@/utils/request'

// 查询供应者管理列表
export function listProvider(query) {
  return request({
    url: '/database/provider/list',
    method: 'get',
    params: query
  })
}

// 查询供应者管理详细
export function getProvider(providerId) {
  return request({
    url: '/database/provider/' + providerId,
    method: 'get'
  })
}

// 新增供应者管理
export function addProvider(data) {
  return request({
    url: '/database/provider',
    method: 'post',
    data: data
  })
}

// 修改供应者管理
export function updateProvider(data) {
  return request({
    url: '/database/provider',
    method: 'put',
    data: data
  })
}

// 删除供应者管理
export function delProvider(providerId) {
  return request({
    url: '/database/provider/' + providerId,
    method: 'delete'
  })
}
