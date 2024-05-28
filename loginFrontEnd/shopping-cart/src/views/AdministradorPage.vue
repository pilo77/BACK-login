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
              <ButtonComponent id="buscarUsuario" value="ir" expand="block" color="success" ></ButtonComponent>
            </div>
          </div>
          <br>
          <div class="flex-row">
            <div class="item-container">
              <ItemComponent id= "editar" value= "editar" label="Editar Usuarios" type="editarUser"></ItemComponent>
            </div>
            <div class="button-container">
              <ButtonComponent id="editarUsuario" value="ir" expand="block" color="warning" @click="editarUser"></ButtonComponent>
            </div>
          </div>
          <br>
          <div class="flex-row">
            <div class="item-container">
              <ItemComponent id= "eliminar" value= "eliminar" label="Eliminar Usuarios" type="eliminarUser"></ItemComponent>
            </div>
            <div class="button-container">
              <ButtonComponent id="eliminarUsuario" value="ir" expand="block" color="warning" @click="eliminarUser"></ButtonComponent>
            </div>
          </div>   
        </div>       
      </div>
      <br>
      <h2 style="text-align: center;">
        <ButtonComponent id="salir" value="Salir" color="danger" @click= "salir"></ButtonComponent>
      </h2>
      
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar } from '@ionic/vue';
import ButtonComponent from '@/components/ButtonComponent.vue';
import ItemComponent from '@/components/ItemComponent.vue';


const salir = () => {
  window.location.href = ("/login")
};

// Eliminar usuario
const eliminarUser = () => {
  window.location.href = ("/eliminarUser")
};

// Editar usuario
const editarUser = () => {
  window.location.href = ("/editarUser")
};
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
  