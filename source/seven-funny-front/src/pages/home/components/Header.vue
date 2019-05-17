<template>
  <div class="header">
    <div class="logo">
      <div class="back-icon">
        <svg class="icon" aria-hidden="true">
          <use xlink:href="#iconmagnet"></use>
        </svg>
      </div>
    </div>
    <div class="nav">
      <ul>
        <li><a href="" >首页</a></li>
        <li><a href="" >最新</a></li>
      </ul>
    </div>
    <div class="pro">
      <ul>
        <li><a href="">注册</a></li>
        <li><a href="">登录</a></li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: 'HomeHeader'
}
</script>

<style lang="stylus" scoped>
  @import '~styles/varibles.styl'
  .header
    position: fixed
    top: 0
    display: flex
    background: $bgColor
    width: 100%
    height: 4.2rem
    font-size: 1.4rem
    align-items: center
    .logo
      flex:1
      .back-icon
        text-align: right
        margin-right: 3rem
        font-size: 3rem
    .nav
      flex:2
      li
        display: inline
        padding: 0 1.5rem
    .pro
      flex:1
      li
        display: inline
        padding: 0 1.5rem
          
    ul li a
      color: #fff
</style>


