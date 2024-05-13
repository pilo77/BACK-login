<template>
    <ion-page>
      <ion-header :translucent="true">
        <ion-toolbar>
          <ion-title>Actualizar Nota</ion-title>
        </ion-toolbar>
      </ion-header>  
      <ion-content>       
        <div id="login-container">  
          <div id="login-form">
            <NotaComponent></NotaComponent>
                  
        </div>
        <div>
            <TimeComponent></TimeComponent>
        </div>
        <h2>
            <ButtonComponent id="registrar" value="Guardar cambios"  color= "success"></ButtonComponent>
            <ButtonComponent id="editar" value="Eliminar" color="danger" ></ButtonComponent>
        </h2>
        </div>
      </ion-content>
    </ion-page>
  </template>
  
  <script setup lang="ts">
  import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar } from '@ionic/vue';
  import ButtonComponent from '@/components/ButtonComponent.vue';
  import NotaComponent from '@/components/NotaComponent.vue';
  import TimeComponent from '@/components/TimeComponent.vue';
  </script>
  
  <style scoped src="../theme/container.css"></style>