<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-title>Dashboard</ion-title>
      </ion-toolbar>
    </ion-header>

    <ion-content>
      <br>
      <div id="container">
        <strong><a href="/nota">Crear Nota</a></strong>
        <br>
        <strong><a href="/proximo">Notas Creadas</a></strong>
        <br>
      
      </div>

    </ion-content>
    <ButtonComponent id="select" value= "atras" expand ="full" color="danger" @click="atras"></ButtonComponent>
  </ion-page>

</template>

<script setup lang="ts">
import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar } from '@ionic/vue';
import ButtonComponent from '@/components/ButtonComponent.vue';
const atras = () => {
     window.location.href = "/login"
  }
</script>

<style scoped src="../theme/login.css"></style>
