<template>
  <div>
    <home-header></home-header>
    <home-list></home-list>
    <home-comment></home-comment>
    <home-side-bar></home-side-bar>
    <home-footer></home-footer>
  </div>
</template>

<script>
import HomeHeader from './components/Header'
import HomeList from './components/List'
import HomeComment from './components/Comment'
import HomeSideBar from './components/SideBar'
import HomeFooter from './components/Footer'
export default {
  name: 'Home',
  components: {
  	HomeHeader,
    HomeList,
    HomeComment,
    HomeSideBar,
    HomeFooter
  },
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  }
}
</script>
