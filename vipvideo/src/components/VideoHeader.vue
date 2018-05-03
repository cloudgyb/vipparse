<template>
  <div>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <a class="navbar-brand" href="#">
          <img src="../assets/logo.png" alt="VIP电影免费看">
      </a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="#">爱奇艺VIP<span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">腾讯VIP</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          更多VIP链接
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" :href="vip.url" v-for="vip in vipLinkList">{{vip.name}}</a>
            </div>
          </li>
        </ul>
        <div class="form-inline">
          <input style="border-color:#a96315" class="form-control mr-sm-2" type="search" placeholder="更多电影" aria-label="Search" v-model="keyword">
          <button style="border-color:#a96315;color:#d39e00" class="btn btn-outline-success my-2 my-sm-0" @click="so">搜索</button>
        </div>
        <ul class="navbar-nav">
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
               赞助我
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item zanzhu" href="#">
                <img src="../assets/sponsor/alipay.jpg" style="width:145px;height: 145px;" />
              </a>
              <div class="dropdown-divider"></div>
              <a class="dropdown-item zanzhu" href="#">
                <img src="../assets/sponsor/weixinpay.png" style="width:145px;height: 145px;" />
              </a>
            </div>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">帮助中心</a>
          </li>
        </ul>
      </div>
    </nav>
  </div>
</template>
<script>
export default {
  name: 'VideoHeader',
  data() {
    return {
      keyword:'',
      vipLinkList: [{
        url: 'http://vip.youku.com/',
        name: '优酷VIP'
      }, {
        url: 'https://film.sohu.com/vip.html',
        name: '搜狐视频VIP'
      }, {
        url: 'http://vip.le.com/',
        name: '乐视VIP'
      }, {
        url: 'http://vip.pptv.com/',
        name: 'PPTV聚力VIP'
      }, {
        url: 'http://vip.baofeng.com/',
        name: '暴风影音VIP'
      }, {
        url: 'http://movie.ku6.com/',
        name: '酷6网VIP'
      }, {
        url: 'http://new.tudou.com/',
        name: '土豆'
      }, {
        url: 'http://video.sina.com.cn/',
        name: '新浪视频'
      }, {
        url: 'http://www.56.com/movie',
        name: '我乐网'
      }, {
        url: 'https://www.bilibili.com/index.html',
        name: '哔哩哔哩'
      }]
    }
  },
  methods:{
    so(){
      if(this.keyword==='')
        return ;
      this.$router.push({path:'/video/so/'+this.keyword});
      window.location.reload();
    }
  }
}

</script>
<style scoped>
.navbar-brand {
  padding: 0px 15px;
  display: inline-block;
  line-height: 40px;
}

.navbar-brand>img {
  padding: 0px 0px 5px;
  height: 40px;
}
.zanzhu{
  padding: 2px;
}
.bg-dark{
  background-color: #121519 !important;
}
</style>
