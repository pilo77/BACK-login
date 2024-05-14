import { createRouter, createWebHistory } from '@ionic/vue-router';
import { RouteRecordRaw } from 'vue-router';
import HomePage from '../views/HomePage.vue'
import ClientePage from '../views/ClientePage.vue'
import LoginPage from '../views/LoginPage.vue'
import DasboardPage from '../views/DasboardPage.vue'
import ProductoPage from '@/views/ProductoPage.vue';
import NotaPage from '@/views/NotaPage.vue';
import UpdateNotaPage from '@/views/UpdateNotapage.vue';
import ProximoPage from '@/views/ProximoPage.vue';
import AdministradorPage from '@/views/AdministradorPage.vue';
import EditarClientePage from '@/views/EditarClientePage.vue';
import EliminarClientePage from '@/views/EliminarClientePage.vue';

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    redirect: '/home'
  },
  {
    path: '/home',
    name: 'Home',
    component: HomePage
  },{
    path: '/cliente',
    name: 'Cliente',
    component: ClientePage
  },
  {
    path: '/login',
    name: 'Login',
    component: LoginPage
  },
  {
    path: '/dashboard',
    name: 'Dashboard',
    component: DasboardPage
  },
  {
    path: '/producto',
    name: 'Producto',
    component: ProductoPage
  },
  {
    path: '/nota',
    name:'nota',
    component: NotaPage
  },
  {
    path: '/actualizar',
    name: 'actualizar',
    component: UpdateNotaPage
  },
  {
    path: '/proximo',
    name: 'proximo',
    component: ProximoPage
  },
  {
    path: '/administrador',
    name: 'administradaor',
    component: AdministradorPage
  },
  {
    path: '/editarUser',
    name: 'editarUser',
    component: EditarClientePage
  },
  {
    path: '/eliminarUser',
    name: 'eliminarUser',
    component: EliminarClientePage
  }
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router
