<template>
  <div>

    <el-container>
      <el-header>Header</el-header>
      <el-container>
        <el-aside width="200px">Aside</el-aside>
        <el-main>Main</el-main>
      </el-container>
    </el-container>

  </div>
</template>

<script>

export default {
  name: 'HelloWorld'
}

</script>

<style>

</style>
#!/bin/bash

rm "/Users/$(whoami)/Library/Application Support/Beyond Compare/registry.dat"

"`dirname "$0"`"/BCompare.real $@
