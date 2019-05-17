<template>
  <div>
    <div class ="list">
      <h1>{{msg}}</h1>
    </div>
  </div>
</template>

<script>
export default{
	name: 'HomeList',
	data () {
    return {
      msg: 'List'
    }
  }
}
</script>

<style lang="stylus" scoped>
  @import '~styles/varibles.styl'
  .list
    //width: 100%
    //height: 100%
    background-color: red
    color: yellow
    float: left
</style>