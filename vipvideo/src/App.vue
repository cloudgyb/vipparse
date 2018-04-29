<template>
  <div id="app">
    <div><VideoHeader /></div>
    <router-view/>
  </div>
</template>

<script>
import VideoHeader from '@/components/VideoHeader'
export default {
  name: 'App',
  components:{
    VideoHeader
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
}
</style>
