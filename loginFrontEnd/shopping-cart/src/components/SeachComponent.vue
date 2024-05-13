<template>
    <ion-searchbar placeholder="Buscar por Fecha: "></ion-searchbar>
  </template>
  
  <script lang="ts">
    import { IonSearchbar } from '@ionic/vue';
    import { defineComponent } from 'vue';
  
    export default defineComponent({
      components: { IonSearchbar },
    });
  </script>