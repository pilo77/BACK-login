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
            <InputComponent id="id" name="id" type="hidden"/>
            <InputComponent id ="nombre" name = "nombre" label ="Nombre: "></InputComponent>
            <SelectComponent ></SelectComponent>
            <InputComponent id="tipoDocumento" name="tipoDocumento" label="Tipo Documento: " />
            <InputComponent id="nombre" name="nombre" label="Contraseña: " />          
          </div>  
          <br>
          <br>
          <div> 
            <ButtonComponent id="crear" value="Crear Usuario" expand="full"></ButtonComponent>
          </div>          
        </div>
      </ion-content>
    </ion-page>
  </template>
  
  <script setup lang="ts">
  import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar } from '@ionic/vue';
  import InputComponent from '@/components/InputComponent.vue';
  import ButtonComponent from '@/components/ButtonComponent.vue';
  import SelectComponent from '@/components/SelectComponent.vue';

  </script>
  
  <style scoped src="../theme/container.css"></style>

