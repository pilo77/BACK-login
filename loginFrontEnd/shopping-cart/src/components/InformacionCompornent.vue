<template>
      <div id="login-container">  
        <div id="login-form">
          <InputComponent id = "id" name = "id" value = "Id: "></InputComponent>
          <InputComponent id = "codigo " name = "codigo" value = "Codigo Dane: "></InputComponent>
          <InputComponent id = "nombre" name = "nombre" value = "Ingresa Nombre: "></InputComponent>
        </div>
      </div>
</template>

<script setup lang="ts">
import InputComponent from './InputComponent.vue';
</script>

<style scoped src="../theme/container.css"></style>