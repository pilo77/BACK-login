<template>
    <ion-page>
      <ion-header :translucent="true">
        <ion-toolbar>
          <ion-title>Registrar Nota</ion-title>
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

            <ButtonComponent id="registrar" value="Agregar"  color= "success"></ButtonComponent>
            <ButtonComponent id="editar" value="Editar"  color="warning" @click="modificar"></ButtonComponent>
            <ButtonComponent id= "select" value= "Atras" color="danger" expand="full" @click="atras"></ButtonComponent>
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

  const atras = () => {
    window.location.href = "/Dashboard"
  }
  const modificar = () => {
    window.location.href = "actualizar"
  }
  </script>
  
  <style scoped src="../theme/container.css"></style>