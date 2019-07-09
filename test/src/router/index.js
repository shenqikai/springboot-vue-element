import Vue from 'vue'
import Router from 'vue-router'
Vue.use(Router)


// export const constantRouterMap = [
//   { path: '/register', components: _important('components/register'), hidden: true },
//   { path: '/userInfo', components: _important('components/userInfo'), hidden: true }

// ]


// export default new Router({
//   // mode: 'history', //后端支持可开
//   scrollBehavior: () => ({ y: 0 }),
//   routes: constantRouterMap
// })

// export const asyncRouterMap = [
//   {
//     path
//   }
// ]
export default new Router({
  routes: [
    {
      path: '/',
      component: () => import('@/view/userInfo'),
      hidden: true
    },
    {
      path:'/userInfo',
      component: () => import('@/components/a')
    },
    // {
    //   path:'/userInfo',
    //   component: () => import('@/components/userInfo')
    // }
  ]
})
