<template>
    
  <v-container class="about-description">

    <v-row justify="center">
      <v-col cols="12" md="8">

        <h1 class="about-section-title">
          Quiénes somos
        </h1>

        <p class="about-section-text">
          En <strong>VetPlus</strong> creemos que la medicina veterinaria va más allá
          de diagnosticar y tratar. Nuestro objetivo es acompañar a las familias
          en cada etapa de la vida de sus mascotas, ofreciendo una atención cercana,
          honesta y basada en la confianza.
        </p>

        <p class="about-section-text">
          Contamos con un equipo profesional en constante formación y con
          instalaciones equipadas con tecnología moderna, lo que nos permite
          ofrecer un servicio integral, personalizado y de alta calidad.
          Porque cada mascota es única, y así debe ser su cuidado.
        </p>

        <v-divider class="my-10" />

        <v-row>
          <v-col cols="12" sm="4" class="text-center mb-6">
            <strong class="about-highlight">+10 años</strong>
            <p class="about-highlight-text">de experiencia</p>
          </v-col>

          <v-col cols="12" sm="4" class="text-center mb-6">
            <strong class="about-highlight">Atención cercana</strong>
            <p class="about-highlight-text">y personalizada</p>
          </v-col>

          <v-col cols="12" sm="4" class="text-center mb-6">
            <strong class="about-highlight">Tecnología</strong>
            <p class="about-highlight-text">veterinaria avanzada</p>
          </v-col>
        </v-row>

      </v-col>
    </v-row>

  </v-container>
</template>

<script>


export default {
  name: 'DescripcionAbout'

}
</script>

<style scoped>
.about-description {
  margin-top: 48px;
  margin-bottom: 48px;
}

.about-section-title {
  font-size: 2rem;
  font-weight: 700;
  color: #2e7d32;
  text-align: center;
  margin-bottom: 24px;
}

.about-section-text {
  font-size: 1.05rem;
  line-height: 1.8;
  color: #374151;
  margin-bottom: 16px;
  text-align: center;
}

.about-highlight {
  font-size: 1.3rem;
  font-weight: 700;
  color: #2e7d32;
}

.about-highlight-text {
  font-size: 0.95rem;
  color: #6b7280;
}
</style>
