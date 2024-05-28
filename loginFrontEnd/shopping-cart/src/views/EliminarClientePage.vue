<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-title>Editar Usuario</ion-title>
      </ion-toolbar>
    </ion-header>

    <ion-content>
      <div id="login-container">
        <ion-card v-for="user in users" :key="user.id" color="light">
          <IonCardContent>
          <IonText>{{user.firstname}} {{user.lastname}} </IonText>
          <ButtonComponent id="eliminar" value="Eliminar" @click="deleteUser(user.id)"/>
        </IonCardContent>
        
        </ion-card>
        </div>
        <br>
        <br>
        <div>
          <ButtonComponent id="salir" value="salir" expand="full" color="warning" @click="salir"></ButtonComponent>
        </div>
    </ion-content>
  </ion-page>
</template>


<script setup lang="ts">
import { onMounted, ref } from 'vue';
import { IonCard, IonCardContent, IonContent, IonHeader, IonPage, IonText, IonTitle, IonToolbar } from '@ionic/vue';
//import InputComponent from '@/components/InputComponent.vue';
import ButtonComponent from '@/components/ButtonComponent.vue';
import axios from 'axios';
const baseURL = 'http://localhost:9000/recordatorioG';

const salir = () =>{
  window.location.href = ("/administrador")
}

// Estado del usuario
const user = ref({
  id: 0,
  country: '',
  firstname: '',
  lastname: '',
  username: '',
  password: ''
});

const users = ref([]);


onMounted(async ()=>{
  await loadUserData();
  console.log(users)
});

const token = localStorage.getItem('token');
  if (!token) {
    console.error('No se encontró el token de autenticación.');
  }


// Función para cargar los datos del usuario
const loadUserData = async () => {
  try {
    const response = await axios.get(`${baseURL}/api/user`, {
      headers: {
        Authorization: `Bearer ${token}`
      }});
    users.value = response.data;
    console.log(user);
  } catch (error) {
    console.error('Error al cargar los datos del usuario:', error);
  }
};





const deleteUser = async (id) => {
  try {
    await axios.delete(`${baseURL}/api/user/${id}`,{
      headers: {
        Authorization: `Bearer ${token}`
      }});
    alert('Usuario elminado con éxito');
    window.location.reload();
  } catch (error) {
    console.error('Error al actualizar el usuario:', error);
  }
};
</script>

<style scoped src="../theme/container.css"></style>
