<template>
  <div>
    <v-app-bar
      app
      fixed
      elevation="2"
      height="96"
      class="vet-header"
    >
      <v-app-bar-nav-icon
        class="d-flex d-md-none"
        @click="drawer = true"
      />

      <div class="brand">
        <v-avatar size="64">
          <img src="@/assets/Logo.png" alt="VetPlus logo" />
        </v-avatar>

        <div class="brand-text">
          <span class="brand-title">VetPlus</span>
          <span class="brand-subtitle">Clínica Veterinaria</span>
        </div>
      </div>

      <v-spacer></v-spacer>

      <nav class="nav d-none d-md-flex">
        <router-link to="/administrar" class="nav-link">ADMINISTRAR</router-link>
        <router-link to="/" exact class="nav-link">Inicio</router-link>
        <router-link to="/servicios" class="nav-link">Servicios</router-link>
        <router-link to="/sobre-nosotros" class="nav-link">Sobre nosotros</router-link>
        <router-link to="/contacto" class="nav-link">Contacto</router-link>
      </nav>

      <v-spacer></v-spacer>

      <div class="d-none d-md-flex">
        <v-btn color="error" class="cta-btn" @click="handleUrgencias">
          Urgencias
        </v-btn>

        <v-btn to="/calendario" color="success" class="cta-btn">
          Pedir cita
        </v-btn>
      </div>
    </v-app-bar>

    <v-navigation-drawer
      v-model="drawer"
      app
      temporary
      left
      class="mobile-drawer"
    >
      <v-list dense>
        <v-list-item to="/" exact @click="drawer = false">
          <v-list-item-title>Inicio</v-list-item-title>
        </v-list-item>
        <v-list-item to="/servicios" @click="drawer = false">
          <v-list-item-title>Servicios</v-list-item-title>
        </v-list-item>

        <v-list-item to="/sobre-nosotros" @click="drawer = false">
          <v-list-item-title>Sobre nosotros</v-list-item-title>
        </v-list-item>

        <v-list-item to="/contacto" @click="drawer = false">
          <v-list-item-title>Contacto</v-list-item-title>
        </v-list-item>
      </v-list>

      <v-divider class="my-4"></v-divider>

      <v-btn block color="error" class="mb-3" @click="handleUrgencias">
        Urgencias
      </v-btn>

      <v-btn block color="success" to="/calendario" @click="drawer = false">
        Pedir cita
      </v-btn>
    </v-navigation-drawer>
  </div>
</template>

<script>
import Swal from 'sweetalert2'

export default {
  name: "HeaderComponent",
  data() {
    return {
      drawer: false
    };
  },
  methods: {
    handleUrgencias() {
      if (/Mobi|Android|iPhone/i.test(navigator.userAgent)) {
        window.location.href = "tel:+34900123456";
      } else {
        Swal.fire({
          icon: 'warning',
          title: 'Urgencias veterinarias',
          html: `
            <p><strong>Atención inmediata</strong></p>
            <p>Llámanos ahora al:</p>
            <h2 style="margin:12px 0; color:#c62828;">900 123 456</h2>
            <p>Servicio disponible 24h</p>
          `,
          confirmButtonText: 'Cerrar',
          confirmButtonColor: '#c62828'
        })
      }
    }
  }
};
</script>

<style scoped>
.vet-header {
  border-bottom: 3px solid #2e7d32;
  z-index: 1000;
}

.brand {
  display: flex;
  align-items: center;
  gap: 12px;
  margin-left: 16px;
}

.brand-text {
  display: flex;
  flex-direction: column;
  line-height: 1.1;
}

.brand-title {
  font-size: 1.6rem;
  font-weight: 700;
  color: #2e7d32;
}

.brand-subtitle {
  font-size: 0.8rem;
  color: #6b7280;
}

.nav-link {
  position: relative;
  margin: 0 14px;
  text-decoration: none;
  font-weight: 500;
  color: #374151;
  transition: color 0.2s ease;
}

.nav-link:hover {
  color: #2e7d32;
}

.nav-link::after {
  content: "";
  position: absolute;
  left: 0;
  bottom: -6px;
  width: 0;
  height: 2px;
  background-color: #2e7d32;
  transition: width 0.25s ease;
}

.nav-link:hover::after {
  width: 100%;
}

.nav-link.router-link-active {
  color: #2e7d32;
  font-weight: 600;
}

.nav-link.router-link-active::after {
  width: 100%;
}

.cta-btn {
  margin-right: 16px;
  font-weight: 600;
}

.mobile-drawer {
  z-index: 2000 !important;
  padding: 16px;
}
</style>
