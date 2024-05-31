<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-title>Actualizar Nota</ion-title>
      </ion-toolbar>
    </ion-header>
    <SeachComponent v-model="idBuscar" @change="loadRecordatorioData"></SeachComponent>
    <ion-content>
      <div id="login-container">
        <div id="login-form">
          <InputComponent id="id" name="id" type="hidden" v-model="recordatorio.id" />
          <InputComponent id="titulo" name="titulo" label="Titulo: " v-model="recordatorio.titulo" />
          <InputComponent id="descripcion" name="descripcion" label="Descripcion: " v-model="recordatorio.descripcion" />
          <InputComponent id="fecha" name="fecha" label="Fecha: " v-model="recordatorio.fecha" />
        </div>
        <div>
          <TimeComponent></TimeComponent>
        </div>
        <h2>
          <ButtonComponent id="registrar" value="Guardar cambios" color="success" @click="updateRecordatorio"></ButtonComponent>
          <ButtonComponent id="select" value="Atras" expand="full" color="danger" @click="atras"></ButtonComponent>
        </h2>
      </div>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import { ref, watch } from 'vue';
import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar } from '@ionic/vue';
import ButtonComponent from '@/components/ButtonComponent.vue';
import TimeComponent from '@/components/TimeComponent.vue';
import InputComponent from '@/components/InputComponent.vue';
import SeachComponent from '@/components/SeachComponent.vue';
import axios from 'axios';

const baseURL = 'http://localhost:9000/recordatorioG';

const atras = () => {
  window.location.href = "/dashboard";
};

const recordatorio = ref({
  id: 0,
  titulo: '',
  descripcion: '',
  fecha: ''
});

const idBuscar = ref(0);

const token = localStorage.getItem('token');
if (!token) {
  console.error('No se encontró el token de autenticación.');
}

// Watcher para detectar cambios en idBuscar y cargar los datos correspondientes
watch(idBuscar, async (newId) => {
  if (newId) {
    await loadRecordatorioData();
  }
});

const loadRecordatorioData = async () => {
  try {
    if (!idBuscar.value) return; 
    const response = await axios.get(`${baseURL}/api/recordatorio/${idBuscar.value}`, {
      headers: {
        Authorization: `Bearer ${token}`
      }
    });
    recordatorio.value = response.data;
    console.log(recordatorio);
  } catch (error) {
    console.error('Error al cargar los datos del Recordatorio:', error);
  }
};

const updateRecordatorio = async () => {
  try {
    await axios.put(`${baseURL}/auth/recordatorio/${recordatorio.value.id}`, recordatorio.value, {
      headers: {
        Authorization: `Bearer ${token}`
      }
    });
    alert('Nota actualizado con éxito');
    window.location.href = "/editarNota";
  } catch (error) {
    console.error('Error al actualizar la nota:', error);
  }
};

</script>

<style scoped src="../theme/container.css"></style>
