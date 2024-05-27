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
            <InputComponent id ="country" name = "country" label ="Nacionalidad: "/>
            <InputComponent id ="firstname" name = "firstname" label ="Nombres: "/> 
            <InputComponent id ="lastname" name = "lastname" label ="Apellidos: "/>
            <InputComponent id ="username" name = "username" label = "Usuario: "/>
            <InputComponent id="password" name="password" label="Contraseña: " />          
          </div>  
          <br>
          <br>
          <div> 
            <ButtonComponent id="crear" value="Crear Usuario" expand="full" nameMethod="createRecord" @click="createRecord"></ButtonComponent>
            <ButtonComponent id = "select" value = "atras" expand="full" color="danger" @click="atras"></ButtonComponent>

          </div>          
        </div>
      </ion-content>
    </ion-page>
  </template>

  
  <script setup lang="ts">
  import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar } from '@ionic/vue';
  import InputComponent from '@/components/InputComponent.vue';
  import ButtonComponent from '@/components/ButtonComponent.vue';
  import axios from 'axios';

  const baseURL ="http://localhost:9000/recordatorioG/auth/register"


  const atras = () => {
     window.location.href = "/login"
  }


async function createRecord() {
  const data = {
    
    country: country.value,
    firstname: firstname.value,
    lastname: lastname.value,
    username: username.value,
    password: password.value

  };

  try {
    const response = await axios.post(baseURL, data);
    console.log('Registro creado exitosamente:', response.data);
    window.location.href = "/login"
  } catch (error) {
    console.error('Error al crear el registro:', error);
  }
}

  </script>
  
  <style scoped src="../theme/container.css"></style>

