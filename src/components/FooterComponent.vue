<template>
  <v-footer color="success" class="pa-10 footer-success mt-16">

    <v-container>

      <v-row>

        <!-- COLUMNA 1 -->
        <v-col cols="12" md="4">
          <h3 class="footer-title">VetPlus</h3>
          <p class="footer-text">
            Clínica veterinaria especializada en el cuidado integral
            de tu mascota con atención cercana y profesional.
          </p>
        </v-col>

        <!-- COLUMNA 2 -->
        <v-col cols="12" md="4">
          <h3 class="footer-title">Servicios</h3>
          <ul class="footer-list">
            <li>Medicina general</li>
            <li>Vacunación</li>
            <li>Cirugía</li>
            <li>Urgencias</li>
          </ul>
        </v-col>

        <!-- COLUMNA 3 -->
        <v-col cols="12" md="4">
          <h3 class="footer-title">Contacto</h3>
          <p class="footer-text">📍 Calle Principal, 123</p>
          <p class="footer-text">📞 600 123 456</p>
          <p class="footer-text">✉️ info@vetplus.es</p>
        </v-col>

      </v-row>

      <v-divider class="my-6 divider-light"></v-divider>

      <!-- COPYRIGHT -->
      <div class="text-center footer-copy">
        © {{año}} VetPlus · Todos los derechos reservados
      </div>

    </v-container>
  </v-footer>
</template>

<script>
export default {
  name: "FooterComponent",
  data() {
    return {
      año: 2025
    }
  }
}
</script>

<style scoped>
.footer-success {
  color: #f1f8f4; /* texto claro sobre verde */
}

.footer-title {
  font-size: 1.2rem;
  font-weight: 600;
  margin-bottom: 12px;
  color: #ffffff;
}

.footer-text {
  font-size: 0.95rem;
  line-height: 1.6;
  opacity: 0.9;
}

.footer-list {
  list-style: none;
  padding: 0;
  margin: 0;
}

.footer-list li {
  margin-bottom: 8px;
  opacity: 0.9;
}

.divider-light {
  border-color: rgba(255, 255, 255, 0.3);
}

.footer-copy {
  font-size: 0.85rem;
  opacity: 0.8;
}
</style>
