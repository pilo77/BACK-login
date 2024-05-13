<template>
    <ion-page>
      <ion-header :translucent="true">
        <ion-toolbar>
          <ion-title>Administrador</ion-title>
        </ion-toolbar>
      </ion-header>  
      <ion-content>       
  
        <div id="login-container" class="flex-container">  
          <div id="login-form">         
            <br>
            <br>
            <div class="flex-row">
              <div class="item-container">
                <ItemComponent label="Buscar Usuarios" type="buscarUser"></ItemComponent>
              </div>
              <div class="button-container">
                <ButtonComponent id="buscarUsuario" value="ir" expand="block" color="success"></ButtonComponent>
              </div>
            </div>
            <br>
            <div class="flex-row">
              <div class="item-container">
                <ItemComponent label="Editar Usuarios" type="editarUser"></ItemComponent>
              </div>
              <div class="button-container">
                <ButtonComponent id="editarUsuario" value="ir" expand="block" color="warning"></ButtonComponent>
              </div>
            </div>
            <br>
            <div class="flex-row">
              <div class="item-container">
                <ItemComponent label="Eliminar Usuarios" type="eliminarUser"></ItemComponent>
              </div>
              <div class="button-container">
                <ButtonComponent id="eliminarUsuario" value="ir" expand="block" color="danger"></ButtonComponent>
              </div>
            </div>   
          </div>       
        </div>
        <br>
        <h2 style="text-align: center;"> <!-- Estilo añadido -->
          <ButtonComponent id="salir" value="Salir" color="danger"></ButtonComponent>
        </h2>
        
      </ion-content>
    </ion-page>
  </template>
  
  <script setup lang="ts">
  import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar } from '@ionic/vue';
  import ButtonComponent from '@/components/ButtonComponent.vue';
  import ItemComponent from '@/components/ItemComponent.vue';
  </script>
  
  <style scoped>
  .flex-container {
    display: flex;
    flex-direction: column;
  }
  
  .flex-row {
    display: flex;
    flex-direction: row;
    align-items: center;
  }
  
  .item-container {
    flex: 1; 
    white-space: nowrap;
    pointer-events: none;
  }
  
  .button-container {
    margin-left: 10px; 
  }
  </style>
  