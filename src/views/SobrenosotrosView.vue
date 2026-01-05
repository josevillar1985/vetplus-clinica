<template>
  <div class="about-view">
    <HeaderComponent />
    <DescripcionAbout />

    <v-container class="about-container">

      <!-- CABECERA -->
      <div class="about-header mb-16">
        <h1 class="about-title">Nuestro Equipo</h1>
        <p class="about-subtitle">
          Personas que cuidan de tu mascota como si fuera parte de su familia
        </p>
      </div>

      <!-- EMPLEADO 1 -->
      <v-row align="center" class="mb-16">

        <!-- IZQUIERDA -->
        <v-col cols="12" md="5" class="text-center">
          <v-avatar size="180" class="mb-4">
            <img src="https://img.freepik.com/vector-premium/nina-veterinaria-dibujos-animados-cuidado-salud-perro-arte-vectorial_1080480-47483.jpg?semt=ais_hybrid&w=740&q=80" />
          </v-avatar>
          <h3 class="team-name">Dra. Laura Martínez</h3>
          <p class="team-role">Veterinaria General</p>
        </v-col>

        <!-- DIVIDERS -->
        <v-col cols="12" md="1" class="d-flex justify-center">
          <!-- Horizontal en móvil -->
          <v-divider class="my-8 d-md-none" />

          <!-- Vertical en desktop -->
          <v-divider
            vertical
            class="d-none d-md-flex team-divider"
          />
        </v-col>

        <!-- DERECHA -->
        <v-col cols="12" md="6">
          <p class="team-desc">
            Especialista en medicina preventiva y diagnóstico clínico,
            con más de 10 años de experiencia ofreciendo una atención
            cercana y personalizada a cada mascota.
          </p>
        </v-col>

      </v-row>

      <!-- EMPLEADO 2 (INVERSO) -->
      <v-row align="center" class="mb-16">

        <v-col cols="12" md="6">
          <p class="team-desc">
            Responsable del área quirúrgica, con formación avanzada
            en cirugía de tejidos blandos y procedimientos complejos,
            priorizando siempre la seguridad y el bienestar del paciente.
          </p>
        </v-col>

        <v-col cols="12" md="1" class="d-flex justify-center">
          <v-divider class="my-8 d-md-none" />
          <v-divider
            vertical
            class="d-none d-md-flex team-divider"
          />
        </v-col>

        <v-col cols="12" md="5" class="text-center">
          <v-avatar size="180" class="mb-4">
            <img src="https://thumbs.dreamstime.com/b/d-avatar-de-un-m%C3%A9dico-retrato-con-uniforme-fondo-blanco-327426936.jpg" />
          </v-avatar>
          <h3 class="team-name">Dr. Carlos Gómez</h3>
          <p class="team-role">Cirugía Veterinaria</p>
        </v-col>

      </v-row>

      <!-- EMPLEADO 3 -->
      <v-row align="center" class="mb-16">

        <v-col cols="12" md="5" class="text-center">
          <v-avatar size="180" class="mb-4">
            <img src="https://www.shutterstock.com/image-vector/avatar-woman-doctors-lab-coat-260nw-2316879763.jpg" />
          </v-avatar>
          <h3 class="team-name">Ana Ruiz</h3>
          <p class="team-role">Auxiliar Veterinaria</p>
        </v-col>

        <v-col cols="12" md="1" class="d-flex justify-center">
          <v-divider class="my-8 d-md-none" />
          <v-divider
            vertical
            class="d-none d-md-flex team-divider"
          />
        </v-col>

        <v-col cols="12" md="6">
          <p class="team-desc">
            Apoyo fundamental en el cuidado diario de los pacientes,
            asistencia en consulta y acompañamiento a las familias
            para garantizar una experiencia tranquila y segura.
          </p>
        </v-col>

      </v-row>

      <!-- EMPLEADO 4 (INVERSO) -->
      <v-row align="center" class="mb-16">

        <v-col cols="12" md="6">
          <p class="team-desc">
            Encargada de la atención al cliente y la gestión de citas,
            asegurando una organización eficiente y un trato cercano
            desde el primer contacto con la clínica.
          </p>
        </v-col>

        <v-col cols="12" md="1" class="d-flex justify-center">
          <v-divider class="my-8 d-md-none" />
          <v-divider
            vertical
            class="d-none d-md-flex team-divider"
          />
        </v-col>

        <v-col cols="12" md="5" class="text-center">
          <v-avatar size="180" class="mb-4">
            <img src="https://img.freepik.com/foto-gratis/retrato-doctora-3d_23-2151107240.jpg?semt=ais_hybrid&w=740&q=80" />
          </v-avatar>
          <h3 class="team-name">María López</h3>
          <p class="team-role">Recepción y Atención</p>
        </v-col>

      </v-row>

    </v-container>

    <FooterComponent />
  </div>
</template>

<script>
import HeaderComponent from '@/components/HeaderComponent.vue'
import FooterComponent from '@/components/FooterComponent.vue'
import DescripcionAbout from '@/components/DescripcionAbout.vue';

export default {
  name: 'SobrenosotrosView',
  components: {
    HeaderComponent,
    FooterComponent,
    DescripcionAbout
  }
}
</script>

<style scoped>
.about-view {
  padding-top: 120px; /* altura del header */
}

.about-container {
  padding-bottom: 48px;
}


.about-header {
  text-align: center;
}

.about-title {
  font-size: 2.4rem;
  font-weight: 700;
  color: #2e7d32;
  margin-bottom: 12px;
}

.about-subtitle {
  font-size: 1.2rem;
  color: #6b7280;
  max-width: 640px;
  margin: 0 auto;
}

.team-name {
  font-size: 1.3rem;
  font-weight: 700;
  margin-top: 8px;
}

.team-role {
  
  font-weight: 600;
  color: #2e7d32;
}

.team-desc {
  font-size: 1.05rem;
  line-height: 1.7;
  color: #374151;
}

/* 🔥 CLAVE: ALTURA DEL DIVIDER VERTICAL */
.team-divider {
  height: 300px;
  border-color: #2e7d32;
  opacity: 0.6;
}
</style>
