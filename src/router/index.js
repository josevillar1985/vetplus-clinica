import Vue from 'vue'
import VueRouter from 'vue-router'

import HomeView from '@/views/HomeView.vue'
import ServiciosView from '@/views/ServiciosView.vue'
import SobrenosotrosView from '@/views/SobrenosotrosView.vue'
import ContactoView from '@/views/ContactoView.vue'
import CalendarioView from '@/views/CalendarioView.vue'
import AdministrarView from '@/views/AdministrarView.vue'
import ReservarCitaAdmin from '@/components/ReservarCitaAdmin.vue'

Vue.use(VueRouter)

const routes = [
  { path: '/', name: 'home', component: HomeView },
  { path: '/servicios', name: 'servicios', component: ServiciosView },
  { path: '/sobre-nosotros', name: 'sobrenosotros', component: SobrenosotrosView },
  { path: '/contacto', name: 'contacto', component: ContactoView },
  { path: '/calendario', name: 'calendario', component: CalendarioView },
  { path: '/administrar', name: 'administrar', component: AdministrarView },
  { path: '/admin/reservar', name: 'admin-reservar', component: ReservarCitaAdmin }
]

const router = new VueRouter({
  mode: 'history',
  routes,
  scrollBehavior () {
    return { x: 0, y: 0 }
  }
})

export default router
