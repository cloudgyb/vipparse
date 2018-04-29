<template>
  <div>
    <div class="play-wrap">
      <div class="container" style="padding-top:10px">
        <div class="row bg-vdark">
          <div class="col-md-9" style="padding-left: 0px;background-color:#000">
            <!-- 16:9 aspect ratio -->
            <div class="embed-responsive embed-responsive-16by9">
              <iframe class="embed-responsive-item" scrolling="no" :src="curritfurl+videoUrl"></iframe>
            </div>
          </div>
          <div class="col-md-3 right-video-detail">
            <span class="video-title">{{video.name}}</span>
            <div class="row" style="padding-top:5px">
              <div class="col-6" style="padding-left:15px;"><img :src="video.imageUrl" style="width:100px;height:131px;"></div>
              <div class="col-6">
                <span class="video-title-v ion-social-vimeo"> {{video.name}}</span>
                <br>
                <span class="play-count ion-social-youtube" v-text="goodPlayCount(video.playCount)"> </span>
                <br>
                <span class="up-count ion-thumbsup" v-text="video.upCount"></span>
                <br>
                <span class="video-time ion-android-time" v-text="goodVideoTimer(video.duration)"></span>
                <br>
                <span class="video-time ion-heart" v-text="'评分：'+video.score"></span>
              </div>
            </div>
            <div style="padding-top:5px">
              <span class="video-desc-title ion-android-bookmark"> 简介：</span>
              <span class="video-desc-text">{{video.description}}</span>
            </div>
          </div>
        </div>
        <div style="padding-top:10px;">
          <div class="input-group">
            <div class="input-group-prepend">
              <span class="input-group-text" style="color: #6c757d;background-color:#2a2a2a;border-color:#a96315" id="inputGroup-sizing-default">播放接口</span>
            </div>
            <select class="form-control" style="color: #6c757d;background-color:#2a2a2a;border-color:#a96315;box-shadow: none;" v-model="curritfurl">
              <option :value="infc.url" v-text="infc.name"  v-for="infc in interfaces"></option>
            </select>
            <div class="input-group-append">
              <button class="btn btn-outline-secondary" type="button" style="border-color:#a96315">点击解析</button>
            </div>
          </div>
          <div class="video-lable">
            <span v-text="video.name" style="color:#ccc;font-size:20px;"></span>
            <i class="badge badge-pill badge-dark" style="color:#d39e00;font-size:14px;" v-text="video.score"></i>
            <span class="badge badge-warning" v-for="cate in video.categories">{{cate.name}}</span>
          </div>
        </div>
      </div>
    </div>
    <div style="padding-top:10px">
      <div class="container">
        <h4 class="list-title">演员列表</h4>
        <hr>
        <div class="row">
          <!--导演 -->
          <div class="col-sm">
            <div class="card" style="width: 130px">
              <img class="card-img-top" :src="video.cast.directors[0].imageUrl" :alt="video.cast.directors[0].name" style="height:150px">
              <div class="card-body" style="padding:5px;">
                <p class="card-text" style="margin-bottom:5px;font-size:12px;"><span>{{video.cast.directors[0].name}}</span></p>
                <p class="v-desc" style="margin-bottom:5px;color:#d39e00">导演
                </p>
              </div>
            </div>
          </div>
          <div class="col-sm" v-for="actor in video.cast.mainActors">
            <!-- <a :href="'/video/play/'+v.vid"> -->
            <div class="card" style="width: 130px">
              <img class="card-img-top" :src="actor.imageUrl" :alt="actor.name" style="height:150px">
              <div class="card-body" style="padding:5px;">
                <p class="card-text" style="margin-bottom:5px;font-size:12px;"><span>{{actor.name}}</span></p>
                <p class="v-desc" style="margin-bottom:5px;color:#d39e00">饰
                  <span v-for="(rol,i) in actor.roles" v-text="rol+' '"></span>
                </p>
              </div>
            </div>
            <!-- </a> -->
          </div>
        </div>
      </div>
    </div>
    <br>
    <br>
  </div>
</template>
<script>
import $ from 'jquery'

export default {
  name: 'VideoPlay',
  data() {
    return {
      videoUrl: '',
      video: {},
      interfaces: [
        { name: "通用接口", url: "http://v.72du.com/api/?url=" },
        { name: "爱奇艺接口", url: "http://www.dgua.xyz/webcloud/?url=" },
        { name: "腾讯视频接口", url: "http://aikan-tv.com/?url=" },
        { name: "优酷视频接口", url: "http://www.82190555.com/video.php?url=" },
        { name: "土豆视频接口", url: "http://000o.cc/jx/ty.php?url=" },
        { name: "芒果TV接口", url: "http://vip.jlsprh.com/index.php?url=" },
        { name: "乐视TV接口", url: "http://jx.vgoodapi.com/jx.php?url=" },
        { name: "搜狐视频接口", url: "http://api.91exp.com/svip/?url=" },
        { name: "PPTV接口", url: "http://api.662820.com/xnflv/index.php?url=" }
      ],
      curritfurl:'http://api.91exp.com/svip/?url='
    }
  },
  created() {
    var vid = this.$route.params.id;
    console.log(vid)
    var _self = this;
    $.get('/api/video/detail/' + vid, function(data) {
      console.log(data);
      _self.video = data.data;
      _self.videoUrl = data.data.url;
    })
  },
  methods: {
    goodPlayCount: function(count) {
      var result = count;
      if (count > 10000)
        result = Math.round(count / 10000) + '万'
      return result;
    },
    goodVideoTimer: function(time) {
      var h, m, s;
      h = Math.floor(time / 60 / 60);
      m = Math.floor(time / 60 % 60);
      s = Math.floor(time % 60);
      return h + '时' + m + "分" + s;
    }
  }
}

</script>
<style scoped>
body {
  overflow-x: hidden;
}

.play-wrap {
  background-color: #292929;
  width: 100%;
  height: 100%;
}

.bg-hui {
  background-color: #666;
}

.bg-vdark {
  background-color: #121519 !important;
}

.list-title {
  color: #d39e00;
}

.right-video-detail {
  padding: 10px 10px;
  background-color: #1f1f1f;
}

.video-title {
  color: #fff;
}

.video-title-v {
  font-size: 12px;
  color: #d39e00;
}

.play-count,
.right-video-detail .up-count,
.video-time {
  color: #ccc !important;
  font-size: 10px;
}

.col-6 {
  padding: 0px;
}

.video-desc-title {
  color: #70859a;
}

.video-desc-text {
  color: #43464a;
  font-size: 12px;
}

.video-lable {
  margin: 15px 0px;
}

.video-lable>span {
  margin-left: 10px;
}

</style>
