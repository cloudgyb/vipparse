import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/components/Index'
import VideoPlay from '@/components/video/VideoPlay'
import VideoSoResult from '@/components/video/VideoSoResult'
import CommonPlay from '@/components/video/CommonPlay'

Vue.use(Router)

export default new Router({
  routes: [{
    path: '/',
    name: 'Index',
    component: Index
  }, {
    path: '/video/play/:id',
    name: "VideoPlay",
    component: VideoPlay
  },{
    path:'/video/so/:id',
    name:'VideoSoResult',
    component:VideoSoResult
  },{
    path:'/video/commonplay',
    name:'CommonPlay',
    component:CommonPlay
  }]
})
