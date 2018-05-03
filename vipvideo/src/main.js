// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router' 
import 'bootstrap/dist/css/bootstrap.min.css' //bootstrap cs
import 'bootstrap/dist/js/bootstrap.min.js'   //bootstrap js
import './assets/font-lib/css/ionicons.min.css'  //icon
import $ from 'jquery'   //jquery
import vPage from 'v-page'
import utils from './utils/index.js'
//http://ionicons.com/
Vue.use(vPage)
Vue.config.productionTip = false
Vue.prototype.$utils = utils

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
