<template>
  <section class="especialidades">
    <v-container >

      <!-- CABECERA -->
      <div class="header">
        <h2>Nuestras especialidades</h2>
        <p>Cuidado veterinario integral para cada etapa de su vida</p>
      </div>

      <!-- CONTENIDO -->
      <v-row align="center">

        <!-- IMAGEN -->
        <v-col cols="12" md="5" class="d-flex justify-center">
          <v-img
            src="https://pngimg.com/uploads/dog/dog_PNG50348.png"
            contain
            max-width="260"
          />
        </v-col>

        <!-- SERVICIOS -->
        <v-col cols="12" md="7">
          <div class="services-box">
            <div class="services">
              <div class="service">Medicina general</div>
              <div class="service">Vacunación </div>
              <div class="service">Dermatología</div>
              <div class="service">Oftalmología</div>
              <div class="service">Diagnóstico avanzado</div>
              <div class="service">Cirugía veterinaria</div>
              <div class="service">Control geriátrico</div>
              <div class="service">Urgencias</div>
            </div>
          </div>
        </v-col>

      </v-row>
    </v-container>
  </section>
</template>

<script>
export default {
  name: "EspecialidadesComponent"
}
</script>

<style scoped>
.especialidades {
  padding: 120px 0;
}

/* CABECERA */
.header {
  max-width: 720px;
  margin: 0 auto 72px auto;
  text-align: center;
}

.header h2 {
  font-size: 2.6rem;
  font-weight: 700;
  margin-bottom: 12px;
  color: #2e7d32;
}

.header p {
  font-size: 1.1rem;
  color: #6b7280;
  line-height: 1.6;
}

/* CAJA SERVICIOS */
.services-box {
  background: #ffffff;
  border-radius: 20px;
  padding: 48px 56px;
  box-shadow: 0 20px 40px rgba(0, 0, 0, 0.06);
}

/* LISTA EN 2 COLUMNAS */
.services {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 28px 48px;
}

/* ITEM */
.service {
  position: relative;
  padding-left: 28px;
  font-size: 0.95rem;
  font-weight: 600;
  letter-spacing: 0.4px;
  text-transform: uppercase;
  color: #1f2937;
  transition: transform 0.2s ease, color 0.2s ease;
}

/* INDICADOR */
.service::before {
  content: "•";
  position: absolute;
  left: 0;
  top: 0;
  color: #2e7d32;
  font-size: 1.5rem;
  line-height: 1;
}

.service:hover {
  transform: translateX(6px);
  color: #2e7d32;
}

/* RESPONSIVE */
@media (max-width: 768px) {
  .especialidades {
    padding: 80px 0;
  }

  .services-box {
    padding: 32px 28px;
  }

  .services {
    grid-template-columns: 1fr;
    gap: 20px;
  }
}
</style>
