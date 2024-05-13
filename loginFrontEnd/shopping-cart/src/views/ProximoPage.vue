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
    </ion-page>
  </template>
  
  <script setup lang="ts">
  import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar } from '@ionic/vue';
  import SeachComponent from '@/components/SeachComponent.vue';
  import CardComponent from '@/components/CardComponent.vue';

  </script>
  
  <style scoped src="../theme/container.css"></style>