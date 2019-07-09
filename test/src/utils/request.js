import axios from 'axios'
import { Message, MessageBox } from 'element-ui'

// 创建axios实例
// https://www.kancloud.cn/yunye/axios/234845
const service = axios.create({
  baseURL: process.env.BASE_API, // api的base_url
  timeout: 5000, // 请求超时时间
  // 所有请求都以Json形式传送
  // 会有预检请求，服务端需要正常通过OPTIONS请求
  // http://www.ruanyifeng.com/blog/2016/04/cors
  headers: {
    'Content-type': 'application/json;charset=UTF-8'
  }
})

// request拦截器
service.interceptors.request.use(config => {
  // if (store.getters.token) {
  //   // 让每个请求携带自定义token 请根据实际情况自行修改
  //   config.headers['Authorization'] = getToken()
  // }
  return config
}, error => {
  // Do something with request error
  console.log(error) // for debug
  Promise.reject(error)
})

// response拦截器
service.interceptors.response.use(
  response => {
    if (response.data.code === 200) {
      // Message({
      //   message: response.data.message,
      //   type: 'success',
      //   duration: 1 * 1000
      // })

      console.log(response.data.data)
      return response.data.data
      
    } else {
      Message({
        message: response.data.message,
        type: 'error',
        duration: 5 * 1000
      })
      return Promise.reject('error')
    }
  },
  error => {
    // 201:错误
    if (error.response.code === 201) {
      console.log("5666666666");
    } else {
      Message({
        message: error.response.data.msg,
        type: 'error',
        duration: 5 * 1000
      })
    }
    return Promise.reject(error)
  }
)

export default service
