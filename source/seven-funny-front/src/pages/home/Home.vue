<template>
  <div>
    <home-header></home-header>
    <home-list></home-list>
    <home-comment></home-comment>
    <home-side-bar></home-side-bar>
  </div>
</template>

<script>
import HomeHeader from './components/Header'
import HomeList from './components/List'
import HomeComment from './components/Comment'
import HomeSideBar from './components/SideBar'
export default {
  name: 'Home',
  components: {
  	HomeHeader,
    HomeList,
    HomeComment,
    HomeSideBar
  },
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  }
}
</script>
