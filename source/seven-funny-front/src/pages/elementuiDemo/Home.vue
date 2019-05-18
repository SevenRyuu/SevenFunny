<template>
  <div>

    <el-container>
      <el-header>Header</el-header>
      <el-container>
        <el-aside width="200px">
          <nav-menu></nav-menu>
        </el-aside>
        <el-main>Main</el-main>
      </el-container>
    </el-container>

  </div>
</template>

<script>
import NavMenu from '@/pages/elementuiDemo/components/NavMenu'
export default {
  name: 'ElHome',
  components: {
    NavMenu
  }
}

</script>

<style>

</style>