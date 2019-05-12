<template>
  <div class="header">
    <div class="logo">
      <div class="iconfont back-icon">&#xe612;</div>
    </div>
    <div class="nav">
      <ul>
        <li><a href="" class="nav-tag">首页</a></li>
        <li><a href="" class="nav-tag">最新</a></li>
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
    line-height: $headerHeight
    background: $bgColor
    .logo
      margin-left: 5rem
      font-size: 1.3rem
    .nav
      .nav-tag
        color: #fff

</style>


