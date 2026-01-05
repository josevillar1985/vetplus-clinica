<template>
  <div class="services-hero">

    <HeaderComponent />

    <v-container class="servicios-container">

      <!-- HEADER -->
      <div class="mb-12 text-center">
        <h1 class="cards-title">Nuestros Servicios</h1>
        <p class="cards-subtitle">
          Somos profesionales y cercanos para tu mascota
        </p>
      </div>

      <!-- CARDS -->
      <v-row>

        <!-- CARD 1 -->
        <v-col cols="12" sm="6" md="3" class="pa-4">
          <v-card>
            <v-img height="200" src="https://clinicaveterinariaaoiz.com/wp-content/uploads/2015/09/diagnostico4-clinicaaoiz.jpg" cover />
            <v-card-title>Medicina General</v-card-title>
            <v-card-subtitle>Atención veterinaria integral</v-card-subtitle>
            <v-card-actions>
              <v-btn color="success" variant="flat">Consultar</v-btn>
              <v-spacer />
              <v-btn icon @click="card1 = !card1"><v-icon>mdi-chevron-down</v-icon></v-btn>
            </v-card-actions>
            <v-expand-transition>
              <div v-show="card1">
                <v-divider />
                <v-card-text>
                  Diagnóstico, seguimiento y tratamiento de las patologías más comunes.
                </v-card-text>
              </div>
            </v-expand-transition>
          </v-card>
        </v-col>

        <!-- CARD 2 -->
        <v-col cols="12" sm="6" md="3" class="pa-4">
          <v-card>
            <v-img height="200" src="https://www.animalshealth.es/fileuploads/news/perro-vacunacion-guia-mascota-veterinaria-216624624471.jpg" cover />
            <v-card-title>Vacunación</v-card-title>
            <v-card-subtitle>Cuidado desde el primer día</v-card-subtitle>
            <v-card-actions>
              <v-btn color="success" variant="flat">Consultar</v-btn>
              <v-spacer />
              <v-btn icon @click="card2 = !card2"><v-icon>mdi-chevron-down</v-icon></v-btn>
            </v-card-actions>
            <v-expand-transition>
              <div v-show="card2">
                <v-divider />
                <v-card-text>
                  Programas personalizados de vacunación y desparasitación.
                </v-card-text>
              </div>
            </v-expand-transition>
          </v-card>
        </v-col>

        <!-- CARD 3 -->
        <v-col cols="12" sm="6" md="3" class="pa-4">
          <v-card>
            <v-img height="200" src="https://www.unavets.com/nuevaandalucia/wp-content/uploads/sites/10/2020/10/shutterstock_1029444703-1.jpg" cover />
            <v-card-title>Dermatología</v-card-title>
            <v-card-subtitle>Cuidado de la piel y el pelaje</v-card-subtitle>
            <v-card-actions>
              <v-btn color="success" variant="flat">Consultar</v-btn>
              <v-spacer />
              <v-btn icon @click="card3 = !card3"><v-icon>mdi-chevron-down</v-icon></v-btn>
            </v-card-actions>
            <v-expand-transition>
              <div v-show="card3">
                <v-divider />
                <v-card-text>
                  Tratamientos especializados para alergias y problemas cutáneos.
                </v-card-text>
              </div>
            </v-expand-transition>
          </v-card>
        </v-col>

        <!-- CARD 4 -->
        <v-col cols="12" sm="6" md="3" class="pa-4">
          <v-card>
            <v-img height="200" src="https://almaoftalmologiaveterinaria.com/imagenes/carlino.jpg" cover />
            <v-card-title>Oftalmología</v-card-title>
            <v-card-subtitle>Salud visual especializada</v-card-subtitle>
            <v-card-actions>
              <v-btn color="success" variant="flat">Consultar</v-btn>
              <v-spacer />
              <v-btn icon @click="card4 = !card4"><v-icon>mdi-chevron-down</v-icon></v-btn>
            </v-card-actions>
            <v-expand-transition>
              <div v-show="card4">
                <v-divider />
                <v-card-text>
                  Diagnóstico y tratamiento de enfermedades oculares.
                </v-card-text>
              </div>
            </v-expand-transition>
          </v-card>
        </v-col>

        <!-- CARD 5 -->
        <v-col cols="12" sm="6" md="3" class="pa-4">
          <v-card>
            <v-img height="200" src="https://4dmedica.ai/wp-content/uploads/2024/10/ecografia-cardiaca-veterinaria.png" cover />
            <v-card-title>Diagnóstico</v-card-title>
            <v-card-subtitle>Precisión clínica</v-card-subtitle>
            <v-card-actions>
              <v-btn color="success" variant="flat">Consultar</v-btn>
              <v-spacer />
              <v-btn icon @click="card5 = !card5"><v-icon>mdi-chevron-down</v-icon></v-btn>
            </v-card-actions>
            <v-expand-transition>
              <div v-show="card5">
                <v-divider />
                <v-card-text>
                  Pruebas avanzadas para detectar enfermedades a tiempo.
                </v-card-text>
              </div>
            </v-expand-transition>
          </v-card>
        </v-col>

        <!-- CARD 6 -->
        <v-col cols="12" sm="6" md="3" class="pa-4">
          <v-card>
            <v-img height="200" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ6U2SVXmFN3nb1JGBIdmVyec3XNhomIEyAew&s" cover />
            <v-card-title>Cirugía</v-card-title>
            <v-card-subtitle>Precisión en intervención</v-card-subtitle>
            <v-card-actions>
              <v-btn color="success" variant="flat">Consultar</v-btn>
              <v-spacer />
              <v-btn icon @click="card6 = !card6"><v-icon>mdi-chevron-down</v-icon></v-btn>
            </v-card-actions>
            <v-expand-transition>
              <div v-show="card6">
                <v-divider />
                <v-card-text>
                  Cirugías con equipamiento avanzado y máxima seguridad.
                </v-card-text>
              </div>
            </v-expand-transition>
          </v-card>
        </v-col>

        <!-- CARD 7 -->
        <v-col cols="12" sm="6" md="3" class="pa-4">
          <v-card>
            <v-img height="200" src="https://www.clinicaveterinariagamusinos.com/wp-content/uploads/2025/08/iStock-500430393.jpg" cover />
            <v-card-title>Control Geriátrico</v-card-title>
            <v-card-subtitle>Cuidado en edad avanzada</v-card-subtitle>
            <v-card-actions>
              <v-btn color="success" variant="flat">Consultar</v-btn>
              <v-spacer />
              <v-btn icon @click="card7 = !card7"><v-icon>mdi-chevron-down</v-icon></v-btn>
            </v-card-actions>
            <v-expand-transition>
              <div v-show="card7">
                <v-divider />
                <v-card-text>
                  Seguimiento específico para mascotas senior.
                </v-card-text>
              </div>
            </v-expand-transition>
          </v-card>
        </v-col>

        <!-- CARD 8 -->
        <v-col cols="12" sm="6" md="3" class="pa-4">
          <v-card>
            <v-img height="200" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRF3pvNfRAsne92HHfH6e5_SDEm_-OHRQhWaA&s" cover />
            <v-card-title>Urgencias</v-card-title>
            <v-card-subtitle>Atención inmediata</v-card-subtitle>
            <v-card-actions>
              <v-btn color="error" variant="flat">Llamar ahora</v-btn>
              <v-spacer />
              <v-btn icon @click="card8 = !card8"><v-icon>mdi-chevron-down</v-icon></v-btn>
            </v-card-actions>
            <v-expand-transition>
              <div v-show="card8">
                <v-divider />
                <v-card-text>
                  Atención veterinaria urgente 24h.
                </v-card-text>
              </div>
            </v-expand-transition>
          </v-card>
        </v-col>

      </v-row>

      <v-divider class="my-16" thickness="2" color="#2e7d32" />
    </v-container>

    <PlanesComponent />
    <FooterComponent />

  </div>
</template>

<script>
import HeaderComponent from '@/components/HeaderComponent.vue'
import FooterComponent from '@/components/FooterComponent.vue'
import PlanesComponent from '@/components/PlanesComponent.vue'

export default {
  name: 'ServiciosView',
  components: { HeaderComponent, FooterComponent, PlanesComponent },
  data () {
    return {
      card1: false,
      card2: false,
      card3: false,
      card4: false,
      card5: false,
      card6: false,
      card7: false,
      card8: false
    }
  }
}
</script>

<style scoped>
.services-hero {
  padding-top: 50px;
}

.servicios-container {
  margin-top: 120px;
}

.cards-title {
  font-size: 2.4rem;
  font-weight: 700;
  color: #2e7d32;
}

.cards-subtitle {
  font-size: 1.1rem;
  color: #6b7280;
}
</style>
