<template>
    <ion-page>
      <ion-header :translucent="true">
        <ion-toolbar>
          <ion-title>Crear Usuario</ion-title>
        </ion-toolbar>
      </ion-header>  
      <ion-content>       
        <div id="login-container">  
          <div id="login-form">
         
          <br>
          <br>
          <div>
            <InputComponent id="buscarUser" name="buscarUser" values="Buscar Usuario "></InputComponent>
            <ButtonComponent id="buscarUsuario" value="ir" expand="full" color="success"></ButtonComponent>
          </div>
          <br>
          <div> 
            <ButtonComponent id="editarUsuario" value="ir" expand="full" color="warning"></ButtonComponent>
          </div>
          <br>
          <div>
            <ButtonComponent id="eliminarUsuario" value="ir" expand="full" color="danger"></ButtonComponent>
          </div>
          <br>
          <div>
            <ButtonComponent id="salir" value="salir" expand="full" color="danger"></ButtonComponent>
          </div>
          </div>          
        </div>
      </ion-content>
    </ion-page>
  </template>
  
  <script setup lang="ts">
  import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar } from '@ionic/vue';
  import InputComponent from '@/components/InputComponent.vue';
  import ButtonComponent from '@/components/ButtonComponent.vue';

  </script>
  
  <style scoped src="../theme/container.css"></style>
