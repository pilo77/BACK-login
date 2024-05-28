<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-title class="cart-title">LOGIN</ion-title>
      </ion-toolbar>
    </ion-header>

    <div id="login-container">
      <div id="login-form" class="login-form">
        <strong>Bienvenido al Recordatorio Personal</strong>
        <br>
        <br>
        <InputComponent v-model="username" id="username" name="username" label="Usuario: " placeholder="Introduce tu usuario" />
        <InputComponent v-model="password" id="password" name="password" label="Contraseña: " placeholder="Introduce tu contraseña" />
      </div>
      <div class="login-button">
        <ButtonComponent id="login" value="Iniciar Sesión" expand="full" color="dark" @click="login" />
        <ButtonComponent id="forgotPassword" value="Crear Cuenta" expand="full" color="success" @click="newUser" />
      </div>
    </div>
  </ion-page>
</template>

<script setup lang="ts">
import { ref } from 'vue';
import { IonHeader, IonPage, IonTitle, IonToolbar } from '@ionic/vue';
import ButtonComponent from '@/components/ButtonComponent.vue';
import InputComponent from '@/components/InputComponent.vue';
import axios from 'axios';
import { jwtDecode } from 'jwt-decode';





// Interfaz para el payload decodificado
interface DecodedToken {
  role: string;
}

const baseURL = 'http://localhost:9000/recordatorioG/auth/login';

const username = ref('');
const password = ref('');

const newUser = () => {
  window.location.href = '/cliente';
};

const obtenerRolDesdeToken = (token: string): string | null => {
  try {
    localStorage.setItem('token', token);
    const decodedToken = jwtDecode<DecodedToken>(token);
    return decodedToken.role;
  } catch (error) {
    console.error('Error al decodificar el token:', error);
    return null;
  }
};

const login = async () => {
  if (!username.value || !password.value) {
    alert('Por favor, ingrese su usuario y contraseña');
    return;
  }

  try {
    const response = await axios.post(baseURL, {
      username: username.value,
      password: password.value,
    });

    const { token } = response.data;

    localStorage.setItem('token', token);

    const role = obtenerRolDesdeToken(token);

    if (role === 'ADMIN') {
      window.location.href = '/administrador';
    } else if (role === 'USER') {
      window.location.href = '/dashboard';
    } else {
      console.error('Rol no reconocido:', role);
    }
  } catch (error) {
    console.error('Error en el inicio de sesión:', error);
  }
}
</script>

<style scoped src="../theme/login.css"></style>
