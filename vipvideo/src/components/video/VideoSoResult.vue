<template>
  <div class="container" style="margin-top:20px;">
    <div class="alert" role="alert" :class="[result.length===0?'alert-danger':'alert-success']">
      共找到<i style="font-size:1.5rem;color:#d39e00">{{result.length}}</i>个相关视频。
    </div>
  </div>
</template>
<script>
export default {
  name: 'VideoSoResult',
  data() {
    return {
      result: []
    }
  },
  created() {
    this.loadData();
  },
  methods: {
    loadData() {
      var keyword = this.$route.params.id;
      var _self = this;
      $.get("/api/video/so", { 'kw': keyword }, function(data) {
        _self.result = data.data;
        console.log(data);
      })
      console.log(keyword);
    }
  }
}

</script>
<style scoped>


</style>
