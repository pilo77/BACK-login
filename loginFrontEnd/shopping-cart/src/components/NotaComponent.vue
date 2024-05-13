<template>
    <div id="login-container">  
      <div id="login-form">
        <InputComponent id = "asunto" name = "asunto" value = "Asunto: "></InputComponent>
        <InputComponent id = "fecha" name = "fecha" value = "Fecha: "></InputComponent>
        <InputComponent id = "hora" name = "hora" value = "Hora: "></InputComponent>
      </div>
    </div>
</template>

<script setup lang="ts">
import InputComponent from './InputComponent.vue';
</script>

<style scoped src="../theme/container.css"></style>