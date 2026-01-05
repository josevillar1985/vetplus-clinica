<template>
  <v-container>

    <!-- HEADER -->
    <div class="cards-header mb-16">
      <h2 class="cards-title">Planes de Cuidado</h2>
      <p class="cards-subtitle">
        Elige el plan que mejor se adapte a la salud de tu mascota
      </p>
    </div>

    <v-row>
      <!-- PLAN BÁSICO -->
      <v-col cols="12" sm="6" md="4" class="pa-5">
        <v-card class="plan-card pa-5">
          <h3 class="plan-title">Plan Básico</h3>
          <p class="plan-price">19€ / mes</p>

          <v-divider class="my-4" />

          <ul class="plan-features">
            <li>✔ Consulta anual</li>
            <li>✔ Revisión general</li>
            <li>✔ Desparasitación</li>
          </ul>

          <v-btn block color="success" variant="flat" class="mt-6">
            Elegir plan
          </v-btn>
        </v-card>
      </v-col>

      <!-- PLAN SALUD -->
      <v-col cols="12" sm="6" md="4" class="pa-5">
        <v-card class="plan-card featured pa-5">
          <h3 class="plan-title">Plan Salud</h3>
          <p class="plan-price">29€ / mes</p>

          <v-divider class="my-4" />

          <ul class="plan-features">
            <li>✔ Consultas ilimitadas</li>
            <li>✔ Vacunación incluida</li>
            <li>✔ Análisis básicos</li>
          </ul>

          <v-btn block color="success" variant="elevated" class="mt-6">
            Más popular
          </v-btn>
        </v-card>
      </v-col>

      <!-- PLAN PREMIUM -->
      <v-col cols="12" sm="6" md="4" class="pa-5">
        <v-card class="plan-card pa-5">
          <h3 class="plan-title">Plan Premium</h3>
          <p class="plan-price">49€ / mes</p>

          <v-divider class="my-4" />

          <ul class="plan-features">
            <li>✔ Todo lo anterior</li>
            <li>✔ Cirugías con descuento</li>
            <li>✔ Urgencias 24h</li>
          </ul>

          <v-btn block color="success" variant="flat" class="mt-6">
            Contratar
          </v-btn>
        </v-card>
      </v-col>

    </v-row>
  </v-container>
</template>

<script>
export default {
  name: "PlanesSection"
}
</script>

<style scoped>
.cards-header {
  text-align: center;
}

.cards-title {
  font-size: 2.4rem;
  font-weight: 700;
  color: #2e7d32;
}

.cards-subtitle {
  font-size: 1.1rem;
  color: #6b7280;
  max-width: 600px;
  margin: 0 auto;
}

/* PLAN CARDS */
.plan-card {
  border-radius: 16px;
  transition: transform 0.2s ease, box-shadow 0.2s ease;
}

.plan-card:hover {
  transform: translateY(-6px);
  box-shadow: 0 12px 30px rgba(0, 0, 0, 0.12);
}

.plan-title {
  font-size: 1.4rem;
  font-weight: 700;
  text-align: center;
}

.plan-price {
  font-size: 1.6rem;
  font-weight: 800;
  color: #2e7d32;
  text-align: center;
  margin-top: 4px;
}

.plan-features {
  list-style: none;
  padding: 0;
  margin: 0;
}

.plan-features li {
  margin: 8px 0;
  font-size: 0.95rem;
}

/* PLAN DESTACADO */
.featured {
  border: 2px solid #2e7d32;
  background: #f1f8f4;
}
</style>
