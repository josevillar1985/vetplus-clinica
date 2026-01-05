<template>
  <div class="contacto-view">
    <HeaderComponent />

    <!-- HERO -->
    <section class="contact-hero">
      <h1>Contacto</h1>
      <p>
        Estamos aquí para ayudarte y cuidar de tu mascota
      </p>
    </section>

    <!-- CONTENIDO -->
    <v-container class="contact-container">
      <v-row align="stretch">

        <!-- FORMULARIO -->
        <v-col cols="12" md="7">
          <v-card class="pa-6 h-100">
            <h2 class="form-title">Escríbenos</h2>

            <v-form>
              <v-row>
                <v-col cols="12" md="6">
                  <v-text-field
                    label="Nombre"
                    variant="outlined"
                    color="success"
                  />
                </v-col>

                <v-col cols="12" md="6">
                  <v-text-field
                    label="Email"
                    variant="outlined"
                    color="success"
                  />
                </v-col>

                <v-col cols="12" md="6">
                  <v-text-field
                    label="Teléfono"
                    variant="outlined"
                    color="success"
                  />
                </v-col>

                <v-col cols="12" md="6">
                  <v-select
                    label="Asunto"
                    variant="outlined"
                    color="success"
                    :items="[
                      'Cita veterinaria',
                      'Urgencias',
                      'Información',
                      'Otros'
                    ]"
                  />
                </v-col>

                <v-col cols="12">
                  <v-textarea
                  color="success"
                    label="Mensaje"
                    rows="4"
                    variant="outlined"
                  />
                </v-col>
              </v-row>

              <v-btn
                color="success"
                size="large"
                class="mt-4"
              >
                Enviar mensaje
              </v-btn>
            </v-form>
          </v-card>
        </v-col>

        <!-- INFO -->
        <v-col cols="12" md="5">
          <v-card class="pa-6 info-card">

            <div>
              <h2 class="info-title">Datos de contacto</h2>

              <div class="info-item">
                <strong>📞 Teléfono</strong>
                <p>900 123 456</p>
              </div>

              <v-divider class="my-4" />

              <div class="info-item">
                <strong>✉️ Email</strong>
                <p>contacto@vetplus.es</p>
              </div>

              <v-divider class="my-4" />

              <div class="info-item">
                <strong>📍 Dirección</strong>
                <p>Calle Mascotas Felices 12, Madrid</p>
              </div>

              <v-divider class="my-4" />

              <div class="info-item">
                <strong>⏰ Horario</strong>
                <p>Lunes a Viernes: 9:00 - 20:00</p>
                <p>Sábados: 10:00 - 14:00</p>
              </div>
            </div>

            <!-- BOTÓN ABAJO -->
            <v-btn
              color="error"
              variant="elevated"
              size="large"
              block
            >
              Urgencias 24h
            </v-btn>

          </v-card>
        </v-col>

      </v-row>
    </v-container>

    <FooterComponent />
  </div>
</template>

<script>
import HeaderComponent from '@/components/HeaderComponent.vue'
import FooterComponent from '@/components/FooterComponent.vue'

export default {
  name: 'ContactoView',
  components: {
    HeaderComponent,
    FooterComponent
  }
}
</script>

<style scoped>
/* ===== HERO ===== */
.contact-hero {
  margin-top: 96px; /* header fixed */
  padding: 80px 24px;
  text-align: center;
}

.contact-hero h1 {
  font-size: 2.4rem;
  font-weight: 800;
  color: #2e7d32;
  margin-bottom: 12px;
}

.contact-hero p {
  font-size: 1.2rem;
  color: #475569;
}

/* ===== CONTENIDO ===== */
.contact-container {
  margin-top: 48px;
  margin-bottom: 64px;
}

.form-title {
  font-size: 1.8rem;
  font-weight: 700;
  margin-bottom: 24px;
  color: #2e7d32;
}

/* ===== INFO ===== */
.info-card {
  display: flex;
  flex-direction: column;
  height: 100%;
  background-color: #f9fafb;
}

.info-title {
  font-size: 1.6rem;
  font-weight: 700;
  margin-bottom: 24px;
  color: #2e7d32;
}

.info-item strong {
  display: block;
  font-weight: 700;
  margin-bottom: 4px;
}

.info-item p {
  margin: 0;
  color: #374151;
}

/* Empuja el botón abajo */
.info-card .v-btn {
  margin-top: auto;
}

/* ===== FORM INPUTS VERDES ===== */

/* Label al focus */
.v-field--active .v-label {
  color: #2e7d32 !important;
}

/* Borde outlined al focus */
.v-field--variant-outlined.v-field--focused .v-field__outline {
  --v-field-border-opacity: 1;
  --v-field-border-width: 2px;
  color: #2e7d32;
  border-color: #2e7d32 !important;
}

/* Iconos internos */
.v-field--focused .v-icon {
  color: #2e7d32 !important;
}
</style>
