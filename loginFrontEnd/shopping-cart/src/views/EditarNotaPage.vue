<template>
    <ion-page>
      <ion-header :translucent="true">
        <ion-toolbar>
          <ion-title>Editar Y Eliminar Recordatorio</ion-title>
        </ion-toolbar>
      </ion-header>
  
      <ion-content>
        <div id="login-container">
          <ion-card v-for="recordatorio in recordatorios" :key="recordatorio.id" color="light">
            <IonCardContent>

            <IonText> {{ recordatorio.id }} {{recordatorio.titulo}} {{recordatorio.descripcion}} {{ recordatorio.fecha }} {{  }}</IonText>
            <ButtonComponent id="delete" value="Eliminar" color="danger" @click="deleteRecordatorio(recordatorio.id)"/>
            <ButtonComponent id="update" value="Actualizar" color="warning" @click="actualizar()"></ButtonComponent>
            
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
  import ButtonComponent from '@/components/ButtonComponent.vue';
  import axios from 'axios';
  const baseURL = 'http://localhost:9000/recordatorioG';
  
  const salir = () =>{
    window.location.href = ("/dashboard")
  }
  const actualizar = () =>{
    window.location.href = ("/actualizar")
  }
  // Estado del usuario
  const recordatorio = ref({
    id: 0,
   titulo: '',
   descripcion: '',
   fecha: ''
  });
  
  const recordatorios = ref([]);
  
  onMounted(async ()=>{
    await updateRecordatorioData ();
    console.log(recordatorios)
  });
  
  const token = localStorage.getItem('token');
    if (!token) {
      console.error('No se encontró el token de autenticación.');
    }
  

  const updateRecordatorioData = async () => {
    try {
      const response = await axios.get(`${baseURL}/api/recordatorio`, {
        headers: {
          Authorization: `Bearer ${token}`
        }});
      recordatorios.value = response.data;
      console.log(recordatorio);
    } catch (error) {
      console.error('Error al cargar los datos del usuario:', error);
    }
  };
  
  
  
  
  
  const deleteRecordatorio = async (id) => {
    try {
      await axios.delete(`${baseURL}/auth/recordatorio/${id}`,{
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
  