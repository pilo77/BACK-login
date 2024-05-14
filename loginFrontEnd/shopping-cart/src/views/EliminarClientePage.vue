<template>
    <ion-page>
      <ion-header :translucent="true">
        <ion-toolbar>
          <ion-title>Eliminar Usuario</ion-title>
        </ion-toolbar>
      </ion-header>  
      <SeachComponent></SeachComponent>
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
            <ButtonComponent id="editar" value="Eliminar Usuario" expand="full" color="danger"></ButtonComponent>
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
  import SeachComponent from '@/components/SeachComponent.vue';

  </script>
  
  <style scoped src="../theme/container.css"></style>