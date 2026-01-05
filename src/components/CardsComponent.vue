<template>
  <v-container>

    
    <div class="cards-header mb-10">
      <h2 class="cards-title">Nuestros Servicios</h2>
      <p class="cards-subtitle">
        Somos profesionales y cercanos para tu mascota
      </p>
    </div>

    <v-row class="mt-10"
    >

      <!-- CARD 1 -->
      <v-col cols="12" sm="6" md="4" class="pa-5">
        <v-card class="pa-1">

          <v-img
            height="200px"
            src="https://media.istockphoto.com/id/1250394360/es/foto/perro-y-gato-mejores-amigos-jugando-juntos-al-aire-libre-acostados-en-la-parte-de-atr%C3%A1s-juntos.jpg?s=612x612&w=0&k=20&c=1FuUjk9JJtTWsuImW2kvfEZ0uJrFpXL8DHkAMvBdvlE="
            cover
          />

          <v-card-title>
            Medicina General
          </v-card-title>

          <v-card-subtitle>
            Atención veterinaria integral
          </v-card-subtitle>

          <v-card-actions>
            <v-btn color="success" variant="flat" to="/servicios">
              Más información
            </v-btn>

            <v-spacer></v-spacer>

            <v-btn icon @click="cardUno = !cardUno">
              <v-icon>mdi-chevron-down</v-icon>
            </v-btn>
          </v-card-actions>

          <v-expand-transition >
            <div v-show ="cardUno">
              <v-divider></v-divider>
              <v-card-text>
                Diagnóstico, seguimiento y tratamiento de las patologías más
                comunes. Cuidamos la salud de tu mascota en cada etapa de su vida.
              </v-card-text>
            </div>
          </v-expand-transition>

        </v-card>
      </v-col>

      <!-- CARD 2 -->
      <v-col cols="12" sm="6" md="4" class="pa-5">
        <v-card class="pa-1">

          <v-img
            height="200px"
            src="https://i.pinimg.com/736x/23/17/db/2317dbb00528022f21318e1ddfe1306e.jpg"
            cover
          />

          <v-card-title>
            Vacunación y Prevención
          </v-card-title>

          <v-card-subtitle>
            Cuidado desde el primer día
          </v-card-subtitle>

          <v-card-actions>
            <v-btn color="success" variant="flat" to="/servicios">
              Ver planes
            </v-btn>

            <v-spacer></v-spacer>

            <v-btn icon @click="cardDos = !cardDos">
              <v-icon>mdi-chevron-down</v-icon>
            </v-btn>
          </v-card-actions>

          <v-expand-transition >
            <div v-show="cardDos">
              <v-divider></v-divider>
              <v-card-text>
                Programas personalizados de vacunación y desparasitación para
                prevenir enfermedades y garantizar una vida larga y saludable.
              </v-card-text>
            </div>
          </v-expand-transition>

        </v-card>
      </v-col>

      <!-- CARD 3 -->
      <v-col cols="12" sm="6" md="4" class="pa-5">
        <v-card class="pa-1">

          <v-img
            height="200px"
            src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS71BlfF0mUUDwNFtx7xqHLKPeKwCFezua3_A&s"
            cover
          />

          <v-card-title>
            Cirugía Veterinaria
          </v-card-title>

          <v-card-subtitle>
            Precisión y tecnología avanzada
          </v-card-subtitle>

          <v-card-actions>
            <v-btn color="success" variant="flat" to="/servicios">
              Consultar
            </v-btn>

            <v-spacer></v-spacer>

            <v-btn icon @click="cardTres = !cardTres">
              <v-icon>mdi-chevron-down</v-icon>
            </v-btn>
          </v-card-actions>

          <v-expand-transition>
            <div v-show="cardTres">
              <v-divider></v-divider>
              <v-card-text>
                Intervenciones quirúrgicas con equipamiento avanzado y un equipo
                especializado que garantiza la máxima seguridad y recuperación.
              </v-card-text>
            </div>
          </v-expand-transition>

        </v-card>
      </v-col>

    </v-row>
  </v-container>
</template>

<script>
export default {
  name: "CardsSection",
  data() {
    return {
      cardUno: false,
      cardDos: false,
      cardTres: false
    };
  }
}
</script>

<style scoped>
.cards-header {
  text-align: center;
  margin-bottom: 48px;
}

.cards-title {
  font-size: 2.4rem;
  font-weight: 700;
  color: #2e7d32;
  margin-bottom: 8px;
}

.cards-subtitle {
  font-size: 1.1rem;
  color: #6b7280;
  max-width: 640px;
  margin: 0 auto;
}
</style>
