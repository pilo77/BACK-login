<template>
    <ion-page>
      <ion-header :translucent="true">
        <ion-toolbar>
          <ion-title>Agendados</ion-title>
        </ion-toolbar>
      </ion-header>  
      <ion-content>       
        <div>
            <SeachComponent></SeachComponent>
            <CardComponent></CardComponent>
        </div>

        

    
      </ion-content>
      <ButtonComponent id="select" value="Atras" expand="full" color="danger" @click="atras"></ButtonComponent>
    </ion-page>
  </template>
  
  <script setup lang="ts">
  import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar } from '@ionic/vue';
  import SeachComponent from '@/components/SeachComponent.vue';
  import CardComponent from '@/components/CardComponent.vue';
import ButtonComponent from '@/components/ButtonComponent.vue';

const atras = () => {

  window.location.href = "/Dashboard"
}

  </script>
  
  <style scoped src="../theme/container.css"></style>