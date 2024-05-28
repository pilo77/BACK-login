<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-title>Editar Usuario</ion-title>
      </ion-toolbar>
    </ion-header>
    <SeachComponent v-model="idBuscar" @change="loadUserData"></SeachComponent>
    <ion-content>
      <div id="login-container">
        <div id="login-form">
          <InputComponent id="id" name="id" type="hidden" v-model="user.id" />
          <InputComponent id="country" name="country" label="Nacionalidad: " v-model="user.country" />
          <InputComponent id="firstname" name="firstname" label="Nombres: " v-model="user.firstname" />
          <InputComponent id="lastname" name="lastname" label="Apellidos: " v-model="user.lastname" />
          <InputComponent id="username" name="username" label="Usuario: " v-model="user.username" />
        
        </div>
        <br>
        <br>
        <div>
          <ButtonComponent id="editar" value="Actualizar Usuario" expand="full" color="warning" @click="updateUser"></ButtonComponent>
        </div>
      </div>
    </ion-content>
  </ion-page>
</template>


<script setup lang="ts">
import { ref } from 'vue';
import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar } from '@ionic/vue';
import InputComponent from '@/components/InputComponent.vue';
import ButtonComponent from '@/components/ButtonComponent.vue';
import SeachComponent from '@/components/SeachComponent.vue';
import axios from 'axios';
const baseURL = 'http://localhost:9000/recordatorioG';


// Estado del usuario
const user = ref({
  id: 0,
  country: '',
  firstname: '',
  lastname: '',
  username: ''
});

const idBuscar = ref(0);


const token = localStorage.getItem('token');
  if (!token) {
    console.error('No se encontró el token de autenticación.');
  }


// Función para cargar los datos del usuario
const loadUserData = async () => {
  try {
    if (!idBuscar.value) return; // Validar que idBuscar tenga un valor
    const response = await axios.get(`${baseURL}/api/user/${idBuscar.value}`, {
      headers: {
        Authorization: `Bearer ${token}`
      }});
    user.value = response.data;
    console.log(user);
  } catch (error) {
    console.error('Error al cargar los datos del usuario:', error);
  }
};

// Función para actualizar el usuario
const updateUser = async () => {
  try {
    await axios.put(`${baseURL}/api/user/${user.value.id}`,{user: user.value}, {
      headers: {
        Authorization: `Bearer ${token}`
      }});
    alert('Usuario actualizado con éxito');
  } catch (error) {
    console.error('Error al actualizar el usuario:', error);
  }
};
</script>

<style scoped src="../theme/container.css"></style>
