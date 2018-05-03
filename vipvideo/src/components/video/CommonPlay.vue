<template>
  <div class="container" style="padding:15px 100px">
    <!-- 16:9 aspect ratio -->
    <div class="embed-responsive embed-responsive-16by9" style="background-color:#000;border-color:#a96315">
      <iframe class="embed-responsive-item" scrolling="no" :src="curritfurl+videoUrl"></iframe>
    </div>
    <div class="input-group" style="margin-top:10px">
      <div class="input-group-prepend">
        <span class="input-group-text" style="color: #6c757d;background-color:#2a2a2a;border-color:#a96315" id="inputGroup-sizing-default">播放接口</span>
      </div>
      <select class="form-control" style="color: #6c757d;background-color:#2a2a2a;border-color:#a96315;box-shadow: none;" v-model="curritfurl">
        <option :value="infc.url" v-text="infc.name" v-for="infc in interfaces"></option>
      </select>
      <input type="text" name="videourl" class="form-control" style="border-color:#a96315;background-color:#2a2a2a;box-shadow: none;" v-model="videoUrl" placeholder="输入url，例如：http://www.iqiyi.com/v_19rrfq53ak.html" />
    </div>
  </div>
</template>
<script>
export default {
  name: 'CommonPlay',
  data() {
    return {
      videoUrl: '',
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
      curritfurl: 'http://api.91exp.com/svip/?url='
    }
  }
}

</script>
