import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/components/Index'
import VideoPlay from '@/components/video/VideoPlay'

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
  }]
})
