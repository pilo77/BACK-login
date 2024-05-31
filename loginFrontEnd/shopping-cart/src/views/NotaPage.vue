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
          <InputComponent v-model="titulo" id="titulo" name="titulo" label="Titulo: "></InputComponent>
          <InputComponent v-model="descripcion" id="descripcion" name="descripcion" label="Descripcion: "></InputComponent>
          <InputComponent v-model="fecha" id="fecha" name="fecha" label="Fecha: "></InputComponent>
           
        </div>
        <div>
          <TimeComponent></TimeComponent>
        </div>
        <h2>
          <ButtonComponent id="registrar" value="Agregar" color="success" @click="guardarNota"></ButtonComponent>
          <ButtonComponent id="editar" value="Editar" color="warning" @click="modificar"></ButtonComponent>
          <ButtonComponent id="select" value="Atrás" color="danger" expand="full" @click="atras"></ButtonComponent>
        </h2>
      </div>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import { ref } from 'vue';
import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar } from '@ionic/vue';
import ButtonComponent from '@/components/ButtonComponent.vue';
import TimeComponent from '@/components/TimeComponent.vue';
import InputComponent from '@/components/InputComponent.vue';
import axios from 'axios';

const baseURL = 'http://localhost:9000/recordatorioG/auth/recordatorio';

const titulo = ref('');
const descripcion = ref('');
const fecha = ref('');


async function guardarNota() {
  const data = {
    titulo: titulo.value,
    descripcion: descripcion.value,
    fecha: fecha.value,
  };

  const token = localStorage.getItem('token');

  try {
    const response = await axios.post(baseURL, data, {
      headers: {
        Authorization: `Bearer ${token}`
      }
    });
    console.log('Guardado exitoso', response.data);
    window.location.href = '/dashboard';
  } catch (error) {
    console.error('Error al guardar', error);
  }
}

const atras = () => {
  window.location.href = '/dashboard';
}

const modificar = () => {
  window.location.href = '/actualizar';
}
</script>

<style scoped src="../theme/container.css"></style>
