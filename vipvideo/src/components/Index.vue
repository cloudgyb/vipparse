<template>
  <div>
    <div class="container" style="margin-top:20px">
      <h4 class="list-title">VIP 热播榜</h4>
      <div class="row">
        <div class="col-sm" v-for="(v ,i) in vlist">
          <router-link :to="'/video/play/'+v.vid">
            <!-- <a :href="'/video/play/'+v.vid"> -->
            <div class="card" style="width: 180px" :class="[pageInfo.currPageNum==1 && i==0?'first-card':'']">
              <img class="card-img-top" :src="v.img" :alt="v.name" style="height:236px">
              <div class="card-body">
                <p class="card-text"><span>{{v.name}}</span><span class="num">{{v.score_decimal}}</span></p>
                <p class="v-desc">{{v.desc}}</p>
              </div>
            </div>
            <!-- </a> -->
          </router-link>
        </div>
      </div>
      <nav aria-label="Page navigation example" class="page" v-show="pageShow">
        <ul class="pagination justify-content-center">
          <li class="page-item" :class="[pageInfo.currPageNum==1?'disabled':'']"><a class="page-link" href="javascript:;" @click="prevPage">上一页</a></li>
          <!-- <li class="page-item"><a class="page-link" href="#">1</a></li>
          <li class="page-item"><a class="page-link" href="#">2</a></li>
          <li class="page-item"><a class="page-link" href="#">3</a></li> -->
          <li class="page-item" :class="[pageInfo.currPageNum==pageInfo.totalPage?'disabled':'']"><a class="page-link" href="javascript:;" @click="nextPage">下一页</a></li>
        </ul>
      </nav>
    </div>
  </div>
</template>
<script>
import $ from 'jquery'
export default {
  name: 'Index',
  data() {
    return {
      vlist: [],
      pageInfo: {},
      pageShow: false
    }
  },
  created() {
    this.getVipData(14, 1);
  },
  methods: {
    getVipData: function(pageSize, pageNum) {
      var _self = this;
      $.get('/api/video/list/' + pageSize + '/' + pageNum, function(data) {
        _self.vlist = data.data;
        _self.pageInfo = data;
        console.log(data);
        _self.pageShow = true;
      });
    },
    nextPage: function() {
      var currPage = this.pageInfo.currPageNum;
      var totalPage = this.pageInfo.totalPage;
      this.getVipData(15, currPage + 1);
    },
    prevPage: function() {
      var currPage = this.pageInfo.currPageNum;
      var totalPage = this.pageInfo.totalPage;
      var pageSize = 15;
      if (currPage == 2)
        pageSize = 14;
      this.getVipData(pageSize, currPage - 1);
    },
    reloadImg: function(imgObj, imgSrc, maxErrorNum) {
     /* console.log(imgObj);
      console.log(imgSrc);*/
      if(maxErrorNum>0){
        imgObj.src = imgSrc;
        imgObj.onerror = function () {
          this.reloadImg(imgObj, imgSrc, maxErrorNum-1);
        }
      }else {
        imgObj.removeAttribute("src");
      }
    }
  },
  components: {

  }
}

</script>
<style scoped>
.container {
  min-width: 200px;
  min-height: 400px;
  background: url(../assets/loading-kiwi.gif) no-repeat center center;
}

.col-sm>a {
  color: #382828;
  font-size: 13px;
  text-decoration: none;
}

.card-body {
  padding: 10px;
  border: none;
}

.card-body>p:first-child {
  margin-bottom: 3px;
}

.v-desc {
  color: #909090;
  font-size: 10px;
}

.first-card {
  width: 410px !important;
}

.num {
  float: right;
  color: #f74912;
}

.list-title {
  color: #d39e00;
}

.card {
  border: none;
}

.card>img {
  display: inline-block;
  background: #f2f2f2 url(../assets/bg-item.png) no-repeat center center;
}

.page {}

</style>
