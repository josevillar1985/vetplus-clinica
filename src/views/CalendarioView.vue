<template>
  <v-container fluid class="fill-height">
    <HeaderComponent />

    <v-row justify="center" class="mt-2">
      <v-col cols="12" class="d-flex justify-center">
        <v-date-picker v-model="formulario.fecha" width="500" color="success" />
      </v-col>
    </v-row>

    <v-row justify="center" class="mt-2">
      <v-col cols="12">
        <section class="seccion-horario">
          <h3 class="titulo-horario">Horario disponible</h3>

          <p class="turno-titulo">Mañana</p>
          <div class="horas-grid">
            <v-btn v-for="hora in horasManana" :key="hora" :color="horaDisponible(hora) ? 'success' : 'error'"
              :disabled="!horaDisponible(hora)" :variant="hora === horaSeleccionada ? 'flat' : 'outlined'" size="small"
              @click="seleccionarHora(hora)">
              {{ hora }}
            </v-btn>
          </div>

          <p class="turno-titulo mt-2">Tarde</p>
          <div class="horas-grid">
            <v-btn v-for="hora in horasTarde" :key="hora" :color="horaDisponible(hora) ? 'success' : 'error'"
              :disabled="!horaDisponible(hora)" :variant="hora === horaSeleccionada ? 'flat' : 'outlined'" size="small"
              @click="seleccionarHora(hora)">
              {{ hora }}
            </v-btn>
          </div>

          <v-btn class="mt-4" color="primary" size="large" :disabled="!horaSeleccionada || !formulario.fecha"
            @click="mostrarDialogo = true">
            Reservar cita
          </v-btn>
        </section>
      </v-col>
    </v-row>

    <v-dialog v-model="mostrarDialogo" max-width="500">
      <v-card>
        <v-card-title>Formulario de la cita</v-card-title>

        <v-card-text>
          <p><strong>Fecha:</strong> {{ formulario.fecha }}</p>
          <p><strong>Hora:</strong> {{ formulario.hora }}</p>

          <v-form>
            <v-row>
              <v-col cols="12" md="6">
                <v-text-field v-model="formulario.nombreCliente" label="Nombre" />
              </v-col>

              <v-col cols="12" md="6">
                <v-text-field v-model="formulario.dni" label="DNI" />
              </v-col>

              <v-col cols="12" md="6">
                <v-text-field v-model="formulario.nombreMascota" label="Nombre de la mascota" />
              </v-col>
            </v-row>

            <v-btn color="success" size="large" class="mt-4" @click="confirmarCita">
              Confirmar cita
            </v-btn>
          </v-form>
        </v-card-text>
      </v-card>
    </v-dialog>
  </v-container>
</template>

<script>
import HeaderComponent from '@/components/HeaderComponent.vue'
import axios from 'axios'
import Swal from 'sweetalert2'

export default {
  name: 'CalendarioConHorario',

  components: { HeaderComponent },

  data() {
    return {
      horasManana: ['10:00', '11:00', '12:00', '13:00', '14:00'],
      horasTarde: ['17:00', '18:00', '19:00', '20:00'],
      horasNoDisponibles: [],
      horaSeleccionada: null,
      mostrarDialogo: false,
      formulario: {
        fecha: '',
        hora: '',
        nombreCliente: '',
        dni: '',
        nombreMascota: ''
      }
    }
  },

  methods: {
    seleccionarHora(hora) {
      if (!this.horaDisponible(hora)) return
      this.horaSeleccionada = hora
      this.formulario.hora = hora
    },

    horaDisponible(hora) {
      return !this.horasNoDisponibles.includes(hora)
    },

    confirmarCita() {
      axios.post('http://localhost:8081/citas', this.formulario)
        .then(() => {
          this.mostrarDialogo = false

          Swal.fire({
            icon: 'success',
            title: 'Cita confirmada',
            text: 'Tu cita se ha registrado correctamente',
            confirmButtonColor: '#2e7d32'
          }).then(() => {
            this.$router.push('/')
          })
        })
        .catch(error => {
          const mensaje =
            error.response &&
              error.response.data &&
              typeof error.response.data === 'string'
              ? error.response.data
              : 'El DNI tiene que ser algo parecido a esto 12345678A'

          Swal.fire({
            icon: 'error',
            title: 'Error al reservar',
            text: mensaje,
            confirmButtonColor: '#c62828'
          })
        })
    }

  },

  watch: {
    'formulario.fecha'(nuevaFecha) {
      if (!nuevaFecha) return

      this.horaSeleccionada = null
      this.formulario.hora = ''

      axios.get('http://localhost:8081/citas/fecha', {
        params: { fecha: nuevaFecha }
      })
        .then(response => {
          this.horasNoDisponibles = [
            ...new Set(response.data.map(c => c.hora))
          ]
        })
        .catch(() => {
          this.horasNoDisponibles = []
        })
    }
  }
}
</script>

<style scoped>
.fill-height {
  min-height: 100vh;
  padding-top: 96px;
}

.seccion-horario {
  text-align: center;
}

.titulo-horario {
  font-size: 1.2rem;
  font-weight: 600;
  margin-bottom: 8px;
}

.turno-titulo {
  font-weight: 600;
  margin-bottom: 6px;
}

.horas-grid {
  display: flex;
  justify-content: center;
  flex-wrap: wrap;
  gap: 10px;
}
</style>
