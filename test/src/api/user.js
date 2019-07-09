import request from '@/utils/request'


export function list(params) {
    return request({
      url: '/user/getAllUsers',
      method: 'get',
      params
    })
  }

  export function finbByUsername(params) {
    return request({
      url: '/findByUsername',
      method: 'post',
      params
    })
  }

  export function addUser(userForm) {
    return request({
      url: '/user/register',
      method: 'post',
      data: userForm
    })
  }

  export function updateUser(userForm) {
    return request({
      url: '/user/updateUser',
      method: 'post',
      data: userForm
    })
  }
  export function remove(userId) {
    return request({
      url: '/user/' + userId,
      method: 'delete',
      
    })
  }

  export function find(params) {
    return request({
      url: '/user/findByTel' ,
      method: 'get',
      params
    })
  }
  
  